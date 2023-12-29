package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

public class Login {

    @Test
    public void test() {
        Driver.getDriver().get("https://loopcamp.vercel.app/login.html");
        WebElement userBox = Driver.getDriver().findElement(By.xpath("//input[@id='username']"));
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        userBox.clear();
        userBox.sendKeys("tomsmith");
        passwordBox.clear();
        passwordBox.sendKeys("SuperSecretPassword");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        String actual = successMessage.getText();
        String expected = "You logged into a secure area!";
        assertEquals(actual, expected, "Login message not displayed. Incorrect username and/or password");
    }
}
