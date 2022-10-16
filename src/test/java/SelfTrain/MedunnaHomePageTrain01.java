package SelfTrain;

import com.beust.ah.A;
import com.google.gson.annotations.Until;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

import static org.bouncycastle.cms.RecipientId.password;

public class MedunnaHomePageTrain01 {
    @Test
    public void test(){
        Driver.getDriver().get("https://www.medunna.com/account/register");
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        List<WebElement> colors = wait.until(ExpectedConditions.visibilityOfAllElements(Driver.getDriver().findElements(By.cssSelector("li[class = 'point']"))));
        System.out.println(colors.get(0).getCssValue("background-color"));
        Assert.assertEquals("rgba(255, 0, 0, 1)", colors.get(0).getCssValue("background-color"));
        for (WebElement element : colors) {
            System.out.println(element.getCssValue("background-color"));
        }
        try {
            boolean passwordWarning = Driver.getDriver().findElement(By.xpath("//div[text() = 'Your password is required to be at least 4 characters.']")).isDisplayed();
            System.out.println(passwordWarning);
            Assert.assertFalse(passwordWarning);
        }catch (WebDriverException e) {
            Assert.assertFalse(false);
        }
    }
}
