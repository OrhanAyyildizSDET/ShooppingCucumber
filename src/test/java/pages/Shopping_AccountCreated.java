package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Shopping_AccountCreated {
    public Shopping_AccountCreated(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//b[. = 'Account Created!']")
    public WebElement createAccountSuccess;
    @FindBy(linkText = "Continue")
    public WebElement continueButton;

}
