package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
    public static RequestSpecification specification;
    //ignore this @BlueRentalCars tag with Assume.assumeTrue(false)
    @Before(value = "@BlueRentalCars")
    public void setUp(Scenario scenario){
        System.out.println("Before hooks");
        Assume.assumeTrue(false);
        System.out.println("Skipped scenario is " + scenario.getName());
    }

    @Before(value = "@tokenApi")
    public void medunnaUrlSetup(){
        specification = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url_medunna")).build();
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","failed_scenario");
        }
        else {
            System.out.println("After hooks");
        }
    }
}
