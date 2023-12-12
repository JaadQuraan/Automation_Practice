package test.vercel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

public class ContextMenu {
    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/context-menu.html";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @AfterMethod
    public void teardownMethod() {
        //driver.close();
    }


    @Test
    public  void main() throws InterruptedException {
        Thread.sleep(2000);

        try {
            WebElement box = driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(box).perform();
            Thread.sleep(1000);
            // Handle the alert
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            Assert.assertEquals(alertText,"You selected a context menu","Actual does NOT match expected");

            alert.accept();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Failed to find or interact with element");
        }
    }
}
