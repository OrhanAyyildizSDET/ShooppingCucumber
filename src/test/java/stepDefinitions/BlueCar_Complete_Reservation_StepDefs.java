package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BlueRental_HomePage;
import pages.BlueRental_LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class BlueCar_Complete_Reservation_StepDefs {
    Faker faker = new Faker();
    Actions action = new Actions(Driver.getDriver());
    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    @Given("user opens the URL {string}")
    public void user_opens_the_url(String string) {
    }
    @When("user navigate the login page")
    public void user_navigate_the_login_page() {
    }
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
    }
    @Given("select a car model {string}")
    public void select_a_car_model(String string) {
        Select select = new Select(blueRentalHomePage.selectACar);
        select.selectByVisibleText(string);
    }
    @Given("enter pick up field")
    public void enter_pick_up_field() {
        blueRentalHomePage.pickUpLocation.sendKeys(Faker.instance(Locale.US).address().city());

    }
    @Given("enter drop off field")
    public void enter_drop_off_field() {
        blueRentalHomePage.dropOfLocation.sendKeys(Faker.instance(Locale.US).address().city());
    }
    @Given("select pick up date")
    public void select_pick_up_date() {
        blueRentalHomePage.pickUpDate.sendKeys("6/18/2088");
        blueRentalHomePage.pickUpTime.sendKeys("12:24AM");
    }
    @Given("select drop off date")
    public void select_drop_off_date() {
        blueRentalHomePage.dropOffDate.sendKeys("6/19/2088");
        blueRentalHomePage.dropOFFTime.sendKeys("12:24PM");
    }

    @Given("click continue reservation")
    public void click_continue_reservation() {

        blueRentalHomePage.continueReservation.click();
    }
    @Given("verify complete reservation screen pops up")
    public void verify_complete_reservation_screen_pops_up() {
        ReusableMethods.waitForVisibility(blueRentalHomePage.completeReservation,3);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.completeReservation);
    }
    @Given("enter card number")
    public void enter_card_number() {
        action.doubleClick(blueRentalHomePage.cardNo).sendKeys(blueRentalHomePage.cardNo,faker.number().digits(16)).build().perform();
    }
    @Given("enter name on the card")
    public void enter_name_on_the_card() {
        blueRentalHomePage.nameOnCard.sendKeys(faker.name().fullName());
    }
    @Given("enter expire date and CVC")
    public void enter_expire_date_and_cvc() {
        action.doubleClick(blueRentalHomePage.expireDate).sendKeys(blueRentalHomePage.expireDate,"12/24").build().perform();
        action.doubleClick(blueRentalHomePage.cvc).sendKeys(blueRentalHomePage.cvc,faker.number().digits(3)).build().perform();
    }
    @Given("checks the agreement")
    public void checks_the_agreement() {
        blueRentalHomePage.contractAgreement.click();
    }
    @Given("click complete reservation")
    public void click_complete_reservation() {
        blueRentalHomePage.completeContract.click();
    }
    @Then("verify {string} pop up")
    public void verify_pop_up(String string) {
        ReusableMethods.waitFor(3);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.reservationCompleted);
//        ReusableMethods.waitFor(2);
//        assertTrue(Driver.getDriver().findElement(By.xpath("//*[contains (text(),"+string+")]")).isDisplayed());
    }

}
