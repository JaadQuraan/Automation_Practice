package test.day5_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import test.utilities.DocuportConstants;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class DocuportDropdown {

    WebDriver driver;
    String expected = "Done";
    String actual;

    @BeforeTest
    public void setUp() {
        System.out.println("Test is running");
    }

    @AfterTest
    public void teardown() {
        System.out.println("Test is done");
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        Driver.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardownMethod() {
        Driver.getDriver().close();
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        Driver.getDriver().get("https://beta.docuport.app/login");
        WebElement usernameInput = Driver.getDriver().findElement(By.cssSelector("label[for='input-14'] + input"));
        WebElement passwordInput = Driver.getDriver().findElement(By.cssSelector("label[for='input-15'] + input"));
        WebElement login = Driver.getDriver().findElement(By.cssSelector("button[type='submit']"));

        usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
        passwordInput.sendKeys(DocuportConstants.PASSWORD_CLIENT);
        login.click();
        Thread.sleep(3000);
        WebElement continueButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        continueButton.click();
        Thread.sleep(3000);
        WebElement myUploads = Driver.getDriver().findElement(By.xpath("//a[@href='/my-uploads']"));
        myUploads.click();
        Thread.sleep(3000);
        WebElement searchElement = Driver.getDriver().findElement(By.xpath("//span[@class='subtitle-2 text-none' and text()='Search']"));
        searchElement.click();
        WebElement statusBox = Driver.getDriver().findElement(By.xpath("//div[@class='v-select__selection v-select__selection--comma']"));
        statusBox.click();
        Thread.sleep(2000);
        WebElement doneStatus = Driver.getDriver().findElement(By.xpath("//div[@class='v-list-item__title' and text()='Done']"));
        doneStatus.click();

        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//div[@class='v-select__selection v-select__selection--comma']")).getText(), expected, "Done is not the current status");
    }
}
