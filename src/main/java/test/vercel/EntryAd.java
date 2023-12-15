package test.vercel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.utilities.WebDriverFactory;

public class EntryAd {

    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/entry-ad.html#";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @AfterMethod
    public void teardownMethod() {
       // driver.close();
    }

}
