package com.daklan.budget.control.rest.dto.output;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class ShoppingCenterOut implements Serializable {
    private static final long serialVersionUID = 4512483176459731471L;
    private String code;
    private String officialname;
    /**
     * The given name of the shopping center given by user.
     */
    private String givenName;
    private String address;
    private List<LocalDate> datesOpen;
    private String telNumber;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOfficialname() {
        return officialname;
    }

    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<LocalDate> getDatesOpen() {
        return datesOpen;
    }

    public void setDatesOpen(List<LocalDate> datesOpen) {
        this.datesOpen = datesOpen;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ShoppingCenterOut)) return false;

        ShoppingCenterOut that = (ShoppingCenterOut) o;

        return new EqualsBuilder()
                .append(code, that.code)
                .append(officialname, that.officialname)
                .append(givenName, that.givenName)
                .append(address, that.address)
                .append(datesOpen, that.datesOpen)
                .append(telNumber, that.telNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(code)
                .append(officialname)
                .append(givenName)
                .append(address)
                .append(datesOpen)
                .append(telNumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("officialname", officialname)
                .append("givenName", givenName)
                .append("address", address)
                .append("datesOpen", datesOpen)
                .append("telNumber", telNumber)
                .toString();
    }
}