package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.model.dto.address.AddressDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.EmailDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.FaxDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.TelephoneDto;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.address.AddressEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.FaxEntity;
import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import com.daklan.controlbudget.rest.model.enums.ContactUse;
import com.daklan.controlbudget.rest.model.enums.PersonStatus;
import com.daklan.controlbudget.rest.repository.*;
import com.daklan.controlbudget.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @see PersonService
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private EmailRepository emailRepository;
    private TelephoneRepository telephoneRepository;
    private AddressRepository addressRepository;
    private FaxRepository faxRepository;

    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository,
                             final EmailRepository emailRepository,
                             final TelephoneRepository telephoneRepository,
                             final AddressRepository addressRepository,
                             final FaxRepository faxRepository) {
        this.personRepository = personRepository;
        this.emailRepository = emailRepository;
        this.telephoneRepository = telephoneRepository;
        this.addressRepository = addressRepository;
        this.faxRepository = faxRepository;
    }


    /**
     * @param personCreateDtoIn DTOin containing the information on the person to be created. This is the initial information on the person.
     * @return personCreateDtoOut which is filled in via the search into teh database for the data already saved in it.
     * @see PersonService#create(PersonCreateDtoIn)
     */
    @Override
    public PersonCreateDtoOut create(final PersonCreateDtoIn personCreateDtoIn) {
        final PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personCreateDtoIn.getPersonInitialInformationDto().getFirstName());
        personEntity.setLastName(personCreateDtoIn.getPersonInitialInformationDto().getLastName());
        personEntity.setBirthDate(personCreateDtoIn.getPersonInitialInformationDto().getBirthDate());
        personEntity.setStatus(PersonStatus.BEGINNER.toString());
        personRepository.save(personEntity);
        PersonEntity personEntityFound = personRepository.findByFirstNameAndLastNameAndBirthDate(personCreateDtoIn.getPersonInitialInformationDto().getFirstName(),
                personCreateDtoIn.getPersonInitialInformationDto().getLastName(),
                personCreateDtoIn.getPersonInitialInformationDto().getBirthDate());

        final PersonCreateDtoOut personCreateDtoOut = new PersonCreateDtoOut();
        personCreateDtoOut.setId(personEntityFound.getId().toString());

        return personCreateDtoOut;
    }

    /**
     * @param personUpdateDtoIn DTOin containing the information on the person to be updated. This is the complete information on the person.
     * @return
     * @see PersonService#update(PersonUpdateDtoIn, Long)
     */
    @Override
    public PersonCreateDtoOut update(final PersonUpdateDtoIn personUpdateDtoIn, final Long id) throws RecordNotFoundException {
        Optional<PersonEntity> personOptional = personRepository.findById(id);
        if (!personOptional.isPresent()) {
            throw new RecordNotFoundException("The person with the id " + id + " does not exist");
        }
        //Adding the information on the person
        PersonEntity personEntity = personOptional.get();
        personEntity.setFirstName(personUpdateDtoIn.getPersonInitialInformationDto().getFirstName());
        personEntity.setLastName(personUpdateDtoIn.getPersonInitialInformationDto().getLastName());
        personEntity.setBirthDate(personUpdateDtoIn.getPersonInitialInformationDto().getBirthDate());
        personEntity.setStatus(PersonStatus.CUSTOMER.toString());
        personEntity.setMiddleName(personUpdateDtoIn.getMiddleName());
        personEntity.setMaritalName(personUpdateDtoIn.getMaritalName());


        //Adding information on the person's email
        Set<EmailEntity> emails = new HashSet<>();

        for (EmailDto emailDto : personUpdateDtoIn.getEmails()) {
            final EmailEntity emailEntity = new EmailEntity();
            emailEntity.setIdentifiedBy(emailDto.getEmail());
            emailEntity.setUse(emailDto.getUse().toString());
            emailEntity.setPerson(personEntity);
            emails.add(emailEntity);
            emailRepository.save(emailEntity);
        }
        personEntity.setEmails(emails);

        //Adding information on the person's telephone
        Set<TelephoneEntity> telephones = new HashSet<>();

        for (TelephoneDto telephoneDto : personUpdateDtoIn.getTelephones()) {
            final TelephoneEntity telephoneEntity = new TelephoneEntity();
            telephoneEntity.setIdentifiedBy(telephoneDto.getTelephone());
            telephoneEntity.setType(telephoneDto.getTelephoneType().toString());
            telephoneEntity.setUse(ContactUse.PERSONAL.toString());
            telephoneEntity.setPerson(personEntity);
            telephones.add(telephoneEntity);
            telephoneRepository.save(telephoneEntity);
        }
        personEntity.setTelephones(telephones);

        //Adding information on the person's address
        Set<AddressEntity> addresses = new HashSet<>();

        for (AddressDto addressDto : personUpdateDtoIn.getAddresses()) {
            final AddressEntity addressEntity = new AddressEntity();
            addressEntity.setStreetNumber(addressDto.getStreetNumber());
            addressEntity.setStreetType(addressDto.getStreetType());
            addressEntity.setStreetName(addressDto.getStreetName());
            addressEntity.setPostalCode(addressDto.getPostalCode());
            addressEntity.setCityName(addressDto.getCityName());
            addressEntity.setCountryName(addressDto.getCountryName());
            addressEntity.setUse(addressDto.getUse().toString());
            addressEntity.setAddressCompletion(addressDto.getAddressCompletion());
            addressEntity.setPerson(personEntity);
            addresses.add(addressEntity);
            addressRepository.save(addressEntity);
        }
        personEntity.setAddresses(addresses);

        //Adding information on the person's fax
        Set<FaxEntity> faxes = new HashSet<>();

        for (FaxDto faxDto : personUpdateDtoIn.getFaxes()) {
            final FaxEntity faxEntity = new FaxEntity();
            faxEntity.setIdentifiedBy(faxDto.getFax());
            faxEntity.setUse(faxDto.getUse().toString());
            faxEntity.setPerson(personEntity);
            faxes.add(faxEntity);
            faxRepository.save(faxEntity);
        }
        personEntity.setFaxes(faxes);

        personRepository.save(personEntity);


        PersonEntity personEntityFound = personRepository.findByFirstNameAndLastNameAndBirthDate(personUpdateDtoIn.getPersonInitialInformationDto().getFirstName(),
                personUpdateDtoIn.getPersonInitialInformationDto().getLastName(),
                personUpdateDtoIn.getPersonInitialInformationDto().getBirthDate());

        final PersonCreateDtoOut personCreateDtoOut = new PersonCreateDtoOut();
        personCreateDtoOut.setId(personEntityFound.getId().toString());

        return personCreateDtoOut;
    }

    @Override
    public PersonDeleteDtoOut delete(Long id) throws RecordNotFoundException {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (!personEntityOptional.isPresent()) {
            throw new RecordNotFoundException("The person with the id " + id + " does not exist");
        }

        personRepository.delete(personEntityOptional.get());
        PersonDeleteDtoOut personDeleteDtoOut = new PersonDeleteDtoOut();
        personDeleteDtoOut.setId(id);

        return personDeleteDtoOut;
    }
}
