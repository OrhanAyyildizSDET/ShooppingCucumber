package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.Google;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleStepDefinitions {
    Google google = new Google();
    @Given("user should go to the google page")
    public void user_should_go_to_the_google_page() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigReader.getProperty("url_google"));
    }
    @Given("user search for iPhone")
    public void user_search_for_i_phone() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("do iphone {int} search")
    public void do_iphone_search(Integer int1) {
        google.searchBox.sendKeys("Iphone 13"+ Keys.ENTER);
        // Write code here that turns the phrase above into concrete actions
        assertTrue(false);
    }
    @Then("user should see results")
    public void user_should_see_results() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(Driver.getDriver().getTitle().contains("Iphone 13"));
    }
    @Then("close the window")
    public void close_the_window() {
        // Write code here that turns the phrase above into concrete actions
        Driver.closeDriver();
    }

    @When("do teapot search")
    public void do_teapot_search() {
        // Write code here that turns the phrase above into concrete actions
        google.searchBox.sendKeys("TeaPot"+ Keys.ENTER);
    }
    @Then("verify the title contains the Teapot")
    public void verify_the_title_contains_the_teapot() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(Driver.getDriver().getTitle().contains("TeaPot"));
    }
    @Given("user should go to URL {string}")
    public void user_should_go_to_url(String string) {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(string);
    }
    @Given("user search for {string} on the google")
    public void user_search_for_car_on_the_google(String string) {
        // Write code here that turns the phrase above into concrete actions
        google.searchBox.sendKeys(string+Keys.ENTER);
    }
    @Then("verify that page title contains {string}")
    public void verify_that_page_title_contains(String string) {
        // Write code here that turns the phrase above into concrete actions

        assertTrue(Driver.getDriver().getTitle().contains(string));
    }
    @Then("close the application")
    public void close_the_application() {
        // Write code here that turns the phrase above into concrete actions
        Driver.closeDriver();
    }
    @Given("user is on the google page")
    public void user_is_on_the_google_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify test case fails")
    public void verify_test_case_fails() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(false);
    }

}
