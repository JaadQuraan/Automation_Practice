package test.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class RadioButtons extends TestBase {

    @Test
    public void testYes() {
        Driver.getDriver().get("https://demoqa.com/radio-button");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement yesButton = Driver.getDriver().findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();

        String actualTextYes = Driver.getDriver().findElement(By.xpath("//span[@class='text-success']")).getText();
        String expectedTextYes = "Yes";
        assertEquals(actualTextYes, expectedTextYes, "Messages do NOT match, Yes was NOT selected");

        WebElement noButton = Driver.getDriver().findElement(By.xpath("//input[@id='noRadio']"));

       // System.out.println(noButton.isEnabled());
        assertFalse(noButton.isEnabled(),"ERROR: No button is enabled");
    }

    @Test
    public void testImpressive() {
        Driver.getDriver().get("https://demoqa.com/radio-button");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement impressiveButton = Driver.getDriver().findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveButton.click();

        String actualTextImpressive = Driver.getDriver().findElement(By.xpath("//span[@class='text-success']")).getText();
        String expectedTextImpressive = "Impressive";
        assertEquals(actualTextImpressive, expectedTextImpressive, "Messages do NOT match, Impressive was NOT selected");
    }
}
