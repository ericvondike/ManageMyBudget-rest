package com.daklan.controlbudget.rest.model.enums;

/**
 * <b>The enum for the usage type of the address of the Person: Work address, Birth address, Home address, Billing address.</b>
 */
public enum AddressUse {
    BILLING("Billing"),
    BIRTH("Birth"),
    HOME("Home"),
    WORK("work");

    private String use;

    AddressUse(String use) {
        this.use = use;
    }

    public String getUse() {
        return use;
    }
}
