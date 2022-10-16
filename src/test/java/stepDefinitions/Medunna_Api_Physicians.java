package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.MedunnaPhysiciansPojo;

import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.TextReader.saveApiPhysicians;


public class Medunna_Api_Physicians {
    MedunnaPhysiciansPojo[] physiciansPojo;
    Response response;
    @Given("admin send the request for physicians data")
    public void admin_send_the_request_for_physicians_data() {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON
        ).when().get(ConfigReader.getProperty("medunna_endpoint_allPhysicians"));
    }
    @Given("admin deserialization the physicians data to java")
    public void admin_deserialization_the_physicians_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        physiciansPojo = obj.readValue(response.asString(), MedunnaPhysiciansPojo[].class);
        System.out.println(physiciansPojo.length);
    }
    @Then("admin saves users data correspondent files to validate")
    public void admin_saves_users_data_correspondent_files_to_validate() {
        saveApiPhysicians(physiciansPojo);
        boolean flag = false;
        for (MedunnaPhysiciansPojo ssn : physiciansPojo) {
            if (ssn.toString().contains("829-24-5659")){
                flag = true;
                break;
            }
        }
    }
}
