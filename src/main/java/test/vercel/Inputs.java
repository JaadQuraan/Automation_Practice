package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.time.Duration;

public class Inputs  {
    @Test
    public void test (){
        Driver.getDriver().get("https://loopcamp.vercel.app/inputs.html");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement inputsText = Driver.getDriver().findElement(By.xpath("//h3"));
        System.out.println("inputsText.getText() = " + inputsText.getText());
        WebElement inputBox = Driver.getDriver().findElement(By.xpath("//input[@type='number']"));
        inputBox.sendKeys("2123");


    }
}

class LoopPracticeInputsPage{
    public LoopPracticeInputsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
