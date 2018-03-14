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

    /** On save of this class query web-service and find out AD_user_ID **/

    private String username;
    private String password;
    private int ad_User_ID;
    private int c_Bpartner_ID;
    private String isActiveUser;

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

    public int getAd_User_ID() {
        return ad_User_ID;
    }

    public void setAd_User_ID(int ad_User_ID) {
        this.ad_User_ID = ad_User_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    /** On save of this record we first fetch the users AD_User_ID and C_BPartner_ID from the Database **/
    @Override
    public long save() throws Exception {
        if (ad_User_ID == 0 || c_Bpartner_ID == 0){
            X_Login_Detail detail = new UserDetailsRequest(username, password).execute().get();
            if (detail.getAd_User_ID() != 0){
                ad_User_ID = detail.getAd_User_ID();
            }
            if (detail.getC_Bpartner_ID() != 0){
                c_Bpartner_ID = detail.getC_Bpartner_ID();
            }
        }
        int ad_User = 0;
        Cursor curs = DBQuery.executeQuery("SELECT * FROM X_Login_Detail WHERE AD_User_ID = " + ad_User_ID + " ");
        while (curs.moveToNext()) {
            ad_User = curs.getInt(curs.getColumnIndex(I_X_LoginDetail.ColumnName_AD_User_ID));
        }
        if (ad_User == 0) {
            ContentValues values = new ContentValues();
            values.put(I_X_LoginDetail.ColumnName_AD_User_ID, ad_User_ID);
            values.put(I_X_LoginDetail.ColumnName_C_BPartner_ID, c_Bpartner_ID);
            values.put(I_X_LoginDetail.ColumnName_Username, username);
            values.put(I_X_LoginDetail.ColumnName_Password, password);
            values.put(I_X_LoginDetail.ColumnName_IsActiveUser, isActiveUser);
            Log.v("InsertingValues", "SavingLoginDetails");
            return DBQuery.insertValues(I_X_LoginDetail.Table_Name, values);
        }
        else {
            Log.i("InsertingUser", "User record already exists");
            return -1;
        }
    }

    @Override
    public void fromJson(JSONObject responseObject) {

    }
}
