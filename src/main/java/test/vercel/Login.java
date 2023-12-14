package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

public class Login {

    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/login.html";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @Test
    public void test (){

    WebElement userBox = driver.findElement(By.xpath("//input[@id='username']"));
    WebElement passwordBox = driver.findElement(By.xpath("//input[@id='password']"));
    userBox.clear();
    userBox.sendKeys("tomsmith");
    passwordBox.clear();
    passwordBox.sendKeys("SuperSecretPassword");
    WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
    loginButton.click();
    WebElement successMessage = driver.findElement(By.xpath("//div[@role='alert']"));
    String actual = successMessage.getText();
    String expected = "You logged into a secure area!";
    assertEquals(actual,expected,"Login message not displayed. Incorrect username and/or password");
    }
    @AfterMethod
    public void teardownMethod() {
    //    driver.close();
    }

}
