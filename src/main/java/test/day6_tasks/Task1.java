package test.day6_tasks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class Task1 extends TestBase {

    @Test
    public void buttonAlert(){
        Driver.getDriver().get("https://demoqa.com/alerts");
        WebElement buttonClick = Driver.getDriver().findElement(By.xpath("//button[@id='alertButton']"));
        buttonClick.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        }
    @Test
    public void buttonFiveSeconds() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        WebElement buttonClick = Driver.getDriver().findElement(By.xpath("//button[@id='timerAlertButton']"));
        buttonClick.click();
        Thread.sleep(5000);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }
    @Test
    public void buttonConfirm() {
        Driver.getDriver().get("https://demoqa.com/alerts");
        WebElement buttonClick = Driver.getDriver().findElement(By.xpath("//button[@id='confirmButton']"));
        buttonClick.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//span[@id='confirmResult']"));
        String expected = "You selected Ok";
        String actual = successMessage.getText();
        assertEquals(actual,expected,"The " + actual + "text does not match the expected text of: " + expected);
    }
    @Test
    public void promptButton() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        WebElement buttonClick = Driver.getDriver().findElement(By.xpath("//button[@id='promtButton']"));
        buttonClick.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("Loop Academy");
        alert.accept();
        Thread.sleep(2000);
        WebElement message = Driver.getDriver().findElement(By.xpath("//span[@id='promptResult']"));
        String expected = "You entered Loop Academy";
        String actual = message.getText();
        assertEquals(actual,expected,"The " + actual + "text does not match the expected text of: " + expected);
    }

    }
