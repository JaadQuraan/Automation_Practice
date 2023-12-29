package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class Add_Remove extends TestBase {
    @Test
    public void testAdd(){
        Driver.getDriver().get("https://loopcamp.vercel.app/add-remove-elements.html");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement addButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-primary']"));
        addButton.click();
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//button[@class='added-manually btn btn-secondary']"));
        assertTrue(deleteButton.isDisplayed(), "Delete button is NOT displayed");
        deleteButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='added-manually btn btn-secondary']")));

        try {
            deleteButton = Driver.getDriver().findElement(By.xpath("//button[@class='added-manually btn btn-secondary']"));
            assertFalse(deleteButton.isDisplayed(), "Delete button is STILL displayed");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // The element is expected to be not found, and the test should pass
            assertTrue(true, "Delete button is not found (as expected)");
        }
    }
}
