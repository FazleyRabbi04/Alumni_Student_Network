package com.nsu.alumni.repository;

import com.nsu.alumni.entity_class.EmailAddress;
import com.nsu.alumni.entity_class.EmailAddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailAddressRepository extends JpaRepository<EmailAddress, EmailAddressId> {

    // Custom query methods you might need
    List<EmailAddress> findByPerson_PersonId(Integer personId);

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END FROM EmailAddress e WHERE e.email = :email")
    boolean existsByEmail(@Param("email") String email);

    EmailAddress findByEmail(String email);
}