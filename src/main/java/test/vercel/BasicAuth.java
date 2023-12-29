package test.vercel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class BasicAuth extends TestBase {


    @Test
    public void test() {

        Driver.getDriver().get("https://loopcamp.vercel.app/basic-auth.html");
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("admin");
        alert.accept();
        Driver.getDriver().switchTo().alert();
        alert.sendKeys("admin");
        alert.accept();
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        String expected = "Congratulations";
        String actual = successMessage.getText();
        assertTrue(actual.contains(expected),"Login failed, enter correct username/password");
    }


}


