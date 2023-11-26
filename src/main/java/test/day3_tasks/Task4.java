package test.day3_tasks;

import test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://etsy.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search for anything']"));
        searchBox.sendKeys("wooden spoon");
        Thread.sleep(1000);

        WebElement search = driver.findElement(By.cssSelector("button[type='submit']"));
        search.click();

        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle)) {
            System.out.println("Expected " + expectedTitle + " matches actual " + actualTitle);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected" + expectedTitle + "DOES NOT match actual " + actualTitle);
            System.out.println("TEST FAILED");

        }

         driver.quit();
    }
}