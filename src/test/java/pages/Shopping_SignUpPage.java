package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Shopping_SignUpPage {
    public Shopping_SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "[name= 'name']")
    public WebElement signName;
    @FindBy(xpath = "//form[@action= '/signup']/input[@name= 'email']")
    public WebElement signEmail;
    @FindBy(xpath = "//button[text() = 'Signup']")
    public WebElement signUpButton;
    @FindBy(id = "id_gender1")
    public WebElement gender;
    @FindBy(css = "[id = 'password']")
    public WebElement signUpPassword;
    @FindBy(id = "days")
    public WebElement daysDropDown;
    @FindBy(id = "months")
    public WebElement monthDropDown;
    @FindBy(id = "years")
    public WebElement yearsDropDown;
    @FindBy(id = "first_name")
    public WebElement firstName;
    @FindBy(id = "last_name")
    public WebElement lastName;
    @FindBy(id = "company")
    public WebElement company;
    @FindBy(id = "address1")
    public WebElement address1;
    @FindBy(id = "address2")
    public WebElement address2;
    @FindBy(id = "country")
    public WebElement countryDropDown;
    @FindBy(id = "state")
    public WebElement state;
    @FindBy(id = "city")
    public WebElement city;
    @FindBy(id = "zipcode")
    public WebElement zipcode;
    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;
    @FindBy(css = "[data-qa = 'create-account']")
    public WebElement createAccount;
    @FindBy(xpath = "//*[.='New User Signup!']")
    public WebElement newUserSignupForVerifying;
}
