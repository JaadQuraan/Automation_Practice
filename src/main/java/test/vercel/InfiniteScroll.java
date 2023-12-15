package test.vercel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utilities.WebDriverFactory;

public class InfiniteScroll {

    WebDriver driver;
    String pageURL = "https://loopcamp.vercel.app/infinite_scroll/index.html";

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(pageURL);
    }

    @Test
    public void test () throws InterruptedException {

        boolean triedToFindParagraph2 = false;

        WebElement paragrah2 = null;
        try {
            paragrah2 = driver.findElement(By.xpath("//div[contains(text(), 'Consectetur ipsum impedit sed')]"));
        } catch (NoSuchElementException e) {
            triedToFindParagraph2 = true;
            System.out.println(triedToFindParagraph2);
//            e.printStackTrace();
//            System.out.println("Hello");
        } finally {

        }
        Assert.assertTrue(triedToFindParagraph2, "Paragraph 2 is unable to be located by default");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(700,700)", "");


        try {
            paragrah2 = driver.findElement(By.xpath("//div[contains(text(), 'Consectetur ipsum impedit sed')]"));

        } catch (NoSuchElementException e) {
            triedToFindParagraph2 = true;
//            e.printStackTrace();
//            System.out.println("Hello");
            //a[contains(text(),'text')]
        }
        Assert.assertTrue(paragrah2 != null, "Paragraph 2 is not null");
        //System.out.println(paragrah2.getText());
    }
    @AfterMethod
    public void teardownMethod() {
        driver.close();
    }

}
