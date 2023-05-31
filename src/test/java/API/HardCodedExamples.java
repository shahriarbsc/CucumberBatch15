package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.equalTo;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";

    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUyMDcwNDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTI1MDI0MSwidXNlcklkIjoiNTI2MiJ9.ursB08ZW2SNL6PE7mkzlb5Oq95qaTivMNWBqw9D6AgM";

    static String employee_id;

    @Test

    public void bgetCreatedEmployee() {

        RequestSpecification preparedRequest = given().

                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        // hitting the endpoint

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        // verify the response

        response.then().assertThat().statusCode(200);
        String tempEmId = response.jsonPath().getString("employee.employee_id");

        // we have 2 emp id, one is global and second is local

        Assert.assertEquals(employee_id, tempEmId);


    }


    @Test

    public void acreateEmployee() {

        // prepare the request
// requestspecfication is an interface

        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "    \"emp_firstname\": \"Tam\",\n" +
                        "    \"emp_lastname\": \"Shahriar\",\n" +
                        "    \"emp_middle_name\": \"I\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1991-03-13\",\n" +
                        "    \"emp_status\": \"Confirmed\",\n" +
                        "    \"emp_job_title\": \"QA\"\n" +
                        "}");


        //hitting the endpoint / send the request

        Response response = preparedRequest.when().post("/createEmployee.php");

        // verifying the assertions / get response

        response.then().assertThat().statusCode(201);


        // we are capturing employee id from the response

        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);


        //it will print the out in the console ,its only for api
        // response.prettyPrint();


        // verifying the firstname in the response body
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("Tam"));
        response.then().assertThat().
                body("Employee.emp_lastname", equalTo("Shahriar"));

        // verify the response header

        response.then().assertThat().header("Content-Type", "application/json");


        System.out.println("My test case is passed");

    }

    // in homework, create a method to get all employee status and job title.

    @Test
    public void cupdateEmployee() {


        RequestSpecification preparedRequest = given().
                header("Content-type", "application/json").
                header("Authorization", token).body(" \"employee_id\":\"" + employee_id + "\",\n" +
                                "    \"emp_firstname\": \"Tamanna\",\n" +
                                "    \"emp_lastname\": \"Ferdoush\",\n" +
                                "    \"emp_middle_name\": \"S\",\n" +
                                "    \"emp_gender\": \"F\",\n" +
                                "    \"emp_birthday\": \"1991-03-13\",\n" +
                                "    \"emp_status\": \"Confirmed\",\n" +
                                "    \"emp_job_title\": \"QA\"n"+
                        "}");

        //hitting the endpoint

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        // for verification
        response.then().assertThat().body("Message", equalTo("Employee Record Updated"));


    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().

                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        // if you want to verify the body of the response.
        //if you can do that using hamcrest matchers







    }




}
