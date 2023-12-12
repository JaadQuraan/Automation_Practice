package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.LogUtil;
import test.utilities.Messages;
import test.utilities.WebDriverFactory;

public class Autocomplete {

    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/autocomplete.html";

    @Test
    public void testLogo(){
        WebElement logo = driver.findElement(By.xpath("//img[@src='./img/logo.svg']"));

        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed");
    }
    @Test
    public  void testAutocomplete() throws InterruptedException {

        //Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("myCountry"));
        search.sendKeys("United States");
        //Thread.sleep(2000);
        new Actions(driver)
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform();
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("result"));
        String resText = result.getText();

        Assert.assertTrue(resText.contains("You selected:"),"Log text" + LogUtil.containsMessage(resText,"You selected:"));


    }
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }
    @AfterMethod
    public void teardownMethod(){
      //  driver.close();
    }
}
