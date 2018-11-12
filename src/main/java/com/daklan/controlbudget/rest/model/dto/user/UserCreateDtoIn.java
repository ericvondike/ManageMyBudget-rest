package com.daklan.controlbudget.rest.model.dto.user;

import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <b>The class for creating a new user with username and password.</b>
 */
public class UserCreateDtoIn implements Serializable {


    private static final long serialVersionUID = 6896105375526940604L;

    @ApiModelProperty(position = 1)
    private PersonCreateDtoIn person;

    @ApiModelProperty(value = "The username of the user", position = 6, example = "username")
    private String userName;

    @ApiModelProperty(value = "The password of the user", position = 7, example = "password")
    private String password;

    public PersonCreateDtoIn getPerson() {
        return person;
    }

    public void setPerson(PersonCreateDtoIn person) {
        this.person = person;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("person", person)
                .append("userName", userName)
                .append("password", password)
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof UserCreateDtoIn)) return false;

        UserCreateDtoIn that = (UserCreateDtoIn) o;

        return new EqualsBuilder()
                .append(getPerson(), that.getPerson())
                .append(getUserName(), that.getUserName())
                .append(getPassword(), that.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPerson())
                .append(getUserName())
                .append(getPassword())
                .toHashCode();
    }
}
