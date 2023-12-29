package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class Redirector  {
    @Test
    public void redirect () throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/redirector.html");
        WebElement header = Driver.getDriver().findElement(By.xpath("//h3"));
        String expected = "Redirection";
        String actual = header.getText();
        assertEquals(actual,expected,"Redirection was not displayed");
        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//a[@href='status_codes.html']"));
        clickHere.click();
        expected = "Status Codes";
        header = Driver.getDriver().findElement(By.xpath("//h3"));
        actual = header.getText();
        assertEquals(actual,expected,"Status codes was not displayed");

        WebElement statusCode200 = Driver.getDriver().findElement(By.xpath("//a[@href='status_codes/200.html']"));
        statusCode200.click();
        WebElement statusText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("200"),"Status code 200 not returned");
        Driver.getDriver().navigate().back();
        WebElement statusCode301 = Driver.getDriver().findElement(By.xpath("//a[@href='status_codes/301.html']"));
        statusCode301.click();
         statusText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("301"),"Status code 301 not returned");
        Driver.getDriver().navigate().back();
        WebElement statusCode404 = Driver.getDriver().findElement(By.xpath("//a[@href='status_codes/404.html']"));
        statusCode404.click();
         statusText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("404"),"Status code 404 not returned");
        Driver.getDriver().navigate().back();
        WebElement statusCode500 = Driver.getDriver().findElement(By.xpath("//a[@href='status_codes/500.html']"));
        statusCode500.click();
         statusText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        assertTrue(statusText.getText().contains("500"),"Status code 500 not returned");
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().back();
       // Thread.sleep(2000);
        header = Driver.getDriver().findElement(By.xpath("//h3"));
         expected = "Redirection";
         actual = header.getText();
        assertEquals(actual,expected,"Redirection was not displayed");
    }
}
