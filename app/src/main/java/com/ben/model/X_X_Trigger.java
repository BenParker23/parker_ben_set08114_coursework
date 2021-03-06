package com.ben.model;

import android.content.ContentValues;
import android.util.Log;

import com.ben.database.DBQuery;

import org.json.JSONObject;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by ben on 26/02/18.
 */

public class X_X_Trigger extends DBObject implements I_X_Trigger{

    private int AD_User_ID;
    private int C_BPartner_ID;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private String statusName;
    public String getActionPurposeName() {
        return actionPurposeName;
    }

    public void setActionPurposeName(String actionPurposeName) {
        this.actionPurposeName = actionPurposeName;
    }

    private String actionPurposeName;
    private int SalesRep_ID;
    private int CompletedByUser_ID;
    private int X_Trigger_ID;
    private Timestamp CompletedOn;
    private String Description;
    private String ContactActivityType;
    private Timestamp EndDate;
    private Timestamp StartDate;
    private int X_Action_Status_ID;
    private int X_Action_Category_ID;
    private int X_Action_Purpose_ID;
    private String Result;
    private String Processed;
    private String IsSuccess;
    private String IsActive;

    @Override
    public int getAD_User_ID() {
        return AD_User_ID;
    }

    @Override
    public void setAD_User_ID(int AD_User_ID) {
        this.AD_User_ID = AD_User_ID;
    }

    @Override
    public int getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    @Override
    public void setC_BPartner_ID(int c_BPartner_ID) {
        C_BPartner_ID = c_BPartner_ID;
    }

    @Override
    public int getSalesRep_ID() {
        return SalesRep_ID;
    }

    @Override
    public void setSalesValue(double SalesValue) {

    }

    @Override
    public double getSalesValue() {
        return 0;
    }

    @Override
    public void setSalesRep_ID(int salesRep_ID) {
        SalesRep_ID = salesRep_ID;
    }

    @Override
    public int getCompletedByUser_ID() {
        return CompletedByUser_ID;
    }

    @Override
    public void setCompletedByUser_ID(int completedByUser_ID) {
        CompletedByUser_ID = completedByUser_ID;
    }

    @Override
    public int getX_Trigger_ID() {
        return X_Trigger_ID;
    }

    @Override
    public void setX_Trigger_ID(int x_Trigger_ID) {
        X_Trigger_ID = x_Trigger_ID;
    }

    @Override
    public Timestamp getCompletedOn() {
        return CompletedOn;
    }

    @Override
    public void setCompletedOn(Timestamp completedOn) {
        CompletedOn = completedOn;
    }

    @Override
    public String getDescription() {
        return Description;
    }

    @Override
    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String getContactActivityType() {
        return ContactActivityType;
    }

    @Override
    public void setContactActivityType(String contactActivityType) {
        ContactActivityType = contactActivityType;
    }

    @Override
    public Timestamp getEndDate() {
        return EndDate;
    }

    @Override
    public void setIsActive(String IsActive) {
        this.IsActive = IsActive;
    }

    @Override
    public String isActive() {
        return IsActive;
    }

    @Override
    public void setIsSuccess(String IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    @Override
    public String isSuccess() {
        return IsSuccess;
    }

    @Override
    public void setProcessed(String Processed) {
        this.Processed = Processed;
    }

    @Override
    public String isProcessed() {
        return Processed;
    }


    @Override
    public void setEndDate(Timestamp endDate) {
        EndDate = endDate;
    }

    @Override
    public Timestamp getStartDate() {
        return StartDate;
    }

    @Override
    public void setStartDate(Timestamp startDate) {
        StartDate = startDate;
    }

    @Override
    public int getX_Action_Status_ID() {
        return X_Action_Status_ID;
    }

    @Override
    public void setX_Action_Status_ID(int x_Action_Status_ID) {
        X_Action_Status_ID = x_Action_Status_ID;
    }

    @Override
    public int getX_Action_Category_ID() {
        return X_Action_Category_ID;
    }

    @Override
    public void setX_Action_Category_ID(int x_Action_Category_ID) {
        X_Action_Category_ID = x_Action_Category_ID;
    }

    @Override
    public int getX_Action_Purpose_ID() {
        return X_Action_Purpose_ID;
    }

    @Override
    public void setX_Action_Purpose_ID(int x_Action_Purpose_ID) {
        X_Action_Purpose_ID = x_Action_Purpose_ID;
    }

    @Override
    public String getResult() {
        return Result;
    }

    @Override
    public void setRoutedOnDate(Timestamp RoutedOnDate) {

    }

    @Override
    public Timestamp getRoutedOnDate() {
        return null;
    }

    @Override
    public void setResult(String result) {
        Result = result;
    }


    @Override
    public long save() {
        try {
            ContentValues values = new ContentValues();
            values.put(I_X_Trigger.COLUMNNAME_C_BPartner_ID, getC_BPartner_ID());
            values.put(I_X_Trigger.COLUMNNAME_Description, getDescription());
            values.put(I_X_Trigger.COLUMNNAME_SalesRep_ID, getSalesRep_ID());
            values.put(I_X_Trigger.COLUMNNAME_CompletedByUser_ID, getCompletedByUser_ID());
            values.put(I_X_Trigger.COLUMNNAME_CompletedOn, String.valueOf(getCompletedOn()));
            values.put(I_X_Trigger.COLUMNNAME_Result, getResult());
            values.put(I_X_Trigger.COLUMNNAME_X_Action_Status_ID, getX_Action_Status_ID());
            String[]args = new String[1];
            args[0] = String.valueOf(getX_Trigger_ID());
            return DBQuery.executeUpdate(I_X_Trigger.Table_Name, values, "X_Trigger_ID = ?", args);
        }
        catch (Exception e){
            Log.v("SaveErrorTrigger", e.getLocalizedMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void fromJson(JSONObject responseObject) {

    }
}
