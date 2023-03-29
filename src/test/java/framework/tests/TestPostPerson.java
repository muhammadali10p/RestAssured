package framework.tests;

import io.restassured.response.Response;
import org.api.helper.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPostPerson extends BaseTest {

    @Test
    public void createPerson()
    {
        String id = personServiceHelper.createPerson().jsonPath().get("id").toString();
        System.out.println("Id: "+id);
        assertNotNull(id,"Person is created");
    }

}
