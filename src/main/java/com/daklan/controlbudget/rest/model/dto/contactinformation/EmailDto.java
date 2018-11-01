package com.daklan.controlbudget.rest.model.dto.contactinformation;

import com.daklan.controlbudget.rest.model.enums.ContactUse;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO class modeling the email of the Person.</b>
 */
public class EmailDto implements Serializable {
    private static final Long serialVersionUID = 8012365407943576210L;

    @ApiModelProperty(value = "The email of the Person", position = 10, example = "email@example.com")
    private String email;

    @ApiModelProperty(value = "The usage type of the email", position = 11, example = "PERSONAL")
    private ContactUse use;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContactUse getUse() {
        return use;
    }

    public void setUse(ContactUse use) {
        this.use = use;
    }

    @Override
    public String
    toString() {
        return "EmailDto{" +
                "email='" + email + '\'' +
                ", use=" + use +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailDto)) return false;
        EmailDto emailDto = (EmailDto) o;
        return Objects.equals(getEmail(), emailDto.getEmail()) &&
                getUse() == emailDto.getUse();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getEmail(), getUse());
    }
}
