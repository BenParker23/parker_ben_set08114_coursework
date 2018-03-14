package com.ben.webservicerequest;

import android.os.AsyncTask;

import com.ben.error.SalesAppException;
import com.ben.model.I_X_ADUser;
import com.ben.model.I_X_LoginDetail;
import com.ben.model.X_Login_Detail;
import com.ben.utils.WSRUtils;
import com.ben.webservice.X_ADLoginRequest;
import com.ben.webservice.X_DataField;
import com.ben.webservice.X_DataRow;
import com.ben.webservice.X_DataSet;
import com.ben.webservice.X_Enums;
import com.ben.webservice.X_ModelCRUD;
import com.ben.webservice.X_WindowTabData;

/**
 * Created by benparker on 10/07/17.
 */

public class UserDetailsRequest extends AsyncTask<Void, Void, X_Login_Detail> {

    private String username;
    private String password;

    private WebServiceRequest wsr;
    private X_ModelCRUD modelCRUD;

    private X_DataRow parameters;
    private X_ADLoginRequest loginRequest;


    public UserDetailsRequest(String username, String password){
        this.username = username;
        this.password = password;
    }


    private X_Login_Detail getUserDetails(){
        modelCRUD = WSRUtils.createModelCRUD(I_WebServiceConstants.SMA_GetUserDetails, I_X_ADUser.Table_Name, X_Enums.ModelCRUD_Action.Read);
        modelCRUD.setDataRow(createUserDetailParameters());
        loginRequest = WSRUtils.createLoginRequest(username, password);
        wsr = new WebServiceRequest(modelCRUD, I_WebServiceRequest.QUERY_DATA, loginRequest);
        X_WindowTabData response = wsr.queryData();
        X_Login_Detail details = createX_Login_DetailFromResponse(response);
        return details;
    }


    private X_Login_Detail createX_Login_DetailFromResponse(X_WindowTabData response ){
        X_DataSet allData = response.DataSet;
        X_Login_Detail detail = new X_Login_Detail();
        if (allData == null) {
            throw new SalesAppException("No Login details returned from query- createLoginDetailFromResponse");
        }
        for (int i = 0 ; i < allData.size() ; i++){
            X_DataRow dataRow = allData.get(i);
            for (int j = 0 ; j < dataRow.size() ; j++) {
                X_DataField dataField = dataRow.get(j);
                switch(dataField.column){
                    //case(I_X_LoginDetail.ColumnName_AD_User_ID):
                   //     detail.setAd_User_ID(Integer.parseInt(dataField.val));
                    case(I_X_LoginDetail.ColumnName_C_BPartner_ID):
                        detail.setC_Bpartner_ID(Integer.parseInt(dataField.val));
                    case(I_X_LoginDetail.ColumnName_Username):
                        detail.setUsername(dataField.val);
                    case(I_X_LoginDetail.ColumnName_Password):
                        detail.setPassword(dataField.val);
                }
            }
        }
        return detail;
    }

    public X_DataRow createUserDetailParameters(){
        X_DataField usernameParam = new X_DataField();
        usernameParam.setColumn("Name");
        usernameParam.setVal(username);
        X_DataRow dataRow = new X_DataRow();
        dataRow.add(usernameParam);
        return dataRow;
    }


    @Override
    protected X_Login_Detail doInBackground(Void... params) {
        return getUserDetails();
    }
}
