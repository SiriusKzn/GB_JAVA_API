package org.example.lesson03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.ComplexSearch.ComplexSearchResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SpoonacularGetTest extends AbstractTest {
    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getPastaTest() {
        JsonPath response = given().spec(getRequestGetSpec())
                .when()
                .get(EndPoints.getComplexSearch())
                .then().spec(getResponseSpec())
                .extract()
                .jsonPath();
        assertThat(response.get("totalResults"), equalTo(223));
    }

    @Test
    void getVegatarianPastaTest() {
        ComplexSearchResponse response = given().spec(getRequestGetSpec())
                .queryParam("diet", "vegetarian")
                .when()
                .get(EndPoints.getComplexSearch())
                .then().spec(getResponseSpec())
                .extract()
                .response()
                .as(ComplexSearchResponse.class);
        assertThat(response.getTotalResults(), equalTo(34));
    }

    @ParameterizedTest
    @CsvSource({"10, 7", "50, 29", "100, 64"})
    void getMaxCalciumPastaTest(int maxCalcium, int totalResults) {
        ComplexSearchResponse response = given().spec(getRequestGetSpec())
                .queryParam("maxCalcium", maxCalcium)
                .when()
                .get(EndPoints.getComplexSearch())
                .then().spec(getResponseSpec())
                .extract()
                .response()
                .as(ComplexSearchResponse.class);
        assertThat(response.getTotalResults(), equalTo(totalResults));
    }

    @ParameterizedTest
    @CsvSource({"100, 204", "30, 21"})
    void getMaxReadyTimePastaTest(int maxReadyTime, int totalResults) {
        ComplexSearchResponse response = given().spec(getRequestGetSpec())
                .queryParam("maxReadyTime", maxReadyTime)
                .when()
                .get(EndPoints.getComplexSearch())
                .then().spec(getResponseSpec())
                .extract()
                .response()
                .as(ComplexSearchResponse.class);
        assertThat(response.getTotalResults(), equalTo(totalResults));
    }

    @ParameterizedTest
    @CsvSource({"100", "2"})
    void getNumberPastaTest(int number) {
        ComplexSearchResponse response = given().spec(getRequestGetSpec())
                .queryParam("number", number)
                .when()
                .get(EndPoints.getComplexSearch())
                .then().spec(getResponseSpec())
                .extract()
                .response()
                .as(ComplexSearchResponse.class);
        assertThat(response.getNumber(), equalTo(number));
    }


}
