package com.nsu.alumni.repository;

import com.nsu.alumni.entity_class.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAddressRepository extends JpaRepository<EmailAddress, String> {
}