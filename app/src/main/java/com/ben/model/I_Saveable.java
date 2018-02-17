package com.ben.model;

/**
 * Created by benparker on 10/07/17.
 */

public interface I_Saveable {

    /** Mandatory columns on all system tables **/
    static final String ColumnName_CREATED = "Created";
    static final String ColumnName_CREATEDBY = "CreatedBy";
    static final String ColumnName_UPDATED= "Updated";
    static final String ColumnName_UPDATEDBY = "UpdatedBy";
    static final String ColumnName_ISACTIVE = "IsActive";
    static final String ColumnName_AD_ORG_ID = "AD_Org_ID";
    static final String ColumnName_AD_CLIENT_ID = "AD_Client_ID";

    public long save() throws Exception;

}
