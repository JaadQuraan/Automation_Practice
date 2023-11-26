package test.day3_tasks;

import test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://google.com/");
        WebElement gmail = driver.findElement(By.cssSelector("a[href=\"https://mail.google.com/mail/&ogbl\""));
        gmail.click();
        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if(actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Expected " + expectedGmailTitle + " contains " + actualGmailTitle);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedGmailTitle + " DOEST NOT contain " + actualGmailTitle);
            System.out.println("Test FAILED");
        }
        Thread.sleep(1000);
        driver.navigate().back();
        String expectedHomeTitle = "Google";
        String actualHomeTitle = driver.getTitle();

        if(actualHomeTitle.contains(expectedHomeTitle)){
            System.out.println("Expected " + expectedHomeTitle + " contains " + actualHomeTitle);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + actualHomeTitle + " DOEST NOT contain " + actualHomeTitle);
            System.out.println("Test FAILED");
        }
        driver.quit();

    }
}
