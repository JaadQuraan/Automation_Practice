package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class DynamicControls extends TestBase {
    @Test
    public void remove_add() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://loopcamp.vercel.app/dynamic-controls.html");

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if(!checkbox.isSelected()){
            checkbox.click();
        }
        //starts as a remove button to remove the checkbox then becomes add button
        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        button.click();
        Thread.sleep(4000);
        WebElement gone = driver.findElement(By.xpath("//p[@id='message']"));
        String expected = "It's gone!";
        String actual = gone.getText();
        assertEquals(actual,expected,"It's gone! is NOT displayed");
        button = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        button.click();
        Thread.sleep(4000);
        checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        assertTrue(checkbox.isDisplayed(),"Checkbox is NOT displayed");
    }
    @Test
    public void enable_disable() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/dynamic-controls.html");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();
        Thread.sleep(4000);
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));
        String expected = "It's enabled!";
        String actual = message.getText();
        assertEquals(actual,expected,"It's enabled! message is NOT displayed");
        inputBox.sendKeys("Loopcamp");
        button = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();
        Thread.sleep(4000);
        message = driver.findElement(By.xpath("//p[@id='message']"));
        expected = "It's disabled!";
        actual = message.getText();
        assertEquals(actual,expected,"It's disabled! message is NOT displayed");


    }
}
