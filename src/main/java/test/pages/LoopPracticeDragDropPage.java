package test.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.utilities.Driver;

public class LoopPracticeDragDropPage {

    @FindBy(xpath="//*[@id='draggable']")
    public WebElement smallCircle;

    @FindBy(id="droptarget")
    public WebElement bigCircle;

    public LoopPracticeDragDropPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

//Constructor initializes the elements from findBy and the driver
//initElements locates all the elements on this page one time then going to start using it