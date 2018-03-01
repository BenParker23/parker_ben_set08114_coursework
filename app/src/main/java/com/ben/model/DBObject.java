package com.ben.model;

import org.json.JSONObject;

import java.io.Serializable;


/**
 * Created by benparker on 10/07/17.
 */

public abstract class DBObject implements I_Saveable, Serializable {

    /**
     * Used for populating the object variables
     * with the data in the returned
     * Base64 encoded JSONObject from the
     * iDempiere WebService
     * **/
    public abstract void fromJson(JSONObject responseObject);
}
