package com.daklan.budget.control.rest.dto.input;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


public class ShoppingCenterIn implements Serializable {

    private static final long serialVersionUID = -45744158454644L;


    @NotNull
    private String code;
    @NotNull
    private String officialname;


    public ShoppingCenterIn() {
    }

    /**
     * The given name of the shopping center given by user.
     */
    @Nullable
    private String givenName;
    @Nullable
    private String address;
    @Nullable
    private List<String> datesOpen;
    @Nullable
    private String telNumber;



    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }
    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }


    /**
     *
     * @return
     */
    public String getOfficialname() {
        return officialname;
    }
    public void setOfficialname(String officialname) {
        this.officialname = officialname;
    }

    /**
     *
     * @return
     */
    @Nullable
    public String getGivenName() {
        return givenName;
    }
    /**
     *
     * @param givenName
     */
    @Nullable
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }


    /**
     *
     * @return
     */
    @Nullable
    public String getAddress() {
        return address;
    }
    /**
     *
     * @param address
     */
    @Nullable
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     *
     * @return
     */
    @Nullable
    public List<String> getDatesOpen() {
        return datesOpen;
    }
    /**
     *
     * @param datesOpen
     */
    @Nullable
    public void setDatesOpen(List<String> datesOpen) {
        this.datesOpen = datesOpen;
    }


    /**
     *
     * @return
     */
    @Nullable
    public String getTelNumber() {
        return telNumber;
    }

    /**
     *
     * @param telNumber
     */
    @Nullable
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ShoppingCenterIn)) return false;

        ShoppingCenterIn that = (ShoppingCenterIn) o;

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




