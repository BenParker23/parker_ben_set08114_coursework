package com.ben.model;

import java.sql.Timestamp;

/**
 * Created by ben on 09/07/17.
 */

public interface I_X_ADUser {

    /** TableName=AD_User */
    public static final String Table_Name = "AD_User";

    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";
    public int getAD_Client_ID();

    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";
    public void setAD_Org_ID(int AD_Org_ID);
    public int getAD_Org_ID();

    public static final String COLUMNNAME_AD_User_ID = "AD_User_ID";
    public void setAD_User_ID(int AD_User_ID);
    public int getAD_User_ID();

    public static final String COLUMNNAME_AD_User_UU = "AD_User_UU";
    public void setAD_User_UU (String AD_User_UU);
    public String getAD_User_UU();

    public static final String COLUMNNAME_Answer = "Answer";
    public void setAnswer (String Answer);
    public String getAnswer();

    public static final String COLUMNNAME_Birthday = "Birthday";
    public void setBirthday (Timestamp Birthday);
    public Timestamp getBirthday();

    public static final String COLUMNNAME_BP_Location_ID = "BP_Location_ID";
    public void setBP_Location_ID(int BP_Location_ID);
    public int getBP_Location_ID();

    public static final String COLUMNNAME_BPName = "BPName";
    public void setBPName (String BPName);
    public String getBPName();

    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";
    public void setC_BPartner_ID(int C_BPartner_ID);
    public int getC_BPartner_ID();

    public static final String COLUMNNAME_C_BPartner_Location_ID = "C_BPartner_Location_ID";
    public void setC_BPartner_Location_ID(int C_BPartner_Location_ID);
    public int getC_BPartner_Location_ID();

    public static final String COLUMNNAME_C_Campaign_ID = "C_Campaign_ID";
    public void setC_Campaign_ID(int C_Campaign_ID);
    public int getC_Campaign_ID();

    public static final String COLUMNNAME_C_Greeting_ID = "C_Greeting_ID";
    public void setC_Greeting_ID(int C_Greeting_ID);
    public int getC_Greeting_ID();

    public static final String COLUMNNAME_C_Job_ID = "C_Job_ID";
    public void setC_Job_ID(int C_Job_ID);
    public int getC_Job_ID();

    public static final String COLUMNNAME_C_Location_ID = "C_Location_ID";
    public void setC_Location_ID(int C_Location_ID);
    public int getC_Location_ID();

    public static final String COLUMNNAME_Comments = "Comments";
    public void setComments (String Comments);
    public String getComments();

    public static final String COLUMNNAME_Created = "Created";
    public Timestamp getCreated();

    public static final String COLUMNNAME_CreatedBy = "CreatedBy";
    public int getCreatedBy();

    public static final String COLUMNNAME_DateAccountLocked = "DateAccountLocked";
    public void setDateAccountLocked (Timestamp DateAccountLocked);
    public Timestamp getDateAccountLocked();

    public static final String COLUMNNAME_DateLastLogin = "DateLastLogin";
    public void setDateLastLogin (Timestamp DateLastLogin);
    public Timestamp getDateLastLogin();

    public static final String COLUMNNAME_DatePasswordChanged = "DatePasswordChanged";
    public void setDatePasswordChanged (Timestamp DatePasswordChanged);
    public Timestamp getDatePasswordChanged();

    public static final String COLUMNNAME_Description = "Description";
    public void setDescription (String Description);
    public String getDescription();

    public static final String COLUMNNAME_EMail = "EMail";
    public void setEMail (String EMail);
    public String getEMail();

    public static final String COLUMNNAME_EMailUser = "EMailUser";
    public void setEMailUser (String EMailUser);
    public String getEMailUser();

    public static final String COLUMNNAME_EMailUserPW = "EMailUserPW";
    public void setEMailUserPW (String EMailUserPW);
    public String getEMailUserPW();

    public static final String COLUMNNAME_EMailVerify = "EMailVerify";
    public void setEMailVerify (String EMailVerify);
    public String getEMailVerify();

    public static final String COLUMNNAME_EMailVerifyDate = "EMailVerifyDate";
    public void setEMailVerifyDate (Timestamp EMailVerifyDate);
    public Timestamp getEMailVerifyDate();

    public static final String COLUMNNAME_FailedLoginCount = "FailedLoginCount";
    public void setFailedLoginCount(int FailedLoginCount);
    public int getFailedLoginCount();

    public static final String COLUMNNAME_Fax = "Fax";
    public void setFax (String Fax);
    public String getFax();

    public static final String COLUMNNAME_IsActive = "IsActive";
    public void setIsActive(boolean IsActive);
    public boolean isActive();

    public static final String COLUMNNAME_IsAddMailTextAutomatically = "IsAddMailTextAutomatically";
    public void setIsAddMailTextAutomatically(boolean IsAddMailTextAutomatically);
    public boolean isAddMailTextAutomatically();

    public static final String COLUMNNAME_IsExpired = "IsExpired";
    public void setIsExpired(boolean IsExpired);
    public boolean isExpired();

    public static final String COLUMNNAME_IsFullBPAccess = "IsFullBPAccess";
    public void setIsFullBPAccess(boolean IsFullBPAccess);
    public boolean isFullBPAccess();

    public static final String COLUMNNAME_IsInPayroll = "IsInPayroll";
    public void setIsInPayroll(boolean IsInPayroll);
    public boolean isInPayroll();

    public static final String COLUMNNAME_IsLocked = "IsLocked";
    public void setIsLocked(boolean IsLocked);
    public boolean isLocked();

    public static final String COLUMNNAME_IsMenuAutoExpand = "IsMenuAutoExpand";

    /** Set Auto expand menu.
     * If ticked, the menu is automatically expanded
     */
    public void setIsMenuAutoExpand (String IsMenuAutoExpand);

    /** Get Auto expand menu.
     * If ticked, the menu is automatically expanded
     */
    public String getIsMenuAutoExpand();

    /** Column name IsNoPasswordReset */
    public static final String COLUMNNAME_IsNoPasswordReset = "IsNoPasswordReset";

    /** Set No Password Reset	  */
    public void setIsNoPasswordReset(boolean IsNoPasswordReset);

    /** Get No Password Reset	  */
    public boolean isNoPasswordReset();

    /** Column name IsSalesLead */
    public static final String COLUMNNAME_IsSalesLead = "IsSalesLead";

    /** Set Sales Lead.
     * This contact is a sales lead
     */
    public void setIsSalesLead(boolean IsSalesLead);

    /** Get Sales Lead.
     * This contact is a sales lead
     */
    public boolean isSalesLead();

    /** Column name LastContact */
    public static final String COLUMNNAME_LastContact = "LastContact";

    /** Set Last Contact.
     * Date this individual was last contacted
     */
    public void setLastContact (Timestamp LastContact);

    /** Get Last Contact.
     * Date this individual was last contacted
     */
    public Timestamp getLastContact();

    /** Column name LastResult */
    public static final String COLUMNNAME_LastResult = "LastResult";

    /** Set Last Result.
     * Result of last contact
     */
    public void setLastResult (String LastResult);

    /** Get Last Result.
     * Result of last contact
     */
    public String getLastResult();

    /** Column name LDAPUser */
    public static final String COLUMNNAME_LDAPUser = "LDAPUser";

    /** Set LDAP User Name.
     * User Name used for authorization via LDAP (directory) services
     */
    public void setLDAPUser (String LDAPUser);

    /** Get LDAP User Name.
     * User Name used for authorization via LDAP (directory) services
     */
    public String getLDAPUser();

    /** Column name LeadSource */
    public static final String COLUMNNAME_LeadSource = "LeadSource";

    /** Set Lead Source.
     * The source of this lead/opportunity
     */
    public void setLeadSource (String LeadSource);

    /** Get Lead Source.
     * The source of this lead/opportunity
     */
    public String getLeadSource();

    /** Column name LeadSourceDescription */
    public static final String COLUMNNAME_LeadSourceDescription = "LeadSourceDescription";

    /** Set Lead Source Description.
     * Additional information on the source of this lead/opportunity
     */
    public void setLeadSourceDescription (String LeadSourceDescription);

    /** Get Lead Source Description.
     * Additional information on the source of this lead/opportunity
     */
    public String getLeadSourceDescription();

    /** Column name LeadStatus */
    public static final String COLUMNNAME_LeadStatus = "LeadStatus";

    /** Set Lead Status.
     * The status of this lead/opportunity in the sales cycle
     */
    public void setLeadStatus (String LeadStatus);

    /** Get Lead Status.
     * The status of this lead/opportunity in the sales cycle
     */
    public String getLeadStatus();

    /** Column name LeadStatusDescription */
    public static final String COLUMNNAME_LeadStatusDescription = "LeadStatusDescription";

    /** Set Lead Status Description.
     * Additional information on the status of this lead/opportunity
     */
    public void setLeadStatusDescription (String LeadStatusDescription);

    /** Get Lead Status Description.
     * Additional information on the status of this lead/opportunity
     */
    public String getLeadStatusDescription();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

    /** Set Name.
     * Alphanumeric identifier of the entity
     */
    public void setName (String Name);

    /** Get Name.
     * Alphanumeric identifier of the entity
     */
    public String getName();

    /** Column name NotificationType */
    public static final String COLUMNNAME_NotificationType = "NotificationType";

    /** Set Notification Type.
     * Type of Notifications
     */
    public void setNotificationType (String NotificationType);

    /** Get Notification Type.
     * Type of Notifications
     */
    public String getNotificationType();

    /** Column name Password */
    public static final String COLUMNNAME_Password = "Password";

    /** Set Password.
     * Password of any length (case sensitive)
     */
    public void setPassword (String Password);

    /** Get Password.
     * Password of any length (case sensitive)
     */
    public String getPassword();

    /** Column name Phone */
    public static final String COLUMNNAME_Phone = "Phone";

    /** Set Phone.
     * Identifies a telephone number
     */
    public void setPhone (String Phone);

    /** Get Phone.
     * Identifies a telephone number
     */
    public String getPhone();

    /** Column name Phone2 */
    public static final String COLUMNNAME_Phone2 = "Phone2";

    /** Set 2nd Phone.
     * Identifies an alternate telephone number.
     */
    public void setPhone2 (String Phone2);

    /** Get 2nd Phone.
     * Identifies an alternate telephone number.
     */
    public String getPhone2();

    /** Column name Processing */
    public static final String COLUMNNAME_Processing = "Processing";

    /** Set Process Now	  */
    public void setProcessing(boolean Processing);

    /** Get Process Now	  */
    public boolean isProcessing();

    /** Column name R_DefaultMailText_ID */
    public static final String COLUMNNAME_R_DefaultMailText_ID = "R_DefaultMailText_ID";

    /** Set Default mail template	  */
    public void setR_DefaultMailText_ID(int R_DefaultMailText_ID);

    /** Get Default mail template	  */
    public int getR_DefaultMailText_ID();

    /** Column name SalesRep_ID */
    public static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";

    /** Set Sales Representative.
     * Sales Representative or Company Agent
     */
    public void setSalesRep_ID(int SalesRep_ID);

    /** Get Sales Representative.
     * Sales Representative or Company Agent
     */
    public int getSalesRep_ID();


    /** Column name Salt */
    public static final String COLUMNNAME_Salt = "Salt";

    /** Set Salt.
     * Random data added to improve password hash effectiveness
     */
    public void setSalt (String Salt);

    /** Get Salt.
     * Random data added to improve password hash effectiveness
     */
    public String getSalt();

    /** Column name SecurityQuestion */
    public static final String COLUMNNAME_SecurityQuestion = "SecurityQuestion";

    /** Set Security Question	  */
    public void setSecurityQuestion (String SecurityQuestion);

    /** Get Security Question	  */
    public String getSecurityQuestion();

    /** Column name Supervisor_ID */
    public static final String COLUMNNAME_Supervisor_ID = "Supervisor_ID";

    /** Set Supervisor.
     * Supervisor for this user/organization - used for escalation and approval
     */
    public void setSupervisor_ID(int Supervisor_ID);

    /** Get Supervisor.
     * Supervisor for this user/organization - used for escalation and approval
     */
    public int getSupervisor_ID();

    /** Column name Title */
    public static final String COLUMNNAME_Title = "Title";

    /** Set Title.
     * Name this entity is referred to as
     */
    public void setTitle (String Title);

    /** Get Title.
     * Name this entity is referred to as
     */
    public String getTitle();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

    /** Get Updated.
     * Date this record was updated
     */
    public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

    /** Get Updated By.
     * User who updated this records
     */
    public int getUpdatedBy();

    /** Column name UserPIN */
    public static final String COLUMNNAME_UserPIN = "UserPIN";

    /** Set User PIN	  */
    public void setUserPIN (String UserPIN);

    /** Get User PIN	  */
    public String getUserPIN();

    public static final String COLUMNNAME_Value = "Value";
    public void setValue (String Value);
    public String getValue();


}
