package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import test.utilities.WebDriverFactory;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/autocomplete.html");
        WebElement logo = driver.findElement(By.xpath("//img[@src='./img/logo.svg']"));
        if(logo.isDisplayed()){
            System.out.println("Logo is displayed - Test PASSED");
        } else {
            System.out.println("Logo is NOT displayed - Test FAILED");

        }
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("myCountry"));
        search.sendKeys("United States");
        Thread.sleep(2000);
        new Actions(driver)
                .keyDown(Keys.ARROW_DOWN)
                .keyUp(Keys.ARROW_DOWN)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .perform();
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='button']"));
        submitButton.click();

        WebElement result = driver.findElement(By.id("result"));
        String resText = result.getText();
        System.out.println(resText);
        if(resText.contains("You selected:")){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }



    }
}
