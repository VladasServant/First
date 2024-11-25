package com.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testGetAllBookingsStatusCode() {
        given()
            .when()
            .get("/booking")
            .then()
            .statusCode(200)
            .header("Content-Type", "application/json; charset=utf-8")
            .body("size()", greaterThan(0));
    }

    @Test
    public void testCreateNewBooking() {
        given()
            .header("Content-Type", "application/json")
            .body("{\n" +
                  "    \"firstname\" : \"John\",\n" +
                  "    \"lastname\" : \"Doe\",\n" +
                  "    \"totalprice\" : 150,\n" +
                  "    \"depositpaid\" : true,\n" +
                  "    \"bookingdates\" : {\n" +
                  "        \"checkin\" : \"2024-11-01\",\n" +
                  "        \"checkout\" : \"2024-11-10\"\n" +
                  "    },\n" +
                  "    \"additionalneeds\" : \"Dinner\"\n" +
                  "}")
            .when()
            .post("/booking")
            .then()
            .statusCode(200)
            .body("booking.firstname", equalTo("John"))
            .body("booking.lastname", equalTo("Doe"));
    }


    @Test
    public void testAuthenticationToken() {
        String token = given()
            .header("Content-Type", "application/json")
            .body("{\n" +
                  "    \"username\" : \"admin\",\n" +
                  "    \"password\" : \"password123\"\n" +
                  "}")
            .when()
            .post("/auth")
            .then()
            .statusCode(200)
            .extract()
            .path("token");

        assertNotNull(token, "Token was not generated successfully.");
    }

    @Test
    public void testFilterBookingsByName() {
        given()
            .queryParam("firstname", "John")
            .when()
            .get("/booking")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void testInvalidDataValidation() {
        given()
            .header("Content-Type", "application/json")
            .body("{\n" +
                  "    \"firstname\" : ,\n" +
                  "    \"lastname\" : ,\n" +
                  "    \"totalprice\" : -100,\n" +
                  "    \"depositpaid\" : true,\n" +
                  "    \"bookingdates\" : {\n" +
                  "        \"checkin\" : ,\n" +
                  "        \"checkout\" : \n" +
                  "    }\n" +
                  "}")
            .when()
            .post("/booking")
            .then()
            .statusCode(400);
    }
}
