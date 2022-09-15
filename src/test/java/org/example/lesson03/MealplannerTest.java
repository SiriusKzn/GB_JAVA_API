package org.example.lesson03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MealplannerTest extends AbstractTest{
    private static int id;

    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void endpointTest(){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .when()
                .body("{\n"
                        + " \"item\": \"1 kilogram meat\",\n"
                        + " \"aisle\": \"Meat\","
                        + " \"parse\": true"
                        + "}")
                .post(getBaseUrl() + "mealplanner/"+ getUsername() + "/shopping-list/items")
                .then()
                .contentType("application/json")
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
        id = response.get("id");
        assertThat(response.get("ingredientId"), equalTo(1065062));
        assertThat(response.get("aisle"), equalTo("Meat"));
    }

    @AfterEach
    void teardownTest(){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .when()
                .delete(getBaseUrl()+"mealplanner/"+getUsername()+"/shopping-list/items/"+id)
                .then()
                .contentType("application/json")
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
        assertThat(response.get("status"), equalTo("success"));
    }


}
