package test.day3_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import test.utilities.WebDriverFactory;

public class Task0ng {

    WebDriver driver;
    String expected;
    String actual;
    @BeforeClass
    public void setup() {
        System.out.println("Before class is running");
    }
    @AfterClass
    public void teardown() {
        System.out.println("After class is running");
    }
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardownMethod(){
        //driver.close();
    }

    @Test (priority = 1)
    public void testForgotPassword(){
        driver.get("https://loopcamp.vercel.app/forgot-password.html");
        WebElement forgotPassword = driver.findElement(By.tagName("h2"));
         actual = forgotPassword.getText();
         expected = "Forgot Password";
        Assert.assertEquals(actual,expected,"Passwords do not match");
    }
    @Test (priority = 1)
    public void email(){
        driver.get("https://loopcamp.vercel.app/forgot-password.html");
        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        actual  = email.getText();
        expected  =  "E-mail";
        Assert.assertEquals(actual,expected,"Emails do not match");
    }
}


