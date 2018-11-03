package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>The repository class for CRUD operations on Email.</b>
 */
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
    EmailEntity findByIdentifiedBy(String identifiedBy);
}
