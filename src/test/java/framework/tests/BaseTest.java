package framework.tests;

import org.api.helper.PersonServiceHelper;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public static PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init()
    {
        personServiceHelper = new PersonServiceHelper();
    }
}
