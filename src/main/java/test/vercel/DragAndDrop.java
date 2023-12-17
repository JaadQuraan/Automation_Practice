package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DragAndDrop extends TestBase {

    @Test
    public void test(){
        driver.get("https://loopcamp.vercel.app/drag-and-drop.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement squareA = driver.findElement(By.id("column-a"));
        System.out.println("squareA.isDisplayed() = " + squareA.isDisplayed());
        WebElement squareB = driver.findElement(By.id("column-b"));
        System.out.println("squareB.isDisplayed() = " + squareB.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));

        Actions actions = new Actions(driver);
        actions.clickAndHold(squareA).moveToElement(squareB).release().perform();
    }
}
