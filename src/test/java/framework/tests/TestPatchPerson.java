package framework.tests;

import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

public class TestPatchPerson extends BaseTest {
    @Test(priority=3)
    public void updatePerson()
    {
        test = report.createTest("Update person");
        try {
            String id = personServiceHelper.updatePerson(2).jsonPath().get("id").toString();
            System.out.println("Id: " + id);
            assertNotNull(id, "Person Is Updated");
            test.log(Status.PASS, "Person is updated");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            test.log(Status.FAIL, "Person Could not be updated");
        }
    }
}
