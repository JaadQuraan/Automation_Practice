package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class NoABTest extends TestBase {
    @Test
    public void test(){
        driver.get("https://loopcamp.vercel.app/ab-test.html");
        WebElement text = driver.findElement(By.xpath("//div[@class='example']/p"));
        String expected = "split testing";
        String actual = text.getText();
        assertTrue(actual.contains(expected),"Not on no A/B test page");
    }
}
