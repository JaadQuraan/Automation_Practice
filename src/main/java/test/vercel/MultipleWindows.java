package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.util.Set;

public class MultipleWindows {
    @Test
    public void test_windows() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/");
        WebElement multipleWindowsTask = Driver.getDriver().findElement(By.xpath("//a[@href='windows.html']"));
        multipleWindowsTask.click();
        Thread.sleep(2000);
        WebElement powered = Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"));
        String actual = powered.getText();
        System.out.println(actual);
        assertTrue(powered.isDisplayed(),"Powered by LOOPCAMP is NOT displayed");
        WebElement header = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        System.out.println("header.getText() = " + header.getText());
        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3/following-sibling::a"));
        clickHere.click();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String windowHandle : windowHandles) {
            System.out.println("Window Handle: " + windowHandle);
            Driver.getDriver().switchTo().window(windowHandle);
        }
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        WebElement newWindow = Driver.getDriver().findElement(By.xpath("//div[@class='example']/h3"));
        System.out.println("newWindow.getText() = " + newWindow.getText());
        assertEquals(newWindow.getText(),"New Window","New window is NOT displayed");

    }
}
