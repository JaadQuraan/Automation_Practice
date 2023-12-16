package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class Geolocation extends TestBase {
    //TODO cannot get latitude and longitude text or values
    @Test
    public void location() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/geolocation.html");
        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());
        String expected = "Geolocation";
        String actual = header.getText();
        assertEquals(actual,expected,"Geolocation header is NOT displayed");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),Where)]"));
        button.click();
//        WebElement location = driver.findElement(By.xpath("//p[@id='demo']"));
//        System.out.println(location.getText());
//        WebElement latitude = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p/div[1]"));
//        System.out.println("latitude.getText() = " + latitude.getText());
    }
}
