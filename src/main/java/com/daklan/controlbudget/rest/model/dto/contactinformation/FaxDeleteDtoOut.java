package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

public class FaxDeleteDtoOut implements Serializable {
    private static final Long serialVersionUID = 3085974631257196304L;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "FaxDeleteDtoOut{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FaxDeleteDtoOut)) return false;
        FaxDeleteDtoOut that = (FaxDeleteDtoOut) o;
        return Objects.equals(getMessage(), that.getMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessage());
    }
}
