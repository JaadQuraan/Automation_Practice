package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class Geolocation  {
    //TODO cannot get latitude and longitude text or values
    @Test
    public void location() {
        Driver.getDriver().get("https://loopcamp.vercel.app/geolocation.html");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement header = Driver.getDriver().findElement(By.xpath("//h3"));
        System.out.println(header.getText());
        String expected = "Geolocation";
        String actual = header.getText();
        assertEquals(actual,expected,"Geolocation header is NOT displayed");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[contains(text(),Where)]"));
        button.click();
        WebElement demo = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));
       // System.out.println("demo.getText() = " + demo.getText());
        WebElement latValue = Driver.getDriver().findElement(By.xpath("//div[@id='lat-value']"));
        System.out.println("latitude value = " + latValue.getText());
        WebElement longValue = Driver.getDriver().findElement(By.xpath("//div[@id='long-value']"));
        System.out.println("longitude value = " + longValue.getText());

    }
}
