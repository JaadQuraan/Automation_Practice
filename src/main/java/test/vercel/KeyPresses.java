package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class KeyPresses extends TestBase {
    @Test
    public void testKeyPress(){
        driver.get("https://loopcamp.vercel.app/key-presses.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement promptText = driver.findElement(By.xpath("//div[@class='example']/p"));
        String actual = promptText.getText();
        String expected = "Key presses are often used to interact with a website";
        System.out.println(actual);
        Actions actions = new Actions(driver);
        actions.sendKeys("j").perform();
        assertTrue(actual.contains(expected));
        WebElement result = driver.findElement(By.xpath("//*[contains(text(),You)]"));
        String expectedResult = "You entered: ";
        String actualResult = result.getText();
        System.out.println(actualResult);
        assertTrue(actualResult.contains(expectedResult),"Actual does not contain expected, no key was pressed");
    }
}
