package org.example.tests.extent;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(TestNGListener.class)
public class TCIntegrationFlowExtent extends BaseTest {

    // Create A Booking, Create a Token
    // Get booking
    // Update the Booking
    // Delete the Booking


    @Test(groups = "integration", priority = 1)
    @Owner("Promode")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBooking(ITestContext iTestContext) {
        Assert.assertTrue(true);
        iTestContext.setAttribute("token", getToken());

        //POST

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.createBookingPayloadAsString())
                .when().log().all().post();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        // Deser
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        System.out.println("Deser ---- " + bookingResponse);

        assertActions.verifyStatusCode(response, 200);
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname())
                .isEqualTo("Pramod").isNotEmpty().isNotNull().isNotBlank();

        //  Set the booking ID
        iTestContext.setAttribute("bookingId", bookingResponse.getBookingid() );

    }

    @Test(groups = "integration", priority = 2)
    @Owner("Promode")
    @Description("TC#INT1 - Step 2. Verify that the Booking By ID")
    public void testVerifyBookingId(ITestContext iTestContext) {
        Assert.assertTrue(true);
        System.out.println("Token - " + iTestContext.getAttribute("token"));

        Integer BookingID = (Integer) iTestContext.getAttribute("bookingId");
        //GET

        String get_BasePath = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + BookingID;

        requestSpecification.basePath(get_BasePath);


        response = RestAssured.given(requestSpecification)
                .when().log().all().get();
        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

        // deser

        Booking booking = payloadManager.getResponseFromJson(response.asString());

        //AssertJ

        assertThat(booking.getFirstname()).isNotNull().isEqualTo("Pramod");
        assertThat(booking.getLastname()).isNotNull().isEqualTo("Stupid");



    }

    @Test(groups = "integration", priority = 3)
    @Owner("Promode")
    @Description("TC#INT1 - Step 3. Verify Updated Booking by ID")
    public void testUpdateBookingByID(ITestContext iTestContext) {
        Assert.assertTrue(true);
        System.out.println("Token - " + iTestContext.getAttribute("token"));
        String token = (String) iTestContext.getAttribute("token");

        //PUT
        Integer BookingID = (Integer) iTestContext.getAttribute("bookingId");
        String put_BasePath = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + BookingID;

        requestSpecification.basePath(put_BasePath);
        response = RestAssured.given(requestSpecification)
                .cookie("token", token).body(payloadManager.fullUpdatePayloadAsString())
                .when().log().all().put();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
// deser

        Booking booking = payloadManager.getResponseFromJson(response.asString());

        //AssertJ

        assertThat(booking.getFirstname()).isNotNull().isEqualTo("Naveen");
        assertThat(booking.getLastname()).isNotNull().isEqualTo("King");


    }

    @Test(groups = "integration", priority = 4)
    @Owner("Promode")
    @Description("TC#INT1 - Step 4. Delete the Booking by ID")
    public void testDeleteBookingById(ITestContext iTestContext) {
        Assert.assertTrue(true);
        System.out.println("Token - " + iTestContext.getAttribute("token"));
        String token = (String) iTestContext.getAttribute("token");

        Integer BookingID = (Integer) iTestContext.getAttribute("bookingId");
        String del_BasePath = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + BookingID;

        requestSpecification.basePath(del_BasePath);
        response = RestAssured.given(requestSpecification)
                .cookie("token", token).cookie("token", token)
                .when().log().all().delete();

        validatableResponse= response.then().log().all();

        validatableResponse.statusCode(201);





    }

}
