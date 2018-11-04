package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * <b>The service for the handling the exceptions of the project.</b>
 */
@Service
public class ExceptionManageMyBudgetService {
    private String errorMessagePersonNotFound;
    private String errorMessageContactInformationNotFound;

    @Autowired
    public ExceptionManageMyBudgetService(@Value("${message.error.person.not.found}") String errorMessagePersonNotFound,
                                          @Value("${message.contact.not.found}") String errorMessageContactInformationNotFound) {
        this.errorMessagePersonNotFound = errorMessagePersonNotFound;
        this.errorMessageContactInformationNotFound = errorMessageContactInformationNotFound;
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
}
