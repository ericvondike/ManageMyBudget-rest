package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.model.dto.contactinformation.*;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.FaxEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import com.daklan.controlbudget.rest.model.enums.ContactUse;
import com.daklan.controlbudget.rest.model.enums.TelephoneType;
import com.daklan.controlbudget.rest.repository.EmailRepository;
import com.daklan.controlbudget.rest.repository.FaxRepository;
import com.daklan.controlbudget.rest.repository.PersonRepository;
import com.daklan.controlbudget.rest.repository.TelephoneRepository;
import com.daklan.controlbudget.rest.service.AbstractManageService;
import com.daklan.controlbudget.rest.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <b>The service for adding, updating and deleting the different contact information of the person.</b>
 */
@Service
public class ContactInformationServiceImpl extends AbstractManageService implements ContactInformationService {

    private TelephoneRepository telephoneRepository;
    private EmailRepository emailRepository;
    private FaxRepository faxRepository;
    private PersonRepository personRepository;
    private ExceptionManageMyBudgetService exceptionManageMyBudgetService;


    @Autowired
    public ContactInformationServiceImpl(final TelephoneRepository telephoneRepository,
                                         final EmailRepository emailRepository,
                                         final FaxRepository faxRepository,
                                         final PersonRepository personRepository,
                                         final ExceptionManageMyBudgetService exceptionManageMyBudgetService) {
        this.telephoneRepository = telephoneRepository;
        this.emailRepository = emailRepository;
        this.faxRepository = faxRepository;
        this.personRepository = personRepository;
        this.exceptionManageMyBudgetService = exceptionManageMyBudgetService;
    }


    /**
     * @see ContactInformationService#addTelephone(TelephoneDto, Long)
     */
    @Override
    public RecordCreateDtoOut addTelephone(final TelephoneDto telephoneDto, Long idPerson) {
        Optional<PersonEntity> personOption = personRepository.findById(idPerson);
        if (!personOption.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(idPerson);
        }

        final PersonEntity personFound = personOption.get();
        final TelephoneEntity telephoneEntity = new TelephoneEntity();
        telephoneEntity.setIdentifiedBy(telephoneDto.getTelephone());
        telephoneEntity.setUse(telephoneDto.getUse().toString());
        telephoneEntity.setType(telephoneDto.getTelephoneType().toString());
        telephoneEntity.setPerson(personFound);

        telephoneRepository.save(telephoneEntity);

        final TelephoneEntity telephoneEntitySavedFound = telephoneRepository.findTelephoneEntityByIdentifiedByAndPerson(telephoneEntity.getIdentifiedBy(), personOption.get());

        final RecordCreateDtoOut telephoneAddDtoOut = buildRecordCreateDtoOut(telephoneEntitySavedFound.getId().toString());

        return telephoneAddDtoOut;
    }

    /**
     * @see ContactInformationService#updateTelephone(TelephoneDto, Long)
     */
    @Override
    public RecordUpdateDtoOut updateTelephone(final TelephoneDto telephoneDto, Long idTelephone) {

        Optional<TelephoneEntity> telephoneEntityOptional = telephoneRepository.findById(idTelephone);
        if (!telephoneEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwContactInformationNotFoundException(idTelephone);
        }

        final TelephoneEntity telephoneEntity = telephoneEntityOptional.get();
        telephoneEntity.setIdentifiedBy(telephoneDto.getTelephone());
        telephoneEntity.setType(telephoneDto.getTelephoneType().toString());
        telephoneEntity.setUse(telephoneDto.getUse().toString());

        telephoneRepository.save(telephoneEntity);

        final RecordUpdateDtoOut telephoneUpdateDtoOut = buildRecordUpdateDtoOut(idTelephone.toString());

        return telephoneUpdateDtoOut;
    }

    /**
     * @see ContactInformationService#deleteTelephone(Long)
     */
    @Override
    public RecordDeleteDtoOut deleteTelephone(Long idTelephone) {

        Optional<TelephoneEntity> telephoneEntityOptional = telephoneRepository.findById(idTelephone);
        if (!telephoneEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwContactInformationNotFoundException(idTelephone);
        }
        telephoneRepository.deleteById(idTelephone);

        final RecordDeleteDtoOut recordDeleteDtoOut = buildRecordDeletDtoOut(idTelephone.toString());

        return recordDeleteDtoOut;
    }

    /**
     * @see ContactInformationService#findTelephone(Long)
     */
    @Override
    public List<TelephoneDto> findTelephone(Long idPerson) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(idPerson);
        if(!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(idPerson);
        }
        final List<TelephoneEntity> telephoneEntityList = telephoneRepository.findTelephoneEntityByPerson(personEntityOptional.get());
        final List<TelephoneDto> telephoneDtoList = new ArrayList<>();

        for (TelephoneEntity telephoneEntity : telephoneEntityList) {
            final TelephoneDto telephoneDto = new TelephoneDto();
            telephoneDto.setTelephone(telephoneEntity.getIdentifiedBy());
            telephoneDto.setTelephoneType(TelephoneType.valueOf(telephoneEntity.getType()));
            telephoneDto.setUse(ContactUse.valueOf(telephoneEntity.getUse()));

            telephoneDtoList.add(telephoneDto);
        }

        return telephoneDtoList;

    }

    /**
     * @see ContactInformationService#addEmail(EmailDto, Long)
     */
    @Override
    public RecordCreateDtoOut addEmail(final EmailDto emailDto, Long idPerson) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(idPerson);
        if(!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(idPerson);
        }

        final EmailEntity emailEntity = new EmailEntity();
        emailEntity.setIdentifiedBy(emailDto.getEmail());
        emailEntity.setUse(emailDto.getUse().toString());
        emailEntity.setPerson(personEntityOptional.get());
        emailRepository.save(emailEntity);

        final EmailEntity emailEntitySavedFound = emailRepository.findByIdentifiedByAndPerson(emailDto.getEmail(), personEntityOptional.get());
        final RecordCreateDtoOut emailCreateDtoOut = buildRecordCreateDtoOut(emailEntitySavedFound.getId().toString());

        return emailCreateDtoOut;
    }

    /**
     * @see ContactInformationService#updateEmail(EmailDto, Long)
     */
    @Override
    public RecordUpdateDtoOut updateEmail(final EmailDto emailDto, Long id) {
        Optional<EmailEntity> emailEntityOptional = emailRepository.findById(id);
        if (!emailEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwContactInformationNotFoundException(id);
        }

        final EmailEntity emailEntityUpdated = emailEntityOptional.get();
        emailEntityUpdated.setIdentifiedBy(emailDto.getEmail());
        emailEntityUpdated.setUse(emailDto.getUse().toString());

        emailRepository.save(emailEntityUpdated);

        final RecordUpdateDtoOut emailUpdateDtoOut = buildRecordUpdateDtoOut(id.toString());
        return  emailUpdateDtoOut;
    }

    /**
     * @see ContactInformationService#deleteEmail(Long)
     */
    @Override
    public RecordDeleteDtoOut deleteEmail(Long id) {
        Optional<EmailEntity> emailEntityOptional = emailRepository.findById(id);
        if (!emailEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwContactInformationNotFoundException(id);
        }

        emailRepository.deleteById(id);

        final RecordDeleteDtoOut emailDeleteDtoOut = buildRecordDeletDtoOut(id.toString());
        return emailDeleteDtoOut;
    }

    /**
     * @see ContactInformationService#findEmail(Long)
     */
    @Override
    public List<EmailDto> findEmail(Long idPerson) {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(idPerson);
        if (!optionalPersonEntity.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(idPerson);
        }

        final List<EmailEntity> emailEntityList = emailRepository.findByPerson(optionalPersonEntity.get());
        final List<EmailDto> emailDtoList = new ArrayList<>();
        for (EmailEntity emailEntity : emailEntityList) {
            final EmailDto emailDto = new EmailDto();
            emailDto.setEmail(emailEntity.getIdentifiedBy());
            emailDto.setUse(ContactUse.valueOf(emailEntity.getUse()));
            emailDtoList.add(emailDto);
        }

        return emailDtoList;
    }

    /**
     * @see ContactInformationService#addFax(FaxDto, Long)
     */
    @Override
    public RecordCreateDtoOut addFax(final FaxDto faxDto, Long id) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(id);
        }

        final FaxEntity faxEntity = new FaxEntity();
        faxEntity.setIdentifiedBy(faxDto.getFax());
        faxEntity.setUse(faxDto.getUse().getUsage());
        faxEntity.setPerson(personEntityOptional.get());
        faxRepository.save(faxEntity);

        final FaxEntity faxEntitySavedFound = faxRepository.findByIdentifiedBy(faxDto.getFax());
        final RecordCreateDtoOut faxCreateDtoOut = buildRecordCreateDtoOut(faxEntitySavedFound.getId().toString());

        return faxCreateDtoOut;
    }

    /**
     * @see ContactInformationService#updateFax(FaxDto, Long)
     */
    @Override
    public RecordUpdateDtoOut updateFax(final FaxDto faxDto, Long id) {
        Optional<FaxEntity> faxEntityOptional = faxRepository.findById(id);
        if (!faxEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwContactInformationNotFoundException(id);
        }

        final FaxEntity faxEntity = faxEntityOptional.get();
        faxEntity.setIdentifiedBy(faxDto.getFax());
        faxEntity.setUse(faxDto.getUse().getUsage());

        final RecordUpdateDtoOut faxUpdateDtoOut = buildRecordUpdateDtoOut(id.toString());

        return faxUpdateDtoOut;
    }

    /**
     * @see ContactInformationService#deleteFax(Long)
     */
    @Override
    public RecordDeleteDtoOut deleteFax(Long id) {
        Optional<FaxEntity> faxEntityOptional = faxRepository.findById(id);
        if (!faxEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwContactInformationNotFoundException(id);
        }

        faxRepository.deleteById(id);

        final RecordDeleteDtoOut faxDeleteDtoOut = buildRecordDeletDtoOut(id.toString());
        return faxDeleteDtoOut;
    }

    @Override
    public List<FaxDto> findFaxes(Long idPerson) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(idPerson);
        if (!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(idPerson);
        }

        final List<FaxEntity> faxEntityList = faxRepository.findByPerson(personEntityOptional.get());
        final List<FaxDto> faxDtoList = new ArrayList<>();
        for (FaxEntity faxEntity : faxEntityList) {
            final FaxDto faxDto = new FaxDto();
            faxDto.setFax(faxEntity.getIdentifiedBy());
            faxDto.setUse(ContactUse.valueOf(faxEntity.getUse()));
            faxDtoList.add(faxDto);
        }

        return faxDtoList;
    }
}
