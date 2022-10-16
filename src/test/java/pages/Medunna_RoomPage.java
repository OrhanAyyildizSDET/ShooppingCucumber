package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Medunna_RoomPage {
    public Medunna_RoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "jh-create-entity")
    public WebElement formRoom;
    @FindBy(xpath = "//*[text() = 'Create or edit a Room']")
    public WebElement roomFormedVerify;
    @FindBy(css = "[id = 'room-roomNumber']")
    public WebElement roomNumberFirst;
    @FindBy(css = "[id = 'room-roomType']")
    public WebElement roomType;
    @FindBy(id = "room-status")
    public WebElement roomStatusOk;
    @FindBy(xpath = "//*[text() = 'This field is required.']")
    public WebElement fieldWarning;
    @FindBy(id = "room-price")
    public WebElement roomPrice;
    @FindBy(id = "room-description")
    public WebElement roomDescription;
    @FindBy(id = "save-entity")
    public WebElement saveEntity;
    @FindBy(xpath = "(//a[@href = 'javascript:void(0)'])[6]")
    public WebElement lastPage;
    @FindBy(xpath = "//h2/span[. = 'Room']")
    public WebElement myRoomVerifying;
    @FindBy(css = "[class = 'btn btn-info']")
    public WebElement backButton;
    @FindBy(xpath = "//td/div/a[@class = 'btn btn-info btn-sm']")
    public List<WebElement> viewButtons;
    @FindBy(xpath = "(//td/div/a[@class = 'btn btn-primary btn-sm'])[1]")
    public WebElement editButton;
    @FindBy(id = "room-description")
    public WebElement descriptionChange;
    @FindBy(id = "save-entity")
    public WebElement saveButtonAgain;
    @FindBy(id = "room-id")
    public WebElement identifer;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]")
    public WebElement saveAlert;
    @FindBy(xpath = "//*[text() = 'Created Date']")
    public WebElement createdDate;
    @FindBy(xpath = "(//td/div/a[3])[1]")
    public WebElement deleteButton;
    @FindBy(id = "jhi-confirm-delete-room")
    public WebElement alertDeleteButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]")
    public WebElement confirmDeleteText;
}
