package service;

import com.daklan.controlbudget.rest.model.dto.output.RecordCreateDtoOut;
import com.daklan.controlbudget.rest.model.dto.person.PersonCreateDtoIn;
import com.daklan.controlbudget.rest.model.dto.person.PersonInitialInformationDto;
import com.daklan.controlbudget.rest.service.PersonService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class PersonServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceTest.class);

    private static final String FIRST_NAME = "Eric";
    private static final String LAST_NAME = "DAKLAN";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1979, 5, 19);

    @Autowired
    PersonService personService;

    private static PersonCreateDtoIn buildPersonCreateDtoIn() {

        final PersonCreateDtoIn personCreateDtoIn = new PersonCreateDtoIn();
        final PersonInitialInformationDto personInitialInformationDto = new PersonInitialInformationDto();
        personInitialInformationDto.setFirstName(FIRST_NAME);
        personInitialInformationDto.setLastName(LAST_NAME);
        personInitialInformationDto.setBirthDate(BIRTH_DATE);
        personCreateDtoIn.setPersonInitialInformationDto(personInitialInformationDto);;

        return personCreateDtoIn;
    }

    private static RecordCreateDtoOut buildRecordCreateDtoOut(String id) {
        final RecordCreateDtoOut recordCreateDtoOut = new RecordCreateDtoOut(id);

        return recordCreateDtoOut;
    }


}
