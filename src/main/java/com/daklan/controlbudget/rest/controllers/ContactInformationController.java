package com.daklan.controlbudget.rest.controllers;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.model.dto.contactinformation.*;
import com.daklan.controlbudget.rest.service.ContactInformationService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api(tags = {"Contact Information"}, description = "APIs for CRUD operations on the contact information of the person")
@RestController
@RequestMapping(value = "/manage/contact")
public class ContactInformationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactInformationController.class);

    private ContactInformationService service;

    @Autowired
    public ContactInformationController(ContactInformationService contactInformationService) {
        this.service = contactInformationService;
    }

    /**
     * <b>The endpoint for adding a telephone number for an existing person.</b>
     * @param telephoneDto The DTOin containing all the information on telephone of the Person.
     * @param id_person the id of the existing person.
     * @return RecordCreateDtoOut DTOout containing the id of the newly created Telephone.
     * @throws RecordNotFoundException this exception is thrown if the person with the input id is not found.
     */
    @RequestMapping(value = "/telephone/add/{id_person}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordCreateDtoOut> addTelephone(@RequestBody TelephoneDto telephoneDto,
                                                           @PathVariable String id_person) {
        RecordCreateDtoOut telephoneAdded = service.addTelephone(telephoneDto, Long.parseLong(id_person));

        return ResponseEntity.ok(telephoneAdded);
    }

    /**
     * <b>The endpoint for updating a telephone number for an existing person.</b>
     * @param telephoneDto The DTOin containing all the information on telephone of the Person.
     * @param id_telephone the id of teh existing person.
     * @return elephonDto DTOout containing the id of the updated telephone information.
     * @throws RecordNotFoundException this exception is thrown if the telephone record for update is not found.
     */
    @RequestMapping(value = "/telephone/update/{id_telephone}", method = PUT)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordUpdateDtoOut> updateTelephone(@RequestBody TelephoneDto telephoneDto,
                                                              @PathVariable String id_telephone) {
        RecordUpdateDtoOut telephoneUpdateDtoOut = service.updateTelephone(telephoneDto, Long.parseLong(id_telephone));

        return ResponseEntity.ok(telephoneUpdateDtoOut);
    }

    /**
     * <b>The endpoint for deleting an existing telephone</b>
     * @param id_telephone the id of the existing telephone to be deleted.
     * @return RecordDeleteDtoOut DTOout containing the id of the deleted Telephone.
     * @throws RecordNotFoundException this exception is thrown if the telephone number for delete does not exist.
     */
    @RequestMapping(value = "/telephone/delete/{id_telephone}", method = DELETE)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordDeleteDtoOut> deleteTelephone(@PathVariable String id_telephone) {
        RecordDeleteDtoOut telephoneDeleteDtoOut = service.deleteTelephone(Long.parseLong(id_telephone));

        return ResponseEntity.ok(telephoneDeleteDtoOut);
    }



    /**
     * <b>The endpoint for adding an email for an existing person.</b>
     * @param emailDto The DTOin containing all information for creating a new email address for an existing Person.
     * @param id_person The id of existing person.
     * @return RecordCreateDtoOut The DTOout containing the id of the newly created email.
     * @throws RecordNotFoundException this exception is thrown if the person with the input id is not found.
     */
    @RequestMapping(value = "/email/add/{id_person}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordCreateDtoOut> addEmail(@RequestBody EmailDto emailDto,
                                                       @PathVariable String id_person) {
        RecordCreateDtoOut emailCreateDtoOut = service.addEmail(emailDto, Long.parseLong(id_person));

        return ResponseEntity.ok(emailCreateDtoOut);
    }

    /**
     * <b>The endpoint for updating an email for an existing person.</b>
     * @param emailDto The DTOin containing all the information on the email to be updated.
     * @param id_email The id of the email to be updated.
     * @return RecordUpdateDtoOut the DTOout containing the id of the updated email.
     * @throws RecordNotFoundException this exception is thrown if the email record for update is not found.
     */
    @RequestMapping(value = "/email/update/{id_email}", method = PUT)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordUpdateDtoOut> updateEmail(@RequestBody EmailDto emailDto,
                                                          @PathVariable String id_email) {
        RecordUpdateDtoOut emailUpdateDtoOut = service.updateEmail(emailDto, Long.parseLong(id_email));

        return ResponseEntity.ok(emailUpdateDtoOut);
    }

    /**
     * <b>The endpoint for deleting the email information corresponding to a person.</b>
     * @param id_email the id of the email to be deleted.
     * @return RecordDeleteDtoOut The DTOout containing the id of the deleted Email.
     * @throws RecordNotFoundException this exception is thrown if the Email record for delete is not found.
     */
    @RequestMapping(value = "/email/delete/{id_email}", method = DELETE)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordDeleteDtoOut> deleteEmail(@PathVariable String id_email) {
        RecordDeleteDtoOut emailDeleteDtoOut = service.deleteEmail(Long.parseLong(id_email));

        return ResponseEntity.ok(emailDeleteDtoOut);
    }

    /**
     * <b>The endpoint for creating a Fax information corresponding to an existing person.</b>
     * @param faxDto The DTOin containing the complete information on the fax being added.
     * @param id_person The di of the person.
     * @return RecordCreateDtoOut The DTOout containing the id of teh newly added Fax.
     * @throws RecordNotFoundException this exception is thrown if the person with the input id is not found.
     */
    @RequestMapping(value = "/fax/add/{id_person}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordCreateDtoOut> addFax(@RequestBody FaxDto faxDto,
                                                     @PathVariable String id_person) {
        RecordCreateDtoOut faxCreateDtoOut = service.addFax(faxDto, Long.parseLong(id_person));

        return ResponseEntity.ok(faxCreateDtoOut);
    }

    /**
     * <b>The endpoint for updating the information on an existing Fax.</b>
     * @param faxDto The DTOin containing the complete information on the fax being updated.
     * @param id_fax The id of the fax being updated.
     * @return RecordUpdateDtoOut the DTOout containing the id of the updated fax.
     * @throws RecordNotFoundException this exception is thrown if the fax record for update is not found.
     */
    @RequestMapping(value = "/fax/update/{id_fax}", method = PUT)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordUpdateDtoOut> updateFax(@RequestBody FaxDto faxDto,
                                                        @PathVariable String id_fax) {
        RecordUpdateDtoOut faxUpdateDtoOut = service.updateFax(faxDto, Long.parseLong(id_fax));

        return ResponseEntity.ok(faxUpdateDtoOut);
    }

    /**
     * <b>The endpoint for deleting an existing Fax.</b>
     * @param id_fax the id of the Fax being deleted.
     * @return RecordDeleteDtoOut The DTOout containing the id of the deleted Fax.
     * @throws RecordNotFoundException this exception is thrown if the fax record for delete is not found.
     */
    @RequestMapping(value = "/fax/delete/{id_fax}", method = DELETE)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecordDeleteDtoOut> deleteFax(@PathVariable String id_fax) {
        RecordDeleteDtoOut faxDeleteDtoOut = service.deleteFax(Long.parseLong(id_fax));

        return ResponseEntity.ok(faxDeleteDtoOut);
    }
}
