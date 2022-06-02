package AT.hw_8;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class jsonPlaceHolderTests extends BaseTest {

    @Test
    public void getRequestTest1() {
        given()
                .when()
                .get("albums")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getRequestTest2() {
        given()
                .when()
                .get("albums")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat().contentType("application/json; charset=utf-8");
    }

    @Test
    public void getRequestTest3() {
        given()
                .when()
                .get("albums")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat().body("", hasSize(100));
    }

    @Test
    public void getRequestTest4() {
        given()
                .when()
                .get("albums/1")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat().body(containsString("userId"))
                .body(containsString("id"))
                .body(containsString("title"));
    }

    @Test
    public void postRequestTest5() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("userId", "1");
        jsonMap.put("title", "test album");
        given()
                .body(jsonMap)
                .when()
                .post("albums")
                .then()
                .log().all()
                .statusCode(201)
                .assertThat().body(notNullValue())
                .assertThat().body(containsString("id"));
    }

    @Test
    public void putRequestTest6() {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("userId", "2");
        jsonMap.put("title", "test album update");
        given()
                .body(jsonMap)
                .when()
                .put("albums/2")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat().body("id", hasToString("2"));
    }

    @Test
    public void deleteRequestTest7() {
        given()
                .when()
                .delete("albums/100")
                .then()
                .log().all()
                .assertThat().statusCode(200);
    }
}
