package framework.tests;

import org.api.helper.PersonServiceHelper;
import org.api.model.Person;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.Console;
import java.util.List;

import static org.testng.Assert.assertNotNull;

public class TestGetPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init()
    {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void GetaAllPerson()
    {
       List<Person> personList = personServiceHelper.getAllPersons();
       assertNotNull(personList, "Got the list of users");
    }


}
