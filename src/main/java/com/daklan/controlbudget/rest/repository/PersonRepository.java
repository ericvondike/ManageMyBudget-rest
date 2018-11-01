package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;


/**
 * <b>The repository class for CRUD operations on PERSON.</b>
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
    public PersonEntity findByFirstNameAndLastNameAndBirthDate(String firstName, String lastName, LocalDate birthDate);
}
