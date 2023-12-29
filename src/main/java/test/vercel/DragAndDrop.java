package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DragAndDrop  {

    @Test
    public void test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop.html");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        WebElement squareA = Driver.getDriver().findElement(By.id("column-a"));
        System.out.println("squareA.isDisplayed() = " + squareA.isDisplayed());
        WebElement squareB = Driver.getDriver().findElement(By.id("column-b"));
        System.out.println("squareB.isDisplayed() = " + squareB.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));

        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(squareA).moveToElement(squareB).release().perform();
    }
}
