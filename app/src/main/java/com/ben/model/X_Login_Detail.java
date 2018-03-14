package com.ben.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.ben.database.DBQuery;
import com.ben.webservicerequest.UserDetailsRequest;

import org.json.JSONObject;

/**
 * Created by ben on 08/07/17.
 */

public class X_Login_Detail extends DBObject implements I_X_LoginDetail{

    private String username;
    private String password;
    private int c_Bpartner_ID;
    private String isActiveUser;
    private int X_LoginDetail_ID;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Name;
    private String Email;

    public static int activeUserID = 0;

    public String isActiveUser() { return isActiveUser; }

    public void setActiveUser(String activeUser) { isActiveUser = activeUser; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getC_Bpartner_ID() {
        return c_Bpartner_ID;
    }

    public void setC_Bpartner_ID(int c_Bpartner_ID) {
        this.c_Bpartner_ID = c_Bpartner_ID;
    }

    public String getUsername() {
        return username;
    }

    public int getX_LoginDetail_ID() {
        return X_LoginDetail_ID;
    }

    public void setX_LoginDetail_ID(int x_LoginDetail_ID) {
        X_LoginDetail_ID = x_LoginDetail_ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    @Override
    public long save() throws Exception {
        ContentValues values = new ContentValues();
        values.put(I_X_LoginDetail.ColumnName_C_BPartner_ID, c_Bpartner_ID);
        values.put(I_X_LoginDetail.ColumnName_Username, username);
        values.put(I_X_LoginDetail.ColumnName_Password, password);
        values.put(I_X_LoginDetail.ColumnName_IsActiveUser, isActiveUser);
        values.put(I_X_LoginDetail.ColumnName_Name, getName());
        values.put(I_X_LoginDetail.ColumnName_Email, getEmail());
        Log.v("InsertingValues", "SavingLoginDetails");
        long resp = DBQuery.insertValues(I_X_LoginDetail.Table_Name, values);
        String sql2 = "SELECT X_LoginDetail_ID FROM X_Login_Detail WHERE Username = '" + username + "' AND password = '" + password + "'";
        Cursor response2 = DBQuery.executeQuery(sql2);
        while (response2.moveToNext()){
            setX_LoginDetail_ID(response2.getInt(response2.getColumnIndex(I_X_LoginDetail.ColumnName_X_LoginDetail_ID)));
        }
        return resp;
    }

    public static int validate(String user, String password){
        int userID = 0;
        /** Testing **/
        String sql2 = "SELECT C_BPartner_ID FROM X_Login_Detail ";
        Cursor response2 = DBQuery.executeQuery(sql2);
        while (response2.moveToNext()){
            Log.v("UserID : ", String.valueOf(response2.getInt(response2.getColumnIndex(I_X_LoginDetail.ColumnName_C_BPartner_ID))));
        }


        String sql = "SELECT C_BPartner_ID FROM X_Login_Detail WHERE Username = '" + user + "' AND Password = '" + password + "'";
        Cursor response = DBQuery.executeQuery(sql);
        while (response.moveToNext()){
            userID = response.getInt(response.getColumnIndex(I_X_LoginDetail.ColumnName_C_BPartner_ID));
        }
        Log.v("UserIDValidation", String.valueOf(userID));
        return userID;
    }


    public static void setLoggedInUser(int userID){
        ContentValues isActive = new ContentValues();
        isActive.put("IsActiveUser", "Y");
        String[]args = new String[1];
        args[0] = String.valueOf(userID);
        DBQuery.executeUpdate(I_X_LoginDetail.Table_Name, isActive, "X_LoginDetail_ID = ?", args);
        activeUserID = userID;
    }

    public static int getLoggedInUser(){
        return activeUserID;
    }


    @Override
    public void fromJson(JSONObject responseObject) {

    }
}
