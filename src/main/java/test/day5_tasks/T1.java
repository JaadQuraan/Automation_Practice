package test.day5_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class T1 {
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
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://the-internet.herokuapp.com/dropdown");
    }
    @AfterMethod
    public void teardownMethod(){
        Driver.getDriver().close();
    }
    @Test (priority = 1)
    public void testDefault() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select dropdown = new Select(Driver.getDriver().findElement(By.id("dropdown")));
        actual = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected,"Actual message does not match expected");
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void testOptions() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select dropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByValue("1");
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 1","Actual does not match expected");
        Thread.sleep(1000);
        dropdown.selectByIndex(2);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Option 2","Actual does not match expected");
        Thread.sleep(1000);

    }
    @Test (priority = 3)
    public void testName() throws InterruptedException {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(Driver.getDriver().findElement(By.tagName("h3")).getText(),"Dropdown List", "Actual does not match expected");
        Thread.sleep(2000);

    }
}

