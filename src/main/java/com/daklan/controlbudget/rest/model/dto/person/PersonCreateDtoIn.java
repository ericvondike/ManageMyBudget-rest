package com.daklan.controlbudget.rest.model.dto.person;


import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;

/**
 * <b>DTOin for the creating Person for the first time.</b>
 */
public class PersonCreateDtoIn implements Serializable {

    private static final long serialVersionUID = 4710236594732128960L;

    @JsonUnwrapped
    PersonInitialInformationDto personInitialInformationDto;

    public PersonInitialInformationDto getPersonInitialInformationDto() {
        return personInitialInformationDto;
    }

    public void setPersonInitialInformationDto(PersonInitialInformationDto personInitialInformationDto) {
        this.personInitialInformationDto = personInitialInformationDto;
    }
}
