package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;
import java.util.Set;
//TODO:NOT DONE
public class NewTab {
    @Test
    public void testTab() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/open-new-tab.html");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String def = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().activeElement();
        Thread.sleep(1000);
       // WebElement loadingText = Driver.getDriver().findElement(By.xpath("strong[@id='msg']"));
       // System.out.println("loadingText.getText() = " + loadingText.getText());
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        Set <String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            Driver.getDriver().switchTo().window(windowHandle);
            System.out.println("Window Handle: " + windowHandle);
            Driver.getDriver().switchTo().window(windowHandle);
        }
        Driver.getDriver().switchTo().activeElement();
        WebElement successText = Driver.getDriver().findElement(By.xpath("//strong[text()='Success!']"));
        String expected = "Success!";
        String actual = successText.getText();
        System.out.println(actual);
//        Driver.getDriver().switchTo().window(def);
//        Thread.sleep(1000);
//        WebElement checkTabText = Driver.getDriver().findElement(By.xpath("strong[@id='msg']"));
//        System.out.println("checkTabText.getText() = " + checkTabText.getText());
        Assert.assertEquals(expected,actual,"The new tab was not created or switched to");
    }

}
