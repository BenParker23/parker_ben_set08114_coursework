package com.ben.model;

/**
 * Created by BenPa on 01/03/2018.
 */

public class X_X_Action_Status implements I_X_Action_Status {

    private int X_Action_Status_ID;
    private String Name;
    private String IsActive;
    private String Description;


    public int getX_Action_Status_ID() {
        return X_Action_Status_ID;
    }

    public void setX_Action_Status_ID(int x_Action_Status_ID) {
        X_Action_Status_ID = x_Action_Status_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

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

    public void setDescription(String description) {
        Description = description;
    }


}
