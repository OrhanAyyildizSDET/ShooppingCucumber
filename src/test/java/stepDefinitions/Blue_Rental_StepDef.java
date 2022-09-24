package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BlueRental_HomePage;
import pages.BlueRental_LoginPage;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Blue_Rental_StepDef {
    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
    @When("user navigate to login page")
    public void user_navigate_to_login_page() {
        // Write code here that turns the phrase above into concrete actions
        blueRentalHomePage.clickOnLogin();
    }
    @When("user enters username as {string} and password as {string} and click on login button")
    public void user_enters_username_as_and_password_as_and_click_on_login_button(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        blueRentalLoginPage.email.sendKeys(string);
        blueRentalLoginPage.password.sendKeys(string2);
        blueRentalLoginPage.loginButton.click();
    }
    @Then("verify the login is successful")
    public void verify_the_login_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
    }
    @When("user enters manager_username and manager_password")
    public void user_enters_manager_username_and_manager_password(DataTable credentials) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
       //************************************************************************//
        //1. get the feature data as a list
//        List<String> customer_credential = credentials.row(1);//row number start at from 1
//        System.out.println("name:"+customer_credential.get(0));
//        System.out.println("password:"+customer_credential.get(1));
//        blueRentalLoginPage.email.sendKeys(customer_credential.get(0));
//        blueRentalLoginPage.password.sendKeys(customer_credential.get(1));
//        blueRentalLoginPage.loginButton.click();
        //2. get the feature data as List<Map<String,String>>
        List<Map<String,String>> customer_credential01 = credentials.asMaps(String.class,String.class);
        for (Map<String,String> value : customer_credential01) {
            blueRentalLoginPage.email.sendKeys(value.get("username"));
            blueRentalLoginPage.password.sendKeys(value.get("password"));
            ReusableMethods.waitFor(2);
            blueRentalLoginPage.loginButton.click();
        }
    }
}
