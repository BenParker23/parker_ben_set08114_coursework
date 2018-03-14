package com.ben.model;

/**
 * Created by ben on 14/03/18.
 */

public interface I_X_SalesChatter {

    static final String Table_Name = "X_SalesChatter";
    static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";
    static final String COLUMNNAME_X_SalesChatter_ID = "X_SalesChatter_ID";
    static final String COLUMNNAME_Message = "Message";
    static final String COLUMNNAME_X_SalesChatter_Parent_ID = "X_SalesChatter_Parent_ID";
    static final String COLUMNNAME_LinkedImagePath = "LinkedImagePath";


    static String tableCreationSQL = "CREATE TABLE " + Table_Name + " ( "
            + COLUMNNAME_X_SalesChatter_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + COLUMNNAME_C_BPartner_ID + " INTEGER , "
            + COLUMNNAME_X_SalesChatter_Parent_ID + " INTEGER , "
            + COLUMNNAME_Message + " TEXT, "
            + COLUMNNAME_LinkedImagePath + " TEXT "
            + "); " ;

    static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;

}
