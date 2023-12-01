package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

public class ChallengingDOM {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/challenging-dom.html");
        Thread.sleep(2000);

        WebElement button1 = driver.findElement(By.xpath("//a[@class='button']"));
        button1.click();
        Thread.sleep(1000);

        button1 = driver.findElement(By.xpath("//a[@class='button']"));

        WebElement button2 = driver.findElement(By.xpath("//a[@class='button']/following-sibling::a"));
        button2.click();
        Thread.sleep(1000);

        button2 = driver.findElement(By.xpath("//a[@class='button']/following-sibling::a"));

        WebElement button3 = driver.findElement(By.xpath("//a[@class='button']/following-sibling::a/following-sibling::a"));
        button3.click();
        Thread.sleep(1000);

        button3 = driver.findElement(By.xpath("//a[@class='button']/following-sibling::a/following-sibling::a"));

        System.out.println("HERE");
        System.out.println("Button 1 Text: " + driver.findElement(By.xpath("//a[@class='button']")).getText());
        System.out.println("Button 2 Text: " + driver.findElement(By.xpath("//a[@class='button']/following-sibling::a")).getText());
        System.out.println("Button 3 Text: " + driver.findElement(By.xpath("//a[@class='button']/following-sibling::a/following-sibling::a")).getText());

        System.out.println("DONE");

    }
}
