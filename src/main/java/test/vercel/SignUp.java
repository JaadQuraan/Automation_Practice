package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class SignUp extends TestBase {

    @Test
    public void testSignUp(){
        driver.get("https://loopcamp.vercel.app/sign_up.html");
        WebElement header = driver.findElement(By.xpath("//h2"));
        String actual = header.getText();
        String expected = "Sign Up Page";
        assertEquals(actual,expected,"SignUp page not loaded");
        WebElement fullName = driver.findElement(By.xpath("//input[@name='full_name']"));
        fullName.sendKeys("Java Java");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("java@gmail.com");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        actual = success.getText();
        expected = "Success!";
        assertTrue(actual.contains(expected),"Sign up was not successful");


    }
}
