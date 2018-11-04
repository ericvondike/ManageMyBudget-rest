package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.configuration.TooManyRecordsFoundException;
import com.daklan.controlbudget.rest.model.dto.contactinformation.*;

/**
 *<b>The service for CRUD actions on the contact information of the Person: Create, Find, Update, Delete : Email, Telephone, Fax.</b>
 */
public interface ContactInformationService {

    /**
     * <b>The method for adding a telephone number for an existing Person.</b>
     * @param telephoneDto the information on the telephone of the person
     * @param id the id of the Person
     * @return TelephoneDto the DTOout for creating a telephone for a Person.
     */
    TelephoneDto addTelephone(TelephoneDto telephoneDto, Long id) throws RecordNotFoundException;

    /**
     * <b>The method for updating a telephone number for an existing Person.</b>
     * @param telephoneDto the information on the telephone of the person
     * @param id the id of the Person
     * @return TelephoneDto the DTOout for updating a telephone for a Person.
     */
    TelephoneDto updateTelephone(TelephoneDto telephoneDto, Long id);

    /**
     * <b>The method for deleting a telephone number for an existing Person.</b>
     * @param telephoneNumber the information on the telephone of the person
     * @param id the id of the Person
     * @return TelephoneDeleteDtoOut the DTOout for deleting the telephone information of a Person.
     */
    TelephoneDeleteDtoOut deleteTelephone(String telephoneNumber, Long id) throws RecordNotFoundException, TooManyRecordsFoundException;

    /**
     * <b>The method for adding an email address for an existing Person.</b>
     * @param emailDto the information on the email of the person
     * @param id the id of the Person
     * @return EmailDto the DTOout for creating an email for a Person.
     */
    EmailDto addEmail(EmailDto emailDto, Long id);

    /**
     * <b>The method for updating the email address of an existing Person.</b>
     * @param emailDto the information on the email of the person
     * @param id the id of the Person
     * @return EmailDto the DTOout for updating an email for a Person.
     */
    EmailDto updateEmail(EmailDto emailDto, Long id);

    /**
     * <b>The method for deleting the email address of an existing Person.</b>
     * @param emailAddress the email address of the person
     * @param id the id of the Person
     * @return EmailDeleteDtoOut the DTOout for deleting the email information of a Person.
     */
    EmailDeleteDtoOut deleteEmail(String emailAddress, Long id);

    /**
     *  <b>The method for adding a fax number for an existing Person.</b>
     * @param faxDto the information on the fax of the person
     * @param id the id of the Person
     * @return FaxDto the DTOout for creating a fax for a Person.
     */
    FaxDto addFax(FaxDto faxDto, Long id);

    /**
     * <b>The method for updating the fax information for an existing Person.</b>
     * @param faxDto the information on the fax of the person
     * @param id the id of the Person
     * @return FaxDto the DTOout for updating a fax for a Person.
     */
    FaxDto updateFax(FaxDto faxDto, Long id);

    /**
     * <b>The method for deleting the fax information of an existing Person.</b>
     * @param faxNumber the fax number of the person.
     * @param id the id of the Person
     * @return FaxDeleteDtoOut the DTOout for deleting the fax information of a Person.
     */
    FaxDeleteDtoOut deleteFax(String faxNumber, Long id);
}
