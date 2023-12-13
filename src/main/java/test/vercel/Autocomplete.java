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
/*
go to: https://loopcamp.vercel.app/autocomplete.html
Check task works manually first and explain what you would be looking for automation testing
1. Type "United States of America" in input box
2. Click the submit button
3. Verify "You selected: United States of America"
 */
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
        Thread.sleep(2000);
       Actions actions = new Actions(driver);
                actions.keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform(); //
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("result"));
        String resText = result.getText();

        Assert.assertTrue(resText.contains("You selected:"),"You did not select an option");


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
