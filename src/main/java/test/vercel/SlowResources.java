package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class SlowResources extends TestBase {
    @Test
    public void test(){
        driver.get("https://loopcamp.vercel.app/slow.html");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(35));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='example']/p[2]")));
        WebElement slowText = driver.findElement(By.xpath("//div[@class='example']/p[2]"));
        System.out.println("slowText.getText() = " + slowText.getText());
    }
}
