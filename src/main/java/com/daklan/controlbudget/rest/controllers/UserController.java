package com.daklan.controlbudget.rest.controllers;

import com.daklan.controlbudget.rest.configuration.WrongPasswordException;
import com.daklan.controlbudget.rest.model.dto.output.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordUpdateDtoOut;
import com.daklan.controlbudget.rest.model.dto.user.PasswordUpdateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.UserCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.UsernameUpdateDtoIn;
import com.daklan.controlbudget.rest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"User"}, description = "APIs for managing User")
@RestController
@RequestMapping("/manage/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * <b>The end point for creating a new user.</b>
     * @param userCreateDtoIn DTOin containing the information on the user to be created.
     * @return RecordCreateDtoOut DTOout containing the id of the created user.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "The operation for creating a new User", notes = "The Operation for creating a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The user is successfully created"),
            @ApiResponse(code = 500, message = "The internal server error"),
            @ApiResponse(code = 400, message = "Error in the input")
    })
    public RecordCreateDtoOut createUser(@RequestBody UserCreateDtoIn userCreateDtoIn) {
        RecordCreateDtoOut userCreateDtoOut = this.userService.createUser(userCreateDtoIn);
        return userCreateDtoOut;
    }

    /**
     * <b>Theend  end point for updating the password of an existing user.</b>
     * @param passwordUpdateDtoIn The DTOin containing the old and the new password of the user.
     * @param id The id of the user.
     * @return RecordUpdateDtoOut the DTOout containing the id of the user in the case the password is successfully updated.
     * @throws WrongPasswordException, RecordNotFoundException
     */
    @RequestMapping(value = "/password/update/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "The operation for updating the password of an existing user", notes = "This operation updates the password of the user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The password is successfully updated"),
            @ApiResponse(code = 500, message = "The internal server error"),
            @ApiResponse(code = 400, message = "Error in input")
    })
    public RecordUpdateDtoOut updatePassword(@RequestBody PasswordUpdateDtoIn passwordUpdateDtoIn,
                                         @PathVariable String id) {
        RecordUpdateDtoOut passwordUpdateDtoOut = this.userService.updatePassword(passwordUpdateDtoIn, Long.parseLong(id));

        return passwordUpdateDtoOut;
    }


    @RequestMapping(value = "/username/update/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "The operation for updating the username of the user", notes = "This operation updates the username of an existing user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The username is successsfully updated"),
            @ApiResponse(code = 500, message = "The internal server error"),
            @ApiResponse(code = 400, message = "Error in input")
    })
    public RecordUpdateDtoOut updateUsername(@RequestBody UsernameUpdateDtoIn usernameUpdateDtoIn,
                                             @PathVariable String id) {
        RecordUpdateDtoOut usernameUpdateDtoOut = this.userService.updateUserName(usernameUpdateDtoIn, Long.parseLong(id));

        return usernameUpdateDtoOut;
    }

}
