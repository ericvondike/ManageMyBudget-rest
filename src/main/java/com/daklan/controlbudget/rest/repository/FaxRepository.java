package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.contactinformation.FaxEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * <b>The repository class for CRUD operations on Fax.</b>
 */
public interface FaxRepository extends CrudRepository<FaxEntity, Long> {
}
