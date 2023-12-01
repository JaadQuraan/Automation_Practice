package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

public class BasicAuth2 {
    public static void main(String[] args) {
        // Modify the URL to include username and password
        String urlWithCredentials = "https://admin:admin@loopcamp.vercel.app/basic-auth.html";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(urlWithCredentials);

        // Continue with your other code...

        // For example, find and validate the success message
        WebElement success = driver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']"));
        System.out.println(success.getText());

        String expectedSuccess = "Congratulations!";

        if(success.getText().contains(expectedSuccess)){
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAIL");
        }

        // Close the browser
        driver.quit();
    }
    }

