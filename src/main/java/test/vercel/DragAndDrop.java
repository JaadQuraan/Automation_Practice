package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/drag-and-drop.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement squareA = driver.findElement(By.id("column-a"));
        System.out.println("squareA.isDisplayed() = " + squareA.isDisplayed());
        WebElement squareB = driver.findElement(By.id("column-b"));
        System.out.println("squareB.isDisplayed() = " + squareB.isDisplayed());
//        WebElement headerA = driver.findElement(By.xpath("//header[text()='A']"));
//        WebElement headerB = driver.findElement(By.xpath("//header[text()='B']"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("column-b")));
//
//        wait.until(ExpectedConditions.elementToBeClickable(squareA));
//
//// Perform the drag-and-drop action
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(squareA).moveToElement(squareB).release().perform();

        Actions actions = new Actions(driver);
     actions.clickAndHold(squareA).moveToElement(squareB).release().perform();
       // actions.clickAndHold(squareA).dragAndDrop(squareA,squareB).release().perform();

    }
}
