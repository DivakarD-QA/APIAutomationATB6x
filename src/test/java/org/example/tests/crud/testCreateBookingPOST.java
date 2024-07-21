package org.example.tests.crud;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.BookingResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class testCreateBookingPOST extends BaseTest {

    @Test(groups = "smoke")
    @Owner("Divakar")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBooking(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .body(payloadManager.createBookingPayloadAsString())
                .when().log().all().post();

        validatableResponse = response.then().log().all();

        // Validatable Assertion
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));

        // TestNG Assertions
        assertActions.verifyStatusCode(response,200);


        // Deser
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        System.out.println("Deser ---- " + bookingResponse);

        //AssertJ

        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname())
                .isEqualTo("Pramod").isNotEmpty().isNotNull().isNotBlank();

  }

    @Test(groups = "smoke")
    @Owner("Divakar")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify that the Booking cannot be Created")
  public void testCreateBookingNegative(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response=RestAssured.given(requestSpecification)
                .body(payloadManager.creaeBookingNegative())
                .when().log().all().post();

        validatableResponse= response.then().log().all();

        validatableResponse.statusCode(500);
        assertActions.verifyStatusCode(response, 500);


  }
}
