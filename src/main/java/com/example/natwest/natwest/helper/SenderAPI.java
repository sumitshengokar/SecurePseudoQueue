package com.example.natwest.natwest.helper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.http.ResponseCookie;

public class SenderAPI {


    public Response PostAPI(String response)
    {
        RestAssured.baseURI ="http://localhost:9000/decryptDetails";
        RequestSpecification httpRequest = RestAssured.given()
                .body(response)
                .relaxedHTTPSValidation();

        return httpRequest.request(Method.POST);
    }

}
