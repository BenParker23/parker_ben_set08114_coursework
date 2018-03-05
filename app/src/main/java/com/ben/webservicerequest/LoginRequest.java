package com.ben.webservicerequest;

import android.os.AsyncTask;
import android.util.Log;

import com.ben.utils.WSRUtils;
import com.ben.webservice.X_ADLoginRequest;
import com.ben.webservice.X_DataField;
import com.ben.webservice.X_DataRow;
import com.ben.webservice.X_Enums;
import com.ben.webservice.X_ModelCRUD;
import com.ben.webservice.X_WindowTabData;

/**
 * @author Ben Parker
 * @created 22/5/17
 * @usage Create a new object passing Username and Password into constructor
 * Then call authenticateUser() method to perform loginRequest
 * Used as form of abstraction and to improve code clarity in the
 * activity handler classes when logging in
 */
public class LoginRequest extends AsyncTask<Void, Void, Integer> {

    private WebServiceRequest wsRequest;
    private String username;
    private String password;

    @Override
    protected Integer doInBackground(Void... params) {
        return authenticateUser();
    }

    public LoginRequest(String username, String password){
        this.username = username;
        this.password = password;

        X_ADLoginRequest loginRequest = createLoginRequest(username, password);
        X_ModelCRUD modelCrud = createModelCRUD();
        wsRequest = new WebServiceRequest(modelCrud, I_WebServiceRequest.READ_DATA, WSRUtils.createLoginRequest(username, password));
    }


    /**
     * @return -1 IF error ELSE 1
     */
    public int authenticateUser(){
        X_WindowTabData response = wsRequest.readData();
        if (response.Error != null){
            Log.v("ErrorLogin",response.Error);
            return -1;
        }
        return 1;
    }



    private X_DataRow createLoginDataRow(){
        X_DataField usernameParam = new X_DataField();
            usernameParam.setColumn("Username");
            usernameParam.setVal(username);
        X_DataField passwordParam = new X_DataField();
            passwordParam.setColumn("Password");
            passwordParam.setVal(password);
        X_DataRow dataRow = new X_DataRow();
            dataRow.add(usernameParam);
            dataRow.add(passwordParam);
        return dataRow;
    }


    private X_ModelCRUD createModelCRUD(){
        X_ModelCRUD modelCRUD = new X_ModelCRUD();
        modelCRUD.setServiceType("SalesAppUserLogin");
        modelCRUD.setTableName("AD_User");
        modelCRUD.setAction(X_Enums.ModelCRUD_Action.Read);

        X_DataRow loginDetails = createLoginDataRow();
        modelCRUD.setDataRow(loginDetails);
        return modelCRUD;
    }



    public X_ADLoginRequest createLoginRequest(String username, String password){
        X_ADLoginRequest aDLoginRequest = new X_ADLoginRequest(username, null, password , "192", 1000000, 1000027, 1000000,
                1000000, 0);
        return aDLoginRequest;
    }

}
