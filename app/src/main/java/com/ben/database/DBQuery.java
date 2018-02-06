package com.ben.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.ben.error.SalesAppException;

/**
 * @author Ben Parker
 * @created 6/2/2018
 * @usage   The main interface for performing queries on the local
 *          App database
 */
public class DBQuery {

    private static String sql;
    private static Database database;

    public DBQuery(){ }

    public DBQuery(String sql){
        this.sql = sql;
    };

    public static Cursor executeQuery(){
        if (database == null){
            database = Database.getInstance();
        }
        if (sql == null){
            throw new SalesAppException(" SQL Query cannot be null. Please provide String query ");
        }
        Cursor response = database.getQueryableDatabase().rawQuery(sql, null);
        return response;
    }


    public static Cursor executeQuery(String sql){
        if (database == null){
            database = Database.getInstance();
        }
        Cursor response = database.getQueryableDatabase().rawQuery(sql, null);
        return response;
    }


    public static long executeUpdate(String tableName, ContentValues values, String whereClause, String[] whereArgs){
        if (database == null){
            database = Database.getInstance();
        }
        return database.getUpdateableDatabase().update(tableName, values, whereClause, whereArgs);
    }


    public static long insertValues(String tableName, ContentValues values){
        if (database == null){
            database = Database.getInstance();
        }
        return database.getUpdateableDatabase().insert(tableName, null, values);
    }

    public static long deleteRecords(String tableName, String whereClause){
        if (database == null){
            database = Database.getInstance();
        }
        return database.getUpdateableDatabase().delete(tableName, whereClause, null);
    }

    public static String getSql() {
        return sql;
    }

    public static void setSql(String sql) {
        DBQuery.sql = sql;
    }


}
