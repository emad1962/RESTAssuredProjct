package APITests;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
public class TestOnLocalAPI {

    @Test
    public void get() {
        baseURI = "http://localhost:3000";
        given().get("/users").then().statusCode(200).log().all();

    }

    @Test
    public void post() {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName", "Nader");
        request.put("lastName", "Gad");
        request.put("subjectId", 1);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/users")
                .then().statusCode(201);
    }

    @Test
    public void put() {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName", "Mamdoh");
        request.put("lastName", "Gad");
        request.put("subjectId", 2);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().put("/users/4")
                .then().statusCode(200);
    }

    @Test
    public void patch() {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();

        request.put("lastName", "Mostafa");

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/4")
                .then().statusCode(200);
    }

    @Test
    public void delete() {
        baseURI = "http://localhost:3000";

        given().
                when().
                delete("/users/4").
                then().
                statusCode(200);
    }
}