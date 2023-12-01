package test.vercel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.utilities.WebDriverFactory;

public class ContextMenu {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/context-menu.html");
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

            // You can accept, dismiss, or perform other actions on the alert
            alert.accept();
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Failed to find or interact with element");
        } finally {
            driver.quit();
        }
    }
}
