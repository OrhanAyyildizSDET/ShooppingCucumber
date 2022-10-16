package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Medunna_HomePage {
    public Medunna_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "account-menu")
    public WebElement accountMenu;
    @FindBy(id = "login-item")
    public WebElement loginButton;
    @FindBy(css = "[placeholder = 'Your username']")
    public WebElement userName;
    @FindBy(css = "[placeholder = 'Your password']")
    public WebElement password;
    @FindBy(xpath = "(//div[@class = 'modal-footer']/button)[2]")
    public WebElement signInButton;
    @FindBy(xpath = "//li[@id = 'entity-menu']/a")
    public WebElement itemMenu;
    @FindBy(css = "[href= '/room'][class]")
    public WebElement room;
}
