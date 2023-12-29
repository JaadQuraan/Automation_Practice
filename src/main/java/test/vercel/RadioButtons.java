package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class RadioButtons {
    @Test
    public void testColors(){
        Driver.getDriver().get("https://loopcamp.vercel.app/radio-buttons.html");
        WebElement blueButton = Driver.getDriver().findElement(By.xpath("//input[@id='blue']"));
        WebElement redButton = Driver.getDriver().findElement(By.xpath("//input[@id='red']"));
        WebElement yellowButton = Driver.getDriver().findElement(By.xpath("//input[@id='yellow']"));
        WebElement blackButton = Driver.getDriver().findElement(By.xpath("//input[@id='black']"));
        redButton.click();
        assertTrue(redButton.isSelected(),"Red is not selected");
        //assertTrue(blackButton.isSelected(),"Black is not selected");
    }
    @Test
    public void testSports (){
        Driver.getDriver().get("https://loopcamp.vercel.app/radio-buttons.html");
        WebElement basketball = Driver.getDriver().findElement(By.xpath("//input[@id='basketball']"));
        WebElement Football = Driver.getDriver().findElement(By.xpath("//input[@id='football']"));
        WebElement Hockey = Driver.getDriver().findElement(By.xpath("//input[@id='hockey']"));
        WebElement WaterPolo = Driver.getDriver().findElement(By.xpath("//input[@id='water_polo']"));

        basketball.click();
        assertTrue(basketball.isSelected(),"Basketball is not selected");

    }
    //check if button or checkbox is enabled using isEnabled() method
}
