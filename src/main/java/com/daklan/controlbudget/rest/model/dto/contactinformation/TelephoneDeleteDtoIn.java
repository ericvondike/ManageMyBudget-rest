package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO for the delete action on the telephone number of the person.</b>
 */
public class TelephoneDeleteDtoIn implements Serializable {
    private static final Long serialVersionUID = 5875932145697410239L;

    private String telephoneNumber;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "TelephoneDeleteDtoIn{" +
                "telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelephoneDeleteDtoIn)) return false;
        TelephoneDeleteDtoIn that = (TelephoneDeleteDtoIn) o;
        return Objects.equals(getTelephoneNumber(), that.getTelephoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTelephoneNumber());
    }
}
