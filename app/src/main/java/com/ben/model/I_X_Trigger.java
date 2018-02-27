package com.ben.model;


import java.sql.Timestamp;



/**
 * Created by ben on 26/02/18.
 */

public interface I_X_Trigger
{

    /** TableName=X_Trigger */
    public static final String Table_Name = "X_Trigger";

    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";
    public void setAD_User_ID (int AD_User_ID);
    public int getAD_User_ID();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";
    public void setC_BPartner_ID (int C_BPartner_ID);
    public int getC_BPartner_ID();

    /** Column name CompletedByUser_ID */
    public static final String COLUMNNAME_CompletedByUser_ID = "CompletedByUser_ID";
    public void setCompletedByUser_ID (int CompletedByUser_ID);
    public int getCompletedByUser_ID();

    public static final String COLUMNNAME_CompletedOn = "CompletedOn";
    public void setCompletedOn (Timestamp CompletedOn);
    public Timestamp getCompletedOn();

    public static final String COLUMNNAME_ContactActivityType = "ContactActivityType";
    public void setContactActivityType (String ContactActivityType);
    public String getContactActivityType();

    public static final String COLUMNNAME_Description = "Description";
    public void setDescription (String Description);
    public String getDescription();

    public static final String COLUMNNAME_EndDate = "EndDate";
    public void setEndDate (Timestamp EndDate);
    public Timestamp getEndDate();

    public static final String COLUMNNAME_IsActive = "IsActive";
    public void setIsActive (String IsActive);
    public String isActive();

    public static final String COLUMNNAME_IsSuccess = "IsSuccess";
    public void setIsSuccess (String IsSuccess);
    public String isSuccess();

    public static final String COLUMNNAME_Processed = "Processed";
    public void setProcessed (String Processed);
    public String isProcessed();

    public static final String COLUMNNAME_Result = "Result";
    public void setResult (String Result);
    public String getResult();

    public static final String COLUMNNAME_RoutedOnDate = "RoutedOnDate";
    public void setRoutedOnDate (Timestamp RoutedOnDate);
    public Timestamp getRoutedOnDate();

    public static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";
    public void setSalesRep_ID (int SalesRep_ID);
    public int getSalesRep_ID();

    public static final String COLUMNNAME_SalesValue = "SalesValue";
    public void setSalesValue (double SalesValue);
    public double getSalesValue();

    public static final String COLUMNNAME_StartDate = "StartDate";
    public void setStartDate (Timestamp StartDate);
    public Timestamp getStartDate();

    public static final String COLUMNNAME_X_Action_Category_ID = "X_Action_Category_ID";
    public void setX_Action_Category_ID (int X_Action_Category_ID);
    public int getX_Action_Category_ID();

    public static final String COLUMNNAME_X_Action_Purpose_ID = "X_Action_Purpose_ID";
    public void setX_Action_Purpose_ID (int X_Action_Purpose_ID);
    public int getX_Action_Purpose_ID();

    public static final String COLUMNNAME_X_Action_Status_ID = "X_Action_Status_ID";
    public void setX_Action_Status_ID (int X_Action_Status_ID);
    public int getX_Action_Status_ID();

    public static final String COLUMNNAME_X_Trigger_ID = "X_Trigger_ID";
    public void setX_Trigger_ID (int X_Trigger_ID);
    public int getX_Trigger_ID();


    public static String tableCreationSQL = "CREATE TABLE X_Trigger ( "
            + COLUMNNAME_C_BPartner_ID + " INTEGER PRIMARY KEY , "
            + COLUMNNAME_X_Trigger_ID + " INTEGER, "
            + COLUMNNAME_X_Action_Category_ID + " INTEGER, "
            + COLUMNNAME_X_Action_Purpose_ID + " INTEGER, "
            + COLUMNNAME_X_Action_Status_ID + " TEXT, "
            + COLUMNNAME_CompletedByUser_ID + " INTEGER, "
            + COLUMNNAME_CompletedOn + " TEXT, "
            + COLUMNNAME_AD_User_ID + " TEXT, "
            + COLUMNNAME_Description + " TEXT, "
            + COLUMNNAME_ContactActivityType + " TEXT, "
            + COLUMNNAME_IsActive + " TEXT, "
            + COLUMNNAME_EndDate + " TEXT, "
            + COLUMNNAME_IsSuccess + " TEXT, "
            + COLUMNNAME_Processed + " TEXT, "
            + COLUMNNAME_Result + " TEXT, "
            + COLUMNNAME_RoutedOnDate + " TEXT, "
            + COLUMNNAME_SalesRep_ID + " NUMERIC, "
            + COLUMNNAME_SalesValue + " TEXT, "
            + COLUMNNAME_StartDate + " INTEGER  "
            + " ); ";

    public static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
}

