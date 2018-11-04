package com.daklan.controlbudget.rest.controllers;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.configuration.TooManyRecordsFoundException;
import com.daklan.controlbudget.rest.model.dto.contactinformation.TelephoneDeleteDtoIn;
import com.daklan.controlbudget.rest.model.dto.contactinformation.TelephoneDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.contactinformation.TelephoneDto;
import com.daklan.controlbudget.rest.service.ContactInformationService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @RequestMapping(value = "/add/{id_person}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TelephoneDto> createTelephone(@RequestBody TelephoneDto telephoneDto,
                                                        @RequestParam String id_person) throws RecordNotFoundException {
        TelephoneDto telephoneAdded = service.addTelephone(telephoneDto, Long.parseLong(id_person));

        return ResponseEntity.ok(telephoneAdded);
    }

    @RequestMapping(value = "/delete/{id_person}", method = POST)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TelephoneDeleteDtoOut> deleteTelephone(@RequestBody TelephoneDeleteDtoIn telephoneDeleteDtoIn,
                                                                 @RequestParam String id_person) throws RecordNotFoundException, TooManyRecordsFoundException {
        TelephoneDeleteDtoOut telephoneDeleteDtoOut = service.deleteTelephone(telephoneDeleteDtoIn.getTelephoneNumber(), Long.parseLong(id_person));

        return ResponseEntity.ok(telephoneDeleteDtoOut);
    }
}
