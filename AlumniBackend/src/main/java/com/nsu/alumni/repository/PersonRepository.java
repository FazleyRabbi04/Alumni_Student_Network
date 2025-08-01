package com.nsu.alumni.repository;

import com.nsu.alumni.entity_class.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    boolean existsByEmail(String email);
}