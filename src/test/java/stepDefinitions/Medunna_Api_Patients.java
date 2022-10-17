package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.MedunnaPhysiciansPojo;
import pojo.Medunna_Patients_FullPacket;
import pojo.Medunna_Patients_Pojo;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.TextReader.saveApiPatients;
import static utilities.TextReader.saveApiPhysicians;

public class Medunna_Api_Patients {
    Medunna_Patients_FullPacket[] patientsPojos;    Response response;
    @Given("admin send the request for patients data")
    public void admin_send_the_request_for_patients_data() {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON
        ).when().get(ConfigReader.getProperty("medunna_endpoint_allPatients"));
    }
    @Given("admin deserialization the patients data to java")
    public void admin_deserialization_the_patients_data_to_java() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        patientsPojos = obj.readValue(response.asString(), Medunna_Patients_FullPacket[].class);
        System.out.println(patientsPojos.length);
    }
    @Then("admin saves patients data correspondent files to validate")
    public void admin_saves_patients_data_correspondent_files_to_validate() {
        saveApiPatients(patientsPojos);
        for (int i = 0; i < patientsPojos.length; i++) {
            System.out.println(patientsPojos[i].getInPatients());
        }
        System.out.println(patientsPojos[11].getBloodGroup());
    }
}
