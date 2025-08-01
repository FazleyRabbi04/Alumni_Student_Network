package com.nsu.alumni.service;

import com.nsu.alumni.data_transfer.SignupRequest;
import com.nsu.alumni.repository.PersonRepository;
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
        if (!request.getRole().equals("Alumni") && !request.getRole().equals("Student")) {
            throw new Exception("Invalid role");
        }

        // Validate passwords match
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new Exception("Passwords do not match");
        }

        // Check if email exists
        if (personRepository.existsByEmail(request.getEmail())) {
            throw new Exception("Email already registered");
        }

        // Create Person entity
        Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setDepartment(request.getDepartment());
        person.setPassword(passwordEncoder.encode(request.getPassword()));

        // Save Person
        person = personRepository.save(person);

        // Save EmailAddress
        EmailAddress emailAddress = new EmailAddress();
        emailAddress.setPerson(person);
        emailAddress.setEmail(request.getEmail());
        emailAddressRepository.save(emailAddress);

        // Save Alumni or Student
        if (request.getRole().equals("Alumni")) {
            if (request.getGradYear() == null) {
                throw new Exception("Graduation year is required for Alumni");
            }
            Alumni alumni = new Alumni();
            alumni.setPerson(person);
            alumni.setGradYear(request.getGradYear());
            alumniRepository.save(alumni);
        } else {
            if (request.getBatch() == null) {
                throw new Exception("Batch is required for Student");
            }
            Student student = new Student();
            student.setPerson(person);
            student.setBatchYear(parseBatchYear(request.getBatch())); // Parse "Spring 2025" to 2025
            studentRepository.save(student);
        }
    }

    private Integer parseBatchYear(String batch) {
        // Extract year from "Spring 2025" or "Fall 2025"
        String[] parts = batch.split(" ");
        return Integer.parseInt(parts[1]);
    }
}