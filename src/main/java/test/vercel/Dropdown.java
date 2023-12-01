package test.vercel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utilities.WebDriverFactory;

import java.time.Duration;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
}
