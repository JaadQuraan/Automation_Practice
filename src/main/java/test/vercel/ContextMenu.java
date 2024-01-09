package test.vercel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class ContextMenu {



    Actions actions;
    LoopPracticeContextMenuPage loopPracticeContextMenuPage;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/context-menu.html");
        actions = new Actions(Driver.getDriver());
        loopPracticeContextMenuPage = new LoopPracticeContextMenuPage();
    }



        @Test
        public void contextClick () throws InterruptedException {

            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            try {
                actions.contextClick(loopPracticeContextMenuPage.box).perform();
                // Handle the alert
                Alert alert = Driver.getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert Text: " + alertText);
                Assert.assertEquals(alertText, "You selected a context menu", "Actual does NOT match expected");

                alert.accept();
                Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            } catch (NoSuchElementException e) {
                System.out.println("Failed to find or interact with element");
            }
        }
    }

    class LoopPracticeContextMenuPage{

        @FindBy(id="hot-spot")
        public WebElement box;

        public LoopPracticeContextMenuPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }
    }