package com.nsu.alumni.entity_class;

import com.nsu.alumni.entity_class.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "email_address")
public class EmailAddress {
    @Id
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @Column(length = 100)
    private String email;

    // Getters and Setters
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}