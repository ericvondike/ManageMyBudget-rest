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
     * @param idPerson the id of the Person
     * @return TelephoneDto the DTOout for creating a telephone for a Person.
     */
    RecordCreateDtoOut addTelephone(TelephoneDto telephoneDto, Long idPerson) throws RecordNotFoundException;

    /**
     * <b>The method for updating a telephone number for an existing Person.</b>
     * @param telephoneDto the information on the telephone of the person
     * @param idTelephone the id of the Telephone to be updated.
     * @return TelephoneDto the DTOout for updating a telephone for a Person.
     */
    RecordUpdateDtoOut updateTelephone(TelephoneDto telephoneDto, Long idTelephone) throws RecordNotFoundException;

    /**
     * <b>The method for deleting a telephone number for an existing Person.</b>
     * @param idTelephone the id of the Telephone to de deleted.
     * @return TelephoneDeleteDtoOut the DTOout for deleting the telephone information of a Person.
     */
    RecordDeleteDtoOut deleteTelephone(Long idTelephone) throws RecordNotFoundException, TooManyRecordsFoundException;

    /**
     * <b>The method for adding an email address for an existing Person.</b>
     * @param emailDto the information on the email of the person
     * @param id the id of the Person
     * @return EmailDto the DTOout for creating an email for a Person.
     */
    RecordCreateDtoOut addEmail(EmailDto emailDto, Long id);

    /**
     * <b>The method for updating the email address of an existing Person.</b>
     * @param emailDto the information on the email of the person
     * @param id the id of the Person
     * @return EmailDto the DTOout for updating an email for a Person.
     */
    RecordUpdateDtoOut updateEmail(EmailDto emailDto, Long id);

    /**
     * <b>The method for deleting the email address of an existing Person.</b>
     * @param id the id of the Email to be deleted.
     * @return EmailDeleteDtoOut the DTOout for deleting the email information of a Person.
     */
    RecordDeleteDtoOut deleteEmail(Long id);

    /**
     *  <b>The method for adding a fax number for an existing Person.</b>
     * @param faxDto the information on the fax of the person
     * @param id the id of the Person
     * @return FaxDto the DTOout for creating a fax for a Person.
     */
    RecordCreateDtoOut addFax(FaxDto faxDto, Long id);

    /**
     * <b>The method for updating the fax information for an existing Person.</b>
     * @param faxDto the information on the fax of the person
     * @param id the id of the Person
     * @return FaxDto the DTOout for updating a fax for a Person.
     */
    RecordUpdateDtoOut updateFax(FaxDto faxDto, Long id);

    /**
     * <b>The method for deleting the fax information of an existing Person.</b>
     * @param id the id of the Person
     * @return FaxDeleteDtoOut the DTOout for deleting the fax information of a Person.
     */
    RecordDeleteDtoOut deleteFax(Long id);
}
