package com.ben.database;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.ben.model.I_X_Action_Purpose;
import com.ben.model.I_X_Action_Status;
import com.ben.model.I_X_C_BPartner;
import com.ben.model.I_X_EmailTemplate;
import com.ben.model.I_X_SalesChatter;
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
        super(context, SQLITE_DATABASE_NAME, null, 3);
        this.context = context;
    }

    /** Called on the initial install of the app **/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(I_X_C_BPartner.tableCreationSQL);
        db.execSQL(I_X_Trigger.tableCreationSQL);
        db.execSQL(I_X_Action_Purpose.tableCreationSQL);
        db.execSQL(I_X_Action_Status.tableCreationSQL);
        db.execSQL(I_X_EmailTemplate.tableCreationSQL);
        db.execSQL(I_X_SalesChatter.tableCreationSQL);

        String triggerRecord1 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 1 , 'Customer Stopped Ordering Soft Drinks. Their Sales YTD on this category are £612.89, please resolve situation.', 'Y', 'N', 1000001, 1000102, 1001000, 0, 'Y', 1000000, 1000000, 1, '2018-02-26', '2018-02-26'); ";
        String triggerRecord2 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 2 , 'Customer Stopped Ordering Beer & Cider. Their Sales YTD on this category are £6712.92, please resolve situation.', 'Y', 'N', 1000001, 1000103, 1001002, 0, 'Y', 1000000, 1000000, 1, '2018-02-26', '2018-02-26'); ";
        String triggerRecord3 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 3 , 'Customer Stopped Ordering Kegs. Their Sales YTD on this category are £2312.89, please resolve situation.', 'Y', 'N', 1000001, 1000104, 1001003, 0, 'Y', 1000000, 1000000, 2, '2018-02-26', '2018-02-26'); ";
        String triggerRecord4 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 4 , 'Customer Stopped Ordering Total. Please resolve situation. ', 'Y', 'N', 1000001, 1000105, 1001004, 0, 'Y', 1000001, 1000000, 2, '2018-02-26', '2018-02-26'); ";
        String triggerRecord5 = " INSERT INTO X_Trigger ( X_Trigger_ID, Description, IsSuccess, Processed, SalesRep_ID, AD_User_ID, C_BPartner_ID, SalesValue, IsActive,  X_Action_Purpose_ID, X_Action_Category_ID, X_Action_Status_ID, StartDate, EndDate ) VALUES ( 5 , 'Customer Stopped Ordering Total. Please resolve situation. ', 'Y', 'N', 1000001, 1000106, 1001005, 0, 'Y', 1000001, 1000000, 2, '2018-02-26', '2018-02-26'); ";

        String bpartnerRecord1 = "INSERT INTO C_BPartner ( C_BPartner_ID, Email, GrossProfit, SalesValue, WebPercent, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID, SalesRep_ID)  VALUES(1001000, 'oykel@outlook.com', 3103.97, 23945, 23.46, 'Oykel Bridge Hotel', 'OO39', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord2 = "INSERT INTO C_BPartner ( C_BPartner_ID, Email, GrossProfit, SalesValue, WebPercent, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001001, 'aultbea@outlook.com', 760.76, 12002, 89.25, 'Aultbea Hotel', 'AA33', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord3 = "INSERT INTO C_BPartner ( C_BPartner_ID, Email, GrossProfit, SalesValue, WebPercent, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001002,  'onestop@outlook.com', 41772.99, 126023, 50.00, 'One Stop Shop', 'OO11', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord4 = "INSERT INTO C_BPartner ( C_BPartner_ID, Email, GrossProfit, SalesValue, WebPercent, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001003, 'spar@outlook.com', 12335.18, 48622, 0.00, 'Spar Culbokie', 'SS97', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord5 = "INSERT INTO C_BPartner ( C_BPartner_ID, Email, GrossProfit, SalesValue, WebPercent, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001004, 'beermore@outlook.com', 31009.87, 97542, 12, 'One Beer More', 'OO21', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord6 = "INSERT INTO C_BPartner ( C_BPartner_ID, Email, GrossProfit, SalesValue, WebPercent, Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID , SalesRep_ID) VALUES(1001005, 'kilmarnockhotel@outlook.com', 7011.33, 21455, 100, 'Kilmarnock Hotel', 'KK20', 'N', 'Y', 1000000, 1000001); ";
        String bpartnerRecord7 = "INSERT INTO C_BPartner ( C_BPartner_ID,  Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID) VALUES(1001006, 'Ben Parker', 'BB01', 'Y', 'N', 1000000); ";
        String bpartnerRecord8 = "INSERT INTO C_BPartner ( C_BPartner_ID,  Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID) VALUES(1001007, 'Steve Crowson', 'SS02', 'Y', 'N', 1000000); ";
        String bpartnerRecord9 = "INSERT INTO C_BPartner ( C_BPartner_ID,  Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID) VALUES(1001008, 'Cathy Hamilton', 'CC92', 'Y', 'N', 1000000); ";
        String bpartnerRecord10 = "INSERT INTO C_BPartner ( C_BPartner_ID,  Name, Value, IsSalesRep, IsCustomer, M_Pricelist_ID) VALUES(1001009, 'Richard Collie', 'RR87', 'Y', 'N', 1000000); ";

        String purposeRecord1 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000000, 'Customer Stopped Ordering Category', 'Y', 'Y', 'CSOC' ); ";
        String purposeRecord2 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000001, 'Customer Stopped Ordering Total', 'Y', 'Y', 'CSOT' ); ";
        String purposeRecord3 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000002, 'Scheduled Call', 'Y', 'N', 'SCHC' ); ";
        String purposeRecord4 = "INSERT INTO X_Action_Purpose ( X_Action_Purpose_ID, Name, SalesValueQuantifiable, IsActive, Value ) VALUES ( 1000003, 'Expected Order Not Placed', 'Y', 'Y', 'EONP' ); ";

        String statusRecord1 = "INSERT INTO X_Action_Status ( X_Action_Status_ID, Name, Description, IsActive ) VALUES ( 1, 'Open - No Contact Made', 'This trigger has not been attempted yet', 'Y' ); ";
        String statusRecord2 = "INSERT INTO X_Action_Status ( X_Action_Status_ID, Name, Description, IsActive ) VALUES ( 2, 'In Progress', 'This trigger has been attempted and is waiting for feedback', 'Y' ); ";
        String statusRecord3 = "INSERT INTO X_Action_Status ( X_Action_Status_ID, Name, Description, IsActive ) VALUES ( 3, 'Closed - Success', 'This trigger is done and successful. ', 'Y' ); ";
        String statusRecord4 = "INSERT INTO X_Action_Status ( X_Action_Status_ID, Name, Description, IsActive ) VALUES ( 4, 'Closed - Failure', 'This trigger is done but objective not complete.', 'Y' ); ";


        String emailTemp1 = "INSERT INTO X_EmailTemplate ( X_EmailTemplate_ID, Name, EmailBody, EmailSubject ) VALUES ( 1, 'Arrange A Meeting', 'Hello @CustomerName@, /n I hope you are well! /n /n Its been a while since we spoke, just wondering if youre available for a catchup on @DATE@ for a quick catchup so I can find out how things are going? /n Let me know when you can! /n Kind Regards /n @UserName@', 'Meeting Due' ); ";
        String emailTemp2 = "INSERT INTO X_EmailTemplate ( X_EmailTemplate_ID, Name, EmailBody, EmailSubject ) VALUES ( 2, 'Introduction', 'Hello @Name@, /n My name is @UserName@, Im just emailing to introduce myself. I work in @CompanyName@, and we currently offer a great level of service to your area already. Im wondering if you have got a few minutes so we can catch up? /n /n\n" + "Our website is @WebsiteURL@, we have some great promotions at the moment. If you send me over your email I can fix you up with a login so you can browse and see if well be a good fit! /n /n Let me know whenever you can! /n Kind Regards, /n @UserName@', '@CompanyName@ Introduction' ); ";
        String emailTemp3 = "INSERT INTO X_EmailTemplate ( X_EmailTemplate_ID, Name, EmailBody, EmailSubject ) VALUES ( 3, 'New Account', 'Hello @Name@, /n Following our discussion previously, here are your online login details : /n UserName : /n Password : /n Ive attached our new account forms so if you can fill them in and send them back to me well get your account finalised. /n If you have any issues, dont hesitate to get in touch. /n Kind Regards, /n @UserName@', 'New Account Setup' ); ";
        String emailTemp4 = "INSERT INTO X_EmailTemplate ( X_EmailTemplate_ID, Name, EmailBody, EmailSubject ) VALUES ( 4, 'Promotion', 'Hello @Name@, /n I hope you are well! /n Just a quick email to let you know about some of applicable promotions. I had a look through and seen these great ones for you! /n @Promo1@ /n @Promo2@ /n @Promo3@ /n Ive attached a PDF version of our promotions brochure. Feel free to browse! /n Kind Regards, /n @UserName@', 'Applicable Promotions' ); ";


        String salesChat1 = "INSERT INTO X_SalesChatter ( C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001006, 0, 'NULL', 'Does anyone know if we are stocking Bibendum wines this month?' ); ";
        String salesChat2 = "INSERT INTO X_SalesChatter (  C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001007, 0, 'NULL', 'Are the retail promotion brochures in the office yet?' ); ";
        String salesChat3 = "INSERT INTO X_SalesChatter (  C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001008, 0, 'NULL', 'Heres the sales figures from Aultbea Hotel this month guys'); ";
        String salesChat4 = "INSERT INTO X_SalesChatter (  C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001009, 0, 'NULL', 'Another £2000 gained from Westerlea Hotel this month!! ' ); ";
        String salesChat5 = "INSERT INTO X_SalesChatter (  C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001008, 0, 'NULL', 'Stornoway is an island with plenty of promise but we arent getting the sales! Thoughts? ' ); ";
        String salesChat6 = "INSERT INTO X_SalesChatter (  C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001007, 0, 'NULL', 'Web Sales this month are looking excellent! 72% is a great increase on last month' ); ";
        String salesChat7 = "INSERT INTO X_SalesChatter (  C_BPartner_ID, X_SalesChatter_Parent_ID, LinkedImagePath, Message ) VALUES ( 1001009, 0, 'NULL', 'Anyone know if Rock Rose is selling to us with a special price this month? Customers are asking' ); ";

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
        db.execSQL(bpartnerRecord8);
        db.execSQL(bpartnerRecord9);
        db.execSQL(bpartnerRecord10);

        db.execSQL(purposeRecord1);
        db.execSQL(purposeRecord2);
        db.execSQL(purposeRecord3);
        db.execSQL(purposeRecord4);

        db.execSQL(statusRecord1);
        db.execSQL(statusRecord2);
        db.execSQL(statusRecord3);
        db.execSQL(statusRecord4);

        db.execSQL(emailTemp1);
        db.execSQL(emailTemp2);
        db.execSQL(emailTemp3);
        db.execSQL(emailTemp4);

        db.execSQL(salesChat1);
        db.execSQL(salesChat2);
        db.execSQL(salesChat3);
        db.execSQL(salesChat4);
        db.execSQL(salesChat5);
        db.execSQL(salesChat6);
        db.execSQL(salesChat7);


        Log.v("DatabaseCreation", "onCreate method called and ended" );
    }


    /** Called every time the app is called if database is a new version **/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(I_X_C_BPartner.tableDeletionSQL);
        db.execSQL(I_X_Trigger.tableDeletionSQL);
        db.execSQL(I_X_Action_Purpose.tableDeletionSQL);
        db.execSQL(I_X_Action_Status.tableDeletionSQL);
        db.execSQL(I_X_EmailTemplate.tableDeletionSQL);
        db.execSQL(I_X_SalesChatter.tableDeletionSQL);
        Log.v("DatabaseUpgrade", "DatabaseHelper upgraded - Version : " + newVersion);
        onCreate(db);
    }
}
