package test.demoqa;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class Alerts extends TestBase {

    @Test
    public void testInformationalAlert() {
        Driver.getDriver().get("https://demoqa.com/alerts");
        // WebElement button1 = Driver.getDriver().findElement(By.cssSelector("#alertButton"));
        WebElement button1 = Driver.getDriver().findElement(By.xpath("//button[@id='alertButton']"));

        button1.click();
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test
    public void testWaitFiveAlert() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@id='timerAlertButton']"));
        button.click();
        Thread.sleep(5000);
        Driver.getDriver().switchTo().alert().accept();
    }
    @Test
    public void testConfirmAlert() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@id='confirmButton']"));
        button.click();
        Driver.getDriver().switchTo().alert().accept();
        button.click();
        Driver.getDriver().switchTo().alert().dismiss();

    }
    @Test
    public void testPrompt() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/alerts");
        String message = "loopcamp";
        WebElement promptButton = Driver.getDriver().findElement(By.xpath("//button[@id='promtButton']"));
        promptButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(message);
        alert.accept();

        WebElement result = Driver.getDriver().findElement(By.xpath("//span[@id='promptResult']"));
        String actual = result.getText();
        Assert.assertTrue(actual.contains(message),"Actual does not contain " + message);
    }
}