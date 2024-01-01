package test.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoadingPage {



    @FindBy(xpath="//div[@id='alert']")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;

    public LoopPracticeDynamicLoadingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
// this keyword says for this class
