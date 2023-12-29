package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class KeyPresses  {
    @Test
    public void testKeyPress(){
        Driver.getDriver().get("https://loopcamp.vercel.app/key-presses.html");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement promptText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        String actual = promptText.getText();
        String expected = "Key presses are often used to interact with a website";
        System.out.println(actual);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys("j").perform();
        assertTrue(actual.contains(expected));
        WebElement result = Driver.getDriver().findElement(By.xpath("//*[contains(text(),You)]"));
        String expectedResult = "You entered: ";
        String actualResult = result.getText();
        System.out.println(actualResult);
        assertTrue(actualResult.contains(expectedResult),"Actual does not contain expected, no key was pressed");
    }
}
