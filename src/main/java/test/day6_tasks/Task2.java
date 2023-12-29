package test.day6_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class Task2 extends TestBase {
    @Test
    public void childiFrame() throws InterruptedException {
        Driver.getDriver().get("https://demoqa.com/nestedframes");
        Thread.sleep(1000);
        WebElement parentIFrame = Driver.getDriver().findElement(By.xpath("//iframe[@id='frame1']"));
        Driver.getDriver().switchTo().frame(parentIFrame);
        WebElement childIFrame = Driver.getDriver().findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        Driver.getDriver().switchTo().frame(childIFrame);
        WebElement childText = Driver.getDriver().findElement(By.xpath("//p[text() = 'Child Iframe']"));
        String expected = "Child Iframe";
        String actual = childText.getText();
        assertEquals(actual, expected, "The actual " + actual + " does NOT match" + expected);
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(parentIFrame);
        WebElement parentText = Driver.getDriver().findElement(By.xpath("//body[text() = 'Parent frame']"));
        expected = "Parent frame";
        actual = parentText.getText();
        assertEquals(actual, expected, "The actual " + actual + " does NOT match" + expected);
        Driver.getDriver().switchTo().defaultContent();
        expected = "Sample Nested Iframe page. There are nested iframes in this page. " +
                "Use browser inspecter or firebug to check out the HTML source. " +
                "In total you can switch between the parent frame and the nested child frame.";
        WebElement sampleText = Driver.getDriver().findElement(By.xpath("//div[@id='framesWrapper']/div"));
        actual = sampleText.getText();
        assertEquals(actual, expected, "The actual " + actual + " does NOT match" + expected);
    }
}
