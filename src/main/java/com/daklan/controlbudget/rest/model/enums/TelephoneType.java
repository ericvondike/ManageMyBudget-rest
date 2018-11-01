package com.daklan.controlbudget.rest.model.enums;

/**
 * <b>The type of the telephone used by the Person: either Fix or mobile</b>
 */
public enum TelephoneType {
    FIX("Fix"),
    MOBILE("Mobile");

    private String type;

    TelephoneType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
