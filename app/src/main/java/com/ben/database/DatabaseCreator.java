package com.ben.database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.ben.model.I_X_Action_Purpose;
import com.ben.model.I_X_C_BPartner;
import com.ben.model.I_X_Trigger;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage   Used to create the initial local database on the app
 */
public class DatabaseCreator extends SQLiteOpenHelper {

    private StringBuffer databaseCreation = new StringBuffer();
    private static final String SQLITE_DATABASE_NAME = "SalesApp_Database";

    private Context context;

    public DatabaseCreator(Context context){
        super(context, SQLITE_DATABASE_NAME, null, 1);
        this.context = context;
    }


    /**
     * This method is for the sandbox version of the app
     * This will be replaced by WebService calls to the appropriate tables
     * Cannot implement web service calls at the moment as live data
     * will be updated on production RDS
     */
    private void readFromFile(){
        StringBuilder text = new StringBuilder();
        try {
            String result = new BufferedReader(new InputStreamReader(context.getAssets().open("ExampleTriggerData.txt")))
                    .lines().collect(Collectors.joining("\n"));
            Log.v("Result", result);
        }
        catch (IOException e) {
            Log.v("ErrorReadingFile", e.getLocalizedMessage());
        }
    }


    /** Called on the initial install of the app **/
    @Override
    public void onCreate(SQLiteDatabase db) {
        readFromFile();
        db.execSQL(I_X_C_BPartner.tableCreationSQL);
        db.execSQL(I_X_Trigger.tableCreationSQL);
        db.execSQL(I_X_Action_Purpose.tableCreationSQL);

        String triggerRecord1 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 1 , 'Customer Stopped Ordering Soft Drinks', 'Y', 'N', 1000001, 1000102, 1001000, 0, 'Y', 1000000, 1000000, 1000000, '2018-02-26', '2018-02-26'); ";
        String triggerRecord2 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 1 , 'Customer Stopped Ordering Soft Drinks', 'Y', 'N', 1000001, 1000103, 1001002, 0, 'Y', 1000000, 1000000, 1000000, '2018-02-26', '2018-02-26'); ";
        String triggerRecord3 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 1 , 'Customer Stopped Ordering Soft Drinks', 'Y', 'N', 1000001, 1000104, 1001003, 0, 'Y', 1000000, 1000000, 1000000, '2018-02-26', '2018-02-26'); ";
        String triggerRecord4 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 1 , 'Customer Stopped Ordering Soft Drinks', 'Y', 'N', 1000001, 1000105, 1001004, 0, 'Y', 1000000, 1000000, 1000000, '2018-02-26', '2018-02-26'); ";
        String triggerRecord5 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 1 , 'Customer Stopped Ordering Soft Drinks', 'Y', 'N', 1000001, 1000106, 1001005, 0, 'Y', 1000000, 1000000, 1000000, '2018-02-26', '2018-02-26'); ";

        String bpartnerRecord1 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID, SalesRep_ID) VALUES(1001000, 'Oykel Bridge Hotel', 'OO39', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord2 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001001, 'Aultbea Hotel', 'AA33', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord3 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001002, 'One Stop Shop', 'OO11', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord4 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES (1001003, 'Spar Culbokie', 'SS97', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord5 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(100104, 'One Beer More', 'OO21', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord6 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001005, 'Kilmarnock Hotel', 'KK20', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord7 = "INSERT INTO C_BPartner ( C_BPartner_ID, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID) VALUES(1001006, 'Ben Parker', 'BB01', 'Y', 'N', 1000000); ";

        String purposeRecord1 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000000, 'Customer Stopped Ordering Category', 'Y', 'Y', 'CSOC' ); ";
        String purposeRecord2 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000001, 'Customer Stopped Ordering Total', 'Y', 'Y', 'CSOT' ); ";
        String purposeRecord3 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000002, 'Scheduled Call', 'Y', 'N', 'SCHC' ); ";
        String purposeRecord4 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000003, 'Expected Order Not Placed', 'Y', 'Y', 'EONP' ); ";

        db.execSQL(triggerRecord1);
        db.execSQL(triggerRecord2);
        db.execSQL(triggerRecord3);
        db.execSQL(triggerRecord4);
        db.execSQL(triggerRecord5);

        db.execSQL(bpartnerRecord1);
        db.execSQL(bpartnerRecord2);
        db.execSQL(bpartnerRecord3);
        db.execSQL(bpartnerRecord4);
        db.execSQL(bpartnerRecord5);
        db.execSQL(bpartnerRecord6);
        db.execSQL(bpartnerRecord7);

        db.execSQL(purposeRecord1);
        db.execSQL(purposeRecord2);
        db.execSQL(purposeRecord3);
        db.execSQL(purposeRecord4);

        Log.v("DatabaseCreation", "onCreate method called and ended" );
    }


    /** Called every time the app is called if database is a new version **/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(I_X_C_BPartner.tableDeletionSQL);
        db.execSQL(I_X_Trigger.tableDeletionSQL);
        Log.v("DatabaseUpgrade", "DatabaseHelper upgraded - Version : " + newVersion);
        onCreate(db);
    }
}
