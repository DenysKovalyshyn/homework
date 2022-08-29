package lesson34;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;


public class Tests {
    Student student = new Student();
    String username = RandomStringUtils.randomAlphanumeric(10);
    String password = RandomStringUtils.randomAlphanumeric(10);
    String token;
    Student[] searchResult;

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://www.robotdreams.karpenko.cc")
            .setContentType(ContentType.JSON)
            .build();

    ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    @Test (priority = 1)
    public void CreateNewUser() {
        given()
                .spec(requestSpec)
                .basePath("/user")
                .when()
                .body(new User(username, password))
                .post()
                .then().log().all().spec(responseSpec);
    }

    @Test (priority = 2)
    public void SuccessfulLogin() {
        Response loginResponse = RestAssured.given()
                .spec(requestSpec)
                .basePath("/login")
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get();
                loginResponse.then().log().all().spec(responseSpec);
        JSONObject tokenRespone = new JSONObject(loginResponse.asString());
        token = tokenRespone.getString("session_token");
    }

    @Test (priority = 3)
    public void StudentsCreation() {
        given()
                .spec(requestSpec)
                .header("user-token", token)
                .body(new StudentData("Denys", "Kovalyshyn"))
                .post("/students")
                .then().spec(responseSpec);

        given()
                .spec(requestSpec)
                .header("user-token", token)
                .body(new StudentData("Julia", "Kostiurechko"))
                .post("/students")
                .then().spec(responseSpec);

        given()
                .spec(requestSpec)
                .header("user-token", token)
                .body(new StudentData("Eva", "Kovalyshyn"))
                .post("/students")
                .then().spec(responseSpec);

        Response studentsList = RestAssured
                .given()
                .spec(requestSpec)
                .header("user-token", token)
                .queryParam("last_name", "Ko")
                .when()
                .get("/students");
        studentsList.then().spec(responseSpec);
        searchResult = studentsList.as(Student[].class);

        Set<String> studentNames = Arrays.stream(searchResult).map(s -> s.firstName).collect(Collectors.toSet());
        System.out.println(studentNames);

        Assert.assertEquals(searchResult.length, 3);
    }

    @Test (priority = 4)
    public void GroupWithStudentsCreation() {
        List<Student> allStudents = Arrays.asList(RestAssured
                .given()
                .spec(requestSpec)
                .header("user-token", token)
                .get("/students")
                .then().spec(responseSpec)
                .extract().as(Student[].class)
        );
        List<Integer> studentIds = allStudents.stream().map(student -> student.id).collect(Collectors.toList());
        System.out.println(studentIds);

        given()
                .spec(requestSpec)
                .header("user-token", token)
                .body(new GroupData("Family", studentIds))
                .post("/groups")
                .then().spec(responseSpec)
                .body("name", equalTo("Family"))
                .body("students", hasSize(studentIds.size()));
    }
}
