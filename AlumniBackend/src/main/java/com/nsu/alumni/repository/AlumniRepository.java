package com.nsu.alumni.repository;

import com.nsu.alumni.entity_class.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniRepository extends JpaRepository<Alumni, Integer> {
}