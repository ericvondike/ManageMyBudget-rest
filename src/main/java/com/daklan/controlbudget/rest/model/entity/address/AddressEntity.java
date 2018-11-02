package com.daklan.controlbudget.rest.model.entity.address;

import com.daklan.controlbudget.rest.model.entity.PersonEntity;

import javax.persistence.*;

/**
 * <b>The entity for the address of teh Person.</b>
 */
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_person", nullable = false)
    private PersonEntity person;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_type")
    private String streetType;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "address_completion")
    private String addressCompletion;

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

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAddressCompletion() {
        return addressCompletion;
    }

    public void setAddressCompletion(String addressCompletion) {
        this.addressCompletion = addressCompletion;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }
}
