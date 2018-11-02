package json;

import com.daklan.controlbudget.rest.configuration.KmsProperties;
import org.junit.Ignore;
import org.junit.Test;

public class PropertiesTest {

    private KmsProperties kmsProperties = new KmsProperties();


    @Ignore
    @Test
    public void aSimpleTest() {
        String birthdatePath = kmsProperties.getTariffication().getTarificationTemplate().getBirthDatePath();
        System.out.print(birthdatePath);
    }

}
