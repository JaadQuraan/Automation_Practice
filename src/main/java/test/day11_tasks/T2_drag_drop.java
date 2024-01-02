package test.day11_tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

import static org.testng.Assert.assertEquals;
/*
task1
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Move it on top of the big circle
5. validate “Now drop…” text appears on big circ

task2
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
 */
public class T2_drag_drop {
    LoopPracticeDragDropPage loopPracticeDragDropPage;
    Actions actions;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vercel.drag"));
        loopPracticeDragDropPage = new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void nowDrop_test(){
        actions.moveToElement(loopPracticeDragDropPage.smallCircle)
                .clickAndHold()
                .moveToElement(loopPracticeDragDropPage.bigCircle)
                .pause(2000)
                .perform();
        String expected = "Now drop...";
        String actual = loopPracticeDragDropPage.bigCircle.getText();
        assertEquals(actual,expected,"Actual message: " + actual + " does not match " + expected);    }

    @Test
    public void tryAgain_test(){
        actions.moveToElement(loopPracticeDragDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(100,100)
                .release()
                .perform();
        String expected = "Try again!";
        String actual = loopPracticeDragDropPage.bigCircle.getText();
        assertEquals(actual,expected,"Actual message: " + actual + " does not match " + expected);
    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}

class LoopPracticeDragDropPage {

    @FindBy(xpath="//*[@id='draggable']")
    public WebElement smallCircle;

    @FindBy(id="droptarget")
    public WebElement bigCircle;

    public LoopPracticeDragDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}