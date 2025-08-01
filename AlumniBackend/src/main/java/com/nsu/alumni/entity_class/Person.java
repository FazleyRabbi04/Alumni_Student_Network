package com.nsu.alumni.entity_class;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personId;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 100)
    private String street;

    @Column(length = 50)
    private String city;

    @Column(length = 10)
    private String zip;

    @Column(length = 10, unique = true)
    private String nid;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(length = 50)
    private String department;

    private LocalDate dateOfBirth;

    @Column(length = 255, nullable = false)
    private String password;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmailAddress> emails = new HashSet<>();

    // Getters and Setters
    public Integer getPersonId() { return personId; }
    public void setPersonId(Integer personId) { this.personId = personId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }
    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Set<EmailAddress> getEmails() { return emails; }
    public void setEmails(Set<EmailAddress> emails) { this.emails = emails; }

    public enum Gender {
        Male, Female, Other
    }
}