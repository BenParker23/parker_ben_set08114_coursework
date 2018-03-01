package com.ben.model;

import java.sql.Timestamp;

/**
 * Created by ben on 27/02/18.
 */

public interface I_X_Action_Purpose {

        /** TableName=X_Action_Purpose */
        public static final String Table_Name = "X_Action_Purpose";

        /** Column name DailyLimit */
        public static final String COLUMNNAME_DailyLimit = "DailyLimit";

        /** Set Daily Limit	  */
        public void setDailyLimit (int DailyLimit);

        /** Get Daily Limit	  */
        public int getDailyLimit();

        /** Column name Description */
        public static final String COLUMNNAME_Description = "Description";

        /** Set Description.
         * Optional short description of the record
         */
        public void setDescription (String Description);

        /** Get Description.
         * Optional short description of the record
         */
        public String getDescription();

        /** Column name IsActive */
        public static final String COLUMNNAME_IsActive = "IsActive";

        /** Set Active.
         * The record is active in the system
         */
        public void setIsActive (String IsActive);

        /** Get Active.
         * The record is active in the system
         */
        public String isActive();

        /** Column name Name */
        public static final String COLUMNNAME_Name = "Name";

        /** Set Name.
         * Alphanumeric identifier of the entity
         */
        public void setName (String Name);

        /** Get Name.
         * Alphanumeric identifier of the entity
         */
        public String getName();

        /** Column name SalesValueQuantifiable */
        public static final String COLUMNNAME_SalesValueQuantifiable = "SalesValueQuantifiable";

        /** Set Quantifiable Sales Value	  */
        public void setSalesValueQuantifiable (String SalesValueQuantifiable);

        /** Get Quantifiable Sales Value	  */
        public String isSalesValueQuantifiable();

        /** Column name TableName */
        public static final String COLUMNNAME_TableName = "TableName";

        public static final String COLUMNNAME_TotalSalesValue = "TotalSalesValue";

        /** Set Total Sales Value	  */
        public void setTotalSalesValue (double TotalSalesValue);

        /** Get Total Sales Value	  */
        public double getTotalSalesValue();

        /** Column name Value */
        public static final String COLUMNNAME_Value = "Value";

        /** Set Search Key.
         * Search key for the record in the format required - must be unique
         */
        public void setValue (String Value);

        /** Get Search Key.
         * Search key for the record in the format required - must be unique
         */
        public String getValue();


        /** Column name X_Action_Purpose_ID */
        public static final String COLUMNNAME_X_Action_Purpose_ID = "X_Action_Purpose_ID";

        /** Set Action Purpose	  */
        public void setX_Action_Purpose_ID (int X_Action_Purpose_ID);

        /** Get Action Purpose	  */
        public int getX_Action_Purpose_ID();

        /** Column name X_Action_Status_ID */
        public static final String COLUMNNAME_X_Action_Status_ID = "X_Action_Status_ID";

        /** Set Action Status	  */
        public void setX_Action_Status_ID (int X_Action_Status_ID);

        /** Get Action Status	  */
        public int getX_Action_Status_ID();

        public static String tableCreationSQL = "CREATE TABLE X_Action_Purpose ( "
                + COLUMNNAME_X_Action_Purpose_ID + " INTEGER PRIMARY KEY , "
                + COLUMNNAME_X_Action_Status_ID + " INTEGER, "
                + COLUMNNAME_Name + " TEXT, "
                + COLUMNNAME_DailyLimit + " INTEGER, "
                + COLUMNNAME_Description + " TEXT, "
                + COLUMNNAME_IsActive + " TEXT, "
                + COLUMNNAME_SalesValueQuantifiable + " TEXT, "
                + COLUMNNAME_Value + " TEXT, "
                + COLUMNNAME_TotalSalesValue + " NUMERIC "
                + " ); ";

        public static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
    }
