package test.day4_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.DocuportConstants;
import test.utilities.WebDriverFactory;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/");

        WebElement userBox = driver.findElement(By.xpath("//input[@id='input-14']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='input-15']"));

        userBox.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        passwordBox.sendKeys(DocuportConstants.PASSWORD_G2);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(3000);

        String expectedHome = "Home";
        String expectedReceivedDocs = "Received docs";
        String expectedMyUploads = "My uploads";
        String expectedInvitations = "Invitations";

        String actualHome = driver.findElement(By.xpath("//span[text()='Home']")).getText();
        String actualReceivedDocs = driver.findElement(By.xpath("//span[text()='Received docs']")).getText();
        String actualMyUploads = driver.findElement(By.xpath("//span[text()='My uploads']")).getText();
        String actualInvitations = driver.findElement(By.xpath("//span[text()='Invitations']")).getText();
        System.out.println(actualHome);
        System.out.println(actualReceivedDocs);
        System.out.println(actualMyUploads);
        System.out.println(actualInvitations);
        if (actualHome.equals(expectedHome)) {
            System.out.println("Expected " + expectedHome + " matches actual " + actualHome);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedHome + " DOES NOT match actual " + actualHome);
            System.out.println("Test FAILED");
        }

        if (actualReceivedDocs.equals(expectedReceivedDocs)) {
            System.out.println("Expected " + expectedReceivedDocs + " matches actual " + actualReceivedDocs);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedReceivedDocs + " DOES NOT match actual " + actualReceivedDocs);
            System.out.println("Test FAILED");
        }

        if (actualMyUploads.equals(expectedMyUploads)) {
            System.out.println("Expected " + expectedMyUploads + " matches actual " + actualMyUploads);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedMyUploads + " DOES NOT match actual " + actualMyUploads);
            System.out.println("Test FAILED");
        }

        if (actualInvitations.equals(expectedInvitations)) {
            System.out.println("Expected " + expectedInvitations + " matches actual " + actualInvitations);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedInvitations + " DOES NOT match actual " + actualInvitations);
            System.out.println("Test FAILED");
        }

        WebElement threeLinesButton = driver.findElement(By.xpath("//div[@class='col col-4']/button"));
        threeLinesButton.click();
        Thread.sleep(1000);

        actualHome = driver.findElement(By.xpath("//span[text()='Home']")).getText();
        actualReceivedDocs = driver.findElement(By.xpath("//span[text()='Received docs']")).getText();
        actualMyUploads = driver.findElement(By.xpath("//span[text()='My uploads']")).getText();
        actualInvitations = driver.findElement(By.xpath("//span[text()='Invitations']")).getText();
        System.out.println();

        if (!actualHome.equals(expectedHome)) {
            System.out.println("Expected " + expectedHome + " DOES NOT match actual " + actualHome);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedHome + " matches actual " + actualHome);
            System.out.println("Test FAILED");
        }

        if (!actualReceivedDocs.equals(expectedReceivedDocs)) {
            System.out.println("Expected " + expectedReceivedDocs + " DOES NOT match actual " + actualReceivedDocs);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedReceivedDocs + " matches actual " + actualReceivedDocs);
            System.out.println("Test FAILED");
        }
        if (!actualMyUploads.equals(expectedMyUploads)) {
            System.out.println("Expected " + expectedMyUploads + " DOES NOT match actual " + actualMyUploads);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedMyUploads + " matches actual " + actualMyUploads);
            System.out.println("Test FAILED");
        }

        if (!actualInvitations.equals(expectedInvitations)) {
            System.out.println("Expected " + expectedInvitations + " DOES NOT match actual " + actualInvitations);
            System.out.println("Test PASSED");
        } else {
            System.out.println("Expected " + expectedInvitations + " matches actual " + actualInvitations);
            System.out.println("Test FAILED");
        }
        Thread.sleep(1000);
        driver.quit();
    }
}
