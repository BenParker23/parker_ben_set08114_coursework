package com.ben.model;

import android.content.ContentValues;

import org.json.JSONObject;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by benparker on 10/07/17.
 */

public abstract class DBObject implements I_Saveable, Serializable {
    public abstract void fromJson(JSONObject responseObject);
}
