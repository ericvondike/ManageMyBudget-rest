package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.address.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {
}
