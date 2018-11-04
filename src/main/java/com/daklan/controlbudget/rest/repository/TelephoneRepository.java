package com.daklan.controlbudget.rest.repository;

import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <b>The repository class for CRUD operations on Telephone.</b>
 */
public interface TelephoneRepository extends CrudRepository<TelephoneEntity, Long> {
    @Query("SELECT id FROM TelephoneEntity t WHERE t.person.id = :id_person AND t.identifiedBy = :telephone_number")
    List<Long> findTelephoneNumberForPerson(@Param("id_person") Long idPerson,
                                            @Param("telephone_number") String telephoneNumber);
}
