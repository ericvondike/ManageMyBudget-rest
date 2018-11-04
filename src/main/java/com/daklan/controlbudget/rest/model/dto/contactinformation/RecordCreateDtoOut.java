package com.daklan.controlbudget.rest.model.dto.contactinformation;

import java.io.Serializable;
import java.util.Objects;

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
        return "RecordCreateDtoOut{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecordCreateDtoOut)) return false;
        RecordCreateDtoOut that = (RecordCreateDtoOut) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
