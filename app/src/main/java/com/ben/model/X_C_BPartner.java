package com.ben.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.ben.database.DBQuery;

import org.json.JSONObject;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by ben on 21/05/17.
 */

public class X_C_BPartner extends DBObject implements I_X_C_BPartner {

    private int C_BPartner_ID;
    private String value;
    private int SalesRep_ID;
    private int C_BP_Group_ID;
    private int C_PaymentTerm_ID;
    private int C_TaxGroup_ID;
    private int createdBy;
    private String deliveryRule;
    private String deliveryViaRule;
    private String description;
    private String invoiceRule;
    private String isActive;
    private String isCustomer;
    private String isManufacturer;
    private String isSummary;
    private String isVendor;
    private String isEmployee;
    private int AD_Org_ID;
    private int AD_Client_ID;
    private String isDiscountPrinted;
    private String isProspect;
    private String isPOTaxExempt;

    public int getM_Pricelist_ID() {
        return M_Pricelist_ID;
    }

    public void setM_Pricelist_ID(int m_Pricelist_ID) {
        M_Pricelist_ID = m_Pricelist_ID;
    }

    private int M_Pricelist_ID;


    public int getC_BPartner_ID() {
        return C_BPartner_ID;
    }

    @Override
    public void setC_BPartner_UU(String C_BPartner_UU) {

    }

    @Override
    public String getC_BPartner_UU() {
        return null;
    }

    @Override
    public void setAcqusitionCost(BigDecimal AcqusitionCost) {

    }

    @Override
    public BigDecimal getAcqusitionCost() {
        return null;
    }

    @Override
    public void setActualLifeTimeValue(BigDecimal ActualLifeTimeValue) {

    }

    @Override
    public BigDecimal getActualLifeTimeValue() {
        return null;
    }

    @Override
    public int getAD_Client_ID() {
        return AD_Client_ID;
    }

    @Override
    public void setAD_Language(String AD_Language) {

    }

    @Override
    public String getAD_Language() {
        return null;
    }

    @Override
    public void setAD_OrgBP_ID(String AD_OrgBP_ID) {

    }

    @Override
    public String getAD_OrgBP_ID() {
        return null;
    }

    @Override
    public void setAD_Org_ID(int AD_Org_ID) {
        this.AD_Org_ID = AD_Org_ID;
    }

    @Override
    public int getAD_Org_ID() {
        return AD_Org_ID;
    }

    @Override
    public void setBPartner_Parent_ID(int BPartner_Parent_ID) {

    }

    @Override
    public int getBPartner_Parent_ID() {
        return 0;
    }

    public void setC_BPartner_ID(int c_BPartner_ID) {
        C_BPartner_ID = c_BPartner_ID;
    }

    public int getSalesRep_ID() {
        return SalesRep_ID;
    }

    @Override
    public void setSalesVolume(int SalesVolume) {

    }

    @Override
    public int getSalesVolume() {
        return 0;
    }

    @Override
    public void setSendEMail(boolean SendEMail) {

    }

    @Override
    public boolean isSendEMail() {
        return false;
    }

    @Override
    public void setShareOfCustomer(int ShareOfCustomer) {

    }

    @Override
    public int getShareOfCustomer() {
        return 0;
    }

    @Override
    public void setShelfLifeMinPct(int ShelfLifeMinPct) {

    }

    @Override
    public int getShelfLifeMinPct() {
        return 0;
    }

    @Override
    public void setSO_CreditLimit(double SO_CreditLimit) {
        this.soCreditLimit = SO_CreditLimit;
    }

    @Override
    public double getSO_CreditLimit() {
        return soCreditLimit;
    }

    @Override
    public void setSOCreditStatus(String SOCreditStatus) {
        this.soCreditStatus = SOCreditStatus;
    }

    @Override
    public String getSOCreditStatus() {
        return soCreditStatus;
    }

    @Override
    public void setSO_CreditUsed(double SO_CreditUsed) {
        this.soCreditUsed = SO_CreditUsed;
    }

    @Override
    public double getSO_CreditUsed() {
        return soCreditUsed;
    }

    @Override
    public void setSO_Description(String SO_Description) {

    }

    @Override
    public String getSO_Description() {
        return null;
    }

    @Override
    public void setTaxID(String TaxID) {

    }

    public void setSalesRep_ID(int salesRep_ID) {
        SalesRep_ID = salesRep_ID;
    }

    public int getC_BP_Group_ID() {
        return C_BP_Group_ID;
    }

    @Override
    public void setC_Dunning_ID(int C_Dunning_ID) {

    }

    @Override
    public int getC_Dunning_ID() {
        return 0;
    }

    @Override
    public void setC_Greeting_ID(int C_Greeting_ID) {

    }

    @Override
    public int getC_Greeting_ID() {
        return 0;
    }

    @Override
    public void setC_InvoiceSchedule_ID(int C_InvoiceSchedule_ID) {

    }

    @Override
    public int getC_InvoiceSchedule_ID() {
        return 0;
    }

    public void setC_BP_Group_ID(int c_BP_Group_ID) {
        C_BP_Group_ID = c_BP_Group_ID;
    }

    public int getC_PaymentTerm_ID() {
        return C_PaymentTerm_ID;
    }

    @Override
    public Timestamp getCreated() {
        return null;
    }

    public void setC_PaymentTerm_ID(int c_PaymentTerm_ID) {
        C_PaymentTerm_ID = c_PaymentTerm_ID;
    }

    public int getC_TaxGroup_ID() {
        return C_TaxGroup_ID;
    }

    @Override
    public void setCustomerProfileID(String CustomerProfileID) {

    }

    @Override
    public String getCustomerProfileID() {
        return null;
    }

    @Override
    public void setDefault1099Box_ID(int Default1099Box_ID) {

    }

    @Override
    public int getDefault1099Box_ID() {
        return 0;
    }

    public void setC_TaxGroup_ID(int c_TaxGroup_ID) {
        C_TaxGroup_ID = c_TaxGroup_ID;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getDeliveryRule() {
        return deliveryRule;
    }

    public void setDeliveryRule(String deliveryRule) {
        this.deliveryRule = deliveryRule;
    }

    public String getDeliveryViaRule() {
        return deliveryViaRule;
    }

    public void setDeliveryViaRule(String deliveryViaRule) {
        this.deliveryViaRule = deliveryViaRule;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void setDocumentCopies(int DocumentCopies) {

    }

    @Override
    public int getDocumentCopies() {
        return 0;
    }

    @Override
    public void setDunningGrace(Timestamp DunningGrace) {

    }

    @Override
    public Timestamp getDunningGrace() {
        return null;
    }

    @Override
    public void setDUNS(String DUNS) {

    }

    @Override
    public String getDUNS() {
        return null;
    }

    @Override
    public void setFirstSale(Timestamp FirstSale) {

    }

    @Override
    public Timestamp getFirstSale() {
        return null;
    }

    @Override
    public void setFlatDiscount(BigDecimal FlatDiscount) {

    }

    @Override
    public BigDecimal getFlatDiscount() {
        return null;
    }

    @Override
    public void setFreightCostRule(String FreightCostRule) {

    }

    @Override
    public String getFreightCostRule() {
        return null;
    }

    @Override
    public void setInvoice_PrintFormat_ID(int Invoice_PrintFormat_ID) {

    }

    @Override
    public int getInvoice_PrintFormat_ID() {
        return 0;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoiceRule() {
        return invoiceRule;
    }

    @Override
    public void setIs1099Vendor(boolean Is1099Vendor) { }

    @Override
    public boolean is1099Vendor() {
        return false;
    }


    @Override
    public String isActive() {
        return isActive;
    }


    @Override
    public String isCustomer() {
        return isCustomer;
    }

    @Override
    public void setIsDiscountPrinted(String IsDiscountPrinted) {
        this.isDiscountPrinted = IsDiscountPrinted;
    }


    @Override
    public String isDiscountPrinted() {
        return isDiscountPrinted;
    }

    @Override
    public void setIsEmployee(String IsEmployee) {
        this.isEmployee = IsEmployee;
    }

    @Override
    public String isEmployee() {
        return isEmployee;
    }

    @Override
    public void setIsManufacturer(String IsManufacturer) {
        this.isManufacturer = IsManufacturer;
    }


    @Override
    public String isManufacturer() {
        return isManufacturer;
    }

    @Override
    public void setIsOneTime(boolean IsOneTime) {

    }

    @Override
    public boolean isOneTime() {
        return false;
    }

    @Override
    public void setIsPOTaxExempt(String IsPOTaxExempt) {
        this.isPOTaxExempt = IsPOTaxExempt;
    }

    @Override
    public String isPOTaxExempt() {
        return isPOTaxExempt();
    }

    @Override
    public void setIsProspect(String IsProspect) {
        this.isProspect = IsProspect;
    }


    @Override
    public String isProspect() {
        return isProspect;
    }


    @Override
    public String isSalesRep() {
        return isSalesRep;
    }

    @Override
    public void setIsSummary(String IsSummary) {
        this.isSummary = IsSummary;
    }

    @Override
    public String isSummary() {
        return isSummary;
    }


    @Override
    public String isTaxExempt() {
        return isTaxExempt;
    }


    @Override
    public String isVendor() {
        return isVendor;
    }

    @Override
    public void setLogo_ID(int Logo_ID) {

    }

    @Override
    public int getLogo_ID() {
        return 0;
    }

    @Override
    public void setM_DiscountSchema_ID(int M_DiscountSchema_ID) {

    }

    @Override
    public int getM_DiscountSchema_ID() {
        return 0;
    }

    public void setInvoiceRule(String invoiceRule) { this.invoiceRule = invoiceRule; }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(String isCustomer) {
        this.isCustomer = isCustomer;
    }

    public String getIsVendor() {
        return isVendor;
    }

    public void setIsVendor(String isVendor) {
        this.isVendor = isVendor;
    }

    public String getIsSalesRep() {
        return isSalesRep;
    }

    public void setIsSalesRep(String isSalesRep) {
        this.isSalesRep = isSalesRep;
    }

    public String getIsTaxExempt() {
        return isTaxExempt;
    }

    public void setIsTaxExempt(String isTaxExempt) {
        this.isTaxExempt = isTaxExempt;
    }

    public double getTotalOpenBalance() {
        return totalOpenBalance;
    }

    @Override
    public Timestamp getUpdated() {
        return null;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setURL(String URL) {

    }

    @Override
    public String getURL() {
        return null;
    }

    @Override
    public void setValue(String Value) {
        this.value = Value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getTaxID() {
        return taxID;
    }

    @Override
    public void setTotalOpenBalance(double TotalOpenBalance) {
        this.totalOpenBalance = TotalOpenBalance;
    }


    public double getSOCreditUsed() {
        return soCreditUsed;
    }

    public void setSOCreditUsed(double soCreditUsed) {
        this.soCreditUsed = soCreditUsed;
    }

    public double getSOCreditLimit() {
        return soCreditLimit;
    }

    public void setSoCreditLimit(double soCreditLimit) {
        this.soCreditLimit = soCreditLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    @Override
    public void setNumberEmployees(int NumberEmployees) {

    }

    @Override
    public int getNumberEmployees() {
        return 0;
    }

    @Override
    public void setPaymentRule(String PaymentRule) {

    }

    @Override
    public String getPaymentRule() {
        return null;
    }

    @Override
    public void setPaymentRulePO(String PaymentRulePO) {

    }

    @Override
    public String getPaymentRulePO() {
        return null;
    }

    @Override
    public void setPO_DiscountSchema_ID(int PO_DiscountSchema_ID) {

    }

    @Override
    public int getPO_DiscountSchema_ID() {
        return 0;
    }

    @Override
    public void setPO_PaymentTerm_ID(int PO_PaymentTerm_ID) {

    }

    @Override
    public int getPO_PaymentTerm_ID() {
        return 0;
    }

    @Override
    public void setPO_PriceList_ID(int PO_PriceList_ID) {

    }

    @Override
    public int getPO_PriceList_ID() {
        return 0;
    }

    @Override
    public void setPOReference(String POReference) {

    }

    @Override
    public String getPOReference() {
        return null;
    }

    @Override
    public void setPotentialLifeTimeValue(BigDecimal PotentialLifeTimeValue) {

    }

    @Override
    public BigDecimal getPotentialLifeTimeValue() {
        return null;
    }

    @Override
    public void setRating(String Rating) {

    }

    @Override
    public String getRating() {
        return null;
    }

    @Override
    public void setReferenceNo(String ReferenceNo) {

    }

    @Override
    public String getReferenceNo() {
        return null;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getM_PriceList_ID() {
        return M_PriceList_ID;
    }

    @Override
    public void setNAICS(String NAICS) {

    }

    @Override
    public String getNAICS() {
        return null;
    }

    public void setM_PriceList_ID(int m_PriceList_ID) {
        M_PriceList_ID = m_PriceList_ID;
    }

    private String isSalesRep;
    private String isTaxExempt;
    private double totalOpenBalance;
    private int updatedBy;
    private String taxID;
    private String soCreditStatus;
    private double soCreditUsed;
    private double soCreditLimit;
    private String name;
    private String name2;
    private int M_PriceList_ID;
    private double GrossProfit;

    public double getGrossProfit() {
        return GrossProfit;
    }

    public void setGrossProfit(double grossProfit) {
        GrossProfit = grossProfit;
    }

    public double getWebPercent() {
        return WebPercent;
    }

    public void setWebPercent(double webPercent) {
        WebPercent = webPercent;
    }

    public double getSalesValue() {
        return SalesValue;
    }

    public void setSalesValue(double salesValue) {
        SalesValue = salesValue;
    }

    private double WebPercent;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private double SalesValue;
    private String Email;
    private int X_LoginDetail_ID;


    public int getX_LoginDetail_ID() {
        return X_LoginDetail_ID;
    }

    public void setX_LoginDetail_ID(int x_LoginDetail_ID) {
        X_LoginDetail_ID = x_LoginDetail_ID;
    }

    @Override
    public long save() throws Exception {
        ContentValues values = new ContentValues();

        values.put(I_X_C_BPartner.COLUMNNAME_C_BP_Group_ID, getC_BP_Group_ID());
        values.put(I_X_C_BPartner.COLUMNNAME_X_LoginDetail_ID, getX_LoginDetail_ID());
        values.put(I_X_C_BPartner.COLUMNNAME_C_PaymentTerm_ID, getC_PaymentTerm_ID());
        values.put(I_X_C_BPartner.COLUMNNAME_C_TaxGroup_ID, getC_TaxGroup_ID());
        values.put(I_X_C_BPartner.COLUMNNAME_DeliveryRule, getDeliveryRule());
        values.put(I_X_C_BPartner.COLUMNNAME_DeliveryViaRule, getDeliveryViaRule());
        values.put(I_X_C_BPartner.COLUMNNAME_Description, getDescription());
        values.put(I_X_C_BPartner.COLUMNNAME_IsCustomer, getIsCustomer());
        values.put(I_X_C_BPartner.COLUMNNAME_Value, getValue());
        values.put(I_X_C_BPartner.COLUMNNAME_UpdatedBy, getUpdatedBy());
        values.put(I_X_C_BPartner.COLUMNNAME_TaxID, getTaxID());
        values.put(I_X_C_BPartner.COLUMNNAME_TotalOpenBalance, getTotalOpenBalance());
        values.put(I_X_C_BPartner.COLUMNNAME_SOCreditStatus, getSOCreditStatus());
        values.put(I_X_C_BPartner.COLUMNNAME_SalesRep_ID, getSalesRep_ID());
        values.put(I_X_C_BPartner.COLUMNNAME_SO_CreditLimit, getSO_CreditLimit());
        values.put(I_X_C_BPartner.COLUMNNAME_SO_CreditUsed, getSO_CreditUsed());
        values.put(I_X_C_BPartner.COLUMNNAME_Name, getName());
        values.put(I_X_C_BPartner.COLUMNNAME_M_PriceList_ID, getM_Pricelist_ID());
        long resp =  DBQuery.insertValues(I_X_C_BPartner.Table_Name, values);
        String sql2 = "SELECT C_BPartner_ID FROM C_Bpartner WHERE Name = '" + getName() + "' ";
        Cursor response2 = DBQuery.executeQuery(sql2);
        while (response2.moveToNext()){
            setC_BPartner_ID(response2.getInt(response2.getColumnIndex(I_X_C_BPartner.COLUMNNAME_C_BPartner_ID)));
        }
        Log.v("AfterBPCreate", String.valueOf(getC_BPartner_ID()));
        return resp;
    }


    @Override
    public void fromJson(JSONObject responseObject) {
        try {
            setC_BPartner_ID(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_BPartner_ID.toLowerCase()));
            if (responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_BP_Group_ID.toLowerCase()) != 0){
                setC_BP_Group_ID(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_BP_Group_ID.toLowerCase()));
            }
            if (responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_PaymentTerm_ID.toLowerCase()) != 0){
                setC_PaymentTerm_ID(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_PaymentTerm_ID.toLowerCase()));
            }
            if (responseObject.getString(I_X_C_BPartner.COLUMNNAME_Description.toLowerCase()) != null){
                setDescription(responseObject.getString(I_X_C_BPartner.COLUMNNAME_Description.toLowerCase()));
            }
            if (responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_TaxGroup_ID.toLowerCase()) != 0){
                setC_TaxGroup_ID(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_C_TaxGroup_ID.toLowerCase()));
            }
            setName(responseObject.getString(I_X_C_BPartner.COLUMNNAME_Name.toLowerCase()));
            setName2(responseObject.getString(I_X_C_BPartner.COLUMNNAME_Name2.toLowerCase()));
            setDeliveryRule(responseObject.getString(I_X_C_BPartner.COLUMNNAME_DeliveryRule.toLowerCase()));
            setDeliveryViaRule(responseObject.getString(I_X_C_BPartner.COLUMNNAME_DeliveryViaRule.toLowerCase()));
            setIsCustomer(responseObject.getString(I_X_C_BPartner.COLUMNNAME_IsCustomer.toLowerCase()));
            setIsSalesRep(responseObject.getString(I_X_C_BPartner.COLUMNNAME_IsSalesRep.toLowerCase()));
            setIsVendor(responseObject.getString(I_X_C_BPartner.COLUMNNAME_IsVendor.toLowerCase()));
            if (responseObject.getInt(I_X_C_BPartner.COLUMNNAME_UpdatedBy.toLowerCase()) != 0){
                setUpdatedBy(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_UpdatedBy.toLowerCase()));
            }
            setValue(responseObject.getString(I_X_C_BPartner.COLUMNNAME_Value.toLowerCase()));
            if (responseObject.getInt(I_X_C_BPartner.COLUMNNAME_SalesRep_ID.toLowerCase()) != 0){
                setSalesRep_ID(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_SalesRep_ID.toLowerCase()));
            }
            setTaxID(responseObject.getString(I_X_C_BPartner.COLUMNNAME_TaxID.toLowerCase()));
            setSO_CreditLimit(responseObject.getDouble(I_X_C_BPartner.COLUMNNAME_SO_CreditLimit.toLowerCase()));
            setSO_CreditUsed(responseObject.getDouble(I_X_C_BPartner.COLUMNNAME_SO_CreditUsed.toLowerCase()));
            setSOCreditStatus(responseObject.getString(I_X_C_BPartner.COLUMNNAME_SOCreditStatus.toLowerCase()));
            setTotalOpenBalance(responseObject.getDouble(I_X_C_BPartner.COLUMNNAME_TotalOpenBalance.toLowerCase()));
            if (responseObject.getInt(I_X_C_BPartner.COLUMNNAME_M_PriceList_ID.toLowerCase()) != 0){
                setM_Pricelist_ID(responseObject.getInt(I_X_C_BPartner.COLUMNNAME_M_PriceList_ID.toLowerCase()));
            }
            save();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
