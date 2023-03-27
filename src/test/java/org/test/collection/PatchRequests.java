package org.test.collection;

import io.restassured.RestAssured;
import org.api.collection.apicollection;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PatchRequests {

    @Test
    public static void patchRequests()
    {
        try
        {
            RestAssured.baseURI = apicollection.User;
            String userData = "{" + "\"name\":\"morpheus\", "+
                    "\"job\": \"leader\""+"}";
            given().body(userData)
                    .when()
                    .post()
                    .then().log().all()
                    .assertThat()
                    .statusCode(201)
                    .body("id", is(notNullValue()));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
