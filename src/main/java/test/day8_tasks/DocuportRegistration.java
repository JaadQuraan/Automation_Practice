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
       // Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement firstName2 = wait.until(d-> driver.findElement(By.xpath("(//label[text()='First name *']/following-sibling::input)[2]")));
       firstName2.sendKeys("name");

//       WebElement radioButtonCompany = driver.findElement(By.xpath("(//input[@value='2'])[3]"));
//       radioButtonCompany.click();

        WebElement lastName2 = driver.findElement(By.xpath("(//label[text()='Last name *']/following-sibling::input)[2]"));
        lastName2.sendKeys("last");

        WebElement middleName = driver.findElement(By.xpath("(//label[text()='Middle name']/following-sibling::input)"));
        middleName.sendKeys("middle");

        WebElement address1 = driver.findElement(By.xpath("(//label[text()='Address line 1 *']/following-sibling::input)"));
        address1.sendKeys("java street");

        WebElement city = driver.findElement(By.xpath("(//label[text()='City *']/following-sibling::input)"));
        city.sendKeys("Array");

        WebElement jurisdiction = driver.findElement(By.xpath("(//label[text()='Jurisdiction *']/following-sibling::input)"));
        jurisdiction.sendKeys("Virginia");
        jurisdiction.sendKeys(Keys.ARROW_DOWN);
        jurisdiction.sendKeys(Keys.ENTER);
        WebElement zipCode = driver.findElement(By.xpath("(//label[text()='Zip code *']/following-sibling::input)"));
        zipCode.sendKeys("11111");

        WebElement email2 = driver.findElement(By.xpath("//label[text()='Email address']/following-sibling::input"));
        email2.sendKeys("java@loop.com");

        WebElement phoneNumber2 = driver.findElement(By.xpath("(//label[text()='Phone number *']/following-sibling::input)[2]"));
        phoneNumber2.sendKeys("111-111-1111");

        WebElement submit2 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submit2.click();

        WebElement firstName3 = wait.until(d-> driver.findElement(By.xpath("(//label[text()='First name *']/following-sibling::input)[3]")));
        firstName3.sendKeys("Third");

        WebElement lastName3 = driver.findElement(By.xpath("(//label[text()='Last name *']/following-sibling::input)[3]"));
        lastName3.sendKeys("last3");

        WebElement middleName2 = driver.findElement(By.xpath("(//label[text()='Middle name']/following-sibling::input)[2]"));
        middleName2.sendKeys("middle2");

        WebElement sharePercent = driver.findElement(By.xpath("//label[text()='Share Ownership (%) *']/following-sibling::input"));
        sharePercent.sendKeys("50");

        WebElement ssn = driver.findElement(By.xpath("//label[text()='SSN of an Organizing Member *']/following-sibling::input"));
        ssn.sendKeys("111-11-1111");

        WebElement firstName4 = wait.until(d-> driver.findElement(By.xpath("(//label[text()='First name *']/following-sibling::input)[4]")));
        firstName4.sendKeys("Fourth");

        WebElement lastName4 = driver.findElement(By.xpath("(//label[text()='Last name *']/following-sibling::input)[4]"));
        lastName4.sendKeys("last4");

        WebElement goToPayment = driver.findElement(By.xpath("(//button[@type='submit'])[3]"));
        goToPayment.click();
    }
}
