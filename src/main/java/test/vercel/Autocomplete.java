package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.*;

import java.time.Duration;

/*
go to: https://loopcamp.vercel.app/autocomplete.html
Check task works manually first and explain what you would be looking for automation testing
1. Type "United States of America" in input box
2. Click the submit button
3. Verify "You selected: United States of America"
 */
public class Autocomplete {
    Actions actions;

    LoopPracticeAutocompletePage loopPracticeAutocompletePage;

    @Test
    public void testLogo(){
        WebElement logo = Driver.getDriver().findElement(By.xpath("//img[@src='./img/logo.svg']"));

        Assert.assertTrue(logo.isDisplayed(),"Logo is not displayed");
    }
    @Test
    public  void testAutocomplete() throws InterruptedException {

        //Thread.sleep(2000);
        loopPracticeAutocompletePage.search.sendKeys("United States"); //instead of typing "United States of America". Use actions to use autocomplete
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                actions.keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform(); //
        BrowserUtils.waitForClickable(loopPracticeAutocompletePage.submitButton,5).click();

        String resultText = loopPracticeAutocompletePage.result.getText();
        System.out.println(resultText);
        Assert.assertTrue(resultText.contains("You selected:"),"You did not select an option");


    }
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/autocomplete.html");
        loopPracticeAutocompletePage = new LoopPracticeAutocompletePage();
        actions = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void teardownMethod(){
        Driver.getDriver().quit();
    }

    class LoopPracticeAutocompletePage{
        public LoopPracticeAutocompletePage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(id="myCountry")
        public WebElement search;

        @FindBy(xpath = "//img[@src='./img/logo.svg']")
        public WebElement logo;

        @FindBy(xpath = "//input[@type='button']")
        public WebElement submitButton;

        @FindBy(id="result")
        public WebElement result;


    }
}
