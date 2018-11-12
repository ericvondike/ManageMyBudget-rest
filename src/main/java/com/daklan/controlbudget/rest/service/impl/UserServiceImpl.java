package com.daklan.controlbudget.rest.service.impl;

import com.daklan.controlbudget.rest.model.dto.output.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordDeleteDtoOut;
import com.daklan.controlbudget.rest.model.dto.output.RecordUpdateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.PasswordUpdateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.UserCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.user.UsernameUpdateDtoIn;
import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.UserEntity;
import com.daklan.controlbudget.rest.repository.PersonRepository;
import com.daklan.controlbudget.rest.repository.UserRepository;
import com.daklan.controlbudget.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private PersonServiceImpl personService;
    private UserRepository userRepository;
    private PersonRepository personRepository;
    private ExceptionManageMyBudgetService exceptionManageMyBudgetService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(final PersonServiceImpl personService,
                           final UserRepository userRepository,
                           final PersonRepository personRepository,
                           final ExceptionManageMyBudgetService exceptionManageMyBudgetService) {
        this.personService = personService;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.exceptionManageMyBudgetService = exceptionManageMyBudgetService;
    }

    /**
     * @see UserService#createUser(UserCreateDtoIn)
     */
    @Override
    public RecordCreateDtoOut createUser(UserCreateDtoIn userCreateDtoIn) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userCreateDtoIn.getUserName());
        userEntity.setPassword(userCreateDtoIn.getPassword());
        String encryptedPassword = passwordEncoder.encode(userCreateDtoIn.getPassword());
        userEntity.setPassword(encryptedPassword);
        userRepository.save(userEntity);

        Optional<UserEntity> optionalUserEntity = userRepository.findByUsernameAndPassword(userCreateDtoIn.getUserName(), encryptedPassword);
        if (!optionalUserEntity.isPresent()) {
            exceptionManageMyBudgetService.throwUserNotFoundException(userCreateDtoIn.getUserName());
        }

        final PersonCreateDtoIn personCreateDtoIn = userCreateDtoIn.getPerson();
        final RecordCreateDtoOut recordCreatePersonDtoOut = personService.create(personCreateDtoIn);
        String id = recordCreatePersonDtoOut.getId();
        Optional<PersonEntity> personEntityOptional = personRepository.findById(Long.parseLong(id));

        if (!personEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwPersonNotFoundExcpetion(Long.parseLong(id));
        }

        personEntityOptional.get().setUserEntity(optionalUserEntity.get());
        personRepository.save(personEntityOptional.get());
        String idUser = optionalUserEntity.get().getId().toString();
        final RecordCreateDtoOut recordCreateDtoOut = new RecordCreateDtoOut(idUser);

        return recordCreateDtoOut;
    }

    /**
     * @see UserService#updatePassword(PasswordUpdateDtoIn, Long)
     */
    @Override
    public RecordUpdateDtoOut updatePassword(PasswordUpdateDtoIn userDtoIn, Long id) {

        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (!userEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwUserNotFoundException(id.toString());
        }

        final UserEntity userEntity = userEntityOptional.get();
        if (!passwordEncoder.matches(userDtoIn.getOldPassword(), userEntity.getPassword())) {
            exceptionManageMyBudgetService.throwWrongPasswordException();
        }

        final String encryptedPasswordNew = passwordEncoder.encode(userDtoIn.getNewPassword());
        userEntity.setPassword(encryptedPasswordNew);
        userRepository.save(userEntity);
        final RecordUpdateDtoOut updatePasswordDtoOut = new RecordUpdateDtoOut(id.toString());
        return updatePasswordDtoOut;
    }


    /**
     * @see UserService#updateUserName(UsernameUpdateDtoIn, Long)
     */
    @Override
    public RecordUpdateDtoOut updateUserName(UsernameUpdateDtoIn usernameUpdateDtoIn, Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (!userEntityOptional.isPresent()) {
            exceptionManageMyBudgetService.throwUserNotFoundException(id.toString());
        }

        final UserEntity userEntity = userEntityOptional.get();
        if(!passwordEncoder.matches(usernameUpdateDtoIn.getPassword(), userEntity.getPassword())) {
            exceptionManageMyBudgetService.throwWrongPasswordException();
        }

        userEntity.setUsername(usernameUpdateDtoIn.getNewUsername());
        userRepository.save(userEntity);

        final RecordUpdateDtoOut updateUsernameDtoOut = new RecordUpdateDtoOut(id.toString());
        return updateUsernameDtoOut;
    }

    /**
     * @see UserService#deleteUser(String)
     */
    @Override
    public RecordDeleteDtoOut deleteUser(String id) {
        return null;
    }
}
