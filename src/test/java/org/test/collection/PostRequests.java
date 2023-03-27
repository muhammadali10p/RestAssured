package org.test.collection;

import io.restassured.RestAssured;
import org.api.collection.apicollection;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostRequests {

    @Test
    public static void patchUpdateeUser()
    {
        RestAssured.baseURI = apicollection.User+"54";
        String userData = "{" + "\"name\":\"Ali\", "+
                "\"job\": \"leader\""+"}";
        given().body(userData)
                .when()
                .patch()
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("id", is(notNullValue()));
    }
}
