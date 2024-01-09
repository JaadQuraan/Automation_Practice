package test.day12_tasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.BrowserUtils;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
task1
1. Open browser
2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click on Login button
6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10.Click on “visa” radio button
11.Generate card number using JavaFaker
12.Click on “Process”
13.Verify success message “New order has been successfully added.”
 */
public class Task1 {

    SecureSmartBearPage secureSmartBearPage;
    Faker faker;
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.login"));
        secureSmartBearPage = new SecureSmartBearPage();
        faker = new Faker();
    }

    @Test
    public void testProduct(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        secureSmartBearPage.username.sendKeys("Tester");
        secureSmartBearPage.password.sendKeys("test");
        secureSmartBearPage.loginButton.click();
        secureSmartBearPage.orderButton.click();

        Select dropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        dropdown.selectByValue("FamilyAlbum");

        secureSmartBearPage.quantity.clear();
        secureSmartBearPage.quantity.sendKeys("2");
        secureSmartBearPage.calculateButton.click();

        //Address Info
        secureSmartBearPage.customerName.sendKeys(faker.name().fullName());
        secureSmartBearPage.street.sendKeys(faker.address().streetName());
        secureSmartBearPage.city.sendKeys(faker.address().city());
        secureSmartBearPage.state.sendKeys(faker.address().state());
        secureSmartBearPage.zip.sendKeys(faker.address().zipCode());
        //Card info
        secureSmartBearPage.visaButton.click();
        secureSmartBearPage.cardNumberBox.sendKeys(faker.numerify("################"));
        secureSmartBearPage.cardExpiration.sendKeys(faker.numerify("##/##"));
        secureSmartBearPage.processButton.click();
        BrowserUtils.waitForVisibility(secureSmartBearPage.result,5);
        assertEquals(secureSmartBearPage.result.getText(),"New order has been successfully added.","Actual does not match expected");

    }

    @AfterMethod
    public void teardownMethod(){
        Driver.closeDriver();
    }
}

class  SecureSmartBearPage{
    public SecureSmartBearPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement orderButton;

    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement selectDropdown;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement calculateButton;

    @FindBy(id="ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$cardList']")
    public WebElement visaButton;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")
    public WebElement cardNumberBox;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")
    public WebElement cardExpiration;

    @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = "//div[@class='buttons_process']/strong")
    public WebElement result;
}