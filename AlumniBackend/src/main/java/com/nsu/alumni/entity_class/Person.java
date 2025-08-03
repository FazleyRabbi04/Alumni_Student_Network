package com.nsu.alumni.entity_class;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "person")
public class Person {
    // Getters and Setters
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

    @Setter
    @Column(length = 50)
    private String firstName;

    @Setter
    @Column(length = 50)
    private String lastName;

    @Setter
    @Column(length = 100)
    private String street;

    @Setter
    @Column(length = 50)
    private String city;

    @Setter
    @Column(length = 10)
    private String zip;

    @Setter
    @Column(length = 10, unique = true)
    private String nid;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Setter
    @Column(length = 50)
    private String department;

    @Setter
    private LocalDate dateOfBirth;

    @Setter
    @Column(length = 255, nullable = false)
    private String password;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmailAddress> email = new HashSet<>();

    public void setEmails(Set<EmailAddress> emails) { this.email= email; }

    public enum Gender {
        Male, Female, Other
    }
}