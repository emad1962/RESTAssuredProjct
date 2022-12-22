package APITests;

import io.restassured.matcher.RestAssuredMatchers;
import org.apache.commons.io.IOUtils;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class xmlSchemaValidation {
    @Test
    public void schemaValidation() throws IOException {
        File file = new File("./SoapRequest/add.xml");
        if (file.exists())
            System.out.println("file exist");

        FileInputStream fileInputStream = new FileInputStream(file );
        String requestBody = IOUtils.toString(fileInputStream,"UTF-8");

        baseURI = "http://dneonline.com";
        given()
                .contentType("text/xml")
                .accept(ContentType.XML)
                .body(requestBody)
                .when()
                .post("/calculator.asmx")
                .then()
                .statusCode(200)
                .log()
                .all()
                .and()
                .body("//*:AddResult.text()",equalTo("5"))
                .and()
                .assertThat()
                .body(RestAssuredMatchers.matchesXsdInClasspath("calculator.xsd"));
    }
}
