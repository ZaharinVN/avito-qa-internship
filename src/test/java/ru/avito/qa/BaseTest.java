package ru.avito.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.avito.qa.dto.Ad;
import ru.avito.qa.helpers.TestDataGenerator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public abstract class BaseTest {

    protected static final String BASE_URL = System.getProperty("base.url", "https://qa-internship.avito.com");

    protected Long currentItemId;
    protected Long currentSellerId;
    protected TestDataGenerator testData;

    @BeforeAll
    static void setupRestAssured() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @BeforeEach
    void setup() {
        testData = new TestDataGenerator();
        currentSellerId = testData.generateUniqueSellerId();
    }

    protected Long createAd(Ad ad) {
        return given()
                .contentType(ContentType.JSON)
                .body(ad)
                .when()
                .post("/ads")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .extract()
                .path("id");
    }
}
