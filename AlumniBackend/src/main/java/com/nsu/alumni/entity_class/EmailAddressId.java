package com.nsu.alumni.entity_class;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
public class EmailAddressId implements Serializable {
    // Getters and Setters
    private Integer person; // Note: This should match the type of Person's ID
    private String email;

    // Default constructor
    public EmailAddressId() {}

    // Constructor with parameters
    public EmailAddressId(Integer person, String email) {
        this.person = person;
        this.email = email;
    }

    // equals and hashCode are required for composite keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddressId that = (EmailAddressId) o;
        return Objects.equals(person, that.person) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, email);
    }
}