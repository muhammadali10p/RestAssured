package org.api.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.api.constants.EndPoints;
import org.api.model.Person;
import org.api.utils.Utils;
import java.lang.reflect.Type;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PersonServiceHelper {

    private static final String BASE_URL = Utils.getInstance().property("baseurl");
    private static final String PORT = Utils.getInstance().property("port");

    public PersonServiceHelper()
    {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Person> getAllPersons()
    {

        Response response = RestAssured.given().log().all()
           .contentType(ContentType.JSON)
           .get(EndPoints.GET_All_PERSON)
           .andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK,"OK");
        Type type = new TypeReference<List<Person>>() {}.getType();
        List<Person> allPersons = response.as(type);
            return allPersons;
    }

    public Response createPerson()
    {
        Person person = new Person();
        person.setId(1);
        person.setAdress("Demo Adress");
        person.setAge(26);
        person.setFirstname("Asad");
        person.setLastname("Ullah");
        person.setPhonenumber("+92308524");

        Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(person)
                .post(EndPoints.CREATE_PERSON)
                .andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Person is Created");
        return response;
    }

    public Response updatePerson(Integer id)
    {
        Person person = new Person();
        person.setAdress("Demo Adress");
        person.setAge(26);
        person.setFirstname("Tayyab");
        person.setLastname("Tariq");
        person.setPhonenumber("+92246914");

       Response response = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .pathParams("id",id)
                .when().body(person)
                .patch(EndPoints.UPDATE_PERSON)
                .andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Person Updayed");
        return response;
    }


    public Response deletePerson(Integer id)
    {
       Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParams("id",id)
                .log().all()
                .when()
                .delete(EndPoints.GET_SINGLE_PERSON)
                .andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Person Deleted");
        return response;

    }

}
