package com.daklan.controlbudget.rest.model.dto.user;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <b>The class for updating the password of an existing user.</b>
 */
public class PasswordUpdateDtoIn implements Serializable {

    private static final long serialVersionUID = 5923838952152437207L;

    @ApiModelProperty(value = "The old password of the user", position = 1, example = "Old password")
    private String oldPassword;

    @ApiModelProperty(value = "The new password of the user", position = 1, example = "new Password")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("oldPassword", oldPassword)
                .append("newPassword", newPassword)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PasswordUpdateDtoIn)) return false;

        PasswordUpdateDtoIn that = (PasswordUpdateDtoIn) o;

        return new EqualsBuilder()
                .append(oldPassword, that.oldPassword)
                .append(newPassword, that.newPassword)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(oldPassword)
                .append(newPassword)
                .toHashCode();
    }
}
