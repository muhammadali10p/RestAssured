package framework.tests;

import com.aventstack.extentreports.Status;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestDeletePerson extends BaseTest {
    @Test(priority=4)
    public void deletePerson()
    {
        test = report.createTest("Delete person call");
        try{
            Response response = personServiceHelper.deletePerson(1);
            test.log(Status.PASS, "Person deleted successfully");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            test.log(Status.FAIL, "Person could not be deleted");
        }


    }

}
