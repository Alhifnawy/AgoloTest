package API;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;

public class ApiTest {

    @Test
    public void testGetApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/v2/pet/findByStatus?status=available");
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200, "Incorrect status code");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void testPostApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body("{\n" +
                "\"id\": 1,\n" +
                "\"category\": {\n" +
                "\"id\": 1,\n" +
                "\"name\": \"TEST_PET_CATEGORY\"\n" +
                "},\n" +
                "\"name\": \"TEST_PET_NAME\",\n" +
                "\n" +
                "\"tags\": [\n" +
                "{\n" +
                "\"id\": 1,\n" +
                "\"name\": \"TEST_NAME_TAG\"\n" +
                "}\n" +
                "],\n" +
                "\"status\": \"available\"\n" +
                "}");
        Response response = request.post("/v2/pet");
        int statusCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200, "Incorrect status code");
        String responseBody = response.getBody().asString();
        softAssert.assertTrue(responseBody.contains("\"name\":\"TEST_PET_CATEGORY\""), "Response message does not match");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testPutApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body("{\n" +
                "\"id\": 1,\n" +
                "\"category\": {\n" +
                "\"id\": 1,\n" +
                "\"name\": \"TEST_PET_CATEGORY\"\n" +
                "},\n" +
                "\"name\": \"TEST_PET_\",\n" +
                "\n" +
                "\"tags\": [\n" +
                "{\n" +
                "\"id\": 1,\n" +
                "\"name\": \"TEST_NAME_TAG\"\n" +
                "}\n" +
                "],\n" +
                "\"status\": \"available\"\n" +
                "}");
        Response response = request.put("/v2/pet");
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200, "Incorrect status code");
        softAssert.assertTrue(responseBody.contains("\"status\":\"available\""), "Response message does not match");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void testDeleteApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("/v2/pet/1");
        int statusCode = response.getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        String responseBody = response.getBody().asString();
        softAssert.assertEquals(statusCode, 200, "Incorrect status code");
        softAssert.assertTrue(responseBody.contains("\"message\":\"1\""), "Response message does not match");
        softAssert.assertAll();
    }
}