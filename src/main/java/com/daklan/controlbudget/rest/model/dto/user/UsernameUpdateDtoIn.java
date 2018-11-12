package com.daklan.controlbudget.rest.model.dto.user;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <b>The class for updating the username of an existing user.</b>
 */
public class UsernameUpdateDtoIn implements Serializable {

    private static final long serialVersionUID = 8677204900830331184L;

    @ApiModelProperty(value = "The password of the user", position = 1, example = "password")
    private String password;

    @ApiModelProperty(value = "The old username of the user", position = 2, example = "Old username")
    private String oldUsername;

    @ApiModelProperty(value = "The new username of the user", position = 3, example = "New username")
    private String newUsername;

    public String getOldUsername() {
        return oldUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOldUsername(String oldUsername) {
        this.oldUsername = oldUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("password", password)
                .append("oldUsername", oldUsername)
                .append("newUsername", newUsername)
                .toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof UsernameUpdateDtoIn)) return false;

        UsernameUpdateDtoIn that = (UsernameUpdateDtoIn) o;

        return new EqualsBuilder()
                .append(getPassword(), that.getPassword())
                .append(getOldUsername(), that.getOldUsername())
                .append(getNewUsername(), that.getNewUsername())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPassword())
                .append(getOldUsername())
                .append(getNewUsername())
                .toHashCode();
    }
}
