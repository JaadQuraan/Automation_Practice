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
import test.utilities.Driver;
import test.utilities.WebDriverFactory;
import test.utilities.enums.States;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Dropdown  {

    Random random;
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://loopcamp.vercel.app/dropdown.html");
        random = new Random();
    }
    @Test
    public void simple() {
        WebElement simpleDropdownElement = Driver.getDriver().findElement(By.xpath("//select[@id='dropdown']"));
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
        WebElement yearElement = Driver.getDriver().findElement(By.xpath("//select[@id='year']"));
        WebElement monthElement = Driver.getDriver().findElement(By.xpath("//select[@id='month']"));
        WebElement dayElement = Driver.getDriver().findElement(By.xpath("//select[@id='day']"));
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
        Select stateDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));

        String actualDefault = stateDropdown.getFirstSelectedOption().getText();
        String STATE_DROPDOWN_DEFAULT = "Select a State";
        assertEquals(actualDefault,STATE_DROPDOWN_DEFAULT,"Unable to select a state");

        int num = random.nextInt((States.values().length-1));
        String expected = States.values()[num-1].name();
        stateDropdown.selectByValue(expected);
        String actual = stateDropdown.getFirstSelectedOption().getAttribute("value");
        assertEquals(actual,expected,"The " + actual + " does not match" + expected);

    }


    @Test
    public void programmingLanguagesMultiple(){
        WebElement languagesElement = Driver.getDriver().findElement(By.xpath("//select[@name='Languages']"));
        Select languages =  new Select(languagesElement);
        languages.deselectAll();
        languages.selectByVisibleText("Java");
        languages.selectByIndex(1);
        String [] arr = languages.getAllSelectedOptions().stream().map(each -> each.getText()).toArray(String[]::new);
        assertEquals(arr, new String[]{"Java","JavaScript"});
//        assertTrue(languages.getAllSelectedOptions().contains(Driver.getDriver().findElement
//                (By.xpath("//option[@value='java']"))),"Java was not selected");
////        assertTrue(languages.getAllSelectedOptions().contains(Driver.getDriver().findElement
////                (By.xpath("//option[@value='java']"))),"Java was not selected");
//        assertTrue(languages.getAllSelectedOptions().contains(Driver.getDriver().findElement
//                (By.xpath("//option[@value='js']"))),"JavaScript was not selected");
    }
    @Test
    public void testSelectWebsites(){
        WebElement websiteDropdown = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));

        for (int i = 0; i < 5; i++) {
            websiteDropdown.click();
            List<WebElement> websites = Driver.getDriver().findElements(By.xpath("//div[@class='dropdown-menu show']/a"));            WebElement site = websites.get(i);
            String current = websites.get(i).getText();
            site.click();
            assertTrue(Driver.getDriver().getTitle().contains(current),current + ".com was not loaded");
            Driver.getDriver().navigate().back();
        }


    }
}
