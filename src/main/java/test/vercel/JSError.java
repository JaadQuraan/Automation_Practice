package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class JSError extends TestBase {
    @Test
    public void test(){
        driver.get("https://loopcamp.vercel.app/javascript-error.html");
        WebElement loadError = driver.findElement(By.xpath("//body[@onload='loadError()']"));
        String expected = "This page has a JavaScript error in the onload event.";
        String actual = loadError.getText();
        //System.out.println("Actual:" + actual);
        assertTrue(actual.contains(expected));
    }
}
