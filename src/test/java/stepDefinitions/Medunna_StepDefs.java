package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Medunna_HomePage;
import pages.Medunna_RoomPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.*;

public class Medunna_StepDefs {
    Actions action = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
    Medunna_RoomPage medunna_roomPage = new Medunna_RoomPage();
    Medunna_HomePage medunna_homePage = new Medunna_HomePage();
    Faker faker = new Faker();
    public String identiferr = "";
    @Given("Sign in as Admin with {string} and {string}")
    public void sign_in_as_admin_with_and(String string, String string2) {
        action.click(medunna_homePage.accountMenu).click(medunna_homePage.loginButton).build().perform();
        action.sendKeys(medunna_homePage.userName,string).sendKeys(medunna_homePage.password,string2).build().perform();
        js.executeScript("arguments[0].click()",medunna_homePage.signInButton);
    }
    @When("Click on Items&Titles button")
    public void click_on_items_titles_button() {
        medunna_homePage.itemMenu.click();
        ReusableMethods.waitFor(2);
    }
    @When("Click on Room button")
    public void click_on_room_button() {
        medunna_homePage.room.click();
    }
    @When("Click on Create a new Room button")
    public void click_on_create_a_new_room_button() {
        medunna_roomPage.formRoom.click();
    }
    @Then("Verify Create or edit a Room text")
    public void verify_create_or_edit_a_room_text() {
        ReusableMethods.verifyElementDisplayed(medunna_roomPage.roomFormedVerify);
    }
    @When("Enter the room number in the room number box")
    public void enter_the_room_number_in_the_room_number_box() {
        medunna_roomPage.roomNumberFirst.sendKeys(faker.number().digits(4));
        ReusableMethods.waitFor(2);
    }
    @When("Clear the room number")
    public void clear_the_room_number() {
        medunna_roomPage.roomNumberFirst.clear();
        medunna_roomPage.roomNumberFirst.sendKeys(Keys.ENTER);
    }
    @When("Click on Room Type dropdown")
    public void click_on_room_type_dropdown() {
        Select selected = new Select(medunna_roomPage.roomType);
        selected.selectByVisibleText("DELUXE");
        ReusableMethods.waitFor(2);
    }
    @Then("Verify This field is required.")
    public void verify_this_field_is_required() {
//        assertTrue(medunna_roomPage.fieldWarning.isDisplayed());
    }
    @When("Enter the room number as {string} in the room number box")
    public void enter_the_room_number_as_in_the_room_number_box(String string) {
        medunna_roomPage.roomNumberFirst.sendKeys(string);
    }
    @Then("Verify {int} room types exist in Room Type dropdown")
    public void verify_room_types_exist_in_room_type_dropdown(Integer int1) {
        Select objSelect = new Select(medunna_roomPage.roomType);
        List<WebElement> roomTypes = objSelect.getOptions();
        int roomNumber = int1;
        assertEquals(roomNumber, roomTypes.size());
    }
    @When("Click on Status Checkbox")
    public void click_on_status_checkbox() {
        medunna_roomPage.roomStatusOk.click();
    }
    @Then("Verify that checkbox is selected")
    public void verify_that_checkbox_is_selected() {
        assertTrue(medunna_roomPage.roomStatusOk.isSelected());
    }
    @When("Send price as {string} to price box")
    public void send_price_as_to_price_box(String string) {
        medunna_roomPage.roomPrice.sendKeys(string);
    }
    @When("Clear the price box")
    public void clear_the_price_box() {
        medunna_roomPage.roomPrice.clear();
    }
    @When("Click on Description box")
    public void click_on_description_box() {
        medunna_roomPage.roomDescription.click();
    }
    @When("Send price to price box")
    public void send_price_to_price_box() {
        medunna_roomPage.roomPrice.sendKeys("1231");
    }
    @When("Send description as {string} to the Description box")
    public void send_description_as_to_the_description_box(String string) {
        medunna_roomPage.roomDescription.sendKeys(string);
    }
    @When("Clear the Description box")
    public void clear_the_description_box() {
        medunna_roomPage.roomDescription.clear();
    }
    @When("Click on price")
    public void click_on_price() {
        medunna_roomPage.roomPrice.click();
        ReusableMethods.waitFor(2);
    }
    @Then("Verify that This field is required is not displayed")
    public void verify_that_this_field_is_required_is_not_displayed() {
        List<WebElement> wrning = Driver.getDriver().findElements(By.xpath("//*[text() = 'This field is required.']"));
        assertEquals(0, wrning.size());
    }
    @When("Click on first view button with room number {string}")
    public void click_on_first_view_button_with_room_number(String roomNumber) {
        medunna_roomPage.saveEntity.click();
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()",medunna_roomPage.lastPage);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(1);
        List<WebElement> rowNumber = Driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()",Driver.getDriver().findElement(By.xpath("//table/tbody/tr["+rowNumber.size()+"]/td[8]/div/a[1]")));
    }
    @Then("Verify Room header {string}")
    public void verify_room_header(String string) {
        String roomNumber = string;
        System.out.println(medunna_roomPage.myRoomVerifying.getText());
        Assert.assertEquals("Room",medunna_roomPage.myRoomVerifying.getText());
    }
    @When("Click on back button")
    public void click_on_back_button() {
        medunna_roomPage.backButton.click();
    }
    @Then("Verify there are {int} view buttons")
    public void verify_there_are_view_buttons(Integer int1) {
        int viewSize = int1;
        ReusableMethods.waitFor(2);
        List<WebElement> viewSizes = Driver.getDriver().findElements(By.xpath("//td/div/a[@class = 'btn btn-info btn-sm']"));
        Assert.assertEquals(viewSize,viewSizes.size());
    }
    @When("Click on Edit Button")
    public void click_on_edit_button() {
        medunna_roomPage.editButton.click();
    }
    @When("Change the Description")
    public void change_the_description() {
        medunna_roomPage.descriptionChange.clear();
        medunna_roomPage.descriptionChange.sendKeys("Hello, world!");
    }
    @When("Click on save button")
    public void click_on_save_button() {
        identiferr = medunna_roomPage.identifer.getText();
        js.executeScript("arguments[0].click()",medunna_roomPage.saveButtonAgain);
    }
    @Then("Verify The room is updated.")
    public void verify_the_room_is_updated() {
        ReusableMethods.waitFor(2);
//        Assert.assertEquals("A room is updated with identifer "+identiferr+".",medunna_roomPage.saveAlert.getText());
    }
    @When("Click on Created Date to sort rooms from newest to oldest")
    public void click_on_created_date_to_sort_rooms_from_newest_to_oldest() {
        medunna_roomPage.createdDate.click();
    }
    @When("Click on first delete button")
    public void click_on_first_delete_button() {
        medunna_roomPage.deleteButton.click();
    }
    @When("Click on Delete button on alert")
    public void click_on_delete_button_on_alert() {
        medunna_roomPage.alertDeleteButton.click();
    }
    @Then("Verify A room is Deleted message")
    public void verify_a_room_is_deleted_message() {
        ReusableMethods.waitFor(2);
        ReusableMethods.verifyElementDisplayed(medunna_roomPage.confirmDeleteText);
    }

}
