package org.example.lesson03;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.example.Utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpoonacularPostTest extends AbstractTest {
    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    private RequestSpecification genSpecification(String title, String ingradientList) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .addQueryParam("apiKey", getApiKey())
                .addFormParam("title", title)
                .addFormParam("ingradientList", ingradientList)
                .addFormParam("language", "en")
                .build().contentType("application/x-www-form-urlencoded");
        return requestSpec;
    }


    @Test
    void getGyrosCuisineTest() {
        given().spec(genSpecification("Gyros", Utils.conctatArrayList(new String[]{"Tomato", "Chicken", "Potato"})))
                .when()
                .post(EndPoints.getClassifyCuisine())
                .then()
                .contentType("application/json")
                .statusCode(200);
    }

    @Test
    void getBurgerCuisineTest() {
        given().spec(genSpecification("Burger", Utils.conctatArrayList(new String[]{"Bread", "Steak", "Potato"})))
                .when()
                .post(EndPoints.getClassifyCuisine())
                .then().spec(responseSpec);
    }

    @Test
    void getPizzaCuisineTest() {
        given().spec(genSpecification("Pizza", Utils.conctatArrayList(new String[]{"Dough", "Tomato", "Cheese"})))
                .when()
                .post(EndPoints.getClassifyCuisine())
                .then().spec(responseSpec);
    }

    @Test
    void getBeerCuisineTest() {
        given().spec(genSpecification("Beer", Utils.conctatArrayList(new String[]{"Hops", "Malt", "Water"})))
                .when()
                .post(EndPoints.getClassifyCuisine())
                .then().spec(responseSpec);
    }

    @Test
    void getChickenCuisineTest() {
        given().spec(genSpecification("Chicken", Utils.conctatArrayList(new String[]{"Chicken", "Salt", "Oil"})))
                .when()
                .post(EndPoints.getClassifyCuisine())
                .then().spec(responseSpec);
    }

}
