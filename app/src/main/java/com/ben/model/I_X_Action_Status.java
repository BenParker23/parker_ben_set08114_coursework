package com.ben.model;

/**
 * Created by BenPa on 01/03/2018.
 */

public interface I_X_Action_Status {

    public static final int OPEN = 1;
    public static final int IN_PROGRESS = 2;
    public static final int CLOSED_SUCCESS = 3;
    public static final int CLOSED_FAILURE = 4;


    /**
     * TableName=X_Action_Status
     */
    public static final String Table_Name = "X_Action_Status";

    /**
     * Column name Description
     */
    public static final String COLUMNNAME_Description = "Description";

    /**
     * Set Description.
     * Optional short description of the record
     */
    public void setDescription(String Description);

    /**
     * Get Description.
     * Optional short description of the record
     */
    public String getDescription();

    /**
     * Column name IsActive
     */
    public static final String COLUMNNAME_IsActive = "IsActive";

    /**
     * Set Active.
     * The record is active in the system
     */
    public void setIsActive(String IsActive);

    /**
     * Get Active.
     * The record is active in the system
     */
    public String isActive();

    /**
     * Column name Name
     */
    public static final String COLUMNNAME_Name = "Name";

    /**
     * Set Name.
     * Alphanumeric identifier of the entity
     */
    public void setName(String Name);

    /**
     * Get Name.
     * Alphanumeric identifier of the entity
     */
    public String getName();

    /**
     * Column name X_Action_Status_ID
     */
    public static final String COLUMNNAME_X_Action_Status_ID = "X_Action_Status_ID";

    /**
     * Set Action Status
     */
    public void setX_Action_Status_ID(int X_Action_Status_ID);

    /**
     * Get Action Status
     */
    public int getX_Action_Status_ID();


    public static String tableCreationSQL = "CREATE TABLE X_Action_Status ( "
            + COLUMNNAME_X_Action_Status_ID + " INTEGER, "
            + COLUMNNAME_Name + " TEXT, "
            + COLUMNNAME_Description + " TEXT, "
            + COLUMNNAME_IsActive + " TEXT "
            + " ); ";

    public static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
}