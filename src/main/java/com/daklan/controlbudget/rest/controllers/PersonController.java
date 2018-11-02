package com.daklan.controlbudget.rest.controllers;

import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
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

    @RequestMapping(value = "/create", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonCreateDtoOut> createPerson(@RequestBody PersonCreateDtoIn personCreateDtoIn) {
        PersonCreateDtoOut personCreateDtoOut = service.create(personCreateDtoIn);

        return ResponseEntity.ok(personCreateDtoOut);
    }

    @RequestMapping(value = "/update/{id}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonCreateDtoOut> updatePerson(@RequestBody PersonUpdateDtoIn personUpdateDtoIn,
                                                           @PathVariable String id) {
        PersonCreateDtoOut personCreateDtoOut = service.update(personUpdateDtoIn, Integer.parseInt(id));

        return ResponseEntity.ok(personCreateDtoOut);
    }
}
