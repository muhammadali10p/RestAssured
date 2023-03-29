package framework.tests;

import io.restassured.response.Response;
import org.api.helper.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestDeletePerson extends BaseTest {
    @Test
    public void updatePerson()
    {
        Response response = personServiceHelper.deletePerson(1);

    }

}
