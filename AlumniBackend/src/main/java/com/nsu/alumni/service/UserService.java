package com.nsu.alumni.service;

import com.nsu.alumni.data_transfer.SignupRequest;
import com.nsu.alumni.entity_class.*;
import com.nsu.alumni.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmailAddressRepository emailAddressRepository;

    @Autowired
    private AlumniRepository alumniRepository;

    @Autowired
    private StudentRepository studentRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void registerUser(SignupRequest request) throws Exception {
        // Validate role
        if (!request.getRole().equals("alumni") && !request.getRole().equals("student")) {
            throw new Exception("Invalid role");
        }

        // Validate passwords match
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new Exception("Passwords do not match");
        }

        // Check if email exists
        if (emailAddressRepository.existsByEmail(request.getEmail())) {
            throw new Exception("Email already registered");
        }

        // Create Person entity
        Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setStreet(request.getStreet());
        person.setCity(request.getCity());
        person.setZip(request.getZip());
        person.setNid(request.getNID());
        person.setDepartment(request.getDepartment());
        person.setDateOfBirth(request.getDateOfBirth());
        person.setPassword(passwordEncoder.encode(request.getPassword()));

        // Set gender enum
        try {
            person.setGender(Person.Gender.valueOf(request.getGender()));
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid gender value");
        }

        // Save Person
        person = personRepository.save(person);

        // Save EmailAddress
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setPerson(person);
        emailAddress.setEmail(request.getEmail());
        emailAddressRepository.save(emailAddress);

        // Save Alumni or Student
        if (request.getRole().equals("alumni")) {
            if (request.getGraduationYear() == null || request.getGraduationYear().isEmpty()) {
                throw new Exception("Graduation year is required for Alumni");
            }
            Alumni alumni = new Alumni();
            alumni.setPerson(person);
            alumni.setGradYear(Integer.parseInt(request.getGraduationYear()));
            alumniRepository.save(alumni);
        } else {
            if (request.getBatchYear() == null || request.getBatchYear().isEmpty()) {
                throw new Exception("Batch year is required for Student");
            }
            Student student = new Student();
            student.setPerson(person);
            student.setBatchYear(parseBatchYear(request.getBatchYear()));
            studentRepository.save(student);
        }
    }

    private Integer parseBatchYear(String batch) {
        // Extract year from "2021-2025" format
        if (batch.contains("-")) {
            String[] parts = batch.split("-");
            return Integer.parseInt(parts[0]); // Return start year
        }
        return Integer.parseInt(batch);
    }
}