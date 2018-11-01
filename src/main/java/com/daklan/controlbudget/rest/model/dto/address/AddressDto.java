package com.daklan.controlbudget.rest.model.dto.address;

import com.daklan.controlbudget.rest.model.enums.AddressUse;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO classs modeling the address of a Person.</b>
 */

public class AddressDto implements Serializable {
    private static final Long serialVersionUID = 9010504060789541235L;

    @ApiModelProperty(value = "The street number of the address", position = 25, example = "78-A")
    private String streetNumber;

    @ApiModelProperty(value = "The stret name of the address", position = 26 , example = "Lagrange")
    private String streetName;

    @ApiModelProperty(value = "The street type of the address", position = 27, example = "Street")
    private String streetType;

    @ApiModelProperty(value = "The postal code of the address", position = 28, example = "45871")
    private String postalCode;

    @ApiModelProperty(value = "The name of the city of the address", position = 29, example = "Paris")
    private String cityName;

    @ApiModelProperty(value = "The name of the country of the address", position = 30, example = "France")
    private String countryName;

    @ApiModelProperty(value = "The complementary information of the address", position = 31, example = "Apartment number 1, The first Floor")
    private String addressCompletion;

    @ApiModelProperty(value = "The usage type of the address", position = 32, example = "HOME")
    private AddressUse use;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAddressCompletion() {
        return addressCompletion;
    }

    public void setAddressCompletion(String addressCompletion) {
        this.addressCompletion = addressCompletion;
    }

    public AddressUse getUse() {
        return use;
    }

    public void setUse(AddressUse use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetType='" + streetType + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", addressCompletion='" + addressCompletion + '\'' +
                ", use=" + use +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDto)) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(getStreetNumber(), that.getStreetNumber()) &&
                Objects.equals(getStreetName(), that.getStreetName()) &&
                Objects.equals(getStreetType(), that.getStreetType()) &&
                Objects.equals(getPostalCode(), that.getPostalCode()) &&
                Objects.equals(getCityName(), that.getCityName()) &&
                Objects.equals(getCountryName(), that.getCountryName()) &&
                Objects.equals(getAddressCompletion(), that.getAddressCompletion()) &&
                getUse() == that.getUse();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStreetNumber(), getStreetName(), getStreetType(), getPostalCode(), getCityName(), getCountryName(), getAddressCompletion(), getUse());
    }
}
