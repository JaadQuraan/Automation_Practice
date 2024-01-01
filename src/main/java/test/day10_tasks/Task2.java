package test.day10_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

import static org.testng.Assert.assertEquals;

public class Task2 {
    @Test
    public void dragOutsideTarget(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vercel.drag"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement logo = Driver.getDriver().findElement(By.xpath("//img[@src='./img/logo.svg']"));
        Actions action = new Actions(Driver.getDriver());
        action.clickAndHold(smallCircle).moveToElement(logo).release().perform();
        String actual = bigCircle.getText();
        String expected = "Try again!";
        assertEquals(actual,expected, "The actual message: " + actual + " does not match the expected: " + expected);
        Driver.closeDriver();
    }
}
