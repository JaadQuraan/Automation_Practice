package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class Inputs extends TestBase {
    @Test
    public void test (){
        driver.get("https://loopcamp.vercel.app/inputs.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement inputsText = driver.findElement(By.xpath("//h3"));
        System.out.println("inputsText.getText() = " + inputsText.getText());
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='number']"));
        inputBox.sendKeys("2123");


    }
}
