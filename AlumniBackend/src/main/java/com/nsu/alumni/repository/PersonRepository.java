package com.nsu.alumni.repository;

import com.nsu.alumni.entity_class.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    // Check if email exists in the EmailAddress table
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN TRUE ELSE FALSE END FROM EmailAddress e WHERE e.email = :email")
    boolean existsByEmail(@Param("email") String email);
}