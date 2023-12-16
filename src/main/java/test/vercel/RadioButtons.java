package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class RadioButtons extends TestBase {
    @Test
    public void testColors(){
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        WebElement blueButton = driver.findElement(By.xpath("//input[@id='blue']"));
        WebElement redButton = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement yellowButton = driver.findElement(By.xpath("//input[@id='yellow']"));
        WebElement blackButton = driver.findElement(By.xpath("//input[@id='black']"));
        redButton.click();
        assertTrue(redButton.isSelected(),"Red is not selected");
        //assertTrue(blackButton.isSelected(),"Black is not selected");
    }
    @Test
    public void testSports (){
        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        WebElement basketball = driver.findElement(By.xpath("//input[@id='basketball']"));
        WebElement Football = driver.findElement(By.xpath("//input[@id='football']"));
        WebElement Hockey = driver.findElement(By.xpath("//input[@id='hockey']"));
        WebElement WaterPolo = driver.findElement(By.xpath("//input[@id='water_polo']"));

        basketball.click();
        assertTrue(basketball.isSelected(),"Basketball is not selected");

    }
}
