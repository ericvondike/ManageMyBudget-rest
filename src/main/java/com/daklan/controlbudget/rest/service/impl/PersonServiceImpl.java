package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.model.dto.address.AddressDto;
import com.daklan.controlbudget.rest.model.dto.contactinformation.*;
import com.daklan.controlbudget.rest.model.dto.person.PersonConsultDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonInitialInformationDto;
import com.daklan.controlbudget.rest.model.dto.person.PersonUpdateDtoIn;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.address.AddressEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.FaxEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import com.daklan.controlbudget.rest.model.enums.ContactUse;
import com.daklan.controlbudget.rest.model.enums.PersonStatus;
import com.daklan.controlbudget.rest.repository.*;
import com.daklan.controlbudget.rest.service.AbstractManageService;
import com.daklan.controlbudget.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @see PersonService
 */
@Service
public class PersonServiceImpl extends AbstractManageService implements PersonService {

    private PersonRepository personRepository;
    private EmailRepository emailRepository;
    private TelephoneRepository telephoneRepository;
    private AddressRepository addressRepository;
    private FaxRepository faxRepository;
    private ExceptionManageMyBudgetService exceptionManageMyBudgetService;


    @Autowired
    public PersonServiceImpl(final PersonRepository personRepository,
                             final EmailRepository emailRepository,
                             final TelephoneRepository telephoneRepository,
                             final AddressRepository addressRepository,
                             final FaxRepository faxRepository,
                             final ExceptionManageMyBudgetService exceptionManageMyBudgetService) {
        this.personRepository = personRepository;
        this.emailRepository = emailRepository;
        this.telephoneRepository = telephoneRepository;
        this.addressRepository = addressRepository;
        this.exceptionManageMyBudgetService = exceptionManageMyBudgetService;
        this.faxRepository = faxRepository;
    }


    /**
     * @see PersonService#create(PersonCreateDtoIn)
     */
    @Override
    public RecordCreateDtoOut create(final PersonCreateDtoIn personCreateDtoIn) {
        final PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personCreateDtoIn.getPersonInitialInformationDto().getFirstName());
        personEntity.setLastName(personCreateDtoIn.getPersonInitialInformationDto().getLastName());
        personEntity.setBirthDate(personCreateDtoIn.getPersonInitialInformationDto().getBirthDate());
        personEntity.setStatus(PersonStatus.BEGINNER.toString());
        personRepository.save(personEntity);

        PersonEntity personEntityFound = personRepository.findByFirstNameAndLastNameAndBirthDate(personCreateDtoIn.getPersonInitialInformationDto().getFirstName(),
                personCreateDtoIn.getPersonInitialInformationDto().getLastName(),
                personCreateDtoIn.getPersonInitialInformationDto().getBirthDate());

        final RecordCreateDtoOut personCreateDtoOut = buildRecordCreateDtoOut(personEntityFound.getId().toString());

        return personCreateDtoOut;
    }

    /**
     * @see PersonService#update(PersonUpdateDtoIn, Long)
     */
    @Override
    public RecordUpdateDtoOut update(final PersonUpdateDtoIn personUpdateDtoIn, Long id) {

        Optional<PersonEntity> personOptional = personRepository.findById(id);
        if (!personOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(id);
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

        final RecordUpdateDtoOut personUpdateDtoOut = buildRecordUpdateDtoOut(id.toString());


        return personUpdateDtoOut;
    }

    /**
     * @see PersonService#delete(Long)
     */
    @Override
    public RecordDeleteDtoOut delete(Long idPerson) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(idPerson);

        if (!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(idPerson);
        }

        personRepository.delete(personEntityOptional.get());

        RecordDeleteDtoOut personDeleteDtoOut = buildRecordDeletDtoOut(idPerson.toString());

        return personDeleteDtoOut;
    }

    /**
     * @see PersonService#retrieve(Long)
     */
    @Override
    public PersonConsultDtoOut retrieve(Long id) throws RecordNotFoundException {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(id);
        }

        final PersonEntity personEntityFound = personEntityOptional.get();

        final PersonConsultDtoOut personConsultDtoOut = new PersonConsultDtoOut();
        final PersonInitialInformationDto personInitialInformationDto = new PersonInitialInformationDto();
        personInitialInformationDto.setFirstName(personEntityFound.getFirstName());
        personInitialInformationDto.setLastName(personEntityFound.getLastName());
        personInitialInformationDto.setBirthDate(personEntityFound.getBirthDate());
        personConsultDtoOut.setPersonInitialInformationDto(personInitialInformationDto);

        List<EmailEntity> emailEntityList = emailRepository.findByPerson(personEntityFound);
        if (!emailEntityList.isEmpty()) {
            List<EmailDto> emailDtoList = new ArrayList<>();
            for (EmailEntity emailEntity : emailEntityList) {
                EmailDto emailDto = new EmailDto();
                emailDto.setEmail(emailEntity.getIdentifiedBy());
                emailDto.setUse(convertStringContactUseToEnumContactUse(emailEntity.getUse()));
                emailDtoList.add(emailDto);
            }
            personConsultDtoOut.setEmails(emailDtoList);
        }



        return null;
    }
}
