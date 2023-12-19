package test.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class Buttons extends TestBase {

    @Test
    public void testDoubleClick() {
        driver.get("https://demoqa.com/buttons");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        String doubleClickMessage = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
        System.out.println(doubleClickMessage);
    }

    @Test
    public void testRightClick() {
        driver.get("https://demoqa.com/buttons");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement rightClickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
        String rightClickMessage = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
        System.out.println(rightClickMessage);
    }

    @Test
    public void testDynamicClick() {
        driver.get("https://demoqa.com/buttons");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement dynamicClickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        dynamicClickButton.click();
        String dynamicClickMessage = driver.findElement(By.xpath("//p[text()='You have done a dynamic click']")).getText();
        System.out.println(dynamicClickMessage);
    }

//    @Test
//    public void testAll(){
//        driver.get("https://demoqa.com/buttons");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
//        Actions actions = new Actions(driver);
//        actions.doubleClick(doubleClickButton).perform();
//        String doubleClickMessage = driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
//        System.out.println(doubleClickMessage);
//
//        WebElement rightClickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
//        actions.contextClick(rightClickButton).perform();
//        String rightClickMessage = driver.findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
//        System.out.println(rightClickMessage);
//
//        WebElement dynamicClickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
//        dynamicClickButton.click();
//        String dynamicClickMessage = driver.findElement(By.xpath("//p[text()='You have done a dynamic click']")).getText();
//        System.out.println(dynamicClickMessage);
//
//    }
}
