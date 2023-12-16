package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class JQueryUI extends TestBase {
    @Test
    public void testPDF() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/jqueryui/menu.html#");
        Actions actions = new Actions(driver);
        WebElement enabledMenu = driver.findElement(By.xpath("//a[@id='ui-id-3']"));
        actions.moveToElement(enabledMenu).click().perform();
        Thread.sleep(1000);

        WebElement downloadsMenu = driver.findElement(By.xpath("//a[@id='ui-id-4']"));
        actions.moveToElement(downloadsMenu).click().perform();
        Thread.sleep(1000);

        WebElement pdfMenu = driver.findElement(By.xpath("//a[@id='ui-id-5']"));
        actions.moveToElement(pdfMenu).click().perform();
        Thread.sleep(1000);
        String expected = "menu.pdf";
        String actual = driver.getCurrentUrl();
        assertTrue(actual.contains(expected),"PDF was not loaded");
    }
}
