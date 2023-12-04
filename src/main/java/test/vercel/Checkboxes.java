package test.vercel;
/*
isSelected() is used for checking the selected state of checkboxes, radio buttons, and dropdown options,
while isEnabled() is used to check if an element is enabled and can be interacted with, such as buttons and input fields.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

public class Checkboxes {
    public static void main(String[] args) throws InterruptedException {
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.get("https://loopcamp.vercel.app/checkboxes.html");
            Thread.sleep(2000);

        WebElement checkbox1 = driver.findElement(By.id("box1"));
        if(!checkbox1.isSelected()){  checkbox1.click();}
        Thread.sleep(1000);
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        if(!checkbox1.isSelected()){  checkbox2.click();}
        Thread.sleep(1000);

        if(checkbox1.isSelected() && checkbox2.isSelected()){
            System.out.println("Both checkboxes are selected. PASS");
        } else {
            System.out.println("Both checkboxes are NOT selected. FAIL");

        }


    }
}
