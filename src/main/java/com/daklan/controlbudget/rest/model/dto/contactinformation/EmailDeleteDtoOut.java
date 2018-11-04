package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO class for Deleting the email address of the Person.</b>
 */
public class EmailDeleteDtoOut implements Serializable {
    private static final Long serialVersionUID = 4652304790687123489L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmailDeleteDtoOut{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailDeleteDtoOut)) return false;
        EmailDeleteDtoOut that = (EmailDeleteDtoOut) o;
        return Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessage());
    }
}
