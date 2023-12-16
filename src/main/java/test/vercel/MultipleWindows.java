package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.Set;

public class MultipleWindows extends TestBase {
    @Test
    public void test_windows() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/");
        WebElement multipleWindowsTask = driver.findElement(By.xpath("//a[@href='windows.html']"));
        multipleWindowsTask.click();
        Thread.sleep(2000);
        WebElement powered = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        String actual = powered.getText();
        System.out.println(actual);
        assertTrue(powered.isDisplayed(),"Powered by LOOPCAMP is NOT displayed");
        WebElement header = driver.findElement(By.xpath("//div[@class='example']/h3"));
        System.out.println("header.getText() = " + header.getText());
        WebElement clickHere = driver.findElement(By.xpath("//div[@class='example']/h3/following-sibling::a"));
        clickHere.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            System.out.println("Window Handle: " + windowHandle);
            driver.switchTo().window(windowHandle);
        }
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getTitle() = " + driver.getTitle());
        WebElement newWindow = driver.findElement(By.xpath("//div[@class='example']/h3"));
        System.out.println("newWindow.getText() = " + newWindow.getText());
        assertEquals(newWindow.getText(),"New Window","New window is NOT displayed");

    }
}
