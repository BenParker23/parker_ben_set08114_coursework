package com.ben.webserviceresponse;

import android.util.Base64;
import android.util.Log;

import com.ben.error.SalesAppException;
import com.ben.model.DBObject;
import com.ben.model.I_X_ADUser;
import com.ben.model.I_X_C_BPartner;
import com.ben.model.X_AD_User;
import com.ben.model.X_C_BPartner;
import com.ben.model.X_X_Trigger;
import com.ben.webservice.X_RunProcessResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benparker on 13/07/17.
 */

public class JSONResponseParser {

    private static DBObject modelToCreate;

    public static String parseProcessResponseToString(X_RunProcessResponse response){
        if (response.Summary == null){
            throw new SalesAppException("Process summary is null. Cannot parse ");
        }
        String respons = null;
        byte[] resp = Base64.decode(response.Summary.getBytes(), 0);
        try {
            respons = new String(resp, "UTF-8");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return respons;
    }


    public static void parseProcessResponseToModel(DBObject object, X_RunProcessResponse response){
        if (response.Summary == null){
            throw new SalesAppException("Process summary is null. Cannot parse ");
        }
        JSONObject responseObject = null;
        byte[] resp = Base64.decode(response.Summary.getBytes(), 0);
        try {
            Log.v("Parsed", new String(resp, "UTF-8"));
            responseObject = new JSONObject(new String(resp, "UTF-8"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        getTypeOfDBObject(object, responseObject);
    }


    private static void getTypeOfDBObject(DBObject object, JSONObject responseObject){
        try {
            String tableName = null;
            if (object instanceof X_X_Trigger) {
                tableName = X_X_Trigger.Table_Name;
                createX_ActionObject(responseObject);
            }
            else if (object instanceof X_AD_User) {
                tableName = I_X_ADUser.Table_Name;
            }
            else if (object instanceof X_C_BPartner) {
                tableName = I_X_C_BPartner.Table_Name;
                createX_C_BPartnerObject(responseObject);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void createX_ActionObject(JSONObject responseObject) throws Exception {
        List<JSONObject> allActions = parseJsonData(responseObject, "Actions");
        for (JSONObject action : allActions){
            X_X_Trigger actionRecord = new X_X_Trigger();
            actionRecord.fromJson(action);
            Log.v("InsertingTriggerFromJSON", "" + actionRecord.getX_Trigger_ID() + " Saved ");
        }
    }

    private static void createX_C_BPartnerObject(JSONObject responseObject) throws Exception {
        List<JSONObject> allActions = parseJsonData(responseObject, "BPartners");
        for (JSONObject action : allActions){
            X_C_BPartner bPartnerRecord = new X_C_BPartner();
            bPartnerRecord.fromJson(action);
            Log.v("InsertBPartnerFromJSON", "" + bPartnerRecord.getC_BPartner_ID() + " Saved ");
        }
    }


    private static List<JSONObject> parseJsonData(JSONObject obj, String pattern) throws JSONException {
        List<JSONObject> listOfModelObjects = new ArrayList<JSONObject>();
        JSONArray modelArray = obj.getJSONArray(pattern);
        for (int i = 0; i < modelArray.length(); ++i) {
            final JSONObject model = modelArray.getJSONObject(i);
            listOfModelObjects.add(model);
        }
        return listOfModelObjects;
    }
}
