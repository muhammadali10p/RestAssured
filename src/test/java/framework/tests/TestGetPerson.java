package framework.tests;

import com.aventstack.extentreports.Status;
import org.api.model.Person;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;

public class TestGetPerson extends BaseTest {
    @Test(priority=2)
    public void GetaAllPerson()
    {


        test = report.createTest("Get person list");
        try{
            List<Person> personList = personServiceHelper.getAllPersons();
            assertNotNull(personList, "Got the list of users");
            test.log(Status.PASS, "Got the list of users successfully");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            test.log(Status.FAIL, "Could not get the list of users");
        }

    }


}
