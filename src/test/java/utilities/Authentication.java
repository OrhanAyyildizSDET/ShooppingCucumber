package utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.specification;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){
        specification.pathParams("first","api","second","authenticate");
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("password","1237899");
        expectedData.put("rememberMe",true);
        expectedData.put("username","orhanAdmin86_87");
        Response response = given().spec(specification).contentType(ContentType.JSON).body(expectedData).when().post("{first}/{second}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        ReusableMethods.waitFor(5);
        return json.getString("id_token");
    }
}
