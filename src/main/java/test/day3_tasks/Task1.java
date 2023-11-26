package test.day3_tasks;

import test.utilities.DocuportConstants;
import test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement usernameInput = driver.findElement(By.cssSelector("label[for='input-14'] + input"));
        WebElement passwordInput = driver.findElement(By.cssSelector("label[for='input-15'] + input"));
        WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
        passwordInput.sendKeys(DocuportConstants.PASSWORD_CLIENT);
        login.click();
        Thread.sleep(3000);
        WebElement cont = driver.findElement(By.cssSelector("button[type='submit']"));
        cont.click();

        WebElement b1g1 = driver.findElement(By.cssSelector("span [class=\"subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3\""));
        String actualb1g1 = b1g1.getText();
        String expectedb1g1 = "Batch1 Group1";

        if(expectedb1g1.equalsIgnoreCase(actualb1g1)){
            System.out.println("Expected " + expectedb1g1 + " matches actual " + actualb1g1);
            System.out.println("Test PASSED");
        }else {
            System.out.println("Expected" + expectedb1g1 + "DOES NOT match actual " + actualb1g1);
            System.out.println("TEST FAILED");
        }

        b1g1.click();
        Thread.sleep(3000);
        WebElement logOut = driver.findElement(By.id("list-item-152"));
        logOut.click();
        Thread.sleep(3000);
        WebElement loginText = driver.findElement(By.tagName("h1"));
        String ActualLoginText = loginText.getText(); //Login
        if(ActualLoginText.equalsIgnoreCase("Login")){
            System.out.println("Test Passed successfully logged out");
        } else {
            System.out.println("Test FAILED");
        }

       // System.out.println(actualb1g1);
        Thread.sleep(2000);
        driver.quit();
    }
}
