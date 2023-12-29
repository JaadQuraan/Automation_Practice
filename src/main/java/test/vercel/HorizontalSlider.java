package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

public class HorizontalSlider {

    @Test
    public void test (){
        Driver.getDriver().get("https://loopcamp.vercel.app/horizontal-slider.html");
        WebElement slider = Driver.getDriver().findElement(By.xpath("//input[@type='range']"));
        WebElement number = Driver.getDriver().findElement(By.xpath("//span[@id='range']"));
        Actions actions = new Actions(Driver.getDriver());
        actions
                .clickAndHold(slider)
                .moveByOffset(20,0)
                .release(slider)
                .perform();
        System.out.println("The value is: " + number.getText());
        Assert.assertTrue(!number.getText().equals("0"),"The slider was not moved");
    }
    @AfterMethod
    public void teardownMethod() {
        Driver.getDriver().quit();
    }

}
