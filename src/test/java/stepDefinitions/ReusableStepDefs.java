package stepDefinitions;

import io.cucumber.java.en.Then;
import utilities.ReusableMethods;

import java.io.IOException;

public class ReusableStepDefs {
    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        ReusableMethods.getScreenshot("Capture_Screenshot");
    }
}
