package com.nsu.alumni.entity_class;

import jakarta.persistence.*;

@Entity
@Table(name = "email_address")
@IdClass(EmailAddressId.class)
public class EmailAddress {
    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @Column(length = 100)
    private String email;

    // Default constructor
    public EmailAddress() {}

    // Constructor with parameters
    public EmailAddress(Person person, String email) {
        this.person = person;
        this.email = email;
    }

    // Getters and Setters
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}