package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCar {
    public BlueRentalCar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/div[2]/ul/li[5]/a")
    public WebElement login;
    @FindBy(css = "[name= 'email']")
    public WebElement email;
    @FindBy(css = "[name= 'password']")
    public WebElement password;
    @FindBy(css = "[type= 'submit']")
    public WebElement loginEnter;
    @FindBy(id = "dropdown-basic-button")
    public WebElement customerDropDown;
}
