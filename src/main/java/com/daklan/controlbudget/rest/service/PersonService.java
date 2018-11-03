package com.daklan.controlbudget.rest.service;

import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
import com.daklan.controlbudget.rest.model.entity.contactinformation.PerosnNotFoudException;

/**
 *<b>The service for CRUD actions on Person: Create, Fine, Update, Delete</b>
 */
public interface PersonService {

    /**
     * <b>The method for creating a nonexistent person for the first time.</b>
     * @param personCreateDtoIn DTOin containing the information on the person to be created. This is the initial information on the person.
     * @return returns the same data saved in the sql table.
     */
    PersonCreateDtoOut create(PersonCreateDtoIn personCreateDtoIn);

    /**
     * <b>The method for updating an existent person.</b>
     * @param personUpdateDtoIn DTOin containing the information on the person to be updated. This is the complete information on the person.
     * @return returns the same data saved in the sql table.
     */
    PersonCreateDtoOut update(PersonUpdateDtoIn personUpdateDtoIn, Long id);

    /**
     * <b>The method for deleting an existent person.</b>
     * @param id The id of the Person to be deleted
     * @return the DTOout for the deleted Person which contains just the id of the delted Person.
     */
    PersonDeleteDtoOut delete(Long id) throws PerosnNotFoudException;

}
