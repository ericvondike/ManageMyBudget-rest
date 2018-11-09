package com.daklan.controlbudget.rest.model.dto.output;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <b>The DTO class for Updating a record: Person, Telephone, Fax, etc,.</b>
 */
public class RecordUpdateDtoOut implements Serializable {
    private static final Long serialVersionUID = 3985201463578934503L;

    private String id;

    public RecordUpdateDtoOut(String id) {
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

        if (!(o instanceof RecordUpdateDtoOut)) return false;

        RecordUpdateDtoOut that = (RecordUpdateDtoOut) o;

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
