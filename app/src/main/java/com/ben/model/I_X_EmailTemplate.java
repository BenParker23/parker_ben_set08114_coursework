package com.ben.model;

/**
 * Created by ben on 01/03/18.
 */

public interface I_X_EmailTemplate {

    public static final String Table_Name = "X_EmailTemplate";

    public static final int MEETING = 1;
    public static final int INTRODUCTION = 2;
    public static final int NEWACC = 3;
    public static final int PROMO = 4;

    public static final String COLUMNNAME_X_EmailTemplate_ID = "X_EmailTemplate_ID";
    public static final String COLUMNNAME_EmailBody = "EmailBody";
    public static final String COLUMNNAME_EmailSubject = "EmailSubject";
    public static final String COLUMNNAME_X_Action_Purpose_ID = "X_EmailTemplate_ID";
    public static final String COLUMNNAME_Name = "Name";

    public static String tableCreationSQL = "CREATE TABLE X_EmailTemplate ( "
            + COLUMNNAME_X_Action_Purpose_ID + " INTEGER, "
            + COLUMNNAME_X_EmailTemplate_ID + "INTEGER PRIMARY KEY, "
            + COLUMNNAME_Name + " TEXT, "
            + COLUMNNAME_EmailBody + " TEXT, "
            + COLUMNNAME_EmailSubject + " TEXT "
            + " ); ";

    public static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
}
