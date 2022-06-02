package AT.hw_8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public abstract class BaseTest {

    @BeforeMethod
    public void configureRestAssured() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/";
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON).accept(ContentType.JSON);
    }
}
