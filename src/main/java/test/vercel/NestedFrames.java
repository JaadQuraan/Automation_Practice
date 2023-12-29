package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class NestedFrames {

    @Test (priority = 1)
    public void left() {
        Driver.getDriver().get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = Driver.getDriver().findElement(By.xpath("//frame[@name='frame-top']"));
        Driver.getDriver().switchTo().frame(topFrame);
        WebElement leftFrame = Driver.getDriver().findElement(By.xpath("//frame[@src= 'frame_left.html']"));
        WebElement leftText = Driver.getDriver().switchTo().frame(leftFrame).findElement(By.xpath("/html/body"));
        System.out.println(leftText.getText());
        String expected = "LEFT";
        String actual = leftText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }

    @Test (priority = 2)
    public void middle() {
        Driver.getDriver().get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = Driver.getDriver().findElement(By.xpath("//frame[@name='frame-top']"));
        Driver.getDriver().switchTo().frame(topFrame);
        WebElement middleFrame = Driver.getDriver().findElement(By.xpath("//frame[@src= 'frame_middle.html']"));
        WebElement middleText = Driver.getDriver().switchTo().frame(middleFrame).findElement(By.xpath("/html/body"));
        System.out.println(middleText.getText());
        String expected = "MIDDLE";
        String actual = middleText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }

    @Test (priority = 3)
    public void right() {
        Driver.getDriver().get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = Driver.getDriver().findElement(By.xpath("//frame[@name='frame-top']"));
        Driver.getDriver().switchTo().frame(topFrame);
        WebElement rightFrame = Driver.getDriver().findElement(By.xpath("//frame[@name= 'frame-right']"));
        WebElement rightText = Driver.getDriver().switchTo().frame(rightFrame).findElement(By.xpath("/html/body"));
        System.out.println(rightText.getText());
        String expected = "RIGHT";
        String actual = rightText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }

    @Test (priority = 4)
    public void bottom() {
        Driver.getDriver().get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement bottomFrame = Driver.getDriver().findElement(By.xpath("//frame[@name='frame-bottom']"));
        WebElement bottomText = Driver.getDriver().switchTo().frame(bottomFrame).findElement(By.xpath("/html/body"));
        System.out.println(bottomText.getText());
        String expected = "BOTTOM";
        String actual = bottomText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }
}
