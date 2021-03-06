package com.ben.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ben on 21/05/17.
 */

public interface I_X_C_BPartner {
    /**
     * TableName=C_BPartner
     */
    public static final String Table_Name = "C_BPartner";

    static final int SMA_App_Table_ID = 1000001;

    public static final String COLUMNNAME_AcqusitionCost = "AcqusitionCost";

    public void setAcqusitionCost(BigDecimal AcqusitionCost);

    public BigDecimal getAcqusitionCost();

    /**
     * Column name ActualLifeTimeValue
     */
    public static final String COLUMNNAME_ActualLifeTimeValue = "ActualLifeTimeValue";

    /**
     * Set Actual Life Time Value.
     * Actual Life Time Revenue
     */
    public void setActualLifeTimeValue(BigDecimal ActualLifeTimeValue);

    /**
     * Get Actual Life Time Value.
     * Actual Life Time Revenue
     */
    public BigDecimal getActualLifeTimeValue();

    /**
     * Column name AD_Client_ID
     */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

    /**
     * Get Client.
     * Client/Tenant for this installation.
     */
    public int getAD_Client_ID();

    /**
     * Column name AD_Language
     */
    public static final String COLUMNNAME_AD_Language = "AD_Language";

    /**
     * Set Language.
     * Language for this entity
     */
    public void setAD_Language(String AD_Language);

    /**
     * Get Language.
     * Language for this entity
     */
    public String getAD_Language();

    /**
     * Column name AD_OrgBP_ID
     */
    public static final String COLUMNNAME_AD_OrgBP_ID = "AD_OrgBP_ID";

    /**
     * Set Linked Organization.
     * The Business Partner is another Organization for explicit Inter-Org transactions
     */
    public void setAD_OrgBP_ID(String AD_OrgBP_ID);

    /**
     * Get Linked Organization.
     * The Business Partner is another Organization for explicit Inter-Org transactions
     */
    public String getAD_OrgBP_ID();

    /**
     * Column name AD_Org_ID
     */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

    /**
     * Set Organization.
     * Organizational entity within client
     */
    public void setAD_Org_ID(int AD_Org_ID);

    /**
     * Get Organization.
     * Organizational entity within client
     */
    public int getAD_Org_ID();

    /**
     * Column name BPartner_Parent_ID
     */
    public static final String COLUMNNAME_BPartner_Parent_ID = "BPartner_Parent_ID";

    /**
     * Set Partner Parent.
     * Business Partner Parent
     */
    public void setBPartner_Parent_ID(int BPartner_Parent_ID);

    /**
     * Get Partner Parent.
     * Business Partner Parent
     */
    public int getBPartner_Parent_ID();

    /**
     * Column name C_BPartner_ID
     */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

    /**
     * Set Business Partner .
     * Identifies a Business Partner
     */
    public void setC_BPartner_ID(int C_BPartner_ID);

    /**
     * Get Business Partner .
     * Identifies a Business Partner
     */
    public int getC_BPartner_ID();

    /**
     * Column name C_BPartner_UU
     */
    public static final String COLUMNNAME_C_BPartner_UU = "C_BPartner_UU";

    /**
     * Set C_BPartner_UU
     */
    public void setC_BPartner_UU(String C_BPartner_UU);

    /**
     * Get C_BPartner_UU
     */
    public String getC_BPartner_UU();

    /**
     * Column name C_BP_Group_ID
     */
    public static final String COLUMNNAME_C_BP_Group_ID = "C_BP_Group_ID";

    /**
     * Set Business Partner Group.
     * Business Partner Group
     */
    public void setC_BP_Group_ID(int C_BP_Group_ID);

    /**
     * Get Business Partner Group.
     * Business Partner Group
     */
    public int getC_BP_Group_ID();

    /**
     * Column name C_Dunning_ID
     */
    public static final String COLUMNNAME_C_Dunning_ID = "C_Dunning_ID";

    /**
     * Set Dunning.
     * Dunning Rules for overdue invoices
     */
    public void setC_Dunning_ID(int C_Dunning_ID);

    /**
     * Get Dunning.
     * Dunning Rules for overdue invoices
     */
    public int getC_Dunning_ID();


    /**
     * Column name C_Greeting_ID
     */
    public static final String COLUMNNAME_C_Greeting_ID = "C_Greeting_ID";

    /**
     * Set Greeting.
     * Greeting to print on correspondence
     */
    public void setC_Greeting_ID(int C_Greeting_ID);

    /**
     * Get Greeting.
     * Greeting to print on correspondence
     */
    public int getC_Greeting_ID();


    /**
     * Column name C_InvoiceSchedule_ID
     */
    public static final String COLUMNNAME_C_InvoiceSchedule_ID = "C_InvoiceSchedule_ID";

    /**
     * Set Invoice Schedule.
     * Schedule for generating Invoices
     */
    public void setC_InvoiceSchedule_ID(int C_InvoiceSchedule_ID);

    /**
     * Get Invoice Schedule.
     * Schedule for generating Invoices
     */
    public int getC_InvoiceSchedule_ID();


    /**
     * Column name C_PaymentTerm_ID
     */
    public static final String COLUMNNAME_C_PaymentTerm_ID = "C_PaymentTerm_ID";

    /**
     * Set Payment Term.
     * The terms of Payment (timing, discount)
     */
    public void setC_PaymentTerm_ID(int C_PaymentTerm_ID);

    /**
     * Get Payment Term.
     * The terms of Payment (timing, discount)
     */
    public int getC_PaymentTerm_ID();


    /**
     * Column name Created
     */
    public static final String COLUMNNAME_Created = "Created";

    /**
     * Get Created.
     * Date this record was created
     */
    public Timestamp getCreated();

    /**
     * Column name CreatedBy
     */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

    /**
     * Get Created By.
     * User who created this records
     */
    public int getCreatedBy();

    /**
     * Column name C_TaxGroup_ID
     */
    public static final String COLUMNNAME_C_TaxGroup_ID = "C_TaxGroup_ID";

    /**
     * Set Tax Group
     */
    public void setC_TaxGroup_ID(int C_TaxGroup_ID);

    /**
     * Get Tax Group
     */
    public int getC_TaxGroup_ID();


    /**
     * Column name CustomerProfileID
     */
    public static final String COLUMNNAME_CustomerProfileID = "CustomerProfileID";

    /**
     * Set Customer Profile ID
     */
    public void setCustomerProfileID(String CustomerProfileID);

    /**
     * Get Customer Profile ID
     */
    public String getCustomerProfileID();

    /**
     * Column name Default1099Box_ID
     */
    public static final String COLUMNNAME_Default1099Box_ID = "Default1099Box_ID";

    /**
     * Set Default 1099 Box
     */
    public void setDefault1099Box_ID(int Default1099Box_ID);

    /**
     * Get Default 1099 Box
     */
    public int getDefault1099Box_ID();


    /**
     * Column name DeliveryRule
     */
    public static final String COLUMNNAME_DeliveryRule = "DeliveryRule";

    /**
     * Set Delivery Rule.
     * Defines the timing of Delivery
     */
    public void setDeliveryRule(String DeliveryRule);

    /**
     * Get Delivery Rule.
     * Defines the timing of Delivery
     */
    public String getDeliveryRule();

    /**
     * Column name DeliveryViaRule
     */
    public static final String COLUMNNAME_DeliveryViaRule = "DeliveryViaRule";

    /**
     * Set Delivery Via.
     * How the order will be delivered
     */
    public void setDeliveryViaRule(String DeliveryViaRule);

    /**
     * Get Delivery Via.
     * How the order will be delivered
     */
    public String getDeliveryViaRule();

    /**
     * Column name Description
     */
    public static final String COLUMNNAME_Description = "Description";

    /**
     * Set Description.
     * Optional short description of the record
     */
    public void setDescription(String Description);

    /**
     * Get Description.
     * Optional short description of the record
     */
    public String getDescription();

    /**
     * Column name DocumentCopies
     */
    public static final String COLUMNNAME_DocumentCopies = "DocumentCopies";

    /**
     * Set Document Copies.
     * Number of copies to be printed
     */
    public void setDocumentCopies(int DocumentCopies);

    /**
     * Get Document Copies.
     * Number of copies to be printed
     */
    public int getDocumentCopies();

    /**
     * Column name DunningGrace
     */
    public static final String COLUMNNAME_DunningGrace = "DunningGrace";

    /**
     * Set Dunning Grace Date
     */
    public void setDunningGrace(Timestamp DunningGrace);

    /**
     * Get Dunning Grace Date
     */
    public Timestamp getDunningGrace();

    /**
     * Column name DUNS
     */
    public static final String COLUMNNAME_DUNS = "DUNS";

    /**
     * Set D-U-N-S.
     * Dun & Bradstreet Number
     */
    public void setDUNS(String DUNS);

    /**
     * Get D-U-N-S.
     * Dun & Bradstreet Number
     */
    public String getDUNS();

    /**
     * Column name FirstSale
     */
    public static final String COLUMNNAME_FirstSale = "FirstSale";

    /**
     * Set First Sale.
     * Date of First Sale
     */
    public void setFirstSale(Timestamp FirstSale);

    /**
     * Get First Sale.
     * Date of First Sale
     */
    public Timestamp getFirstSale();

    /**
     * Column name FlatDiscount
     */
    public static final String COLUMNNAME_FlatDiscount = "FlatDiscount";

    /**
     * Set Flat Discount %.
     * Flat discount percentage
     */
    public void setFlatDiscount(BigDecimal FlatDiscount);

    /**
     * Get Flat Discount %.
     * Flat discount percentage
     */
    public BigDecimal getFlatDiscount();

    /**
     * Column name FreightCostRule
     */
    public static final String COLUMNNAME_FreightCostRule = "FreightCostRule";

    /**
     * Set Freight Cost Rule.
     * Method for charging Freight
     */
    public void setFreightCostRule(String FreightCostRule);

    /**
     * Get Freight Cost Rule.
     * Method for charging Freight
     */
    public String getFreightCostRule();

    /**
     * Column name Invoice_PrintFormat_ID
     */
    public static final String COLUMNNAME_Invoice_PrintFormat_ID = "Invoice_PrintFormat_ID";

    /**
     * Set Invoice Print Format.
     * Print Format for printing Invoices
     */
    public void setInvoice_PrintFormat_ID(int Invoice_PrintFormat_ID);

    /**
     * Get Invoice Print Format.
     * Print Format for printing Invoices
     */
    public int getInvoice_PrintFormat_ID();


    /**
     * Column name InvoiceRule
     */
    public static final String COLUMNNAME_InvoiceRule = "InvoiceRule";

    /**
     * Set Invoice Rule.
     * Frequency and method of invoicing
     */
    public void setInvoiceRule(String InvoiceRule);

    /**
     * Get Invoice Rule.
     * Frequency and method of invoicing
     */
    public String getInvoiceRule();

    /**
     * Column name Is1099Vendor
     */
    public static final String COLUMNNAME_Is1099Vendor = "Is1099Vendor";

    /**
     * Set 1099 Vendor
     */
    public void setIs1099Vendor(boolean Is1099Vendor);

    /**
     * Get 1099 Vendor
     */
    public boolean is1099Vendor();

    /**
     * Column name IsActive
     */
    public static final String COLUMNNAME_IsActive = "IsActive";

    /**
     * Set Active.
     * The record is active in the system
     */
    public void setIsActive(String IsActive);

    /**
     * Get Active.
     * The record is active in the system
     */
    public String isActive();

    /**
     * Column name IsCustomer
     */
    public static final String COLUMNNAME_IsCustomer = "IsCustomer";

    /**
     * Set Customer.
     * Indicates if this Business Partner is a Customer
     */
    public void setIsCustomer(String IsCustomer);

    /**
     * Get Customer.
     * Indicates if this Business Partner is a Customer
     */
    public String isCustomer();

    /**
     * Column name IsDiscountPrinted
     */
    public static final String COLUMNNAME_IsDiscountPrinted = "IsDiscountPrinted";

    /**
     * Set Discount Printed.
     * Print Discount on Invoice and Order
     */
    public void setIsDiscountPrinted(String IsDiscountPrinted);

    /**
     * Get Discount Printed.
     * Print Discount on Invoice and Order
     */
    public String isDiscountPrinted();

    /**
     * Column name IsEmployee
     */
    public static final String COLUMNNAME_IsEmployee = "IsEmployee";

    /**
     * Set Employee.
     * Indicates if  this Business Partner is an employee
     */
    public void setIsEmployee(String IsEmployee);

    /**
     * Get Employee.
     * Indicates if  this Business Partner is an employee
     */
    public String isEmployee();

    /**
     * Column name IsManufacturer
     */
    public static final String COLUMNNAME_IsManufacturer = "IsManufacturer";

    /**
     * Set Is Manufacturer.
     * Indicate role of this Business partner as Manufacturer
     */
    public void setIsManufacturer(String IsManufacturer);

    /**
     * Get Is Manufacturer.
     * Indicate role of this Business partner as Manufacturer
     */
    public String isManufacturer();

    /**
     * Column name IsOneTime
     */
    public static final String COLUMNNAME_IsOneTime = "IsOneTime";

    /**
     * Set One time transaction
     */
    public void setIsOneTime(boolean IsOneTime);

    /**
     * Get One time transaction
     */
    public boolean isOneTime();

    /**
     * Column name IsPOTaxExempt
     */
    public static final String COLUMNNAME_IsPOTaxExempt = "IsPOTaxExempt";

    /**
     * Set PO Tax exempt.
     * Business partner is exempt from tax on purchases
     */
    public void setIsPOTaxExempt(String IsPOTaxExempt);

    /**
     * Get PO Tax exempt.
     * Business partner is exempt from tax on purchases
     */
    public String isPOTaxExempt();

    /**
     * Column name IsProspect
     */
    public static final String COLUMNNAME_IsProspect = "IsProspect";

    /**
     * Set Prospect.
     * Indicates this is a Prospect
     */
    public void setIsProspect(String IsProspect);

    /**
     * Get Prospect.
     * Indicates this is a Prospect
     */
    public String isProspect();

    /**
     * Column name IsSalesRep
     */
    public static final String COLUMNNAME_IsSalesRep = "IsSalesRep";

    /**
     * Set Sales Representative.
     * Indicates if  the business partner is a sales representative or company agent
     */
    public void setIsSalesRep(String IsSalesRep);

    /**
     * Get Sales Representative.
     * Indicates if  the business partner is a sales representative or company agent
     */
    public String isSalesRep();

    /**
     * Column name IsSummary
     */
    public static final String COLUMNNAME_IsSummary = "IsSummary";

    /**
     * Set Summary Level.
     * This is a summary entity
     */
    public void setIsSummary(String IsSummary);

    /**
     * Get Summary Level.
     * This is a summary entity
     */
    public String isSummary();

    /**
     * Column name IsTaxExempt
     */
    public static final String COLUMNNAME_IsTaxExempt = "IsTaxExempt";

    /**
     * Set SO Tax exempt.
     * Business partner is exempt from tax on sales
     */
    public void setIsTaxExempt(String IsTaxExempt);

    /**
     * Get SO Tax exempt.
     * Business partner is exempt from tax on sales
     */
    public String isTaxExempt();

    /**
     * Column name IsVendor
     */
    public static final String COLUMNNAME_IsVendor = "IsVendor";

    /**
     * Set Vendor.
     * Indicates if this Business Partner is a Vendor
     */
    public void setIsVendor(String IsVendor);

    /**
     * Get Vendor.
     * Indicates if this Business Partner is a Vendor
     */
    public String isVendor();

    /**
     * Column name Logo_ID
     */
    public static final String COLUMNNAME_Logo_ID = "Logo_ID";

    /**
     * Set Logo
     */
    public void setLogo_ID(int Logo_ID);

    /**
     * Get Logo
     */
    public int getLogo_ID();

    /**
     * Column name M_DiscountSchema_ID
     */
    public static final String COLUMNNAME_M_DiscountSchema_ID = "M_DiscountSchema_ID";

    /**
     * Set Discount Schema.
     * Schema to calculate the trade discount percentage
     */
    public void setM_DiscountSchema_ID(int M_DiscountSchema_ID);

    /**
     * Get Discount Schema.
     * Schema to calculate the trade discount percentage
     */
    public int getM_DiscountSchema_ID();


    /**
     * Column name M_PriceList_ID
     */
    public static final String COLUMNNAME_M_PriceList_ID = "M_PriceList_ID";

    /**
     * Set Price List.
     * Unique identifier of a Price List
     */
    public void setM_PriceList_ID(int M_PriceList_ID);

    /**
     * Get Price List.
     * Unique identifier of a Price List
     */
    public int getM_PriceList_ID();


    /**
     * Column name NAICS
     */
    public static final String COLUMNNAME_NAICS = "NAICS";

    /**
     * Set NAICS/SIC.
     * Standard Industry Code or its successor NAIC - http://www.osha.gov/oshstats/sicser.html
     */
    public void setNAICS(String NAICS);

    /**
     * Get NAICS/SIC.
     * Standard Industry Code or its successor NAIC - http://www.osha.gov/oshstats/sicser.html
     */
    public String getNAICS();

    /**
     * Column name Name
     */
    public static final String COLUMNNAME_Name = "Name";


    public static final String COLUMNNAME_WebPercent = "WebPercent";

    /**
     * Set Name.
     * Alphanumeric identifier of the entity
     */
    public void setName(String Name);

    /**
     * Get Name.
     * Alphanumeric identifier of the entity
     */
    public String getName();

    /**
     * Column name Name2
     */
    public static final String COLUMNNAME_Name2 = "Name2";

    /**
     * Set Name 2.
     * Additional Name
     */
    public void setName2(String Name2);

    /**
     * Get Name 2.
     * Additional Name
     */
    public String getName2();

    /**
     * Column name NumberEmployees
     */
    public static final String COLUMNNAME_NumberEmployees = "NumberEmployees";

    /**
     * Set Employees.
     * Number of employees
     */
    public void setNumberEmployees(int NumberEmployees);

    /**
     * Get Employees.
     * Number of employees
     */
    public int getNumberEmployees();

    /**
     * Column name PaymentRule
     */
    public static final String COLUMNNAME_PaymentRule = "PaymentRule";

    /**
     * Set Payment Rule.
     * How you pay the invoice
     */
    public void setPaymentRule(String PaymentRule);

    /**
     * Get Payment Rule.
     * How you pay the invoice
     */
    public String getPaymentRule();

    /**
     * Column name PaymentRulePO
     */
    public static final String COLUMNNAME_PaymentRulePO = "PaymentRulePO";

    /**
     * Set Payment Rule.
     * Purchase payment option
     */
    public void setPaymentRulePO(String PaymentRulePO);

    /**
     * Get Payment Rule.
     * Purchase payment option
     */
    public String getPaymentRulePO();

    /**
     * Column name PO_DiscountSchema_ID
     */
    public static final String COLUMNNAME_PO_DiscountSchema_ID = "PO_DiscountSchema_ID";

    /**
     * Set PO Discount Schema.
     * Schema to calculate the purchase trade discount percentage
     */
    public void setPO_DiscountSchema_ID(int PO_DiscountSchema_ID);

    /**
     * Get PO Discount Schema.
     * Schema to calculate the purchase trade discount percentage
     */
    public int getPO_DiscountSchema_ID();

    /**
     * Column name PO_PaymentTerm_ID
     */
    public static final String COLUMNNAME_PO_PaymentTerm_ID = "PO_PaymentTerm_ID";

    /**
     * Set PO Payment Term.
     * Payment rules for a purchase order
     */
    public void setPO_PaymentTerm_ID(int PO_PaymentTerm_ID);

    /**
     * Get PO Payment Term.
     * Payment rules for a purchase order
     */
    public int getPO_PaymentTerm_ID();


    /**
     * Column name PO_PriceList_ID
     */
    public static final String COLUMNNAME_PO_PriceList_ID = "PO_PriceList_ID";

    /**
     * Set Purchase Pricelist.
     * Price List used by this Business Partner
     */
    public void setPO_PriceList_ID(int PO_PriceList_ID);

    /**
     * Get Purchase Pricelist.
     * Price List used by this Business Partner
     */
    public int getPO_PriceList_ID();


    /**
     * Column name POReference
     */
    public static final String COLUMNNAME_POReference = "POReference";

    /**
     * Set Order Reference.
     * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
     */
    public void setPOReference(String POReference);

    /**
     * Get Order Reference.
     * Transaction Reference Number (Sales Order, Purchase Order) of your Business Partner
     */
    public String getPOReference();

    /**
     * Column name PotentialLifeTimeValue
     */
    public static final String COLUMNNAME_PotentialLifeTimeValue = "PotentialLifeTimeValue";

    /**
     * Set Potential Life Time Value.
     * Total Revenue expected
     */
    public void setPotentialLifeTimeValue(BigDecimal PotentialLifeTimeValue);

    /**
     * Get Potential Life Time Value.
     * Total Revenue expected
     */
    public BigDecimal getPotentialLifeTimeValue();

    /**
     * Column name Rating
     */
    public static final String COLUMNNAME_Rating = "Rating";

    /**
     * Set Rating.
     * Classification or Importance
     */
    public void setRating(String Rating);

    /**
     * Get Rating.
     * Classification or Importance
     */
    public String getRating();

    /**
     * Column name ReferenceNo
     */
    public static final String COLUMNNAME_ReferenceNo = "ReferenceNo";

    /**
     * Set Reference No.
     * Your customer or vendor number at the Business Partner's site
     */
    public void setReferenceNo(String ReferenceNo);

    /**
     * Get Reference No.
     * Your customer or vendor number at the Business Partner's site
     */
    public String getReferenceNo();

    /**
     * Column name SalesRep_ID
     */
    public static final String COLUMNNAME_SalesRep_ID = "SalesRep_ID";

    /**
     * Set Sales Representative.
     * Sales Representative or Company Agent
     */
    public void setSalesRep_ID(int SalesRep_ID);

    /**
     * Get Sales Representative.
     * Sales Representative or Company Agent
     */
    public int getSalesRep_ID();


    /**
     * Column name SalesVolume
     */
    public static final String COLUMNNAME_SalesVolume = "SalesVolume";

    /**
     * Set Sales Volume in 1.000.
     * Total Volume of Sales in Thousands of Currency
     */
    public void setSalesVolume(int SalesVolume);

    /**
     * Get Sales Volume in 1.000.
     * Total Volume of Sales in Thousands of Currency
     */
    public int getSalesVolume();

    /**
     * Column name SendEMail
     */
    public static final String COLUMNNAME_SendEMail = "SendEMail";

    /**
     * Set Send EMail.
     * Enable sending Document EMail
     */
    public void setSendEMail(boolean SendEMail);

    /**
     * Get Send EMail.
     * Enable sending Document EMail
     */
    public boolean isSendEMail();

    /**
     * Column name ShareOfCustomer
     */
    public static final String COLUMNNAME_ShareOfCustomer = "ShareOfCustomer";

    /**
     * Set Share.
     * Share of Customer's business as a percentage
     */
    public void setShareOfCustomer(int ShareOfCustomer);

    /**
     * Get Share.
     * Share of Customer's business as a percentage
     */
    public int getShareOfCustomer();

    /**
     * Column name ShelfLifeMinPct
     */
    public static final String COLUMNNAME_ShelfLifeMinPct = "ShelfLifeMinPct";

    /**
     * Set Min Shelf Life %.
     * Minimum Shelf Life in percent based on Product Instance Guarantee Date
     */
    public void setShelfLifeMinPct(int ShelfLifeMinPct);

    /**
     * Get Min Shelf Life %.
     * Minimum Shelf Life in percent based on Product Instance Guarantee Date
     */
    public int getShelfLifeMinPct();

    /**
     * Column name SO_CreditLimit
     */
    public static final String COLUMNNAME_SO_CreditLimit = "SO_CreditLimit";

    /**
     * Set Credit Limit.
     * Total outstanding invoice amounts allowed
     */
    public void setSO_CreditLimit(double SO_CreditLimit);

    /**
     * Get Credit Limit.
     * Total outstanding invoice amounts allowed
     */
    public double getSO_CreditLimit();

    /**
     * Column name SOCreditStatus
     */
    public static final String COLUMNNAME_SOCreditStatus = "SOCreditStatus";

    /**
     * Set Credit Status.
     * Business Partner Credit Status
     */
    public void setSOCreditStatus(String SOCreditStatus);

    /**
     * Get Credit Status.
     * Business Partner Credit Status
     */
    public String getSOCreditStatus();

    /**
     * Column name SO_CreditUsed
     */
    public static final String COLUMNNAME_SO_CreditUsed = "SO_CreditUsed";

    /**
     * Set Credit Used.
     * Current open balance
     */
    public void setSO_CreditUsed(double SO_CreditUsed);

    /**
     * Get Credit Used.
     * Current open balance
     */
    public double getSO_CreditUsed();

    /**
     * Column name SO_Description
     */
    public static final String COLUMNNAME_SO_Description = "SO_Description";

    /**
     * Set Order Description.
     * Description to be used on orders
     */
    public void setSO_Description(String SO_Description);

    /**
     * Get Order Description.
     * Description to be used on orders
     */
    public String getSO_Description();

    /**
     * Column name TaxID
     */
    public static final String COLUMNNAME_TaxID = "TaxID";

    /**
     * Set Tax ID.
     * Tax Identification
     */
    public void setTaxID(String TaxID);

    /**
     * Get Tax ID.
     * Tax Identification
     */
    public String getTaxID();

    /**
     * Column name TotalOpenBalance
     */
    public static final String COLUMNNAME_TotalOpenBalance = "TotalOpenBalance";

    /**
     * Set Open Balance.
     * Total Open Balance Amount in primary Accounting Currency
     */
    public void setTotalOpenBalance(double TotalOpenBalance);

    /**
     * Get Open Balance.
     * Total Open Balance Amount in primary Accounting Currency
     */
    public double getTotalOpenBalance();

    /**
     * Column name Updated
     */
    public static final String COLUMNNAME_Updated = "Updated";

    /**
     * Get Updated.
     * Date this record was updated
     */
    public Timestamp getUpdated();

    /**
     * Column name UpdatedBy
     */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

    /**
     * Get Updated By.
     * User who updated this records
     */
    public int getUpdatedBy();

    /**
     * Column name URL
     */
    public static final String COLUMNNAME_URL = "URL";

    /**
     * Set URL.
     * Full URL address - e.g. http://www.idempiere.org
     */
    public void setURL(String URL);

    /**
     * Get URL.
     * Full URL address - e.g. http://www.idempiere.org
     */
    public String getURL();

    /**
     * Column name Value
     */
    public static final String COLUMNNAME_Value = "Value";

    public static final String COLUMNNAME_SalesValue = "SalesValue";

    public static final String COLUMNNAME_GrossProfit = "GrossProfit";


    public static final String COLUMNNAME_Email = "Email";

    /**
     * Set Search Key.
     * Search key for the record in the format required - must be unique
     */
    public void setValue(String Value);

    static final String COLUMNNAME_X_LoginDetail_ID = "X_LoginDetail_ID";
    /**
     * Get Search Key.
     * Search key for the record in the format required - must be unique
     */
    public String getValue();

    static String tableCreationSQL = "CREATE TABLE C_BPartner ( "
            + COLUMNNAME_C_BPartner_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + COLUMNNAME_C_BP_Group_ID + " INTEGER, "
            + COLUMNNAME_X_LoginDetail_ID + " INTEGER, "
            + COLUMNNAME_C_PaymentTerm_ID + " INTEGER, "
            + COLUMNNAME_C_TaxGroup_ID + " INTEGER, "
            + COLUMNNAME_Created + " TEXT, "
            + COLUMNNAME_CreatedBy + " INTEGER, "
            + COLUMNNAME_DeliveryRule + " TEXT, "
            + COLUMNNAME_WebPercent + " NUMERIC, "
            + COLUMNNAME_SalesValue + " NUMERIC, "
            + COLUMNNAME_GrossProfit + " NUMERIC, "
            + COLUMNNAME_DeliveryViaRule + " TEXT, "
            + COLUMNNAME_Description + " TEXT, "
            + COLUMNNAME_InvoiceRule + " TEXT, "
            + COLUMNNAME_IsActive + " TEXT, "
            + COLUMNNAME_IsCustomer + " TEXT, "
            + COLUMNNAME_IsVendor + " TEXT, "
            + COLUMNNAME_Value + " TEXT, "
            + COLUMNNAME_IsSalesRep + " TEXT, "
            + COLUMNNAME_IsTaxExempt + " TEXT, "
            + COLUMNNAME_TotalOpenBalance + " NUMERIC, "
            + COLUMNNAME_Email + " TEXT, "
            + COLUMNNAME_Updated + " TEXT, "
            + COLUMNNAME_UpdatedBy + " INTEGER , "
            + COLUMNNAME_TaxID + " INTEGER, "
            + COLUMNNAME_SOCreditStatus + " TEXT, "
            + COLUMNNAME_SO_CreditUsed + " NUMERIC, "
            + COLUMNNAME_SO_CreditLimit + " NUMERIC, "
            + COLUMNNAME_SalesRep_ID + " INTEGER, "
            + COLUMNNAME_Name + " TEXT, "
            + COLUMNNAME_Name2 + " TEXT, "
            + COLUMNNAME_M_PriceList_ID + " INTEGER "
            + " ); ";

    static String tableDeletionSQL = "DROP TABLE IF EXISTS " + Table_Name;
}