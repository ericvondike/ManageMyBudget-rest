package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

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
        return "RecordUpdateDtoOut{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecordUpdateDtoOut)) return false;
        RecordUpdateDtoOut that = (RecordUpdateDtoOut) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
