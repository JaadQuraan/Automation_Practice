package test.vercel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

/*

                    Congratulations! You must have the proper credentials.

 */
public class BasicAuth {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/basic-auth.html");

        try {
            // Handle the alert (if present)
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("admin");
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            Alert alert2 = driver.switchTo().alert();
            alert2.sendKeys("admin");
            String alert2Text = alert2.getText();
            System.out.println("Alert2 Text: " + alert2Text);

        } catch (Exception e) {
            // If no alert is present or there's an issue handling the alert
            System.out.println("No alert or failed to handle the alert");
        }


        WebElement success = driver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']"));
        System.out.println(success.getText());
        String expectedSuccess = "Congratulations!";

        if(success.getText().contains(expectedSuccess)){
            System.out.println("Test PASS");
        }else {
            System.out.println("Test FAIL");
        }
    }
}
