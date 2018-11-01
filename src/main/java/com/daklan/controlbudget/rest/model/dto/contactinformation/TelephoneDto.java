package com.daklan.controlbudget.rest.model.dto.contactinformation;

import com.daklan.controlbudget.rest.model.enums.ContactUse;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO class modeling the telephone of the Person.</b>
 */
public class TelephoneDto implements Serializable {
    private static final Long serialVersionUID = 5701297634587120569L;

    @ApiModelProperty(value = "The telephonenumber of the Person", position = 15, example = "0000000000")
    private String telephone;

    @ApiModelProperty(value = "The usage type of the telephone", position = 16, example = "PERSONAL")
    private ContactUse use;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        return "TelephoneDto{" +
                "telephone='" + telephone + '\'' +
                ", use=" + use +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelephoneDto)) return false;
        TelephoneDto that = (TelephoneDto) o;
        return Objects.equals(getTelephone(), that.getTelephone()) &&
                getUse() == that.getUse();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTelephone(), getUse());
    }
}