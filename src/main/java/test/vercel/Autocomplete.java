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
import test.utilities.Driver;
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
        WebElement logo = Driver.getDriver().findElement(By.xpath("//img[@src='./img/logo.svg']"));

        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed");
    }
    @Test
    public  void testAutocomplete() throws InterruptedException {

        //Thread.sleep(2000);
        WebElement search = Driver.getDriver().findElement(By.id("myCountry"));
        search.sendKeys("United States"); //instead of typing "United States of America". Use actions to use autocomplete
        Thread.sleep(2000);
       Actions actions = new Actions(driver);
                actions.keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform(); //
        Thread.sleep(2000);
        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//input[@type='button']"));
        submitButton.click();

        WebElement result = Driver.getDriver().findElement(By.id("result"));
        String resultText = result.getText();
        System.out.println(resultText);
        Assert.assertTrue(resultText.contains("You selected:"),"You did not select an option");


    }
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(pageURL);
    }
    @AfterMethod
    public void teardownMethod(){
        Driver.getDriver().quit();
    }
}
