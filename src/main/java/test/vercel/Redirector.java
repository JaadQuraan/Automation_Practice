package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class Redirector extends TestBase {
    @Test
    public void redirect () throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/redirector.html");
        WebElement header = driver.findElement(By.xpath("//h3"));
        String expected = "Redirection";
        String actual = header.getText();
        assertEquals(actual,expected,"Redirection was not displayed");
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='status_codes.html']"));
        clickHere.click();
        expected = "Status Codes";
        header = driver.findElement(By.xpath("//h3"));
        actual = header.getText();
        assertEquals(actual,expected,"Status codes was not displayed");

        WebElement statusCode200 = driver.findElement(By.xpath("//a[@href='status_codes/200.html']"));
        statusCode200.click();
        WebElement statusText = driver.findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("200"),"Status code 200 not returned");
        driver.navigate().back();
        WebElement statusCode301 = driver.findElement(By.xpath("//a[@href='status_codes/301.html']"));
        statusCode301.click();
         statusText = driver.findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("301"),"Status code 301 not returned");
        driver.navigate().back();
        WebElement statusCode404 = driver.findElement(By.xpath("//a[@href='status_codes/404.html']"));
        statusCode404.click();
         statusText = driver.findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("404"),"Status code 404 not returned");
        driver.navigate().back();
        WebElement statusCode500 = driver.findElement(By.xpath("//a[@href='status_codes/500.html']"));
        statusCode500.click();
         statusText = driver.findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("500"),"Status code 500 not returned");
        driver.navigate().back();
        driver.navigate().back();
       // Thread.sleep(2000);
        header = driver.findElement(By.xpath("//h3"));
         expected = "Redirection";
         actual = header.getText();
        assertEquals(actual,expected,"Redirection was not displayed");
    }
}
