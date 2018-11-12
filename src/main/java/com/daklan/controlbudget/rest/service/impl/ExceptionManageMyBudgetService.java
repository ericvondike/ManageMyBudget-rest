package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.configuration.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * <b>The service for the handling the exceptions of the project.</b>
 */
@Service
public class ExceptionManageMyBudgetService {

    private final String errorMessagePersonNotFound;
    private final String errorMessageContactInformationNotFound;
    private final String errorMessageContactUseNotFound;
    private final String errorMessageUserNotFound;
    private final String errorWrongPassword;
    @Value("${message.error.person.not.found}") private String errorMessagePersonNotFoundTest;

    @Autowired
    public ExceptionManageMyBudgetService(@Value("${message.error.person.not.found}") String errorMessagePersonNotFound,
                                          @Value("${message.contact.not.found}") String errorMessageContactInformationNotFound,
                                          @Value("${message.error.contact.use.not.found}") String errorMessageContactUseNotFound,
                                          @Value("${message.error.user.not.found}") String errorMessageUserNotFound,
                                          @Value("${message.error.password.wrong}") String errorWrongPassword) {
        this.errorMessagePersonNotFound = errorMessagePersonNotFound;
        this.errorMessageContactInformationNotFound = errorMessageContactInformationNotFound;
        this.errorMessageContactUseNotFound = errorMessageContactUseNotFound;
        this.errorMessageUserNotFound = errorMessageUserNotFound;
        this.errorWrongPassword = errorWrongPassword;
    }

    /**
     * <b>The method for handling the exception for a nonExistent Person.</b>
     * @param idPerson the id of the person to be deleted, which normally does not exist at this stage.
     */
    public void throwPersonNotFoundExcpetion(Long idPerson) {
        final String errorMessage = MessageFormat.format(errorMessagePersonNotFound, idPerson);
        throw new RecordNotFoundException(errorMessage);
    }

    /**
     * <b>The method for handling the exception for a nonExistent contact information for a Person.</b>
     * @param idContactInformation te id of the record for contact information.
     */
    public void throwContactInformationNotFoundException(Long idContactInformation) {
        final String errorMessage = MessageFormat.format(errorMessageContactInformationNotFound, idContactInformation);
        throw new RecordNotFoundException(errorMessage);
    }

    /**
     * <b>The method for handling the exception for a nonExistent contact Use.</b>
     * @param strContactUse the input contact USE: The usage type of the contact information (PERSONAL, PROFESSIONAL)
     */
    public void throwContactUseNotFoundException(String strContactUse) {
        final String errorMessage = MessageFormat.format(errorMessageContactUseNotFound, strContactUse);
        throw new RecordNotFoundException(errorMessage);
    }

    /**
     *
     * @param username
     */
    public void throwUserNotFoundException(String username) {
        final String errorMessage = MessageFormat.format(errorMessageUserNotFound, username);
        throw new RecordNotFoundException(errorMessage);
    }

    public void throwWrongPasswordException() {
        final String errorMessage = errorWrongPassword;
        throw new WrongPasswordException(errorMessage);
    }
}
