package test.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checkbox extends TestBase {
    @Test
    public void test(){
        Driver.getDriver().get("https://demoqa.com/checkbox");
        WebElement homeArrrow = Driver.getDriver().findElement(By.xpath("//label[@for='tree-node-home']/../button"));
        homeArrrow.click();
        WebElement documentCheckbox = Driver.getDriver().findElement(By.xpath("//span[text()='Documents']/../span"));
        documentCheckbox.click();
        WebElement desktopCheckbox = Driver.getDriver().findElement(By.xpath("//span[text()='Desktop']/../span"));
        desktopCheckbox.click();
        WebElement documentArrow = Driver.getDriver().findElement(By.xpath("//label[@for='tree-node-documents']/../button"));
        documentArrow.click();
        WebElement downloadArrow = Driver.getDriver().findElement(By.xpath("//label[@for='tree-node-downloads']/../button"));
        downloadArrow.click();
        WebElement wordFile = Driver.getDriver().findElement(By.xpath("//span[text()='Word File.doc']/preceding-sibling::span"));
        wordFile.click();
        WebElement excelFile = Driver.getDriver().findElement(By.xpath("//span[text()='Excel File.doc']/preceding-sibling::span"));
        excelFile.click();

        int numOfSpans = 18; // 18 when all checked
      //  WebElement resultElement = Driver.getDriver().findElement(By.xpath("//div[@id='result']"));
        List<String> actualStrings = new ArrayList<>();
        for (int i = 1; i < numOfSpans; i++) {
            actualStrings.add(Driver.getDriver().findElement(By.xpath("//div[@id='result']/span[" + i + "]")).getText());
        }
        String[] arr = {"You have selected :", "home", "desktop", "notes", "commands", "documents", "workspace", "react", "angular", "veu", "office", "public", "private", "classified", "general", "downloads", "wordFile"};

        List<String> expectedStrings = new ArrayList<>(Arrays.asList(arr));
        System.out.println("Expected: " + expectedStrings);
        System.out.println("Actual: " + actualStrings);
        assertEquals(actualStrings,expectedStrings, "The messages are NOT equal");
    }
}
