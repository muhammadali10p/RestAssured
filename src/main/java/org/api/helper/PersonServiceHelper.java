package org.api.helper;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.api.constants.EndPoints;
import org.api.model.Person;
import org.api.utils.Utils;
import java.lang.reflect.Type;
import java.util.List;

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
        List<Person> allPersons = null;
        try {
            Response response = RestAssured.given().log().all()
                    .contentType(ContentType.JSON)
                    .get(EndPoints.GET_All_PERSON)
                    .andReturn();
            Type type = new TypeReference<List<Person>>() {
            }.getType();
            allPersons = response.as(type);

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return allPersons;
    }


}
