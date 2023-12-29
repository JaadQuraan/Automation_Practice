package test.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class Buttons extends TestBase {

    @Test
    public void testDoubleClick() {
        Driver.getDriver().get("https://demoqa.com/buttons");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement doubleClickButton = Driver.getDriver().findElement(By.xpath("//button[@id='doubleClickBtn']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        String doubleClickMessage = Driver.getDriver().findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
        System.out.println(doubleClickMessage);
    }

    @Test
    public void testRightClick() {
        Driver.getDriver().get("https://demoqa.com/buttons");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement rightClickButton = Driver.getDriver().findElement(By.xpath("//button[text()='Right Click Me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();
        String rightClickMessage = Driver.getDriver().findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
        System.out.println(rightClickMessage);
    }

    @Test
    public void testDynamicClick() {
        Driver.getDriver().get("https://demoqa.com/buttons");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement dynamicClickButton = Driver.getDriver().findElement(By.xpath("//button[text()='Click Me']"));
        dynamicClickButton.click();
        String dynamicClickMessage = Driver.getDriver().findElement(By.xpath("//p[text()='You have done a dynamic click']")).getText();
        System.out.println(dynamicClickMessage);
    }

//    @Test
//    public void testAll(){
//        Driver.getDriver().get("https://demoqa.com/buttons");
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        WebElement doubleClickButton = Driver.getDriver().findElement(By.xpath("//button[@id='doubleClickBtn']"));
//        Actions actions = new Actions(driver);
//        actions.doubleClick(doubleClickButton).perform();
//        String doubleClickMessage = Driver.getDriver().findElement(By.xpath("//p[@id='doubleClickMessage']")).getText();
//        System.out.println(doubleClickMessage);
//
//        WebElement rightClickButton = Driver.getDriver().findElement(By.xpath("//button[text()='Right Click Me']"));
//        actions.contextClick(rightClickButton).perform();
//        String rightClickMessage = Driver.getDriver().findElement(By.xpath("//p[@id='rightClickMessage']")).getText();
//        System.out.println(rightClickMessage);
//
//        WebElement dynamicClickButton = Driver.getDriver().findElement(By.xpath("//button[text()='Click Me']"));
//        dynamicClickButton.click();
//        String dynamicClickMessage = Driver.getDriver().findElement(By.xpath("//p[text()='You have done a dynamic click']")).getText();
//        System.out.println(dynamicClickMessage);
//
//    }
}
