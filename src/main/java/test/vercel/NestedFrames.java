package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class NestedFrames extends TestBase {

    @Test (priority = 1)
    public void left() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        WebElement leftFrame = driver.findElement(By.xpath("//frame[@src= 'frame_left.html']"));
        WebElement leftText = driver.switchTo().frame(leftFrame).findElement(By.xpath("/html/body"));
        System.out.println(leftText.getText());
        String expected = "LEFT";
        String actual = leftText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }

    @Test (priority = 2)
    public void middle() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@src= 'frame_middle.html']"));
        WebElement middleText = driver.switchTo().frame(middleFrame).findElement(By.xpath("/html/body"));
        System.out.println(middleText.getText());
        String expected = "MIDDLE";
        String actual = middleText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }

    @Test (priority = 3)
    public void right() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        WebElement rightFrame = driver.findElement(By.xpath("//frame[@name= 'frame-right']"));
        WebElement rightText = driver.switchTo().frame(rightFrame).findElement(By.xpath("/html/body"));
        System.out.println(rightText.getText());
        String expected = "RIGHT";
        String actual = rightText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }

    @Test (priority = 4)
    public void bottom() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        WebElement bottomText = driver.switchTo().frame(bottomFrame).findElement(By.xpath("/html/body"));
        System.out.println(bottomText.getText());
        String expected = "BOTTOM";
        String actual = bottomText.getText();
        assertEquals(actual,expected,"Actual text does not match expected");
    }
}
