package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class NoABTest {
    @Test
    public void test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/ab-test.html");
        WebElement text = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p"));
        String expected = "split testing";
        String actual = text.getText();
        assertTrue(actual.contains(expected),"Not on no A/B test page");
    }
}
