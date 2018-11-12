package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.model.dto.output.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordUpdateDtoOut;
import com.daklan.controlbudget.rest.model.dto.user.PasswordUpdateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.UserCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.UsernameUpdateDtoIn;

/**
 * <b>The service for CRUD operations on a user.</b>
 */
public interface UserService {

    /**
     * <b>The method for creating a new user.</b>
     * @param userCreateDtoIn DTOin conatining the information on a new user to be created.
     * @return RecordCreateDtoOut DTOout containing just the id of the recently created user.
     */
    RecordCreateDtoOut createUser(UserCreateDtoIn userCreateDtoIn);

    /**
     * <b>The method for updating the password of the user.</b>
     * @param userDtoIn DTOin containing the old and the new password of the user.
     * @param id the id of the user.
     * @return RecordUpdateDtoOut DTOout containg just the id of the user whose password has been updated.
     */
    RecordUpdateDtoOut updatePassword(PasswordUpdateDtoIn userDtoIn, Long id);

    /**
     * <b>The method for updating the username of an existing user.</b>
     * @param usernameUpdateDtoIn DTOin containg the old and the new username of the usr to be updated.
     * @param id the id of the user.
     * @return RecordUpdateDtoOut DTOout containing the id of the user whose information has been updated.
     */
    RecordUpdateDtoOut updateUserName(UsernameUpdateDtoIn usernameUpdateDtoIn, Long id);

    /**
     * <b>The method for deleting the user.</b>
     * @param id The id of the user
     * @return RecordDeleteDtoOut DTOout containing the id of the user whose information have been deleted.
     */
    RecordDeleteDtoOut deleteUser(String id);

}
