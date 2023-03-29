package framework.tests;

import org.api.helper.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TestPatchPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init()
    {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void updatePerson()
    {
        String id = personServiceHelper.updatePerson(1).jsonPath().get("id").toString();
        System.out.println("Id: "+id);
        assertNotNull(id,"Purson Is Updated");
    }
}
