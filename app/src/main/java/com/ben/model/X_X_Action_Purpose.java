package com.ben.model;

public class X_X_Action_Purpose implements I_X_Action_Purpose
{
	private String Description;
	private int X_Action_Purpose_ID;
	private int X_Action_Status_ID;
	private String IsActive;
	private String Name;
	private int DailyLimit;

	@Override
	public String getDescription() {
		return Description;
	}

	@Override
	public void setIsActive(String IsActive) {
		this.IsActive = IsActive;
	}

	@Override
	public String isActive() {
		return IsActive;
	}

	@Override
	public void setName(String Name) {
		this.Name = Name;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public void setDailyLimit(int DailyLimit) {
		this.DailyLimit = DailyLimit;
	}

	@Override
	public int getDailyLimit() {
		return DailyLimit;
	}

	@Override
	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public int getX_Action_Purpose_ID() {
		return X_Action_Purpose_ID;
	}

	@Override
	public void setX_Action_Purpose_ID(int x_Action_Purpose_ID) {
		X_Action_Purpose_ID = x_Action_Purpose_ID;
	}

	@Override
	public int getX_Action_Status_ID() {
		return X_Action_Status_ID;
	}

	@Override
	public void setX_Action_Status_ID(int x_Action_Status_ID) {
		X_Action_Status_ID = x_Action_Status_ID;
	}

	public String getIsActive() {
		return IsActive;
	}


	@Override
	public double getTotalSalesValue() {
		return TotalSalesValue;
	}

	@Override
	public void setTotalSalesValue(double totalSalesValue) {
		TotalSalesValue = totalSalesValue;
	}

	@Override
	public String getValue() {
		return Value;
	}

	@Override
	public void setValue(String value) {
		Value = value;
	}

	public String getSalesValueQuantifiable() {
		return SalesValueQuantifiable;
	}

	@Override
	public void setSalesValueQuantifiable(String salesValueQuantifiable) {
		SalesValueQuantifiable = salesValueQuantifiable;
	}

	@Override
	public String isSalesValueQuantifiable() {
		return SalesValueQuantifiable;
	}

	private double TotalSalesValue;
	private String Value;
	private String SalesValueQuantifiable;
}