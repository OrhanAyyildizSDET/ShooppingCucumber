package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.BlueRental_HomePage;
import pages.BlueRental_LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {
    ExcelUtil excelUtil;
    BlueRental_HomePage blueRentalHomePage = new BlueRental_HomePage();
    BlueRental_LoginPage blueRentalLoginPage = new BlueRental_LoginPage();
    List<Map<String ,String >> testData; //we will store excel data in this java object as a list

    public void login() {
//        going to the url
        Driver.getDriver().get(ConfigReader.getProperty("url_BlueCar"));
//        initializing the pages
//        GOING TO THE LOGIN PAGE FIRST TIME
        try {
            // if there is any exception, then keep going.
            // will be used only at the 1st login since homeLoginButton is available
            blueRentalHomePage.homeLoginButton.click();
        } catch (Exception e) {
        }
//        GOING TO THE LOGIN PAGE AFTER FIRST TIME
        try {
            // if there is any exception, then keep going.
            // will be used AFTER the 1st login since userID is available AFTER the 1st login
//            Logging Out
            ReusableMethods.waitFor(1);
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.homeLoginButton.click();
        } catch (Exception e) {
        }
    }
    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String string) throws IOException {
        //        path of customer sheet
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
//        customer sheet name
        String customerSheet ="customer_info";
//        Use Excel Util
        excelUtil = new ExcelUtil(path,customerSheet);
//        getting the data from the excel using excel util method
        testData=excelUtil.getDataList();
        System.out.println(testData);
        for (Map<String ,String> eachData: testData){
            login();
//            Not that we are on login page, we can send username, password, and click on login button
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.email.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
//            Asserting making sure login is successful
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.getScreenshot(eachData.get("username"));
        }
    }
}
