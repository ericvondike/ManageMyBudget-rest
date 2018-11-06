package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.PersonEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.FaxEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * <b>The repository class for CRUD operations on Fax.</b>
 */
public interface FaxRepository extends CrudRepository<FaxEntity, Long> {
    FaxEntity findByIdentifiedBy(String faxNumber);

    List<FaxEntity> findByPerson(PersonEntity personEntity);
}
