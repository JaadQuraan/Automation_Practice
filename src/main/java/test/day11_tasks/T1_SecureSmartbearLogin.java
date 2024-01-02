package test.day11_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.BrowserUtils;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

import java.util.List;
/*
task1
1. Open browser
2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
 */
public class T1_SecureSmartbearLogin {

    SecureSmartBearLoginPage secureSmartBearLoginPage;
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.login"));
        secureSmartBearLoginPage = new SecureSmartBearLoginPage();
    }

    @Test
    public void getLinks_test(){
        secureSmartBearLoginPage.username.sendKeys("Tester");
        secureSmartBearLoginPage.password.sendKeys("test");
        BrowserUtils.waitForClickable(secureSmartBearLoginPage.loginButton,5).click();

        //Get count of all links
        List<WebElement> linksList = Driver.getDriver().findElements(By.xpath("//a"));
        System.out.println("Size = " + linksList.size()); // count = 6

        for(WebElement link : linksList){
            if(!link.getText().equals("")) {
                System.out.println("Link Text = " + link.getText());
            }
        }
        for(WebElement link : linksList){
            System.out.println("Link = " + link.getAttribute("href"));
        }

    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}

class  SecureSmartBearLoginPage{
    public SecureSmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

}

