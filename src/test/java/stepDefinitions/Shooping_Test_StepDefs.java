package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Shopping_AccountCreated;
import pages.Shopping_CartPage;
import pages.Shopping_HomePage;
import pages.Shopping_SignUpPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.*;

public class Shooping_Test_StepDefs {
    Shopping_CartPage shoppingCartPage = new Shopping_CartPage();
    Shopping_HomePage shoppingHomePage = new Shopping_HomePage();
    Shopping_SignUpPage shopping_signUpPage = new Shopping_SignUpPage();
    Shopping_AccountCreated shopping_accountCreated = new Shopping_AccountCreated();
    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
    Faker faker = new Faker();
    @Then("verify that you are in home page")
    public void verify_that_you_are_in_home_page() {
        assertEquals("Automation Exercise",Driver.getDriver().getTitle());
    }
    @When("click on sign up button")
    public void click_on_sign_up_button() {
        shoppingHomePage.signup.click();
    }
    @When("Enter name and email and click on SignUp Button")
    public void enter_name_and_email_and_click_on_sign_up_button() {
        shopping_signUpPage.signEmail.sendKeys(faker.internet().emailAddress());
        shopping_signUpPage.signName.sendKeys(faker.name().firstName());
        shopping_signUpPage.signUpButton.click();
    }
    @When("Fill all details in Signup and create account")
    public void fill_all_details_in_signup_and_create_account() {
        shopping_signUpPage.gender.click();
        shopping_signUpPage.signUpPassword.sendKeys(faker.number().digits(7));
        Select select = new Select(shopping_signUpPage.daysDropDown);
        select.selectByValue("22");
        Select select2 = new Select(shopping_signUpPage.monthDropDown);
        select2.selectByValue("7");
        Select select3 = new Select(shopping_signUpPage.yearsDropDown);
        select3.selectByValue("1991");
        shopping_signUpPage.firstName.sendKeys(faker.name().firstName());
        shopping_signUpPage.lastName.sendKeys(faker.name().lastName());
        shopping_signUpPage.company.sendKeys(faker.company().name());
        shopping_signUpPage.address1.sendKeys(faker.address().streetAddress());
        shopping_signUpPage.address2.sendKeys(faker.address().fullAddress());
        Select select4 = new Select(shopping_signUpPage.countryDropDown);
        select4.selectByVisibleText("United States");
        shopping_signUpPage.state.sendKeys("Washington");
        shopping_signUpPage.city.sendKeys("Washington");
        shopping_signUpPage.zipcode.sendKeys("98001");
        shopping_signUpPage.mobileNumber.sendKeys("123456123213");
        js.executeScript("arguments[0].click()",shopping_signUpPage.createAccount);
    }
    @Then("Verify ACCOUNT CREATED! and click Continue button")
    public void verify_account_created_and_click_continue_button() {
        ReusableMethods.verifyElementDisplayed(shopping_accountCreated.createAccountSuccess);
        shopping_accountCreated.continueButton.click();
    }
    @Then("Verify  Logged in as username at top")
    public void verify_logged_in_as_username_at_top() {
        ReusableMethods.verifyElementDisplayed(shoppingHomePage.myLoginName);
    }
    @When("Add products to cart")
    public void add_products_to_cart() {
        Actions action = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(5);
        action.moveToElement(shoppingHomePage.product1Hover).perform();
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()",shoppingHomePage.product1);
        js.executeScript("arguments[0].click()",shoppingHomePage.continueShoppingButton);
        action.moveToElement(shoppingHomePage.product2Hover).perform();
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()",shoppingHomePage.product2);
        js.executeScript("arguments[0].click()",shoppingHomePage.continueShoppingButton);
        action.moveToElement(shoppingHomePage.product3Hover).perform();
        ReusableMethods.waitFor(2);
        js.executeScript("arguments[0].click()",shoppingHomePage.product3);
        js.executeScript("arguments[0].click()",shoppingHomePage.continueShoppingButton);
    }
    @When("Click Cart button")
    public void click_cart_button() {
        shoppingHomePage.shoppingCart.click();
    }
    @Then("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        ReusableMethods.verifyElementDisplayed(shoppingCartPage.shoppingCartDisplay);
    }
    @When("Click Proceed To Checkout")
    public void click_proceed_to_checkout() {
        shoppingCartPage.proceedToCheckout.click();
    }
    @Then("Verify that the delivery address and billing address are same")
    public void verify_that_the_delivery_address_and_billing_address_are_same() {
        ReusableMethods.waitFor(5);
//        assertEquals(shoppingCartPage.shoppingAddress.getText(),shoppingCartPage.shoppingAddressCheck.getText());
       // List<WebElement> address1 = Driver.getDriver().findElements(By.xpath("//ul[@class = 'address item box']//li"));
        List<WebElement> shoppingAddress = shoppingCartPage.address1;
        List<WebElement> billingAddress = shoppingCartPage.address2;
     //   List<WebElement> address2 = Driver.getDriver().findElements(By.xpath("//ul[@class = 'address alternate_item box']//li"));
        for (var i = 1; i < shoppingAddress.size(); i++) {
            assertEquals(shoppingAddress.get(i).getText(),billingAddress.get(i).getText());
            System.out.println(shoppingAddress.get(i).getText()+"    other address   "+billingAddress.get(i).getText());
        }
    }
    @When("Click logout button")
    public void click_logout_button() {
        shoppingCartPage.logout.click();
    }
    @Then("Verify that user logged out")
    public void verify_that_user_logged_out() {
        ReusableMethods.verifyElementDisplayed(shopping_signUpPage.newUserSignupForVerifying);
    }
    @Then("Close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

}
