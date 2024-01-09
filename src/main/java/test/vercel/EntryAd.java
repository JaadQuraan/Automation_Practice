package test.vercel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

public class EntryAd {

    LoopPracticeEntryAdPage loopPracticeEntryAdPage;

    @BeforeMethod
    public void setupMethod() {
       Driver.getDriver().get("https://loopcamp.vercel.app/entry-ad.html");
       loopPracticeEntryAdPage = new LoopPracticeEntryAdPage();
    }

    @Test
    public void modalWindowTest(){
        System.out.println(loopPracticeEntryAdPage.header.getText());
    }

    @AfterMethod
    public void teardownMethod() {
       // driver.close();
    }

}

class LoopPracticeEntryAdPage{
    public LoopPracticeEntryAdPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h3")
    public WebElement header;

    @FindBy(id = "restart-ad")
    public WebElement clickHere;
}
