package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DynamicLoading {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
    }

    @Test
    public void test1 (){

        driver.get("https://loopcamp.vercel.app/dynamic_loading/1.html");
        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement user = driver.findElement(By.xpath("//input[@type = 'username']"));
        user.click();
        user.clear();
        user.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        password.click();
        password.clear();
        password.sendKeys("SuperSecretPassword");
        WebElement submit = driver.findElement(By.xpath("//button[text() ='Submit' ]"));
        submit.click();
        WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        String expected = "You logged into a secure area!";
        String actual = success.getText();
        assertEquals(actual,expected,"You entered wrong username or password for login");
    }

    @Test
    public void test2 (){
        driver.get("https://loopcamp.vercel.app/dynamic_loading/2.html");
        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // WebElement helloWorld = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[1]/h4"));
        WebElement helloWorld2 = driver.findElement(By.xpath("//h4[text() = 'Hello World!']"));
        String actual = helloWorld2.getText();
        String expected = "Hello World!";
        assertEquals(actual,expected, "The Hello World! is not displayed");

    }

    @Test
    /*public void test3 () {
        //wait 5 seconds
       driver.get("https://loopcamp.vercel.app/dynamic_loading/3.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(6));
        wait.until(d ->driver.findElement(By.xpath("//input[@type = 'username']")) );
        WebElement user = driver.findElement(By.xpath("//input[@type = 'username']"));
        user.click();
        user.clear();
        user.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        password.click();
        password.clear();
        password.sendKeys("SuperSecretPassword");
        WebElement submit = driver.findElement(By.xpath("//button[text() ='Submit' ]"));
        submit.click();
        WebElement success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        String expected = "You logged into a secure area!";
        String actual = success.getText();
        assertEquals(actual,expected,"You entered wrong username or password for login");
    }

      */


        @AfterMethod
        public void teardownMethod () {
            //  driver.close();
        }


    }