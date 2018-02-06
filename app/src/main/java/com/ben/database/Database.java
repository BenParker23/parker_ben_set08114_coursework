package com.ben.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ben.error.SalesAppException;

/** Singleton **/
public class Database {

    private static DatabaseCreator databaseCreator;
    private static Database database;
    private static final Object LOCK = new Object();

    private Database() {} ;

    /** Uses synchronized code block to prevent concurrency issues **/
    public static Database getInstance(){
        synchronized (LOCK) {
            if (databaseCreator == null) {
                throw new SalesAppException(" Database does not yet exist. Create Database first. ");
            }
        }
        return database;
    }



    public static void createOrUpgradeDatabase(Context context){
        Log.v("DatabaseCreation", "createDatabase method called");
        databaseCreator = new DatabaseCreator(context);
        getUpdateableDatabase().close();
    }

    public static SQLiteDatabase getQueryableDatabase(){
        return databaseCreator.getReadableDatabase();
    }

    public static SQLiteDatabase getUpdateableDatabase(){
        return databaseCreator.getWritableDatabase();
    }
}
