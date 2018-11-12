package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.address.AddressEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * <b>The repository class for CRUD operations on Address.</b>
 */
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
