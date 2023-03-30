package framework.tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPostPerson extends BaseTest {

    @Test(priority=1)
    public void createPerson()
    {
        test = report.createTest("Create new person");
        try {
            String id = personServiceHelper.createPerson().jsonPath().get("id").toString();
            System.out.println("Id: " + id);
            assertNotNull(id, "Person is created");
            test.log(Status.PASS, "Record created successfully");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            test.log(Status.FAIL, "Record not created");
        }
    }

}
