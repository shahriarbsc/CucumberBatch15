package APIStepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseUri = RestAssured.baseURI ="http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;


    @Given("a JWT is generated")
    public void a_jwt_is_generated() {

        RequestSpecification generateTokenRequest =

                   given().header("Content-Type","application/json").body("{\n" +
                           "    \"email\": \"Shahbatch15@test.com\",\n" +
                           "    \"password\": \"Shahtest123\"\n" +
                           "}");

        // hitting the end point

        Response response = generateTokenRequest.when().post("/generateToken.php");

        //storing the token in global variable

        token = "Bearer " + response.jsonPath().getString("token");

        System.out.println(token);
       }
}
