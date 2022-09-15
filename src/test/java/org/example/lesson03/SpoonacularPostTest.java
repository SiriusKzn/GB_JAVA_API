package org.example.lesson03;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularPostTest extends AbstractTest{
    @BeforeAll
    static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getGyrosCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Gyros\",\n"
                        + " \"ingredientList\": \"Tomato \n Chicken \n Potato \""
                        + " \"language\": \"en\" "
                        + "}")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .contentType("application/json")
                .statusCode(200);
    }

    @Test
    void getBurgerCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Gyros\",\n"
                        + " \"ingredientList\": \"Tomato \n Chicken \n Potato \""
                        + " \"language\": \"en\" "
                        + "}")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .contentType("application/json")
                .statusCode(200);
    }

    @Test
    void getPizzaCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Gyros\",\n"
                        + " \"ingredientList\": \"Tomato \n Cheese \n Salt \""
                        + " \"language\": \"en\" "
                        + "}")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .contentType("application/json")
                .statusCode(200);
    }

    @Test
    void getBeerCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Gyros\",\n"
                        + " \"ingredientList\": \"Beer \""
                        + " \"language\": \"en\" "
                        + "}")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .contentType("application/json")
                .statusCode(200);
    }

    @Test
    void getChickenCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .body("{\n"
                        + " \"title\": \"Gyros\",\n"
                        + " \"ingredientList\": \"Tomato \n Chicken \n Salt \n Oil\""
                        + " \"language\": \"en\" "
                        + "}")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .contentType("application/json")
                .statusCode(200);
    }

}
