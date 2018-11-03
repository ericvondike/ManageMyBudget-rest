package com.daklan.controlbudget.rest.model.dto.person;

import java.io.Serializable;
import java.util.Objects;

public class PersonDeleteDtoOut implements Serializable {
    private static final Long serialVersionUID = 4270859413275068019L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDeleteDtoOut{" +
                "id='" + id + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDeleteDtoOut)) return false;
        PersonDeleteDtoOut that = (PersonDeleteDtoOut) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
