package APITests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
    @Test
    public void test1()
    {
       // RestAssured.get("https://reqres.in/api/users?page=2");
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Response : "+ response.asString());
        System.out.println("Status code : " + response.getStatusCode());
        System.out.println("Body : "+ response.getBody().asString());
        System.out.println("Time taken : "+ response.getTime());
        System.out.println("Header : "+ response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
