package com.daklan.controlbudget.rest.model.entity.contactinformation;

import com.daklan.controlbudget.rest.model.entity.PersonEntity;

import javax.persistence.*;

/**
 * <b>The entity for the fax of the Person</b>
 */
@Entity
@Table(name = "fax")
public class FaxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_person", nullable = false)
    PersonEntity person;

    //The fax number of the Person
    @Column(name = "fax_number")
    private String identifiedBy;

    @Column(name = "use")
    private String use;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public String getIdentifiedBy() {
        return identifiedBy;
    }

    public void setIdentifiedBy(String identifiedBy) {
        this.identifiedBy = identifiedBy;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }
}
