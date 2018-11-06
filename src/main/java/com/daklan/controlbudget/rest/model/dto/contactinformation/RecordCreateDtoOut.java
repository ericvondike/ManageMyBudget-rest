package com.daklan.controlbudget.rest.model.dto.contactinformation;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <b>The DTO class for Creating a record: Person, Telephone, Fax, etc,.</b>
 */
public class RecordCreateDtoOut implements Serializable {
    private static final Long serialVersionUID = 7120356478952790248L;

    private String id;

    public RecordCreateDtoOut(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof RecordCreateDtoOut)) return false;

        RecordCreateDtoOut that = (RecordCreateDtoOut) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }
}
