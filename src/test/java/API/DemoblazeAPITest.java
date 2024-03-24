package API;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;

public class DemoblazeAPITest {

    @Test(priority = 1)
    public void testSignUp() {
        RestAssured.baseURI = "https://api.demoblaze.com/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body("{\"username\": \"Alhifnawy12345\", \"password\": \"Test123!\"}");
        Response response = request.post("/signup");
        int statusCode = response.getStatusCode();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200, "Incorrect status code");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testLogin() {
        RestAssured.baseURI = "https://api.demoblaze.com/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body("{\"username\": \"Alhifnawy12345\", \"password\": \"Test123!\"}");
        Response response = request.post("/login");
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200, "Incorrect status code");
        softAssert.assertTrue(responseBody.contains("\"Auth_token:"), "Response message does not match");
        softAssert.assertAll();
    }
}