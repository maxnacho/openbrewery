package search;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utilities.Basic;

import static io.restassured.RestAssured.given;

public class SearchService extends Basic {

    public static void verifyGetResponse(String s, int statusCode, String pathToJsonSchema) {
        setUp();
        given()
                .when()
                .get(s)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(pathToJsonSchema));
    }

    public static void verifyUnsupportedMethods(String method, String query, int statusCode) {
        Response response = null;
        setUp();
        RequestSpecification when = given().when();
        switch (method) {
            case "post": {
                response = when.post("search" + query);
                break;
            }
            case "put": {
                response = when.put("search" + query);
                break;
            }
            case "delete": {
                response = when.delete("search" + query);
                break;
            }
            default:
                Assert.fail("Unsupported case!");
        }
        response
                .then()
                .assertThat()
                .statusCode(statusCode);
    }
}
