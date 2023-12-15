package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;
import java.util.Set;
//TODO:NOT DONE
public class NewTab extends TestBase {
    @Test
    public void testTab() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/open-new-tab.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String def = driver.getWindowHandle();
        driver.switchTo().activeElement();
        Thread.sleep(1000);
       // WebElement loadingText = driver.findElement(By.xpath("strong[@id='msg']"));
       // System.out.println("loadingText.getText() = " + loadingText.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        Set <String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            System.out.println("Window Handle: " + windowHandle);
            driver.switchTo().window(windowHandle);
        }
        driver.switchTo().activeElement();
        WebElement successText = driver.findElement(By.xpath("//strong[text()='Success!']"));
        String expected = "Success!";
        String actual = successText.getText();
        System.out.println(actual);
//        driver.switchTo().window(def);
//        Thread.sleep(1000);
//        WebElement checkTabText = driver.findElement(By.xpath("strong[@id='msg']"));
//        System.out.println("checkTabText.getText() = " + checkTabText.getText());
        Assert.assertEquals(expected,actual,"The new tab was not created or switched to");
    }

}
