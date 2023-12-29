package test.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RF3 extends TestBase{

    @Test
    public void extraTask() throws InterruptedException {
        driver.get(" https://app.docuport.app/company-formation/resident");

        // Clicking on checkbox Corporation
        WebElement corporationButton = driver.findElement(By.xpath("//label[.='Corporation']/../div/div"));
        WebElement corporationRadioButton = driver.findElement(By.xpath("//label[.='Corporation']/../div/input[@role='radio']"));
        corporationButton.click();
        Assert.assertTrue(corporationRadioButton.isSelected(), "Corporation is not selected");

        // Selecting states
        List<String> states = Arrays.asList("Delaware", "Maryland", "Virginia", "Washington D.C.");
        for (String state : states) {
            WebElement stateElement = findWebElementsForClicking(state);
            stateElement.click();
            WebElement radioButtonElement = findWebElementsForAssertion(state);
            Assert.assertTrue(radioButtonElement.isSelected(), state + " is not selected");
        }

        // Selecting industry
        WebElement industry = driver.findElement(By.xpath("//label[text()='Industry *']/following-sibling::input"));
        industry.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> industryOptions = driver.findElements(By.xpath("//div[@tabindex='0']//following-sibling::div[1] "));

        for (WebElement option : industryOptions) {
            String optionText = option.getText().trim();
            System.out.println(optionText);

            if (optionText.equals("Accounting")) {
                continue;
            }

            // Simulate selection
            option.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='0']//following-sibling::div/div/div[text()='" + optionText + "']")));

            // Assert
            WebElement actual = driver.findElement(By.xpath("//div[@tabindex='0']//following-sibling::div/div/div[normalize-space(.)='" + optionText + "']"));
            Assert.assertTrue(actual.isDisplayed(), "Option '" + optionText + "' is not displayed");
        }

        // Assert "Other"
        WebElement other = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@tabindex='0']//following-sibling::div/div/div[text()='Other']")));
        Assert.assertTrue(other.isDisplayed(), "Other option is not displayed");
    }

    private WebElement findWebElementsForClicking(String state) {
        String stateXpath = "//label[.='" + state + "']/../div/div";
        return driver.findElement(By.xpath(stateXpath));
    }

    private WebElement findWebElementsForAssertion(String state) {
        String stateXpath = "//label[.='" + state + "']/../div/input[@role='radio']";
        return driver.findElement(By.xpath(stateXpath));
    }
}
