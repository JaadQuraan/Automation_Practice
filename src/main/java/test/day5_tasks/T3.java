package test.day5_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import test.utilities.DocuportConstants;
import test.utilities.WebDriverFactory;

public class T3 {

    WebDriver driver;
    String expected = "Please select an option";
    String actual;

    @BeforeClass
    public void setup(){
        System.out.println("Before class is running");
    }
    @AfterClass
    public void teardown(){
        System.out.println("After class is running");
    }
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/login");
    }
    @AfterMethod
    public void teardownMethod(){
        driver.close();
    }

    @Test
    public void testStatusDropdown() throws InterruptedException {
    Actions actions = new Actions(driver);
    WebElement usernameInput = driver.findElement(By.cssSelector("label[for='input-14'] + input"));
    actions.sendKeys(usernameInput, DocuportConstants.USERNAME_ADVISOR).sendKeys(Keys.TAB).sendKeys(DocuportConstants.PASSWORD_ADVISOR).sendKeys(Keys.ENTER).perform();
    Thread.sleep(2000);
    WebElement receivedDocuments = driver.findElement(By.xpath("//h2[contains(., 'Received') and contains(., 'documents')]"));
    receivedDocuments.click();

    WebElement searchElement = driver.findElement(By.xpath("//span[@class='subtitle-2 text-none' and text()='Search']"));
    searchElement.click();
    WebElement statusBox = driver.findElement(By.xpath("//div[@class='v-select__selection v-select__selection--comma']"));
    statusBox.click();
    Thread.sleep(2000);
    expected = "In progress";
    WebElement inProgressStatus = driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='In progress']"));
    inProgressStatus.click();
    actual = driver.findElement(By.xpath("//div[@class='v-select__selection v-select__selection--comma']")).getText();
    System.out.println(actual);
    Assert.assertEquals(actual, expected, "In progress is not the current status");


    }


}
