package test.day3_tasks;

import test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement usernamePlaceholder = driver.findElement(By.cssSelector("label[for='input-14'"));
        String actualUsernamePlaceholder = usernamePlaceholder.getText();
        String expectedUsernamePlaceholder = "Username or email";
        WebElement passwordPlaceholder = driver.findElement(By.cssSelector("label[for='input-15'"));
        String actualPasswordPlaceholder = passwordPlaceholder.getText();
        String expectedPasswordPlaceholder = "Password";

        if (expectedUsernamePlaceholder.equalsIgnoreCase(actualUsernamePlaceholder)) {
            System.out.println("Expected " + expectedUsernamePlaceholder + " matches actual " + actualUsernamePlaceholder);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected" + expectedUsernamePlaceholder + "DOES NOT match actual " + actualUsernamePlaceholder);
            System.out.println("TEST FAILED");


        }
        if (expectedPasswordPlaceholder.equalsIgnoreCase(actualPasswordPlaceholder)) {
            System.out.println("Expected " + expectedPasswordPlaceholder + " matches actual " + actualPasswordPlaceholder);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected" + expectedPasswordPlaceholder + "DOES NOT match actual " + actualPasswordPlaceholder);
            System.out.println("TEST FAILED");
        }
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
        login.click();

       WebElement userErr= driver.findElement(By.xpath("//div[.='Please enter your username or email address']")); //Works xpath
       // System.out.println(userErr.getText());

        ArrayList<WebElement> errors = new ArrayList<>(driver.findElements(By.cssSelector("div[class=v-messages__message]")));
        //Gets an ArrayList of Web elements of the error messages
        String [] errorArr = new String[errors.size()];
        for (int i = 0; i < errors.size(); i++) { //Takes Strings from the error messages and makes it an array
            errorArr[i] = errors.get(i).getText();
        }
        System.out.println(Arrays.toString(errorArr));

        String expectedUsrErr = "Please enter your username or email address";
        String expectedPassErr = "Please enter your password";

        if (expectedUsrErr.equalsIgnoreCase(errorArr[0])) {
            System.out.println("Expected " + expectedUsrErr + " matches actual " + errorArr[0]);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected" + expectedUsrErr + "DOES NOT match actual " + errorArr[0]);
            System.out.println("TEST FAILED");
        }

        if (expectedPassErr.equalsIgnoreCase(errorArr[1])) {
            System.out.println("Expected " + expectedPassErr + " matches actual " + errorArr[1]);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected" + expectedPassErr + "DOES NOT match actual " + errorArr[1]);
            System.out.println("TEST FAILED");
        }

Thread.sleep(1000);
        driver.quit();
    }
}
