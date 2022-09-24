package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRental_LoginPage {
    public BlueRental_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "formBasicEmail")
    public WebElement email;
    @FindBy(id = "formBasicPassword")
    public WebElement password;
    @FindBy(css = "[type = 'submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div[4]/div/div/div/div/form/div[1]/div")
    public WebElement errorMessage;
}

