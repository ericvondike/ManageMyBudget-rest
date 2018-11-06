package com.daklan.controlbudget.rest.model.dto.person;

import com.daklan.controlbudget.rest.model.dto.address.AddressDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.EmailDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.FaxDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.TelephoneDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * <b>The DTOout class for consulting the entire information on a person.</b>
 */
public class PersonConsultDtoOut implements Serializable {
    private static final Long serialVersionUID = 9123654809712456703L;

    @JsonUnwrapped
    PersonInitialInformationDto personInitialInformationDto;

    @ApiModelProperty(value = "The middle name of the Person", position = 5, example = "Maxwell")
    private String middleName;

    @ApiModelProperty(value = "The marital name of the Person", position = 6, example = "KRAUSS")
    private String maritalName;

    @ApiModelProperty(value = "The list of the emails of the Person", position = 10)
    private List<EmailDto> emails;

    @ApiModelProperty(value = "The list of the telephones of the Person", position = 15)
    private List<TelephoneDto> telephones;

    @ApiModelProperty(value = "The list of the faxes of the Person", position = 20)
    private List<FaxDto> faxes;

    @ApiModelProperty(value = "The list of the addresses of the Person", position = 25)
    private List<AddressDto> addresses;

    public PersonInitialInformationDto getPersonInitialInformationDto() {
        return personInitialInformationDto;
    }

    public void setPersonInitialInformationDto(PersonInitialInformationDto personInitialInformationDto) {
        this.personInitialInformationDto = personInitialInformationDto;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMaritalName() {
        return maritalName;
    }

    public void setMaritalName(String maritalName) {
        this.maritalName = maritalName;
    }

    public List<EmailDto> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailDto> emails) {
        this.emails = emails;
    }

    public List<TelephoneDto> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<TelephoneDto> telephones) {
        this.telephones = telephones;
    }

    public List<FaxDto> getFaxes() {
        return faxes;
    }

    public void setFaxes(List<FaxDto> faxes) {
        this.faxes = faxes;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("personInitialInformationDto", personInitialInformationDto)
                .append("middleName", middleName)
                .append("maritalName", maritalName)
                .append("emails", emails)
                .append("telephones", telephones)
                .append("faxes", faxes)
                .append("addresses", addresses)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PersonConsultDtoOut)) return false;

        PersonConsultDtoOut that = (PersonConsultDtoOut) o;

        return new EqualsBuilder()
                .append(getPersonInitialInformationDto(), that.getPersonInitialInformationDto())
                .append(getMiddleName(), that.getMiddleName())
                .append(getMaritalName(), that.getMaritalName())
                .append(getEmails(), that.getEmails())
                .append(getTelephones(), that.getTelephones())
                .append(getFaxes(), that.getFaxes())
                .append(getAddresses(), that.getAddresses())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPersonInitialInformationDto())
                .append(getMiddleName())
                .append(getMaritalName())
                .append(getEmails())
                .append(getTelephones())
                .append(getFaxes())
                .append(getAddresses())
                .toHashCode();
    }
}
