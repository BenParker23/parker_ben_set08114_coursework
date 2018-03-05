package com.ben.webservice;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.1
//
// Created by Quasar Development at 20/04/2017
//
//---------------------------------------------------


import org.ksoap2.serialization.*;

import java.util.Hashtable;
import java.util.Vector;


public class X_OutputFields extends Vector<X_OutputField> implements KvmSerializable
{
    
    public X_OutputFields(){}
    
    public X_OutputFields(Object inObj, X_ExtendedSoapSerializationEnvelope __envelope)
    {
        if (inObj == null)
            return;
        SoapObject soapObject=(SoapObject)inObj;
        int size = soapObject.getPropertyCount();
        for (int i0=0;i0< size;i0++)
        {
            Object obj = soapObject.getProperty(i0);
            if (obj!=null && obj instanceof AttributeContainer)
            {
                AttributeContainer j =(AttributeContainer) soapObject.getProperty(i0);
                X_OutputField j1= (X_OutputField)__envelope.get(j,X_OutputField.class,false);
                add(j1);
            }
        }
}
    
    @Override
    public Object getProperty(int arg0) {
        return this.get(arg0)!=null?this.get(arg0):SoapPrimitive.NullNilElement;
    }
    
    @Override
    public int getPropertyCount() {
        return this.size();
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "outputField";
        info.type = X_OutputField.class;
    	info.namespace= "http://idempiere.org/ADInterface/1_0";
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    
}