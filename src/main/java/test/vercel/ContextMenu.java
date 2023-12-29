package test.vercel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class ContextMenu {







        @Test
        public void contextClick () throws InterruptedException {
            Driver.getDriver().get("https://loopcamp.vercel.app/context-menu.html");

            Thread.sleep(2000);

            try {
                WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
                Actions actions = new Actions(Driver.getDriver());
                actions.contextClick(box).perform();
                Thread.sleep(1000);
                // Handle the alert
                Alert alert = Driver.getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert Text: " + alertText);
                Assert.assertEquals(alertText, "You selected a context menu", "Actual does NOT match expected");

                alert.accept();
                Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            } catch (NoSuchElementException e) {
                System.out.println("Failed to find or interact with element");
            }
        }
    }