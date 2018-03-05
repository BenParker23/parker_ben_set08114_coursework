package com.ben.webservice;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.0.8.1
//
// Created by Quasar Development at 20/04/2017
//
//---------------------------------------------------


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.*;
import org.kxml2.io.KXmlParser;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Vector;

public class X_ExtendedSoapSerializationEnvelope extends SoapSerializationEnvelope {
    static HashMap< String,Class> classNames = new HashMap< String, Class>();
    static {
        classNames.put("http://idempiere.org/ADInterface/1_0^^WindowTabData",X_WindowTabData.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^DataField",X_DataField.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^LookupValue",X_LookupValue.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^RunProcessResponse",X_RunProcessResponse.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ADLoginRequest",X_ADLoginRequest.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ADLoginResponse",X_ADLoginResponse.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^StandardResponse",X_StandardResponse.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^outputField",X_OutputField.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ModelSetDocAction",X_ModelSetDocAction.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ModelSetDocActionRequest",X_ModelSetDocActionRequest.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ModelRunProcess",X_ModelGetList.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ModelGetListRequest",X_ModelRunProcessRequest.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ModelCRUD",X_ModelCRUD.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^ModelCRUDRequest",X_ModelCRUDRequest.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^DataSet",X_DataSet.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^DataRow",X_DataRow.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^LookupValues",X_LookupValues.class);
        classNames.put("http://idempiere.org/ADInterface/1_0^^outputFields",X_OutputFields.class);
    }   

    protected static final int QNAME_NAMESPACE = 0;
    private static final String TYPE_LABEL = "type";

    public X_ExtendedSoapSerializationEnvelope() {
        this(SoapEnvelope.VER11);
    }

    public X_ExtendedSoapSerializationEnvelope(int soapVersion) {
        super(soapVersion);
        implicitTypes = true;
        setAddAdornments(false);
        new X_MarshalGuid().register(this);
        new MarshalFloat().register(this);
    }

    

    @Override
    protected void writeProperty(XmlSerializer writer, Object obj, PropertyInfo type) throws IOException {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (obj == null || obj== SoapPrimitive.NullNilElement) {
            writer.attribute(xsi, version >= VER12 ? NIL_LABEL : NULL_LABEL, "true");
            return;
        }
        Object[] qName = getInfo(null, obj);
        if (!type.multiRef && qName[2] == null )
        {

            if (!implicitTypes || (obj.getClass() != type.type && !(obj instanceof Vector) && type.type!=String.class  )) {
                String xmlName= X_Helper.getKeyByValue(classNames,obj.getClass());
                if(xmlName!=null) {
                    String[] parts = xmlName.split("\\^\\^");
                    String prefix = writer.getPrefix(parts[0], true);
                    writer.attribute(xsi, TYPE_LABEL, prefix + ":" + parts[1]);
                }
                else
                {
                    if(type.type instanceof String) {
                        String xsdPrefix = writer.getPrefix(xsd, true);
                        String myType = (String) type.type;
                        String[] parts = myType.split("\\^\\^");
                        if (parts.length == 2) {
                            xsdPrefix = writer.getPrefix(parts[0], true);
                            myType = parts[1];
                        }

                        writer.attribute(xsi, TYPE_LABEL, xsdPrefix + ":" + myType);
                    }
                    else
                    {
                        String prefix = writer.getPrefix(type.namespace, true);
                        writer.attribute(xsi, TYPE_LABEL, prefix + ":" + obj.getClass().getSimpleName());
                    }

                }
            }
            //super.writeProperty(writer,obj,type);

            //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
            //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
            writeElement(writer, obj, type, qName[QNAME_MARSHAL]);
        }
        else {
            super.writeProperty(writer, obj, type);
        }
    }
    public SoapObject GetExceptionDetail(Element detailElement, String exceptionElementNS, String exceptionElementName)
    {
        int index=detailElement.indexOf(exceptionElementNS,exceptionElementName,0);
        if(index>-1)
        {
            Element errorElement=detailElement.getElement(index);
            return GetSoapObject(errorElement);
        }
        return null;
    }

    public SoapObject GetSoapObject(Element detailElement) {
        try{
            XmlSerializer xmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            detailElement.write(xmlSerializer);
            xmlSerializer.flush();

            XmlPullParser xpp = new KXmlParser();
            xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);

            xpp.setInput(new StringReader(writer.toString()));
            xpp.nextTag();
            SoapObject soapObj = new SoapObject(detailElement.getNamespace(),detailElement.getName());
            readSerializable(xpp,soapObj);
            return soapObj;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public Object GetHeader(Element detailElement) {
        if(detailElement.getChildCount()>0 && detailElement.getText(0)!=null)
        {
            SoapPrimitive primitive = new SoapPrimitive(detailElement.getNamespace(),detailElement.getName(),detailElement.getText(0));
            return  primitive;
        }
    
        return GetSoapObject(detailElement);
    }
    
    public Object get(Object soap, Class cl, boolean typeFromClass)
    {
        if(soap==null)
        {
            return null;
        }
        try
        {
            if(soap instanceof Vector || typeFromClass)
            {
                Constructor ctor = cl.getConstructor(Object.class,X_ExtendedSoapSerializationEnvelope.class);
                return ctor.newInstance(soap,this);
            }
            {
                if(soap instanceof SoapObject)
                {
                    if(cl ==SoapObject.class)
                    {
                        return soap;
                    }
                    String key= String.format("%s^^%s",((SoapObject)soap).getNamespace(),((SoapObject)soap).getName());
                    if(classNames.containsKey(key))
                    {
                        cl=classNames.get(key);
                    }
                }
                Constructor ctor = cl.getConstructor(Object.class,X_ExtendedSoapSerializationEnvelope.class);
                return ctor.newInstance(soap,this);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

} 

