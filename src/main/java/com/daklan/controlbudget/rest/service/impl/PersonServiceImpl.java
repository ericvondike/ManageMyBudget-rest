package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.enums.PersonStatus;
import com.daklan.controlbudget.rest.repository.PersonRepository;
import com.daklan.controlbudget.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @see PersonService
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonCreateDtoOut create(PersonCreateDtoIn personCreateDtoIn) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personCreateDtoIn.getPersonInitialInformationDto().getFirstName());
        personEntity.setLastName(personCreateDtoIn.getPersonInitialInformationDto().getLastName());
        personEntity.setBirthDate(personCreateDtoIn.getPersonInitialInformationDto().getBirthDate());
        personEntity.setStatus(PersonStatus.BEGINNER.toString());
        personRepository.save(personEntity);
        PersonEntity personEntityFound = personRepository.findByFirstNameAndLastNameAndBirthDate(personCreateDtoIn.getPersonInitialInformationDto().getFirstName(),
                personCreateDtoIn.getPersonInitialInformationDto().getLastName(),
                personCreateDtoIn.getPersonInitialInformationDto().getBirthDate());

        PersonCreateDtoOut personCreateDtoOut = new PersonCreateDtoOut();
        personCreateDtoOut.setFirtsName(personEntityFound.getFirstName());
        personCreateDtoOut.setLastName(personEntityFound.getLastName());
        personCreateDtoOut.setBirthDate(personEntityFound.getBirthDate());

        return personCreateDtoOut;
    }

    @Override
    public PersonCreateDtoOut update(PersonUpdateDtoIn personUpdateDtoIn) {
        return null;
    }
}
