package org.example.lesson03;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.MealPlanner.Add.MealPlannerRequest;
import org.example.MealPlanner.Add.MealPlannerRequestBuilder;
import org.example.MealPlanner.Add.MealPlannerResponse;
import org.example.MealPlanner.Get.MealPlannerList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MealplannerTest extends AbstractTest {
    private static int id;

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(1)
    void addMealPlannerTest() {
        MealPlannerRequest request = new MealPlannerRequestBuilder()
                .setItem("1 kilogram meat")
                .setAisle("Meat")
                .setParse(true)
                .createMealPlannerRequest();

        MealPlannerResponse response = given().spec(getRequestMealPlannerSpec())
                .when()
                .body(request)
                .post(EndPoints.getAddMealPlanner())
                .then().spec(getResponseSpec())
                .extract()
                .response()
                .as(MealPlannerResponse.class);
        id = response.getId();
        assertThat(response.getIngredientId(), equalTo(1065062));
        assertThat(response.getAisle(), equalTo("Meat"));
    }

    @Test
    @Order(2)
    void getMealPlannerTest() {
        MealPlannerList response = given().spec(getRequestMealPlannerSpec())
                .when()
                .get(EndPoints.getGetMealPlanner())
                .then().spec(responseSpec)
                .extract()
                .response()
                .as(MealPlannerList.class);
        assertThat(response.getCost(), equalTo(Double.valueOf("886.67")));
    }


    @Test
    @Order(3)
    void teardownTest() {
        JsonPath response = given().spec(getRequestMealPlannerSpec())
                .when()
                .delete(EndPoints.getDeleteMealPlanner(id))
                .then().spec(getResponseSpec())
                .extract()
                .body()
                .jsonPath();
        assertThat(response.get("status"), equalTo("success"));
    }


}
