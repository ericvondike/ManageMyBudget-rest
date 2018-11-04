package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>The DTO class for Deleting a record: Person, Telephone, Fax, etc,.</b>
 */
public class RecordDeleteDtoOut implements Serializable {
    private static final Long serialVersionUID = 925064708963214760L;

    private String id;

    public RecordDeleteDtoOut(String id) {
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
        return "RecordDeleteDtoOut{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecordDeleteDtoOut)) return false;
        RecordDeleteDtoOut that = (RecordDeleteDtoOut) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
