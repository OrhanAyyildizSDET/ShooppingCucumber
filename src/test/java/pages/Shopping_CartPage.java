package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Shopping_CartPage {
    public Shopping_CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[text() = 'Shopping Cart']")
    public WebElement shoppingCartDisplay;
    @FindBy(xpath = "//a[text() = 'Proceed To Checkout']")
    public WebElement proceedToCheckout;
    @FindBy(css = "(//li[@class='address_city address_state_name address_postcode'])[1]")
    public WebElement shoppingAddress;
    @FindBy(css = "(//li[@class='address_city address_state_name address_postcode'])[2]")
    public WebElement shoppingAddressCheck;
    @FindBys({
            @FindBy(xpath = "//ul[@class = 'address item box']//li")
    })
    public List<WebElement> address1;
    @FindBys({
            @FindBy(xpath = "//ul[@class = 'address alternate_item box']//li")
    })
    public List<WebElement> address2;
    @FindBy(css = "[href = '/logout']")
    public WebElement logout;
}
