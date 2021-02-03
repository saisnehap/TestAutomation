package com.qa.rest.tests;

import org.testng.annotations.Test;
import  static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class RestAssuredAPI {


    @Test
    public void test_get(){
        given()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employees")
                .then()
                .statusCode(200);
    }

    //Delete API assert response code and response
    @Test
    public void test_delete(){
        given()
                .when()
                .delete("http://dummy.restapiexample.com/api/v1/delete/718")
                .then()
                .statusCode(200)
                .log().body()
                .body("status",equalTo("success"))
               .body("message",equalTo("Successfully! Record has been deleted"));

    }

    @Test
    public void test_get_response(){
        given()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employee/1")
                .then()
                .statusCode(200)
                .log().body()
                .body("data.id",equalTo(1))
                .body("data.employee_name",equalTo("Tiger Nixon"));

    }
}
