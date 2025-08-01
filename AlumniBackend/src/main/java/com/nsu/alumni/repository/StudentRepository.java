package com.nsu.alumni.repository;

import com.nsu.alumni.entity_class.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}