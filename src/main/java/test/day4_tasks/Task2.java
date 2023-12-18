package test.day4_tasks;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.DocuportConstants;
import test.utilities.WebDriverFactory;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/");

        WebElement userBox = driver.findElement(By.xpath("//input[@id='input-14']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='input-15']"));

        userBox.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        passwordBox.sendKeys(DocuportConstants.PASSWORD);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement navDrawer = driver.findElement(By.xpath("//nav[@class='v-navigation-drawer v-navigation-drawer--fixed v-navigation-drawer--open theme--light']"));
        //Finds the left navigation drawer and then  search that for the links
        Thread.sleep(3000);
        List<WebElement> drawerLinks = navDrawer.findElements(By.xpath(".//a"));

        for (WebElement link : drawerLinks) {
            System.out.println("Element: " + link.getText());
            System.out.println("Link: " + link.getAttribute("href"));

        }
        List<String> expectedLinks = Arrays.asList("" ,"Home", "Received docs", "My uploads", "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 Form", "Reconciliations");
        for (int i = 0; i < drawerLinks.size(); i++) {
            WebElement link = drawerLinks.get(i);
            String actualLinkText = link.getText();
            String expectedLinkText = expectedLinks.get(i);
//            System.out.println("Actual: "+actualLinkText);
//            System.out.println("Expected: "+expectedLinks.get(i));
            if (actualLinkText.equals(expectedLinkText)) {
                System.out.println("Test Passed for " + expectedLinkText);
            } else {
                System.out.println("Test Failed for " + expectedLinkText);
            }
        }
        driver.quit();
    }
}

//        int linkCount = 0;
//        for (WebElement link : leftNavLinks) {
//            System.out.println("link = " + link.getText());
//            System.out.println(link.getAttribute("href"));
//            linkCount++;
//            if(linkCount==11){
//                break;
//Also worked just got every link on the page but stopped at 11

//        for (WebElement link : leftNavLinks) {
//            String linkText = link.getText();
//            if (linkText == "Home" || linkText.equals("Home") || linkText.equals("Received docs") || linkText.equals("My uploads")
//                    || linkText.equals("Clients") || linkText.equals("Invitations") || linkText.equals("Users") || linkText.equals("Leads")
//                    || linkText.equals("Bookkeeping") || linkText.equals("1099 Form") || linkText.equals("Reconciliations")) {
//                System.out.println("link = " + link.getText());
//                System.out.println(link.getAttribute("href"));
//                if(linkText.equals("Reconciliations")){
//                    break;
//                }






