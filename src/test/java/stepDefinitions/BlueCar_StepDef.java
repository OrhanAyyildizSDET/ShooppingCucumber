package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlueRentalCar;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class BlueCar_StepDef {
    BlueRentalCar blueRentalCar = new BlueRentalCar();
    @Given("user go to the blue rental car site")
    public void user_go_to_the_blue_rental_car_site() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigReader.getProperty("url_Blue_Car"));
    }
    @When("user click the login button")
    public void user_click_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        ReusableMethods.waitForVisibility(blueRentalCar.login,2).click();
    }
    @When("user enters true credential")
    public void user_enters_true_credential() {
        // Write code here that turns the phrase above into concrete actions
        blueRentalCar.email.sendKeys(ConfigReader.getProperty("Blue_Car_Username3"));
        blueRentalCar.password.sendKeys(ConfigReader.getProperty("Blue_Car_Password3"));
    }
    @When("user click the login button again")
    public void user_click_the_login_button_again() {
        // Write code here that turns the phrase above into concrete actions
        blueRentalCar.loginEnter.click();
    }
    @Then("verify user is in user page")
    public void verify_user_is_in_user_page() {
        // Write code here that turns the phrase above into concrete actions
        ReusableMethods.waitForVisibility(blueRentalCar.customerDropDown,2);
        ReusableMethods.verifyElementDisplayed(blueRentalCar.customerDropDown);
    }
}
