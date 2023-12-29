package test.vercel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

/*
Warning/information
Confirmation
Prompt
accept() dismiss() sendKeys()
 */
public class JSAlerts extends TestBase {
    @Test
    public void testInformationButton(){
        Driver.getDriver().get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement informationButton = Driver.getDriver().findElement(By.xpath("//button[contains(text(),'JS Alert')]"));
        informationButton.click();
        Driver.getDriver().switchTo().alert().accept();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = result.getText();
        assertEquals(actual,expected,"Alert not handled");
        }
    @Test
    public void testConfirmButton(){
        Driver.getDriver().get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement confirmButton = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmButton.click();
        Driver.getDriver().switchTo().alert().accept();
        WebElement result = Driver.getDriver().findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        String expected = "You clicked: Ok";
        String actual = result.getText();
        assertEquals(actual,expected,"Alert not handled");
        confirmButton.click();
        Driver.getDriver().switchTo().alert().dismiss();
        result = Driver.getDriver().findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        expected = "You clicked: Cancel";
        actual = result.getText();
        assertEquals(actual,expected,"Alert not handled");
    }
    @Test
    public void testPrompt(){
        Driver.getDriver().get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement promptButton = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("loopcamp");
        alert.accept();
        WebElement result = Driver.getDriver().findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        String expected = "You entered:";
        String actual = result.getText();
        assertTrue(actual.contains(expected),"You did not enter anything in the prompt");
        promptButton.click();
        alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();
        result = Driver.getDriver().findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        expected = "You entered: null";
        actual = result.getText();
        assertEquals(actual,expected,"Alert not dismissed");
    }
}

