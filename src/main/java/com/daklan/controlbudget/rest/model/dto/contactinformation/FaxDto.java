package com.daklan.controlbudget.rest.model.dto.contactinformation;

import com.daklan.controlbudget.rest.model.enums.ContactUse;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

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
        return new ToStringBuilder(this)
                .append("fax", fax)
                .append("use", use)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof FaxDto)) return false;

        FaxDto faxDto = (FaxDto) o;

        return new EqualsBuilder()
                .append(getFax(), faxDto.getFax())
                .append(getUse(), faxDto.getUse())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFax())
                .append(getUse())
                .toHashCode();
    }
}
