package com.ben.model;

import android.content.ContentValues;

import com.ben.database.DBQuery;

import org.json.JSONObject;

/**
 * Created by ben on 14/03/18.
 */

public class X_SalesChatter extends DBObject {

    private int C_BPartner_ID;
    private int X_SalesChatter_ID;
    private String Message;
    private int X_SalesChatter_Parent_ID = 0;
    private String LinkedImagePath;
    private String bpName;

    public String getBpName() {
        return bpName;
    }

    public void setBpName(String bpName) {
        this.bpName = bpName;
    }

    public int getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    public void setC_BPartner_ID(int c_BPartner_ID) {
        C_BPartner_ID = c_BPartner_ID;
    }

    public int getX_SalesChatter_ID() {
        return X_SalesChatter_ID;
    }

    public void setX_SalesChatter_ID(int x_SalesChatter_ID) {
        X_SalesChatter_ID = x_SalesChatter_ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getX_SalesChatter_Parent_ID() {
        return X_SalesChatter_Parent_ID;
    }

    public void setX_SalesChatter_Parent_ID(int x_SalesChatter_Parent_ID) {
        X_SalesChatter_Parent_ID = x_SalesChatter_Parent_ID;
    }

    public String getLinkedImagePath() {
        return LinkedImagePath;
    }

    public void setLinkedImagePath(String linkedImagePath) {
        LinkedImagePath = linkedImagePath;
    }

    @Override
    public long save() throws Exception {
        ContentValues values = new ContentValues();
        values.put(I_X_SalesChatter.COLUMNNAME_LinkedImagePath, getLinkedImagePath());
        values.put(I_X_SalesChatter.COLUMNNAME_X_SalesChatter_Parent_ID, getX_SalesChatter_Parent_ID());
        values.put(I_X_SalesChatter.COLUMNNAME_Message, getMessage());
        values.put(I_X_C_BPartner.COLUMNNAME_C_BPartner_ID, getC_BPartner_ID());
        return DBQuery.insertValues(I_X_SalesChatter.Table_Name, values);
    }

    @Override
    public void fromJson(JSONObject responseObject) {

    }
}
