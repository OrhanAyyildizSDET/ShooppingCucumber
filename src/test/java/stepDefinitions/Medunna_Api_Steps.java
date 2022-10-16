package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Medunna_pojo;
import utilities.ConfigReader;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.TextReader.saveUIRegistrants;


public class Medunna_Api_Steps {
    Medunna_pojo[] registrants;
    Response response;
    @Given("user sends get request for users data")
    public void user_sends_get_request_for_users_data() {
        response = given().headers(
            "Authorization",
                "Bearer " + generateToken(),
                "Content-Type",
                ContentType.JSON,
            "Accept",
        ContentType.JSON
        ).when().get(ConfigReader.getProperty("medunna_endpoint_allUser"));
        response.prettyPrint();

    }
    @Given("user deserialization the users data to java")
    public void user_deserialization_the_users_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        registrants = obj.readValue(response.asString(), Medunna_pojo[].class);
        System.out.println(registrants.length);
    }
    @Then("user saves users data correspondent files to validate")
    public void user_saves_users_data_correspondent_files_to_validate() {
        saveUIRegistrants(registrants);
        boolean flag = false;
        for (Medunna_pojo ssn : registrants) {
            if (ssn.toString().contains("829-24-5659")){
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
        System.out.println(registrants[11].getLastName());
    }

}
