package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class DynamicControls {
    @Test
    public void remove_add() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().get("https://loopcamp.vercel.app/dynamic-controls.html");

        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        //starts as a remove button to remove the checkbox then becomes add button
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        button.click();
        Thread.sleep(4000);
        WebElement gone = Driver.getDriver().findElement(By.xpath("//p[@id='message']"));
        String expected = "It's gone!";
        String actual = gone.getText();
        assertEquals(actual,expected,"It's gone! is NOT displayed");
        button = Driver.getDriver().findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        button.click();
        Thread.sleep(4000);
        checkbox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        assertTrue(checkbox.isDisplayed(),"Checkbox is NOT displayed");
    }
    @Test
    public void enable_disable() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/dynamic-controls.html");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();
        Thread.sleep(4000);
        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        WebElement message = Driver.getDriver().findElement(By.xpath("//p[@id='message']"));
        String expected = "It's enabled!";
        String actual = message.getText();
        assertEquals(actual,expected,"It's enabled! message is NOT displayed");
        inputBox.sendKeys("Loopcamp");
        button = Driver.getDriver().findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();
        Thread.sleep(4000);
        message = Driver.getDriver().findElement(By.xpath("//p[@id='message']"));
        expected = "It's disabled!";
        actual = message.getText();
        assertEquals(actual,expected,"It's disabled! message is NOT displayed");


    }
}
