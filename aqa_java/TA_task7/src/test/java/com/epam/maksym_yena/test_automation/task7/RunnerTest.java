package com.epam.maksym_yena.test_automation.task7;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;


public class RunnerTest {

    private static final String SWAGGER = "http://petstore.swagger.io/v2/swagger.json";

    private static String payload = "{\n" +
            "  \"id\": \" 1\",\n" +
            "  \"name\": \"maksym\"\n" +
            "}";

    @Test
    public void checkStatus() {
        given()
                .baseUri(SWAGGER)
                .then()
                .statusCode(200);
    }

    @Test
    public void checkGettingDogs() {
        given()
                .contentType("application/json")
                .baseUri("https://petstore.swagger.io/v2/pet/0")
                .when()
                .get()
                .then()
                .body(containsString("Pet not found"));
    }

    @Test
    public void checkPostRequestForCreatingDog() {

        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void checkDeleteDogs() {

        given()
                .contentType(ContentType.JSON)
                .delete("https://petstore.swagger.io/v2/pet/1")
                .then()
                .statusCode(200);
    }
}