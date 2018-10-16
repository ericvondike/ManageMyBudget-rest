package json;

import com.daklan.controlbudget.rest.configuration.KmsProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PropertiesTest {

    private KmsProperties kmsProperties = new KmsProperties();


    @Test
    public void aSimpleTest() {
        String birthdatePath = kmsProperties.getTariffication().getTarificationTemplate().getBirthDatePath();
        System.out.print(birthdatePath);
    }

}
