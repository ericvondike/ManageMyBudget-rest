package com.daklan.controlbudget.rest.controllers;

import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.service.PersonService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api(tags = {"Person"}, description = "APIs for managing Person")
@RestController
@RequestMapping(value = "/manage/person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * <b>The endpoint for creating a new Person.</b>
     * @param personCreateDtoIn the initial data of the person to be created.
     * @return The DTOout containg the id of the created Person.
     */
    @RequestMapping(value = "/create", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonCreateDtoOut> createPerson(@RequestBody PersonCreateDtoIn personCreateDtoIn) {
        PersonCreateDtoOut personCreateDtoOut = service.create(personCreateDtoIn);

        return ResponseEntity.ok(personCreateDtoOut);
    }

    /**
     * <b>The endpoint for updating the information on an existing Person.</b>
     * @param personUpdateDtoIn the complementary information on the Person.
     * @param id The id of the Person to be updated.
     * @return DTOout containing the id of the updated person.
     */
    @RequestMapping(value = "/update/{id}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonCreateDtoOut> updatePerson(@RequestBody PersonUpdateDtoIn personUpdateDtoIn,
                                                           @PathVariable String id) throws RecordNotFoundException {
        PersonCreateDtoOut personCreateDtoOut = service.update(personUpdateDtoIn, Long.parseLong(id));

        return ResponseEntity.ok(personCreateDtoOut);
    }

    /**
     * <b>The endpoint for deleting an existing Person.</b>
     * @param id The id of the existing Person.
     * @return DTOout containing the id of the deleted Person.
     */
    @RequestMapping(value = "/delete/{id}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDeleteDtoOut> deletePerson(@PathVariable String id) throws RecordNotFoundException {
        PersonDeleteDtoOut personDeleteDtoOut = service.delete(Long.parseLong(id));

        return ResponseEntity.ok(personDeleteDtoOut);
    }
}
