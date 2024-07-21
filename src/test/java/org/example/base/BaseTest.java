package org.example.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.actions.AssertActions;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    //  Base Test Father -> Testcase - Son - Single Inheritance

    public PayloadManager payloadManager;
    public APIConstants apiConstants;
    public AssertActions assertActions;
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest
    public void setup() {
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

//        requestSpecification = RestAssured.given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON).log().all();


    }


    public String getToken() {

        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

        String payload = payloadManager.setAuthPayload();

        response = requestSpecification.contentType(ContentType.JSON)
                .body(payload).when().log().all().post();

        String token = payloadManager.getTokenFromJson(response.asString());

        return token;
    }



}
