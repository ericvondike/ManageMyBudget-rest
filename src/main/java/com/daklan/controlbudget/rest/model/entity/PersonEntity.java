package com.daklan.controlbudget.rest.model.entity;

import com.daklan.controlbudget.rest.model.entity.address.AddressEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.EmailEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.FaxEntity;
import com.daklan.controlbudget.rest.model.entity.contactinformation.TelephoneEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * <b>The class for creating the entity person.</b>
 */
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(position = 1)
    private Integer id;

    @Column(name = "fisrt_name", nullable = false)
    @ApiModelProperty(position = 2)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @ApiModelProperty(position = 3)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    @ApiModelProperty(position = 4)
    private LocalDate birthDate;

    @Column(name = "status", nullable = false)
    @ApiModelProperty(position = 5)
    private String status;

    @Column(name = "middle_name", nullable = true)
    @ApiModelProperty(position = 6)
    private String middleName;

    @Column(name = "mrital_name", nullable = true)
    @ApiModelProperty(position = 7)
    private String maritalName;


    @OneToMany(mappedBy = "person")
    private Set<EmailEntity> emails;

    @OneToMany(mappedBy = "person")
    private Set<TelephoneEntity> telephones;

    @OneToMany(mappedBy = "person")
    private Set<FaxEntity> faxes;

    @OneToMany(mappedBy = "person")
    private Set<AddressEntity> addresses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMaritalName() {
        return maritalName;
    }

    public void setMaritalName(String maritalName) {
        this.maritalName = maritalName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<EmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(Set<EmailEntity> emails) {
        this.emails = emails;
    }

    public Set<TelephoneEntity> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<TelephoneEntity> telephones) {
        this.telephones = telephones;
    }

    public Set<FaxEntity> getFaxes() {
        return faxes;
    }

    public void setFaxes(Set<FaxEntity> faxes) {
        this.faxes = faxes;
    }

    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
