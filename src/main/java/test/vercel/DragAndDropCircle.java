package test.vercel;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DragAndDropCircle {

    @Test
    public void test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        WebElement draggableCircle = Driver.getDriver().findElement(By.id("draggable"));
        System.out.println("draggableCircle.isDisplayed() = " + draggableCircle.isDisplayed());
        WebElement dropTarget = Driver.getDriver().findElement(By.id("droptarget"));
        System.out.println("dropTarget.isDisplayed() = " + dropTarget.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droptarget")));


        Actions actions = new Actions(Driver.getDriver());
        actions.clickAndHold(draggableCircle).moveToElement(dropTarget).release().perform();
        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        WebElement dropTargetxpath = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        System.out.println("dropTargetxpath.getText() = " + dropTargetxpath.getText());
        assertTrue(dropTargetxpath.getText().contains("great"),"Circle not moved to appropriate location");
    }}

//    public static void main(String[] args) {
//        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        Driver.getDriver().manage().window().maximize();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement draggableCircle = Driver.getDriver().findElement(By.id("draggable"));
//        System.out.println("draggableCircle.isDisplayed() = " + draggableCircle.isDisplayed());
//        WebElement dropTarget = Driver.getDriver().findElement(By.id("droptarget"));
//        System.out.println("dropTarget.isDisplayed() = " + dropTarget.isDisplayed());
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droptarget")));
//
//
//        Actions actions = new Actions(Driver.getDriver());
//        actions.clickAndHold(draggableCircle).moveToElement(dropTarget).release().perform();
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
//        WebElement dropTargetxpath = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
//        System.out.println("dropTargetxpath.getText() = " + dropTargetxpath.getText());
//        if(dropTargetxpath.getText().contains("great")){
//            System.out.println("Test PASSED");
//        } else {
//            System.out.println("Test FAILED");
//        }
//
//    }
//}
