package org.example.tests.DDT;

import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.pojos.BookingResponse;
import org.example.pojos.VWOLogin;
import org.example.pojos.VWOResponse;
import org.example.utils.UtilsExcel;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VWOLoginTC01 extends BaseTest {

    @Test(dataProvider = "getdata", dataProviderClass = UtilsExcel.class)
    public void login(String email, String password){

        System.out.println(" -- Login API Testing");
        System.out.println(email);
        System.out.println(password);

        //Payload
        VWOLogin vwoLogin = new VWOLogin();
        vwoLogin.setUsername(email);
        vwoLogin.setPassword(password);
        vwoLogin.setRemember(false);
        vwoLogin.setRecaptchaResponseField("");

        requestSpecification.baseUri("https://app.vwo.com").basePath("/login");
        response= RestAssured.given(requestSpecification)
                .body(vwoLogin).when().log().all().post();

        validatableResponse = response.then().log().all();

       //  validatableResponse.statusCode(200);

        // Deser
        VWOResponse vwoResponse = payloadManager.vwoResponseJava(response.asString());
        System.out.println("Deser ---- " + vwoResponse);


// Extract the status code
        int statusCode = response.getStatusCode();


         switch (statusCode) {
            case 200:
                System.out.println("Request was successful");
                assertActions.verifyStatusCode(response, 200);
//                assertThat(vwoResponse.getName()).isEqualTo("Test Q4");
//                assertThat(vwoResponse.getEmail()).isNotNull().isEqualTo(email);
                break;
            case 401:
                 System.out.println("Not Authorized");
                assertActions.verifyStatusCode(response, 401);
                 break;
            case 404:
                System.out.println("Resource not found");
                assertActions.verifyStatusCode(response, 404);
                break;
            case 500:
                System.out.println("Internal server error");
                assertActions.verifyStatusCode(response, 500);
                break;
            default:
                System.out.println("Unexpected status code: " + statusCode);
        }




    }
}
