package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.WebDriverFactory;


import java.time.Duration;
import java.util.List;

public class Dropdown extends TestBase {
    @Test
    public void simple() {
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        WebElement simpleDropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select simple = new Select(simpleDropdownElement);
        String actual = simple.getFirstSelectedOption().getText();
        String expected = "Please select";
        assertTrue(actual.contains(expected),"Not on dropdown page");
        simple.selectByIndex(2);
        actual = simple.getFirstSelectedOption().getText();
        expected = "Option 2";
        assertEquals(actual,expected,"Option 2 not selected");
    }
    @Test
    public void testDOB(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        WebElement yearElement = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement monthElement = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
        Select year = new Select(yearElement);
        Select month = new Select(monthElement);
        Select day = new Select(dayElement);
        year.selectByVisibleText("2000");
        month.selectByValue("0"); //January
        day.selectByIndex(0); // 1
        System.out.println("Date of Birth: " + year.getFirstSelectedOption().getText() + "/"
                + month.getFirstSelectedOption().getText() + "/"
                + day.getFirstSelectedOption().getText());
        String actual = "Date of Birth: " + year.getFirstSelectedOption().getText() + "/"
                + month.getFirstSelectedOption().getText() + "/"
                + day.getFirstSelectedOption().getText();
        String expected = "Date";
        assertTrue(actual.contains(expected), "No date changed");

    }
    @Test
    public void stateTest(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        WebElement stateElement = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(stateElement);
        String actual = stateDropdown.getFirstSelectedOption().getText();
        String expected = "Select a State";
        assertEquals(actual,expected,"Unable to select a state");
        List<WebElement> listOfStates = stateDropdown.getOptions();
        stateDropdown.selectByValue("OH");
         actual = stateDropdown.getFirstSelectedOption().getText();
        for (WebElement element: listOfStates){
            //System.out.println(element.getText());
            if(element.getText().equals(actual)){
                System.out.println("The state of: " + element.getText() + " has been selected");
            }
        }
        assertTrue(!actual.contains("Select"), "A state has not been selected");
    }

    @Test
    public void programmingLanguagesMultiple(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        WebElement languagesElement = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select languages =  new Select(languagesElement);
        languages.deselectAll();
        languages.selectByVisibleText("Java");
        languages.selectByIndex(1);
        assertTrue(languages.getAllSelectedOptions().contains(driver.findElement
                (By.xpath("//option[@value='java']"))),"Java was not selected");
        assertTrue(languages.getAllSelectedOptions().contains(driver.findElement
                (By.xpath("//option[@value='js']"))),"JavaScript was not selected");
    }
    @Test
    public void testSelectWebsites(){
        driver.get("https://loopcamp.vercel.app/dropdown.html");
        WebElement websiteDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        WebElement google = driver.findElement(By.xpath("//a[@href='https://www.google.com/']"));
        WebElement amazon = driver.findElement(By.xpath("//a[@href='https://www.amazon.com/']"));
        WebElement yahoo = driver.findElement(By.xpath("//a[@href='https://www.yahoo.com/']"));
        WebElement facebook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        WebElement etsy = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/']"));
        websiteDropdown.click();
        google.click();
        assertTrue(driver.getTitle().contains("Google"),"Google.com was not loaded");
        driver.navigate().back();
        websiteDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        websiteDropdown.click();
        amazon.click();
        assertTrue(driver.getTitle().contains("Amazon"),"Amazon.com was not loaded");
        driver.navigate().back();

        websiteDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        websiteDropdown.click();
        yahoo.click();
        assertTrue(driver.getTitle().contains("Yahoo"),"Yahoo.com was not loaded");

        driver.navigate().back();
        websiteDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        websiteDropdown.click();
        facebook.click();
        assertTrue(driver.getTitle().contains("Facebook"),"Facebook.com was not loaded");

        driver.navigate().back();
        websiteDropdown = driver.findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        websiteDropdown.click();
        etsy.click();
        assertTrue(driver.getTitle().contains("Etsy"),"Etsy.com was not loaded");
    }
}
