package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.model.dto.contactinformation.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.contactinformation.RecordDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.contactinformation.RecordUpdateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;

/**
 *<b>The service for CRUD actions on Person: Create, Find, Update, Delete</b>
 */
public interface PersonService {

    /**
     * <b>The method for creating a nonexistent person for the first time.</b>
     * @param personCreateDtoIn DTOin containing the information on the person to be created. This is the initial information on the person.
     * @return returns the same data saved in the sql table.
     */
    RecordCreateDtoOut create(PersonCreateDtoIn personCreateDtoIn);

    /**
     * <b>The method for updating an existent person.</b>
     * @param personUpdateDtoIn DTOin containing the information on the person to be updated. This is the complete information on the person.
     * @return returns the same data saved in the sql table.
     * @throws RecordNotFoundException : this exception is thrown if the person with the input id does not exist.
     */
    RecordUpdateDtoOut update(PersonUpdateDtoIn personUpdateDtoIn, Long id) throws RecordNotFoundException;

    /**
     * <b>The method for deleting an existent person.</b>
     * @param id The id of the Person to be deleted
     * @return the DTOout for the deleted Person which contains just the id of the delted Person.
     * @throws RecordNotFoundException: this exception is thrown if the person with the input id does not exist.
     */
    RecordDeleteDtoOut delete(Long id) throws RecordNotFoundException;

}
