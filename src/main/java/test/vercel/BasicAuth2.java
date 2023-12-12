package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

public class BasicAuth2 {
    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/basic-auth.html";
    @Test
    public void  main() {
        String urlWithCredentials = "https://admin:admin@loopcamp.vercel.app/basic-auth.html";




        WebElement success = driver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']"));
        System.out.println(success.getText());

        String expectedSuccess = "Congratulations!";

        if(success.getText().contains(expectedSuccess)){
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAIL");
        }

        // Close the browser
        driver.quit();
    }
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


