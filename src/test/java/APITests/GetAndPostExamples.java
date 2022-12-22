package APITests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static       org.hamcrest.Matchers.*;

public class GetAndPostExamples {
    @Test
    public void testGet(){
        baseURI ="https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).
                body("data[4].first_name",equalTo("George")).
                body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void testPost(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","Emad");
        map.put("job","Instructor");
        System.out.println(map);
        JSONObject request = new JSONObject(map);
        System.out.println(request.toJSONString());
}
    @Test
    public void testPost1(){
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
                post("/users").
                then().
                statusCode(201).log().all();
    }
}
