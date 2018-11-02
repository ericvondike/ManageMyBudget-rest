package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.model.dto.contactinformation.EmailDto;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import com.daklan.controlbudget.rest.model.enums.ContactUse;
import com.daklan.controlbudget.rest.model.enums.PersonStatus;
import com.daklan.controlbudget.rest.repository.EmailRepository;
import com.daklan.controlbudget.rest.repository.PersonRepository;
import com.daklan.controlbudget.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @see PersonService
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private EmailRepository emailRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, EmailRepository emailRepository) {
        this.personRepository = personRepository;
        this.emailRepository = emailRepository;
    }

    /**
     * @see PersonService#create(PersonCreateDtoIn)
     * @param personCreateDtoIn DTOin containing the information on the person to be created. This is the initial information on the person.
     * @return personCreateDtoOut which is filled in via the search into teh database for the data already saved in it.
     */
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
        personCreateDtoOut.setId(personEntityFound.getId().toString());

        return personCreateDtoOut;
    }

    /**
     * @see PersonService#update(PersonUpdateDtoIn, Integer)
     * @param personUpdateDtoIn DTOin containing the information on the person to be updated. This is the complete information on the person.
     * @return
     */
    @Override
    public PersonCreateDtoOut update(PersonUpdateDtoIn personUpdateDtoIn, Integer id) {
        Optional<PersonEntity> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            PersonEntity personEntity = personOptional.get();
            personEntity.setFirstName(personUpdateDtoIn.getPersonInitialInformationDto().getFirstName());
            personEntity.setLastName(personUpdateDtoIn.getPersonInitialInformationDto().getLastName());
            personEntity.setBirthDate(personUpdateDtoIn.getPersonInitialInformationDto().getBirthDate());
            personEntity.setStatus(PersonStatus.CUSTOMER.toString());
            personEntity.setMiddleName(personUpdateDtoIn.getMiddleName());
            personEntity.setMaritalName(personUpdateDtoIn.getMaritalName());
            personRepository.save(personEntity);

            Set<EmailEntity> emails = new HashSet<>();

            personUpdateDtoIn.getEmails().stream()
                    .filter(entry -> ContactUse.PERSONAL.equals(entry.getUse()))
                    .collect(Collectors.toList());

            for (EmailDto emailDto : personUpdateDtoIn.getEmails()) {
                EmailEntity emailEntity = new EmailEntity();
                emailEntity.setIdentifiedBy(emailDto.getEmail());
                emailEntity.setUse(emailDto.getUse().toString());
                emailEntity.setPerson(personEntity);
                emails.add(emailEntity);
                emailRepository.save(emailEntity);
            }

            personEntity.setEmails(emails);

        }


        PersonEntity personEntityFound = personRepository.findByFirstNameAndLastNameAndBirthDate(personUpdateDtoIn.getPersonInitialInformationDto().getFirstName(),
                personUpdateDtoIn.getPersonInitialInformationDto().getLastName(),
                personUpdateDtoIn.getPersonInitialInformationDto().getBirthDate());

        PersonCreateDtoOut personCreateDtoOut = new PersonCreateDtoOut();
        personCreateDtoOut.setId(personEntityFound.getId().toString());

        return personCreateDtoOut;
    }
}
