package framework.tests;

import io.restassured.response.Response;
import org.api.helper.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestDeletePerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init()
    {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void updatePerson()
    {
        Response response = personServiceHelper.deletePerson(1);

    }

}
