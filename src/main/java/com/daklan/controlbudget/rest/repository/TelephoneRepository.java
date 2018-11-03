package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * <b>The repository class for CRUD operations on Telephone.</b>
 */
public interface TelephoneRepository extends CrudRepository<TelephoneEntity, Long> {
}
