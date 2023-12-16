package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

public class FormAuthentication extends TestBase {
    @Test
    public void login (){
        driver.get("https://loopcamp.vercel.app/login.html");
        WebElement header = driver.findElement(By.xpath("//h2"));
        String expectedHeader = "Login Page";
        String actualHeader = header.getText();
        assertEquals(actualHeader,expectedHeader, "Correct header is not displayed");

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));

        Actions actions = new Actions(driver);
        actions.sendKeys(username,"tomsmith").sendKeys(password,"SuperSecretPassword").sendKeys(Keys.ENTER).perform();
        WebElement result = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        String expectedResult = "You logged into a secure area!";
        String actualResult = result.getText();
        assertEquals(actualResult,expectedResult,"Login failed, please try again");
    }
}
