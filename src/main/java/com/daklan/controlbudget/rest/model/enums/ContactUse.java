package com.daklan.controlbudget.rest.model.enums;

/**
 * <b>The enum for the usage type of the contact informations: Professional or Personal.</b>
 */
public enum ContactUse {
    PROFESSIONAL("Professional"),
    PERSONAL("Personal");

    private String usage;

    ContactUse(String usage) {
        this.usage = usage;
    }

    public String getUsage() {
        return usage;
    }
}
