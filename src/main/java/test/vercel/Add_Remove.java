package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import static org.testng.Assert.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.BrowserUtils;
import test.utilities.Driver;

import java.time.Duration;
import java.util.Random;

public class Add_Remove{

    LoopPracticeAddRemovePage loopPracticeAddRemovePage;


    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/add-remove-elements.html");
        loopPracticeAddRemovePage = new LoopPracticeAddRemovePage();

    }
    @Test
    public void testAdd()  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        BrowserUtils.waitForClickable(loopPracticeAddRemovePage.addButton,5);
        loopPracticeAddRemovePage.addButton.click();
        clickAddRandomTimes();
        BrowserUtils.justWait(3);

        while (isDeleteButtonDisplayed()) {
            WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//button[@class='added-manually btn btn-secondary']"));
            deleteButton.click();
        }
        assertFalse(isDeleteButtonDisplayed(), "Delete button is still displayed");


    }

    public void clickAddRandomTimes(){
        Random random = new Random();

        for (int i = 1; i < random.nextInt(10); i++) {
            loopPracticeAddRemovePage.addButton.click();
        }
    }

    public boolean isDeleteButtonDisplayed() {
        try {
            WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//button[@class='added-manually btn btn-secondary']"));
            return deleteButton.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}

class LoopPracticeAddRemovePage {

    public LoopPracticeAddRemovePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement addButton;
}
