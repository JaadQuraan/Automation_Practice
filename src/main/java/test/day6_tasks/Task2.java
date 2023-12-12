package test.day6_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class Task2 extends TestBase {
    @Test
    public void childiFrame() throws InterruptedException {
        driver.get("https://demoqa.com/nestedframes");
        Thread.sleep(1000);
        WebElement parentIFrame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(parentIFrame);
        WebElement childIFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(childIFrame);
        WebElement childText = driver.findElement(By.xpath("//p[text() = 'Child Iframe']"));
        String expected = "Child Iframe";
        String actual = childText.getText();
        assertEquals(actual, expected, "The actual " + actual + " does NOT match" + expected);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(parentIFrame);
        WebElement parentText = driver.findElement(By.xpath("//body[text() = 'Parent frame']"));
        expected = "Parent frame";
        actual = parentText.getText();
        assertEquals(actual, expected, "The actual " + actual + " does NOT match" + expected);
        driver.switchTo().defaultContent();
        expected = "Sample Nested Iframe page. There are nested iframes in this page. " +
                "Use browser inspecter or firebug to check out the HTML source. " +
                "In total you can switch between the parent frame and the nested child frame.";
        WebElement sampleText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div"));
        actual = sampleText.getText();
        assertEquals(actual, expected, "The actual " + actual + " does NOT match" + expected);
    }
}
