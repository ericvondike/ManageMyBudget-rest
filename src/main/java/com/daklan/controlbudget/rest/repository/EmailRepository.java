package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <b>The repository class for CRUD operations on Email.</b>
 */
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
    EmailEntity findByIdentifiedByAndPerson(String identifiedBy, PersonEntity personEntity);

    List<EmailEntity> findByPerson(PersonEntity personEntity);
}
