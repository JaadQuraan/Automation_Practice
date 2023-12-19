package test.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class RadioButtons extends TestBase {

    @Test
    public void testYes() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();

        String actualTextYes = driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        String expectedTextYes = "Yes";
        assertEquals(actualTextYes, expectedTextYes, "Messages do NOT match, Yes was NOT selected");

        WebElement noButton = driver.findElement(By.xpath("//input[@id='noRadio']"));

       // System.out.println(noButton.isEnabled());
        assertFalse(noButton.isEnabled(),"ERROR: No button is enabled");
    }

    @Test
    public void testImpressive() {
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement impressiveButton = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        String actualTextImpressive = driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        String expectedTextImpressive = "Impressive";
        assertEquals(actualTextImpressive, expectedTextImpressive, "Messages do NOT match, Impressive was NOT selected");
    }
}
