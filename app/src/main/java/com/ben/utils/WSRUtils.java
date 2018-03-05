package com.ben.utils;

import com.ben.error.SalesAppException;
import com.ben.model.X_Login_Detail;
import com.ben.webservice.X_ADLoginRequest;
import com.ben.webservice.X_DataField;
import com.ben.webservice.X_DataRow;
import com.ben.webservice.X_Enums;
import com.ben.webservice.X_ModelCRUD;
import com.ben.webservice.X_ModelRunProcess;

/**
 * Created by benparker on 10/07/17.
 */


/** Defining new methods in this Utils class to create a web service
 * request can use :
 * createModelCRUD()
 * createUserDetailsParameters()
 * createLoginRequest();
 */
public class WSRUtils {

    private static X_ModelCRUD modelCRUD;

    private static X_DataRow parameters;
    private static X_ADLoginRequest loginRequest;


    public static X_ModelCRUD createModelCRUD(String serviceType, String tableName, X_Enums.ModelCRUD_Action action){
        modelCRUD = new X_ModelCRUD();
        modelCRUD.setServiceType(serviceType);
        if (tableName != null)
             modelCRUD.setTableName(tableName);
        if (action != null)
            modelCRUD.setAction(action);
        return modelCRUD;
    }


    public static X_ModelRunProcess createModelRunProcess(String serviceType, int AD_Process_ID, int AD_Record_ID){
        X_ModelRunProcess runProcess = new X_ModelRunProcess();
        runProcess.setServiceType(serviceType);
        runProcess.setParamValues(createParamValues(AD_Process_ID, AD_Record_ID));
        return runProcess;
    }


    public static X_ModelRunProcess createModelRunProcess(String serviceType, X_DataRow paramValues){
        X_ModelRunProcess runProcess = new X_ModelRunProcess();
        runProcess.setServiceType(serviceType);
        runProcess.setParamValues(paramValues);
        return runProcess;
    }


    private static X_DataRow createParamValues(int AD_Process_ID, int AD_Record_ID){
        X_DataRow paramValues = new X_DataRow();
        X_DataField ad_Process_ID = new X_DataField();
        X_DataField ad_Record_ID = new X_DataField();
        if (AD_Process_ID != 0){
            ad_Process_ID.setColumn("AD_Process_ID");
            ad_Process_ID.setVal(String.valueOf(AD_Process_ID));
            paramValues.add(ad_Process_ID);
        }
        if (AD_Record_ID != 0){
            ad_Record_ID.setColumn("AD_Record_ID");
            ad_Record_ID.setVal(String.valueOf(AD_Record_ID));
            paramValues.add(ad_Record_ID);
        }
        return paramValues;
    }


    public static X_ADLoginRequest createLoginRequest(String user, String pass){
        if (user == null || pass == null) {
            X_Login_Detail details = DBUtils.getLoggedInUser();
            if (details.getUsername() == null){
                throw new SalesAppException(" No Username/password passed to WSRUtils AND No Login_Detail record saved for current logged in user ");
            }
            user = details.getUsername();
            pass = details.getPassword();
        }
        X_ADLoginRequest aDLoginRequest = new X_ADLoginRequest(user, null, pass , "192", 1000000, 1000027, 1000000,
                1000000, 0);
        return aDLoginRequest;
    }



    public void setParameters(X_DataRow parameters) {
        this.parameters = parameters;
    }

}
