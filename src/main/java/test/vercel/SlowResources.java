package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class SlowResources  {
    @Test
    public void test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/slow.html");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(35));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='example']/p[2]")));
        WebElement slowText = Driver.getDriver().findElement(By.xpath("//div[@class='example']/p[2]"));
        System.out.println("slowText.getText() = " + slowText.getText());
    }
}
