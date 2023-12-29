package test.vercel;
/*
isSelected() is used for checking the selected state of checkboxes, radio buttons, and dropdown options,
while isEnabled() is used to check if an element is enabled and can be interacted with, such as buttons and input fields.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

public class Checkboxes {
    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/checkboxes.html";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(pageURL);
    }

    @AfterMethod
    public void teardownMethod() {
        Driver.getDriver().close();
    }


    @Test
    public  void testCheckboxes() throws InterruptedException {

        WebElement checkbox1 = Driver.getDriver().findElement(By.id("box1"));
        if(!checkbox1.isSelected()){  checkbox1.click();}
        Thread.sleep(1000);
        WebElement checkbox2 = Driver.getDriver().findElement(By.id("box2"));
        if(!checkbox1.isSelected()){  checkbox2.click();}
        Thread.sleep(1000);
        Assert.assertTrue(checkbox1.isSelected() && checkbox2.isSelected(),"Both checkboxes are NOT selected");


    }
}
