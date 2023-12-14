package test.vercel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;
/*
default
    top
        left
        middle
        right
 */
public class NestedFrames {

    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/nested-frames.html";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @Test
    public void test(){




    }

    @AfterMethod
    public void teardownMethod() {
       // driver.close();
    }

}
