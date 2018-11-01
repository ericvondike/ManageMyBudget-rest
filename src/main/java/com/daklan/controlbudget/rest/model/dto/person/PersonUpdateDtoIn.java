package com.daklan.controlbudget.rest.model.dto.person;

import com.daklan.controlbudget.rest.model.dto.address.AddressDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.EmailDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.FaxDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.TelephoneDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * <b>The DTO classs modeling the complete information on a Person.</b>
 */
public class PersonUpdateDtoIn implements Serializable {
    private static final Long serialVersionUID = 5123047896347521039L;

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
        return "PersonUpdateDtoIn{" +
                "personInitialInformationDto=" + personInitialInformationDto +
                ", middleName='" + middleName + '\'' +
                ", maritalName='" + maritalName + '\'' +
                ", emails=" + emails +
                ", telephones=" + telephones +
                ", faxes=" + faxes +
                ", addresses=" + addresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonUpdateDtoIn)) return false;
        PersonUpdateDtoIn that = (PersonUpdateDtoIn) o;
        return Objects.equals(getPersonInitialInformationDto(), that.getPersonInitialInformationDto()) &&
                Objects.equals(getMiddleName(), that.getMiddleName()) &&
                Objects.equals(getMaritalName(), that.getMaritalName()) &&
                Objects.equals(getEmails(), that.getEmails()) &&
                Objects.equals(getTelephones(), that.getTelephones()) &&
                Objects.equals(getFaxes(), that.getFaxes()) &&
                Objects.equals(getAddresses(), that.getAddresses());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPersonInitialInformationDto(), getMiddleName(), getMaritalName(), getEmails(), getTelephones(), getFaxes(), getAddresses());
    }
}
