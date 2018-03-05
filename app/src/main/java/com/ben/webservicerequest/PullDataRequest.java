package com.ben.webservicerequest;


import android.os.AsyncTask;
import android.util.Log;

import com.ben.model.DBObject;
import com.ben.utils.DBUtils;
import com.ben.utils.WSRUtils;
import com.ben.webservice.X_ADLoginRequest;
import com.ben.webservice.X_DataField;
import com.ben.webservice.X_DataRow;
import com.ben.webservice.X_ModelRunProcess;
import com.ben.webservice.X_RunProcessResponse;
import com.ben.webserviceresponse.JSONResponseParser;

/**
 * @author Ben Parker
 * @created 8/7/17
 * @usage Method used to pull all query information from the system
 */
public class PullDataRequest extends AsyncTask<DBObject, Void, X_RunProcessResponse> {

    private WebServiceRequest wsr;
    private int SMA_App_Table_ID;
    private X_ModelRunProcess modelRunProcess;
    private X_ADLoginRequest loginRequest;
    private int AD_User_ID;


    @Override
    protected X_RunProcessResponse doInBackground(DBObject... params) {
        X_RunProcessResponse response = runRequest();
        if (response.Error != null){
            Log.v("PullDataError", response.Error);
        }
        if (response.Summary != null){
            Log.v("PullDataSummary", response.Summary);
            JSONResponseParser.parseProcessResponseToModel(params[0], response);
        }
        return response;
    }


    public PullDataRequest(int SMA_App_Table_ID){
        this.SMA_App_Table_ID = SMA_App_Table_ID;
        this.AD_User_ID = DBUtils.getLoggedInUser().getAd_User_ID();
        Log.v("AD_User_ID", "" + AD_User_ID);
    }


    private X_RunProcessResponse runRequest(){
        X_DataRow paramValues = new X_DataRow();
        X_DataField app_Table_ID = new X_DataField();
        app_Table_ID.setColumn("App_Table_ID");
        app_Table_ID.setVal(String.valueOf(SMA_App_Table_ID));
        X_DataField ad_User_ID = new X_DataField();
        ad_User_ID.setColumn("AD_User_ID");
        ad_User_ID.setVal(String.valueOf(AD_User_ID));
        paramValues.add(app_Table_ID);
        paramValues.add(ad_User_ID);
        wsr = new WebServiceRequest(WSRUtils.createModelRunProcess("SMAPullData", paramValues),
                                    I_WebServiceRequest.RUN_PROCESS,
                                    WSRUtils.createLoginRequest(null, null));
        return wsr.runProcess();
    }

}
