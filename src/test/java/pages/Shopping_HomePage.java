package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Shopping_HomePage {
    public Shopping_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "[href = '/login']")
    public WebElement signup;
    @FindBy(xpath = "//b")
    public WebElement myLoginName;
    @FindBy(xpath = "(//a[@data-product-id = '1'])[1]")
    public WebElement product1;
    @FindBy(xpath = "(//a[@data-product-id = '2'])[1]")
    public WebElement product2;
    @FindBy(xpath = "(//a[@data-product-id = '3'])[1]")
    public WebElement product3;
    @FindBy(css = "[data-dismiss = 'modal']")
    public WebElement continueShoppingButton;
    @FindBy(xpath = "//li/a[@href = '/view_cart']")
    public WebElement shoppingCart;
    @FindBy(xpath = "//div[2]/div[1]/div[2]/div/div[1]/div[1]")
    public WebElement product1Hover;
    @FindBy(xpath = "//div[2]/div[1]/div[3]/div/div[1]/div[1]")
    public WebElement product2Hover;
    @FindBy(xpath = "//div[2]/div[1]/div[5]/div/div[1]/div[1]")
    public WebElement product3Hover;
}
