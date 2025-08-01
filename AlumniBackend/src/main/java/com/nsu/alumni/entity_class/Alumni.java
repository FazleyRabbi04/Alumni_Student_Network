package com.nsu.alumni.entity_class;

import com.nsu.alumni.entity_class.Person;
import jakarta.persistence.*;

@Entity
@Table(name = "alumni")
public class Alumni {
    @Id
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "grad_year")
    private Integer gradYear;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id")
    private Person person;

    // Getters and Setters
    public Integer getPersonId() { return personId; }
    public void setPersonId(Integer personId) { this.personId = personId; }
    public Integer getGradYear() { return gradYear; }
    public void setGradYear(Integer gradYear) { this.gradYear = gradYear; }
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}