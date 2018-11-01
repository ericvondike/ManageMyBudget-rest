package com.daklan.controlbudget.rest.model.dto.contactinformation;

import com.daklan.controlbudget.rest.model.enums.ContactUse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO class modeling the fax of the Person.</b>
 */
public class FaxDto implements Serializable {
    private static final Long serialVersionUID = 4150203478941234357L;

    @ApiModelProperty(value = "The fax of the Person", position = 20, example = "0000000000")
    private String fax;

    @ApiModelProperty(value = "the usage type of the fax", position = 21, example = "PERSONAL")
    private ContactUse use;

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public ContactUse getUse() {
        return use;
    }

    public void setUse(ContactUse use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return "FaxDto{" +
                "fax='" + fax + '\'' +
                ", use=" + use +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FaxDto)) return false;
        FaxDto faxDto = (FaxDto) o;
        return Objects.equals(getFax(), faxDto.getFax()) &&
                getUse() == faxDto.getUse();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFax(), getUse());
    }
}
