package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.Driver;
import test.utilities.Messages;
import test.utilities.WebDriverFactory;

import java.util.ArrayList;
import java.util.List;

public class DisappearingElements extends Exception{


    @Test
    public void main() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/disappearing-elements.html");
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//li[@class='random-item']//a"));
        for(WebElement button: list){
//            System.out.println(button.getText() + " has link " + button.getAttribute("href"));
            System.out.println("getExpectedLink(button.getText()) = " + getExpectedLink(button.getText()));
            Assert.assertEquals(button.getAttribute("href"),getExpectedLink(button.getText()),button.getText() + " link" + Messages.EQUALS);
        }


    }

    public String getExpectedLink (String text){
        switch (text){
            case "Home" :
                return "https://loopcamp.vercel.app/index.html";
            case "About" :
                return "https://loopcamp.vercel.app/about/index.html";
            case "Contact Us" :
                return "https://loopcamp.vercel.app/contact-us/index.html";
            case "Portfolio" :
                return "https://loopcamp.vercel.app/portfolio/index.html";
            case "Gallery" :
                return "https://loopcamp.vercel.app/gallery/index.html";
        }
        return "";
    }
}