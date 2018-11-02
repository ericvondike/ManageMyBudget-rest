package com.daklan.controlbudget.rest.model.dto.person;

import java.io.Serializable;
import java.util.Objects;

/**
 * <b>DTOout for creating a Person for the first time.</b>
 */
public class PersonCreateDtoOut implements Serializable {

    private static final long serialVersionUID = 2014503680795210941L;

    //The id of the created person
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonCreateDtoOut{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonCreateDtoOut)) return false;
        PersonCreateDtoOut that = (PersonCreateDtoOut) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
