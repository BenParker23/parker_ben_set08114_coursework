package com.ben.utils;

import android.database.Cursor;

import com.ben.database.DBQuery;
import com.ben.model.X_Login_Detail;

/**
 * Created by benparker on 10/07/17.
 */

public class DBUtils {

    public static X_Login_Detail getLoggedInUser(){
        DBQuery getUser = new DBQuery("SELECT * FROM X_Login_Detail WHERE IsActiveUser = 'Y' ");
        Cursor userCursor = getUser.executeQuery();
        X_Login_Detail details = new X_Login_Detail();
        while (userCursor.moveToNext()){
            details.setUsername(userCursor.getString(userCursor.getColumnIndex(X_Login_Detail.ColumnName_Username)));
            details.setPassword(userCursor.getString(userCursor.getColumnIndex(X_Login_Detail.ColumnName_Password)));
            details.setAd_User_ID(userCursor.getInt(userCursor.getColumnIndex(X_Login_Detail.ColumnName_AD_User_ID)));
            details.setC_Bpartner_ID(userCursor.getInt(userCursor.getColumnIndex(X_Login_Detail.ColumnName_C_BPartner_ID)));
        }
        userCursor.close();
        return details;
    }





}
