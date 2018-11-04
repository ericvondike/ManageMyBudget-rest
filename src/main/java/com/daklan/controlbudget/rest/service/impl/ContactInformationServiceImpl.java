package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.configuration.RecordNotFoundException;
import com.daklan.controlbudget.rest.configuration.TooManyRecordsFoundException;
import com.daklan.controlbudget.rest.model.dto.contactinformation.*;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import com.daklan.controlbudget.rest.repository.EmailRepository;
import com.daklan.controlbudget.rest.repository.FaxRepository;
import com.daklan.controlbudget.rest.repository.PersonRepository;
import com.daklan.controlbudget.rest.repository.TelephoneRepository;
import com.daklan.controlbudget.rest.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

/**
 * <b>The service for adding, updating and deleting the different contact information of the person.</b>
 */
@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    private TelephoneRepository telephoneRepository;
    private EmailRepository emailRepository;
    private FaxRepository faxRepository;
    private PersonRepository personRepository;
    private String messageDeleteTelephone;
    private String errorMessagePersonNotFound;
    private String errorMessageTelephoneNotFound;
    private String errorMessageManyTelephonesFound;

    @Autowired
    public ContactInformationServiceImpl(final TelephoneRepository telephoneRepository,
                                         final EmailRepository emailRepository,
                                         final FaxRepository faxRepository,
                                         final PersonRepository personRepository,
                                         @Value("${message.delete.telephone}") String messageDeleteTelephone,
                                         @Value("${message.person.not.found}") String errorMessagePersonNotFound,
                                         @Value("${message.telephone.not.found}") String errorMessageTelephoneNotFound,
                                         @Value("${message.telephone.many}") String errorMessageManyTelephonesFound) {
        this.telephoneRepository = telephoneRepository;
        this.emailRepository = emailRepository;
        this.faxRepository = faxRepository;
        this.personRepository = personRepository;
        this.messageDeleteTelephone = messageDeleteTelephone;
        this.errorMessagePersonNotFound = errorMessagePersonNotFound;
        this.errorMessageTelephoneNotFound = errorMessageTelephoneNotFound;
        this.errorMessageManyTelephonesFound = errorMessageManyTelephonesFound;
    }


    /**
     * @see ContactInformationService#addTelephone(TelephoneDto, Long)
     */
    @Override
    public TelephoneDto addTelephone(TelephoneDto telephoneDto, Long idPerson) throws RecordNotFoundException {
        final Optional<PersonEntity> personOption = personRepository.findById(idPerson);
        if (!personOption.isPresent()) {
            final String errorMessage = MessageFormat.format(errorMessagePersonNotFound, idPerson);
            throw new RecordNotFoundException(errorMessage);
        }

        PersonEntity personFound = personOption.get();
        final TelephoneEntity telephoneEntity = new TelephoneEntity();
        telephoneEntity.setIdentifiedBy(telephoneDto.getTelephone());
        telephoneEntity.setUse(telephoneDto.getUse().toString());
        telephoneEntity.setType(telephoneDto.getTelephoneType().toString());
        telephoneEntity.setPerson(personFound);

        telephoneRepository.save(telephoneEntity);

        return telephoneDto;
    }

    /**
     * @see ContactInformationService#updateTelephone(TelephoneDto, Long)
     */
    @Override
    public TelephoneDto updateTelephone(TelephoneDto telephoneDto, Long id) {

        return null;
    }

    /**
     * @see ContactInformationService#deleteTelephone(String, Long)
     */
    @Override
    public TelephoneDeleteDtoOut deleteTelephone(String telephoneNumber, Long idPerson) throws RecordNotFoundException, TooManyRecordsFoundException {
        final Optional<PersonEntity> personOption = personRepository.findById(idPerson);
        if (!personOption.isPresent()) {
            final String errorMessage = MessageFormat.format(errorMessagePersonNotFound, idPerson);
            throw new RecordNotFoundException(errorMessage);
        }

        final List<Long> telephoneIdList = telephoneRepository.findTelephoneNumberForPerson(idPerson, telephoneNumber);


        if (telephoneIdList.isEmpty()) {
            final String errorMesage = MessageFormat.format(errorMessageTelephoneNotFound, telephoneNumber, idPerson);
            throw new RecordNotFoundException(errorMesage);
        }

        if (telephoneIdList.size() > 1) {
            final String errorMesage = MessageFormat.format(errorMessageManyTelephonesFound, telephoneNumber, telephoneIdList.size(), idPerson);
            throw new TooManyRecordsFoundException(errorMesage);
        }

        final Long idTelephone = telephoneIdList.get(0);
        telephoneRepository.deleteById(idTelephone);

        final String processedMessage = MessageFormat.format(messageDeleteTelephone, idPerson);
        final TelephoneDeleteDtoOut telephoneDeleteDtoOut = new TelephoneDeleteDtoOut();
        telephoneDeleteDtoOut.setMessage(processedMessage);

        return telephoneDeleteDtoOut;
    }

    @Override
    public EmailDto addEmail(EmailDto emailDto, Long id) {
        return null;
    }

    @Override
    public EmailDto updateEmail(EmailDto emailDto, Long id) {
        return null;
    }

    @Override
    public EmailDeleteDtoOut deleteEmail(String emailAddress, Long id) {
        return null;
    }

    @Override
    public FaxDto addFax(FaxDto faxDto, Long id) {
        return null;
    }

    @Override
    public FaxDto updateFax(FaxDto faxDto, Long id) {
        return null;
    }

    @Override
    public FaxDeleteDtoOut deleteFax(String faxNumber, Long id) {
        return null;
    }
}
