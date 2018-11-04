package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO class for Deleting the Telephone number of the Person.</b>
 */
public class TelephoneDeleteDtoOut implements Serializable {
    private static final Long serialVersionUID = 1023987143569712985L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TelephoneDeleteDtoOut{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelephoneDeleteDtoOut)) return false;
        TelephoneDeleteDtoOut that = (TelephoneDeleteDtoOut) o;
        return Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessage());
    }
}
