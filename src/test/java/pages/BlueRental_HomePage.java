package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class BlueRental_HomePage {
    public BlueRental_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText = "Login")
    public WebElement homeLoginButton;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;
    @FindBy(linkText = "Logout")
    public WebElement logoutLink;
    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;
    @FindBy(xpath = "//*[@name='car']")
    public WebElement selectACar;
    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pickUpLocation;
    @FindBy(xpath = "//input[@name='dropOfLocation']")
    public WebElement dropOfLocation;
    @FindBy(xpath = "//button[text() = ' CONTINUE RESERVATION']")
    public WebElement continueReservation;
    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickUpDate;
    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickUpTime;
    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOffDate;
    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOFFTime;
    @FindBy(xpath = "//*[.='Complete Reservation']")
    public WebElement completeReservation;
    @FindBy(css = "[name = 'cardNo']")
    public WebElement cardNo;
    @FindBy(css = "[name = 'nameOnCard']")
    public WebElement nameOnCard;
    @FindBy(css = "[name = 'expireDate']")
    public WebElement expireDate;
    @FindBy(css = "[name = 'cvc']")
    public WebElement cvc;
    @FindBy(css = "[name = 'contract']")
    public WebElement contractAgreement;
    @FindBy(css = "[type = 'submit'][class = 'btn btn-primary'] ")
    public WebElement completeContract;
    @FindBy(xpath = "//div[@role='alert']//div")
    public WebElement reservationCompleted;

    public void clickOnLogin(){
        homeLoginButton.click();
    }
}
