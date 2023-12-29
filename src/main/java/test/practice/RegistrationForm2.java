package test.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;
import java.util.*;

public class RegistrationForm2 extends TestBase {

    @Test
    public void extraTask() throws InterruptedException {
        driver.get(" https://app.docuport.app/company-formation/resident");


        //clicking on checkbox Corporation
        WebElement corporationButtom = driver.findElement(By.xpath("//label[.='Corporation']/../div/div"));
        WebElement corporationRadioButton = driver.findElement(By.xpath("//label[.='Corporation']/../div/input[@role='radio']"));
        corporationButtom.click();

        System.out.println("corporationRadioButtom.isSelected() = " + corporationRadioButton.isSelected());

        List<String> states = new ArrayList<>(Arrays.asList("Delaware", "Maryland", "Virginia", "Washington D.C."));
        Map<String, WebElement> stateXpath = new HashMap<>();

        for (String state : states) {
            stateXpath.put(state, findWebElementsForClicking(state));
        }
//for cliccking
        for (Map.Entry<String, WebElement> each : stateXpath.entrySet()) {

            each.getValue().click();
            WebElement radioButtonElement = findWebElementsForAssertion(each.getKey());
            Assert.assertTrue(radioButtonElement.isSelected(), each.getKey() + " is not selected");
        }


        WebElement industry = driver.findElement(By.xpath("//label[text()='Industry *']/following-sibling::input"));
        industry.click();

        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed

        for (int i = 0; i < 47; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(200);
        }
//
        List<WebElement> industryOptions = driver.findElements(By.xpath("//div[@tabindex='0']//following-sibling::div[1] "));

        for (int i = 0; i < industryOptions.size(); i++) {
            System.out.println(industryOptions.get(i).getText());
        }
        System.out.println("Size:" + industryOptions.size());

        WebElement other = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='0']//following-sibling::div/div/div[text()='Other']")));
        Assert.assertTrue(other.isDisplayed(), "Other option is not displayed");

        List<String> industryOptionList = Arrays.asList("Accounting","Agents", "Agriculture", "Antiques and Collectables", "Arts and Crafts", "Asset Management", "Automative", "Beverages", "Brokers", "Business Services", "Child Care", "Cleaning Services", "Distributor", "Ecommerce", "Education & Training", "Fashion", "Food Services", "Gardening and Landscaping", "Health and Beauty", "Information Technology", "Legal Services", "Maintenance and Repair", "Management Services", "Manufacturing", "Marketing Services","Media", "Medical Practitioners", "Music", "Nightlife", "Personal Services", "Pet Services", "Photography", "Professional Services", "Publishing", "Recruiting and Staffing", "Rental and Leasing", "Research Services", "Retail", "Shipping and Delivery", "Sustainability", "Toys and Hobbies", "Transportation", "Travel and Tourism","Value Added Reseller", "Warehousing and Storage", "Wholesale", "Other"
        );
        for (int i = 0; i < industryOptions.size(); i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(200);
            actions.sendKeys(Keys.ENTER).perform();

            // Hardcoded handling for "Accounting"
            if (industryOptionList.get(i).equals("Accounting")) {
                continue;
            }

            WebElement actual = driver.findElement(By.xpath("//div[@tabindex='0']//following-sibling::div/div/div[normalize-space(.)='" + industryOptionList.get(i) + "']"));
            String expected = industryOptionList.get(i);

            Assert.assertEquals(actual.getText().trim(), expected, "Actual does not match expected");
            industry.click();
        }

    }

    private WebElement findWebElementsForClicking(String state){
        String stateXpath = "//label[.='"+ state+ "']/../div/div";
        WebElement stateElement = driver.findElement(By.xpath(stateXpath));
        return stateElement;
    }

    private WebElement findWebElementsForAssertion (String state){
        String stateXpath = "//label[.='"+ state + "']/../div/input[@role='radio']";
        WebElement radioButtonElement = driver.findElement(By.xpath(stateXpath));
        return radioButtonElement;
    }
}





