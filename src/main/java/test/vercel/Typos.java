package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class Typos extends TestBase {

    @Test
    public void test(){
        driver.get("https://loopcamp.vercel.app/typos.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement sentence = driver.findElement(By.xpath("//p[@id='sentence']"));
        String initialText = sentence.getText();

        for (int i = 0; i < 3; i++) {
            driver.navigate().refresh();
            wait.until(ExpectedConditions.stalenessOf(sentence));
            sentence = driver.findElement(By.xpath("//p[@id='sentence']"));
            String refreshedText = sentence.getText();
            assertNotEquals(refreshedText, initialText, "The text did not change after refresh");
            System.out.println("Text after refresh " + (i + 1) + ": " + refreshedText);
            initialText = refreshedText; // Update the initial text for the next iteration
        }

    }
}

