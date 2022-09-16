package org.example.lesson04;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {
    static Properties prop = new Properties();
    private static String apiKey;
    private static String baseUrl;
    private static String hash;
    private static String username;
    protected static ResponseSpecification responseSpec;
    private static RequestSpecification requestGetSpec;
    private static RequestSpecification requestMealPlannerSpec;

    @BeforeAll
    static void initTest() throws IOException {
        InputStream configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        apiKey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("base_url");
        username = prop.getProperty("username");
        hash = prop.getProperty("hash");

        requestMealPlannerSpec = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("hash", getHash())
                .build();

        requestGetSpec = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("query", "pasta")
                .build();
        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static ResponseSpecification getResponseSpec() {
        return responseSpec;
    }

    public static RequestSpecification getRequestGetSpec() {
        return requestGetSpec;
    }

    public static RequestSpecification getRequestMealPlannerSpec() {
        return requestMealPlannerSpec;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getHash() {
        return hash;
    }

    public static String getUsername() {
        return username;
    }
}


