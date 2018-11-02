package com.daklan.controlbudget.rest.model.entity.contactinformation;

import com.daklan.controlbudget.rest.model.entity.PersonEntity;

import javax.persistence.*;

/**
 * <b>The class for the emails of the users</b>
 */
@Entity
@Table(name = "email")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    private PersonEntity person;

    //The email address
    @Column(name = "email_address", unique = true)
    private String identifiedBy;

    @Column(name = "use")
    private String use;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
