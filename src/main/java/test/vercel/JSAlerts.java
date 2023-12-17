package test.vercel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

/*
Warning/information
Confirmation
Prompt
accept() dismiss() sendKeys()
 */
public class JSAlerts extends TestBase {
    @Test
    public void testInformationButton(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement informationButton = driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]"));
        informationButton.click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = result.getText();
        assertEquals(actual,expected,"Alert not handled");
        }
    @Test
    public void testConfirmButton(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement confirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmButton.click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        String expected = "You clicked: Ok";
        String actual = result.getText();
        assertEquals(actual,expected,"Alert not handled");
        confirmButton.click();
        driver.switchTo().alert().dismiss();
        result = driver.findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        expected = "You clicked: Cancel";
        actual = result.getText();
        assertEquals(actual,expected,"Alert not handled");
    }
    @Test
    public void testPrompt(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement promptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promptButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("loopcamp");
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        String expected = "You entered:";
        String actual = result.getText();
        assertTrue(actual.contains(expected),"You did not enter anything in the prompt");
        promptButton.click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        result = driver.findElement(By.xpath("//div[@class='container']/p/following-sibling::p"));
        expected = "You entered: null";
        actual = result.getText();
        assertEquals(actual,expected,"Alert not dismissed");
    }
}

