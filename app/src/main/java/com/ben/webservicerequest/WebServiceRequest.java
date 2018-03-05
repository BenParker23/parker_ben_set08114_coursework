package com.ben.webservicerequest;

import android.util.Log;

import com.ben.error.SalesAppException;
import com.ben.webservice.X_ADLoginRequest;
import com.ben.webservice.X_ModelADServiceSoapBinding;
import com.ben.webservice.X_ModelCRUD;
import com.ben.webservice.X_ModelCRUDRequest;
import com.ben.webservice.X_ModelRunProcess;
import com.ben.webservice.X_ModelRunProcessRequest;
import com.ben.webservice.X_RunProcessResponse;
import com.ben.webservice.X_StandardResponse;
import com.ben.webservice.X_WindowTabData;

import java.util.ArrayList;

/**
 * @author Ben Parker
 * @created 21/5/17
 * @usage Main interface used for creating web-service requests
 * from the Sales App to the iDempiere SOAP Web-Service
 * Abstracted out most of the unnecessary details
 */
public class WebServiceRequest implements I_WebServiceRequest {

    protected X_ModelCRUD modelCRUD;
    protected X_ModelRunProcess modelRunProcess;
    protected X_ModelRunProcessRequest modelRunProcessRequest;
    protected X_ModelCRUDRequest modelCRUDRequest;
    protected X_ADLoginRequest loginRequest;
    protected X_ModelADServiceSoapBinding soapBinding;
    protected String type;
    protected ArrayList<String> allTypes = new ArrayList<>();
    protected String BASE_URL = "http://10.0.2.2:8080/ADInterface/services/ModelADService/";

    /**
     * Complex constructor which takes all data in and is ready to send request
     * by calling the appropriate method for that type
     **/


    public WebServiceRequest(X_ModelRunProcess runProcess, String type, X_ADLoginRequest loginRequest){
        this.loginRequest = loginRequest;
        createArrayOfTypes();
        if (!allTypes.contains(type)) {
            throw new SalesAppException("Request type not a registered type - please choose from specified WebServiceRequest constants ");
        }
        BASE_URL += type;
        Log.v("RequestTypeURL", BASE_URL);
        this.type = type;
        setModelRunProcess(runProcess);
        createModelRunProcessRequest();
    }

    private void setModelRunProcess(X_ModelRunProcess runProcess){
        this.modelRunProcess = runProcess;
    }

    private void createModelRunProcessRequest(){
        modelRunProcessRequest = new X_ModelRunProcessRequest(modelRunProcess, loginRequest);
        createSoapBinding();
    }


    public WebServiceRequest(X_ModelCRUD modelCRUD, String type, X_ADLoginRequest loginRequest) {
        this.loginRequest = loginRequest;
        createArrayOfTypes();
        if (!allTypes.contains(type)) {
            throw new SalesAppException("Request type not a registered type - please choose from specified WebServiceRequest constants ");
        }
        BASE_URL += type;
        Log.v("RequestTypeURL", BASE_URL);
        this.type = type;
        setModelCRUD(modelCRUD);
        createModelCRUDRequest();
        createSoapBinding();
    }


    public void setLoginRequest(X_ADLoginRequest loginRequest){
        this.loginRequest = loginRequest;
    }


    /** Create the SoapBinding object which contains the URL full of information to perform
     * the necessary type of request
     */
    public void createSoapBinding(){
        /** Checking to see if BASE_URL has been updated to create type **/
        if (BASE_URL.lastIndexOf("/") == (BASE_URL.length() - 1)){
            throw new SalesAppException("Base Url of Web Service request has not been updated to contain type yet ");
        }
        soapBinding = new X_ModelADServiceSoapBinding(BASE_URL);
    }


    public X_ADLoginRequest createLoginRequest(String username, String password){
        X_ADLoginRequest aDLoginRequest = new X_ADLoginRequest(username, null ,password, "192", 1000000, 1000027, 1000000,
                1000000, 0);
        this.loginRequest = aDLoginRequest;
        return loginRequest;
    }


    /** Set the type of the request i.e. createData, queryData **/
    public void setRequestType(String type){
        if (!allTypes.contains(type)){
            throw new SalesAppException("Request type not a registered type - please choose from specified WebServiceRequest constants ");
        }
        BASE_URL += type;
        this.type = type;
    }


    public void setModelCRUD(X_ModelCRUD modelCRUD){
        this.modelCRUD = modelCRUD;
    }


    public void createModelCRUDRequest(){
        if (loginRequest == null){
            throw new SalesAppException("Must create login request before creating model crud request ");
        }
        if (modelCRUD == null){
            throw new SalesAppException("Passed ModelCRUD is null ");
        }
        modelCRUDRequest = new X_ModelCRUDRequest(modelCRUD, loginRequest);
    }


    public X_WindowTabData queryData(){
        if (!type.equals(QUERY_DATA)){
            throw new SalesAppException("Cannot call queryData method on type " + type);
        }
        try {
            X_WindowTabData queryData = soapBinding.queryData(modelCRUDRequest);
            return queryData;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /** Used to create a record on the system **/
    public X_StandardResponse createData(){
        if (!type.equals(CREATE_DATA)){
            throw new SalesAppException("Cannot call createData method on type " + type);
        }
        try {
            X_StandardResponse response = soapBinding.createData(modelCRUDRequest);
            return response;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /** Creates the record if the record does not exists
     * IF exists then updates the record
     * @return X_StandardResponse containing response data
     */
    public X_StandardResponse updateData(){
        if (!type.equals(UPDATE_DATA)){
            throw new SalesAppException("Cannot call updateData method on type " + type);
        }
        try {
            X_StandardResponse updateData = soapBinding.createUpdateData(modelCRUDRequest);
            return updateData;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public X_RunProcessResponse runProcess(){
        if (!type.equals(RUN_PROCESS)){
            throw new SalesAppException("Cannot call runProcess method on type " + type);
        }
        try {
            X_RunProcessResponse runProcessResponse = soapBinding.runProcess(modelRunProcessRequest);
            return runProcessResponse;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }


    public X_WindowTabData readData(){
        if (!type.equals(READ_DATA)){
            throw new SalesAppException("Cannot call readData method on type " + type);
        }
        try {
            X_WindowTabData readData = soapBinding.readData(modelCRUDRequest);
            return readData;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String deleteData(){
        if (!type.equals(DELETE_DATA)){
            throw new SalesAppException("Cannot call deleteData method on type " + type);
        }
        try {
            String deleteData = soapBinding.deleteData(modelCRUDRequest.toString());
            return deleteData;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public String getListData(){
        if (!type.equals(GET_LIST)){
            throw new SalesAppException("Cannot call getListData method on type " + type);
        }
        try {
            /** Need to alter this to receive ModelListRequest and use getList method of soapBinding **/
            String deleteData = soapBinding.deleteData(modelCRUDRequest.toString());
            return deleteData;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /** Creating an array to improve readability **/
    public void createArrayOfTypes(){
        allTypes.add(CREATE_DATA);
        allTypes.add(UPDATE_DATA);
        allTypes.add(DELETE_DATA);
        allTypes.add(READ_DATA);
        allTypes.add(QUERY_DATA);
        allTypes.add(GET_LIST);
        allTypes.add(RUN_PROCESS);
    }
}
