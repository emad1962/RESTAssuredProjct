package APITests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDeleteExample {

    @Test
    public void testPut(){
        baseURI ="https://reqres.in/api";
        JSONObject request = new JSONObject();
        request.put("name","Emad");
        request.put("job","Instructor");
        System.out.println(request.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void testPatch(){
        baseURI ="https://reqres.in";
        JSONObject request = new JSONObject();
        request.put("name","Emad");
        request.put("job","Instructor");
        System.out.println(request.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).log().all();
    }
    @Test
    public void testDelete(){
        baseURI ="https://reqres.in";

        given().
                when().
                delete("/api/users/2").
                then().
                statusCode(204).log().all();
    }
}
