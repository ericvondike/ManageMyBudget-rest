package com.daklan.controlbudget.rest.model.dto.person;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * <b>DTOout for creating a Person for the first time.</b>
 */
public class PersonCreateDtoOut implements Serializable {

    private static final long serialVersionUID = 2014503680795210941L;

    private String firtsName;
    private String lastName;
    private LocalDate birthDate;

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
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
        return "PersonCreateDtoOut{" +
                "firtsName='" + firtsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonCreateDtoOut)) return false;
        PersonCreateDtoOut that = (PersonCreateDtoOut) o;
        return Objects.equals(getFirtsName(), that.getFirtsName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getBirthDate(), that.getBirthDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirtsName(), getLastName(), getBirthDate());
    }
}
