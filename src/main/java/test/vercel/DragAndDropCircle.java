package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DragAndDropCircle {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement draggableCircle = driver.findElement(By.id("draggable"));
        System.out.println("draggableCircle.isDisplayed() = " + draggableCircle.isDisplayed());
        WebElement dropTarget = driver.findElement(By.id("droptarget"));
        System.out.println("dropTarget.isDisplayed() = " + dropTarget.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droptarget")));


        Actions actions = new Actions(driver);
        actions.clickAndHold(draggableCircle).moveToElement(dropTarget).release().perform();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement dropTargetxpath = driver.findElement(By.xpath("//div[@id='droptarget']"));
        System.out.println("dropTargetxpath.getText() = " + dropTargetxpath.getText());
        if(dropTargetxpath.getText().contains("great")){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

    }
}
