package com.daklan.controlbudget.rest.model.dto.person;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <b>The DTO class modeling the initial information necessary to create a person for the first time.</b>
 */
public class PersonInitialInformationDto implements Serializable {

    private static Long serialVersionUID = 4110214785903065401L;

    @ApiModelProperty(value = "The firstName of the person", position = 1, example = "Lawrence")
    private String firstName;

    @ApiModelProperty(value = "The lastName of the person", position = 2, example = "KRAUSS")
    private String lastName;

    @ApiModelProperty(value = "The birthDate of the person", position = 3, example = "1954-05-27")
    private LocalDate birthDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "PersonCreateDtoIn{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonInitialInformationDto)) return false;
        PersonInitialInformationDto that = (PersonInitialInformationDto) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getBirthDate(), that.getBirthDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getLastName(), getBirthDate());
    }
}
