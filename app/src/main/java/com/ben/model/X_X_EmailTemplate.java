package com.ben.model;

import android.content.ContentValues;

import com.ben.database.DBQuery;

import org.json.JSONObject;

/**
 * Created by ben on 01/03/18.
 */

public class X_X_EmailTemplate extends DBObject {

    private String EmailBody;
    private String EmailSubject;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private int X_EmailTemplate_ID;
    private int X_Action_Purpose_ID;

    public String getEmailBody() {
        return EmailBody;
    }

    public void setEmailBody(String emailBody) {
        this.EmailBody = emailBody;
    }

    public String getEmailSubject() {
        return EmailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.EmailSubject = emailSubject;
    }

    public int getX_EmailTemplate_ID() {
        return X_EmailTemplate_ID;
    }

    public void setX_EmailTemplate_ID(int x_EmailTemplate_ID) {
        X_EmailTemplate_ID = x_EmailTemplate_ID;
    }

    public int getX_Action_Purpose_ID() {
        return X_Action_Purpose_ID;
    }

    public void setX_Action_Purpose_ID(int x_Action_Purpose_ID) {
        X_Action_Purpose_ID = x_Action_Purpose_ID;
    }


    @Override
    public long save() throws Exception {
        ContentValues values = new ContentValues();
        values.put(I_X_EmailTemplate.COLUMNNAME_X_EmailTemplate_ID, getX_EmailTemplate_ID());
        values.put(I_X_EmailTemplate.COLUMNNAME_EmailBody, getEmailBody());
        values.put(I_X_EmailTemplate.COLUMNNAME_EmailSubject, getEmailSubject());
        values.put(I_X_EmailTemplate.COLUMNNAME_X_Action_Purpose_ID, getX_Action_Purpose_ID());
        String[]args = new String[1];
        args[0] = String.valueOf(getX_EmailTemplate_ID());
        return DBQuery.executeUpdate(I_X_Trigger.Table_Name, values,
                I_X_EmailTemplate.COLUMNNAME_X_EmailTemplate_ID + " = ?", args);
    }


    @Override
    public void fromJson(JSONObject responseObject) {

    }
}
