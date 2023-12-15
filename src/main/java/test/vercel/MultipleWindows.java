package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.Set;

public class MultipleWindows extends TestBase {
    @Test
    public void test_windows(){
        driver.get("https://loopcamp.vercel.app/windows.html");
        WebElement header = driver.findElement(By.xpath("//div[@class='example']/h3"));
        System.out.println("header.getText() = " + header.getText());
        WebElement clickHere = driver.findElement(By.xpath("//div[@class='example']/h3/following-sibling::a"));
        clickHere.click();
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

    }
}
