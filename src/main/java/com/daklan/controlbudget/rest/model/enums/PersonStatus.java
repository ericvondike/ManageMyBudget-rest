package com.daklan.controlbudget.rest.model.enums;

/**
 * <b>The enum for the status of the Person: Beginner, Customer.</b>
 */
public enum PersonStatus {
    BEGINNER("Beginner"),
    CUSTOMER("Customer");

    private String status;

    PersonStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
