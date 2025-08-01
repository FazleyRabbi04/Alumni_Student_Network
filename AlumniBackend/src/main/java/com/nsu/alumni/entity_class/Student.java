package com.nsu.alumni.entity_class;

import com.nsu.alumni.entity_class.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "batch_year")
    private Integer batchYear;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id")
    private Person person;

    // Getters and Setters
    public Integer getPersonId() { return personId; }
    public void setPersonId(Integer personId) { this.personId = personId; }
    public Integer getBatchYear() { return batchYear; }
    public void setBatchYear(Integer batchYear) { this.batchYear = batchYear; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}