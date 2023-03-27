package org.test.collection;

import com.aventstack.extentreports.gherkin.model.When;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import org.api.collection.apicollection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequests
{

    @Test
    public static void getUser()
    {
        try {
            RestAssured.baseURI = apicollection.User;
            given().
                    queryParam("page", "2")
                    .body("")
                    .when()
                    .get()
                    .then()
                    .assertThat().statusCode(200).body("page",equalTo(2));

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
