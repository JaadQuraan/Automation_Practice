package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;

public class NotificationMessage {
    @Test
    public void testMessage(){
        Driver.getDriver().get("https://loopcamp.vercel.app/notification-message-rendered.html");
        WebElement header = Driver.getDriver().findElement(By.xpath("//h3"));
        String expected = "Notification Message";
        String actual = header.getText();
        assertEquals(expected,actual, "Notification Message header is not displayed");
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Action successful","Action unsuccessful, please try again"));
        WebElement notification = Driver.getDriver().findElement(By.xpath("//div[@class='flash notice']"));
        String expectedNotification = "";
        String actualNotification = "";
        WebElement clickHere = Driver.getDriver().findElement(By.xpath("//a[@href='notification-message-rendered.html']"));

        for(String each : list){
            notification = Driver.getDriver().findElement(By.xpath("//div[@class='flash notice']"));
            expectedNotification = each;
            actualNotification = notification.getText();
            if(actualNotification.equals(expectedNotification)){
                Assert.assertEquals(actualNotification,expectedNotification,"Notification message NOT displayed properly");
            } else {
                clickHere = Driver.getDriver().findElement(By.xpath("//a[@href='notification-message-rendered.html']"));
                clickHere.click();
            }
        }



    }
}
