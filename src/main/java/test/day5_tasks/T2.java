package test.day5_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class T2 {

    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    @BeforeClass
    public void setup(){
        System.out.println("Before class is running");
    }
    @AfterClass
    public void teardown(){
        System.out.println("After class is running");
    }
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
    }
    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }

    @Test
    public void testRings() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
//        searchBox.sendKeys("rings");
//        Thread.sleep(1000);
        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(searchBox,"rings").sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);
        WebElement estimatedDate = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']/span"));
        actual = estimatedDate.getText();
        expected = "Estimated Arrival Any time";
        System.out.println(actual);
        Assert.assertEquals(actual,expected,"Actual does not match expected");
        estimatedDate.click();
        Thread.sleep(2000);
        WebElement customDates = driver.findElement(By.xpath("//select[@id='edd_select_tf']"));
        Select dropdown = new Select(customDates);
        Thread.sleep(2000);
        customDates.click();

        dropdown.selectByValue("20");
        Thread.sleep(2000);
        WebElement estimatedDate2 = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']/span"));
        actual = estimatedDate2.getText();
        expected = "Estimated Arrival By Dec 25";
        System.out.println(actual);
        Assert.assertEquals(actual,expected,"Actual does not match expected");

    }
}
