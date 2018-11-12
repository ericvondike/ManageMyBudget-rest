package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * <b>The repository class for CRUD operations on User.</b>
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
