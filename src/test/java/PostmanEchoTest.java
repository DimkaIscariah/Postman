package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {
    @Test
    void shouldReturnData() {


        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Радуйся, мир")


                .when()
                .post("/post")

                .then()
                .statusCode(400)
                .body("data", equalTo("Радуйся, мир"))
                .contentType(ContentType.JSON)

        ;
    }
}