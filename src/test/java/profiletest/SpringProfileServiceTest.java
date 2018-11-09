package profiletest;

import com.daklan.controlbudget.rest.ControlbugetRestApplication;
import com.daklan.controlbudget.rest.configuration.KmsProperties;
import com.daklan.controlbudget.rest.service.JsonPathTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControlbugetRestApplication.class)
public class SpringProfileServiceTest {

    @Autowired
    private JsonPathTestService jsonPathTestService;

    @Autowired
    KmsProperties kmsProperties;



    @Test
    public void when_kmsProfileShouldRunTheKmsCase() throws IOException {
        jsonPathTestService.callPropertiesFile();
    }
}
