package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class Geolocation extends TestBase {
    //TODO cannot get latitude and longitude text or values
    @Test
    public void location() {
        driver.get("https://loopcamp.vercel.app/geolocation.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());
        String expected = "Geolocation";
        String actual = header.getText();
        assertEquals(actual,expected,"Geolocation header is NOT displayed");
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),Where)]"));
        button.click();
        WebElement demo = driver.findElement(By.xpath("//p[@id='demo']"));
       // System.out.println("demo.getText() = " + demo.getText());
        WebElement latValue = driver.findElement(By.xpath("//div[@id='lat-value']"));
        System.out.println("latitude value = " + latValue.getText());
        WebElement longValue = driver.findElement(By.xpath("//div[@id='long-value']"));
        System.out.println("longitude value = " + longValue.getText());

    }
}
