package test.day3_tasks;

import test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task0 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.tagName("h2"));
        String actualForgotPassword = forgotPassword.getText();
        String expectedForgotPassword = "Forgot Password";

        if(expectedForgotPassword.equalsIgnoreCase(actualForgotPassword)){
            System.out.println("Expected " + expectedForgotPassword + " matches actual " + actualForgotPassword);
            System.out.println("Test PASSED");
        }else {
            System.out.println("Expected" + expectedForgotPassword + "DOES NOT match actual " + actualForgotPassword);
            System.out.println("TEST FAILED");
        }

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        String actualEmail = email.getText();
        String expectedEmail =  "E-mail";

        if(expectedEmail.equalsIgnoreCase(actualEmail)){
            System.out.println("Expected " + expectedEmail + " matches actual " + actualEmail);
            System.out.println("Test PASSED");
        }else {
            System.out.println("Expected" + expectedEmail + "DOES NOT match actual " + actualEmail);
            System.out.println("TEST FAILED");
        }

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
        emailInput.sendKeys("tom@gmail.com");
        //input was displayed

        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        String actualRetrievePassword = retrievePassword.getText();
        String expectedRetrievePassword = "Retrieve password";

        if(expectedRetrievePassword.equalsIgnoreCase(actualRetrievePassword)){
            System.out.println("Expected " + expectedRetrievePassword + " matches actual " + actualRetrievePassword);
            System.out.println("Test PASSED");
        }else {
            System.out.println("Expected" + expectedRetrievePassword + "DOES NOT match actual " + actualRetrievePassword);
            System.out.println("TEST FAILED");
        }

        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("a[href=\"https://www.loopcamp.io/\"]"));
        String actualPoweredByLoopcamp = poweredByLoopcamp.getText();
        System.out.println(actualPoweredByLoopcamp);
        String expectedPoweredByLoopcamp = "LOOPCAMP";

        if(expectedPoweredByLoopcamp.equalsIgnoreCase(actualPoweredByLoopcamp)){
            System.out.println("Expected " + expectedPoweredByLoopcamp + " matches actual " + actualPoweredByLoopcamp);
            System.out.println("Test PASSED");
        }else {
            System.out.println("Expected" + expectedPoweredByLoopcamp + "DOES NOT match actual " + actualPoweredByLoopcamp);
            System.out.println("TEST FAILED");
        }
       Thread.sleep(2000);
            driver.close();
    }
}
