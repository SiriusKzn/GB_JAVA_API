package org.example.lesson03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SpoonacularGetTest extends AbstractTest {
    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getPastaTest(){
       JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
       assertThat(response.get("totalResults"), equalTo(223));
    }

    @Test
    void getVegatarianPastaTest(){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("diet","vegetarian")
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .contentType("application/json")
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(34));
    }

    @ParameterizedTest
    @CsvSource({"10, 7","50, 29", "100, 64"})
    void getMaxCalciumPastaTest(int maxCalcium, int totalResults){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("maxCalcium",maxCalcium)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(totalResults));
    }

    @ParameterizedTest
    @CsvSource({"100, 204","30, 21"})
    void getMaxReadyTimePastaTest(int maxReadyTime, int totalResults){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("maxReadyTime",maxReadyTime)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .body()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(totalResults));
    }

    @ParameterizedTest
    @CsvSource({"100", "2"})
    void getNumberPastaTest(int number){
        JsonPath response = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("number", number)
                .when()
                .get(getBaseUrl() + "recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract()
                .body()
                .jsonPath();
        assertThat(response.get("number"), equalTo(number));
    }


}
