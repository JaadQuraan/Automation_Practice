package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
default
    top
        left
        middle
        right
 */
public class OLDNestedFrames extends TestBase {



    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        WebElement topFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topFrame);
        WebElement leftFrame = driver.findElement(By.xpath("//frame[@src= 'frame_left.html']"));
        WebElement leftText = driver.switchTo().frame(leftFrame).findElement(By.xpath("/html/body"));
        System.out.println(leftText.getText());
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@src= 'frame_middle.html']"));

        driver.switchTo().parentFrame();
        WebElement middleText = driver.switchTo().frame(middleFrame).findElement(By.xpath("/html/body"));
        System.out.println(middleText.getText());
        driver.switchTo().parentFrame();
        WebElement rightFrame = driver.findElement(By.xpath("//frame[@name= 'frame-right']"));
        WebElement rightText = driver.switchTo().frame(rightFrame).findElement(By.xpath("/html/body"));
        System.out.println(rightText.getText());
        driver.switchTo().defaultContent();
        WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        WebElement bottomText = driver.switchTo().frame(bottomFrame).findElement(By.xpath("/html/body"));
        System.out.println(bottomText.getText());

    }



}
