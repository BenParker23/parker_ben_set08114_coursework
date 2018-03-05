package com.ben.model;

/**
 * Created by benparker on 10/07/17.
 */

public interface I_X_LoginDetail {

    static final String Table_Name = "X_Login_Detail";
    static final String ColumnName_Username = "Username";
    static final String ColumnName_Password = "Password";
    static final String ColumnName_AD_User_ID = "AD_User_ID";
    static final String ColumnName_C_BPartner_ID = "C_BPartner_ID";
    static final String ColumnName_IsActiveUser = "IsActiveUser";
    static final String ColumnName_X_LoginDetail_ID = "X_LoginDetail_ID";

    /** TODO - Store password as hashed password **/
    static String tableCreationSQL = "CREATE TABLE " + Table_Name + " ( "
            + ColumnName_X_LoginDetail_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ColumnName_AD_User_ID + " INTEGER, "
            + ColumnName_C_BPartner_ID + " INTEGER, "
            + ColumnName_Username + " VARCHAR(50), "
            + ColumnName_Password + " VARCHAR(50), "
            + ColumnName_IsActiveUser + " VARCHAR(10) "
            + "); " ;

    static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name + "; ";
}
