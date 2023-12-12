package test.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.utilities.WebDriverFactory;

public class Practice1 {

    WebDriver driver;
    String pageURL = "";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }

}
