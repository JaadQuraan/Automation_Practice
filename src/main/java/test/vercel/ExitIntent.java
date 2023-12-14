package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class ExitIntent extends TestBase{

    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/entry-ad.html#";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @Test
    public void test () throws InterruptedException {
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        actions.moveToLocation(0,0);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'modal']"))));

           WebElement modalTitle = driver.findElement(By.xpath("//div[@class= 'modal-title']/h3"));
     String actual = modalTitle.getText();
      String expected = "THIS IS A MODAL WINDOW";
     assertEquals(actual,expected,"Modal window not displayed");
        WebElement modalWindow = driver.findElement(By.xpath("//div[@class = 'modal']"));
        assertTrue(modalWindow.isDisplayed(),"Modal window is not displayed");

    }
    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }

}
