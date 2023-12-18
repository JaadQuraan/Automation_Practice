package test.day8_tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

public class DocuportRegistration extends TestBase {
    @Test
    public void registration() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://app.docuport.app/company-formation/resident");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement formationStateVirginia = driver.findElement(By.xpath("(//div[@class='v-input--selection-controls__input'])[5]"));
        formationStateVirginia.click();
        WebElement companyName = driver.findElement(By.xpath("//label[text()='Legal Company Name  *']/following-sibling::input"));
        companyName.sendKeys("SDET Java");
        WebElement DBA = driver.findElement(By.xpath("//label[text()='DBA (Doing Business As)']/following-sibling::input"));
        DBA.sendKeys("Information Technology Help");
        WebElement industry = driver.findElement(By.xpath("//label[text()='Industry *']/following-sibling::input"));
        industry.sendKeys("Information");
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ENTER);
        WebElement firstName = driver.findElement(By.xpath("//label[text()='First name *']/following-sibling::input"));
        firstName.sendKeys("java");
        WebElement lastName = driver.findElement(By.xpath("//label[text()='Last name *']/following-sibling::input"));
        lastName.sendKeys("loop");
        WebElement email = driver.findElement(By.xpath("//label[text()='Email address *']/following-sibling::input"));
        email.sendKeys("java@loop.com");
        WebElement phoneNumber = driver.findElement(By.xpath("//label[text()='Phone number *']/following-sibling::input"));
        phoneNumber.sendKeys("111-111-1111");
        WebElement fax = driver.findElement(By.xpath("//label[text()='Fax']/following-sibling::input"));
        fax.sendKeys("222-222-2222");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstName2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='First name *']/following-sibling::input")));
        firstName2.sendKeys("java");


        firstName2 = driver.findElement(By.xpath("//label[text()='First name *']/following-sibling::input"));
        firstName2.sendKeys("java");


    }
}
