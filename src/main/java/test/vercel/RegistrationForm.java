package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.List;

public class RegistrationForm extends TestBase {
    @Test
    public void testForm(){
        driver.get("https://loopcamp.vercel.app/registration_form.html");
        //Input boxes
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("loopcamp");
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("java");
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='username']"));
        userName.sendKeys("javaisfun");
        WebElement email = driver.findElement(By.xpath("//input[@data-bv-field='email']"));
        WebElement phone = driver.findElement(By.xpath("//input[@data-bv-field='phone']"));
        phone.sendKeys("111-111-1111");
        email.sendKeys("java@email.com");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("JavaPassword");

        //Gender radio buttons
        WebElement genderMale = driver.findElement(By.xpath("//input[@value='male']"));
        genderMale.click();
        WebElement genderFemale = driver.findElement(By.xpath("//input[@value='female']"));
        genderFemale.click();
        WebElement genderOther = driver.findElement(By.xpath("//input[@value='other']"));
        genderOther.click();

        //Date
        WebElement birthday = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("01/01/2000"); // MM/DD/YYYY

        //Select dropdown department
        WebElement departmentElement = driver.findElement(By.xpath("//select[@name='department']"));
        Select dropdownDepartment = new Select(departmentElement);
        List<WebElement> listOfOptions = dropdownDepartment.getOptions();
        for (WebElement option : listOfOptions) {
            //System.out.println(option.getText());
        }
        //System.out.println("------------------------");
        dropdownDepartment.selectByVisibleText("Mayor's Office");
        String expected = "Mayor's Office";
        String actual = dropdownDepartment.getFirstSelectedOption().getText();
        assertEquals(actual,expected,"Mayor's Office was not selected");

        //JobTitle dropdown
        WebElement jobTitleDropdownElement = driver.findElement(By.xpath("//select[@data-bv-field='job_title']"));
        Select dropdownJob = new Select(jobTitleDropdownElement);
        dropdownJob.selectByValue("sdet");
        expected = "SDET";
        actual = dropdownJob.getFirstSelectedOption().getText();
        assertEquals(actual,expected,"SDET was not selected");

        //checkboxes
        WebElement checkboxCPP = driver.findElement(By.xpath("//input[@value='cplusplus']"));
        WebElement checkboxJava = driver.findElement(By.xpath("//input[@value='java']"));
        WebElement checkboxJS = driver.findElement(By.xpath("//input[@value='javascript']"));
        checkboxCPP.click();
        checkboxJava.click();
        checkboxJS.click();
        assertTrue(checkboxCPP.isSelected(),"C++ was not selected");
        assertTrue(checkboxJava.isSelected(),"Java was not selected");
        assertTrue(checkboxJS.isSelected(),"JavaScript was not selected");

    }
}
