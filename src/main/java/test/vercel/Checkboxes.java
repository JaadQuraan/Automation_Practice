package test.vercel;
/*
isSelected() is used for checking the selected state of checkboxes, radio buttons, and dropdown options,
while isEnabled() is used to check if an element is enabled and can be interacted with, such as buttons and input fields.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.BrowserUtils;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

public class Checkboxes {
    LoopPracticesCheckboxesPage loopPracticesCheckboxesPage;

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get("https://loopcamp.vercel.app/checkboxes.html");
        loopPracticesCheckboxesPage = new LoopPracticesCheckboxesPage();
    }

    @AfterMethod
    public void teardownMethod() {
        //Driver.getDriver().close();
    }


    @Test
    public  void testCheckboxes() throws InterruptedException {

        if(!loopPracticesCheckboxesPage.checkbox1.isSelected()){  loopPracticesCheckboxesPage.checkbox1.click();}
        BrowserUtils.justWait(1);
        if(!loopPracticesCheckboxesPage.checkbox2.isSelected()){  loopPracticesCheckboxesPage.checkbox2.click();}
        BrowserUtils.justWait(1);

        Assert.assertTrue(loopPracticesCheckboxesPage.checkbox1.isSelected() && loopPracticesCheckboxesPage.checkbox2.isSelected(),"Both checkboxes are NOT selected");


    }
}

class LoopPracticesCheckboxesPage{
    public LoopPracticesCheckboxesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="box1")
    public WebElement checkbox1;

    @FindBy(id="box2")
    public WebElement checkbox2;
}
