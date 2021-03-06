package com.ben.webservice;




//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.1
//
// Created by Quasar Development at 20/04/2017
//
//---------------------------------------------------




import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;

import java.util.List;


public class X_ModelADServiceSoapBinding
{
    interface X_IWcfMethod
    {
        X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws Exception;

        Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object result) throws Exception;
    }

    String url="http://n1.suthbros.co.uk:8080/ADInterface/services/ModelADService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    public X_ModelADServiceSoapBinding(){}

    public X_ModelADServiceSoapBinding(String url)
    {
        this.url = url;
    }

    public X_ModelADServiceSoapBinding(String url, int timeOut)
    {
        this.url = url;
        this.timeOut=timeOut;
    }

    protected org.ksoap2.transport.Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new HttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new HttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }
    
    protected X_ExtendedSoapSerializationEnvelope createEnvelope()
    {
        X_ExtendedSoapSerializationEnvelope envelope= new X_ExtendedSoapSerializationEnvelope(X_ExtendedSoapSerializationEnvelope.VER11);
        return envelope;
    }
    
    protected List sendRequest(String methodName, X_ExtendedSoapSerializationEnvelope envelope, org.ksoap2.transport.Transport transport  )throws Exception
    {
        return transport.call(methodName, envelope, httpHeaders);
    }

    Object getResult(Class destObj, Object source, String resultName, X_ExtendedSoapSerializationEnvelope __envelope) throws Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                Object instance=__envelope.get(j,destObj,false);
                return instance;
            }
            else if( soap.getName().equals(resultName)) {
                Object instance=__envelope.get(source,destObj,false);
                return instance;
            }
       }

       return null;
    }

        
    public X_StandardResponse setDocAction(final X_ModelSetDocActionRequest ModelSetDocActionRequest ) throws Exception
    {
        return (X_StandardResponse)execute(new X_IWcfMethod()
        {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0","ModelSetDocActionRequest",new X_ModelSetDocActionRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "setDocAction");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://idempiere.org/ADInterface/1_0";
                __info.name="ModelSetDocActionRequest";
                __info.type=X_ModelSetDocActionRequest.class;
                __info.setValue(ModelSetDocActionRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (X_StandardResponse)getResult(X_StandardResponse.class,__result,"StandardResponse",__envelope);
            }
        },"");
    }
    
    public X_StandardResponse createUpdateData(final X_ModelCRUDRequest ModelCRUDRequest ) throws Exception
    {
        return (X_StandardResponse)execute(new X_IWcfMethod()
        {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0","ModelCRUDRequest",new X_ModelCRUDRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "createUpdateData");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://idempiere.org/ADInterface/1_0";
                __info.name="ModelCRUDRequest";
                __info.type=X_ModelCRUDRequest.class;
                __info.setValue(ModelCRUDRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (X_StandardResponse)getResult(X_StandardResponse.class,__result,"StandardResponse",__envelope);
            }
        },"");
    }
    
    public X_WindowTabData getList(final X_ModelRunProcessRequest ModelGetListRequest ) throws Exception
    {
        return (X_WindowTabData)execute(new X_IWcfMethod()
        {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0","ModelGetListRequest",new X_ModelRunProcessRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "getList");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://idempiere.org/ADInterface/1_0";
                __info.name="ModelGetListRequest";
                __info.type=X_ModelRunProcessRequest.class;
                __info.setValue(ModelGetListRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (X_WindowTabData)getResult(X_WindowTabData.class,__result,"WindowTabData",__envelope);
            }
        },"");
    }
    
    public X_WindowTabData readData(final X_ModelCRUDRequest ModelCRUDRequest ) throws Exception
    {
        return (X_WindowTabData)execute(new X_IWcfMethod()
        {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0","ModelCRUDRequest",new X_ModelCRUDRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "readData");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://idempiere.org/ADInterface/1_0";
                __info.name="ModelCRUDRequest";
                __info.type=X_ModelCRUDRequest.class;
                __info.setValue(ModelCRUDRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (X_WindowTabData)getResult(X_WindowTabData.class,__result,"WindowTabData",__envelope);
            }
        },"");
    }
    
    public X_StandardResponse createData(final X_ModelCRUDRequest ModelCRUDRequest ) throws Exception
    {
        return (X_StandardResponse)execute(new X_IWcfMethod()
        {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0","ModelCRUDRequest",new X_ModelCRUDRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "createData");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://idempiere.org/ADInterface/1_0";
                __info.name="ModelCRUDRequest";
                __info.type=X_ModelCRUDRequest.class;
                __info.setValue(ModelCRUDRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (X_StandardResponse)getResult(X_StandardResponse.class,__result,"StandardResponse",__envelope);
            }
        },"");
    }
    
    public X_RunProcessResponse runProcess(final X_ModelRunProcessRequest ModelRunProcessRequest ) throws Exception {
        return (X_RunProcessResponse) execute(new X_IWcfMethod() {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope() {
                X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0", "ModelRunProcessRequest", new X_ModelRunProcessRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "runProcess");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info = null;
                __info = new PropertyInfo();
                __info.namespace = "http://idempiere.org/ADInterface/1_0";
                __info.name = "ModelRunProcessRequest";
                __info.type = X_ModelRunProcessRequest.class;
                __info.setValue(ModelRunProcessRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result) throws Exception {
                return (X_RunProcessResponse) getResult(X_RunProcessResponse.class, __result, "RunProcessResponse", __envelope);
            }
        }, "");
    }
    
    public X_WindowTabData queryData(final X_ModelCRUDRequest ModelCRUDRequest ) throws Exception
    {
        return (X_WindowTabData)execute(new X_IWcfMethod()
        {
            @Override
            public X_ExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                X_ExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                __envelope.addMapping("http://idempiere.org/ADInterface/1_0","ModelCRUDRequest", new X_ModelCRUDRequest().getClass());
                SoapObject __soapReq = new SoapObject("http://idempiere.org/ADInterface/1_0", "queryData");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="http://idempiere.org/ADInterface/1_0";
                __info.name="ModelCRUDRequest";
                __info.type=X_ModelCRUDRequest.class;
                __info.setValue(ModelCRUDRequest);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public Object ProcessResult(X_ExtendedSoapSerializationEnvelope __envelope, Object __result)throws Exception {
                return (X_WindowTabData)getResult(X_WindowTabData.class,__result,"WindowTabData",__envelope);
            }
        },"");
    }



    public String deleteData(final String ModelCRUDRequest ) throws Exception
    {

        return null;    
    }
    
    public String updateData(final String ModelCRUDRequest ) throws Exception
    {

        return null;    
    }
    
    public String runProcessTrx(final String ModelRunProcessRequest ) throws Exception
    {

        return null;    
    }

    
    protected Object execute(X_IWcfMethod wcfMethod, String methodName) throws Exception
    {
        org.ksoap2.transport.Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        X_ExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport);
            
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    System.out.println("requestDump: "+__httpTransport.requestDump);
                    
                }
                if (__httpTransport.responseDump != null) {
                    System.out.println("responseDump: "+__httpTransport.responseDump);
                }
            }
        }
        Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }
    
        
    Exception convertToException(org.ksoap2.SoapFault fault, X_ExtendedSoapSerializationEnvelope envelope)
    {
        return new Exception(fault.faultstring);
    }
}


