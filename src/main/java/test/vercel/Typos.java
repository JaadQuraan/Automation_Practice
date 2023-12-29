package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class Typos {

    @Test
    public void test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/typos.html");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait( Driver.getDriver(),Duration.ofSeconds(5));
        WebElement sentence = Driver.getDriver().findElement(By.xpath("//p[@id='sentence']"));
        String initialText = sentence.getText();

        for (int i = 0; i < 3; i++) {
            Driver.getDriver().navigate().refresh();
            wait.until(ExpectedConditions.stalenessOf(sentence));
            sentence = Driver.getDriver().findElement(By.xpath("//p[@id='sentence']"));
            String refreshedText = sentence.getText();
            if(!refreshedText.equals(initialText)) {
                assertNotEquals(refreshedText, initialText, "The text did not change after refresh");
            }
            System.out.println("Text after refresh " + (i + 1) + ": " + refreshedText);
            initialText = refreshedText; // Update the initial text for the next iteration
        }

    }
}

