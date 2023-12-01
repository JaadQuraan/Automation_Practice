package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

public class DisappearingElements extends Exception{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/disappearing-elements.html");

//        if ((home.isDisplayed())) {
//            System.out.println(homeText);
//        } else {
//            System.out.println("Home is not displayed");        }
        //Does not work because element will never be located

        try {
            WebElement home = driver.findElement(By.xpath("//a[text()='Home']"));
            String homeText = home.getText();
            System.out.println(homeText + " is displayed");
        }catch (NoSuchElementException e){
            System.out.println("Home is not displayed");
        }


        try {
            WebElement about = driver.findElement(By.xpath("//a[text()='About']"));
            String aboutText = about.getText();
            System.out.println(aboutText+ " is displayed");
        }catch (NoSuchElementException e){
            System.out.println("About is not displayed");
        }

        try {
            WebElement contact = driver.findElement(By.xpath("//a[text()='Contact Us']"));
            String contactText = contact.getText();
            System.out.println(contactText+ " is displayed");
        }catch (NoSuchElementException e){
            System.out.println("Contact Us is not displayed");
        }



        try {
            WebElement portfolio = driver.findElement(By.xpath("//a[text()='Portfolio']"));
            String portfolioText = portfolio.getText();
            System.out.println(portfolioText+ " is displayed");
        }catch (NoSuchElementException e){
            System.out.println("Portfolio is not displayed");
        }



        try {
            WebElement gallery = driver.findElement(By.xpath("//a[text()='Gallery']"));
            String galleryText = gallery.getText();
            System.out.println(galleryText+ " is displayed");
        }catch (NoSuchElementException e){
            System.out.println("Gallery is not displayed");
        }
    }
}
