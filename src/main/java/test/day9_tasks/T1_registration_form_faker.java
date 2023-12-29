package test.day9_tasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

import java.util.List;
import java.util.Random;

public class T1_registration_form_faker {

    @Test
    public void testRegistrationForm(){
        Driver.getDriver().get(ConfigurationReader.getProperty("reg"));
        Faker faker = new Faker();
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='lastname']"));
        lastName.sendKeys(faker.name().lastName());
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        username.sendKeys(faker.bothify("????###??##"));


        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='email']"));
        email.sendKeys(faker.name().firstName().toLowerCase() + "@gmail.com");

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(faker.bothify("????####??##",true));
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys(faker.numerify("###-###-####"));

        WebElement genderOther = Driver.getDriver().findElement(By.xpath("//input[@value='other']"));
        genderOther.click();

        WebElement birthdayEle = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        String birthMonth;
        String birthDay;
        String birthYear;
        Integer month;
        Integer day;
        Integer year;
        Integer maxDays = 0;


        do{
            birthYear = faker.numerify("####");
            year = Integer.parseInt(birthYear);

        }while (year<1950 || year>2005);

        do{
            birthMonth = faker.numerify("##");
            month = Integer.parseInt(birthMonth);
        }while (month<1 || month>12);

        do{
            birthDay = faker.numerify("##");
            day = Integer.parseInt(birthDay);


            if(month == 2 ){
                maxDays = 28;
            } else if(month == 1 || month == 3 || month == 5 || month == 7|| month == 8 || month == 10 || month == 12){
                maxDays = 31;
            } else {
                maxDays = 30;
            }

        }while (day<1 || day>maxDays);

        birthdayEle.sendKeys(birthMonth+ "/" + birthDay + "/" + birthYear);

        WebElement department = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));
        Random random = new Random();
        Select departmentDropdown = new Select(department);
        List<WebElement> options = departmentDropdown.getOptions();
        int randomIntDepartment = 0;

        do {
            randomIntDepartment = random.nextInt(options.size()-1);
        }while (randomIntDepartment == 0);

        departmentDropdown.selectByIndex(randomIntDepartment);


        WebElement jobTitles = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));
        Select jobsDropdown = new Select(jobTitles);
        List<WebElement> optionsJobs = jobsDropdown.getOptions();
        int randomIntJobs = 0;
        do {
            randomIntJobs = random.nextInt(optionsJobs.size()-1);
        }while (randomIntJobs == 0);
        jobsDropdown.selectByIndex(randomIntJobs);

        WebElement javaCheckbox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        javaCheckbox.click();
        WebElement javaScriptCheckbox = Driver.getDriver().findElement(By.xpath("//input[@value='javascript']"));
        javaScriptCheckbox.click();

        WebElement signUp = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUp.click();
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-success']"));
        String expected = "Thanks for signing up!";
        String actual = successMessage.getText();
        Assert.assertEquals(actual,expected, "Sign up was not successful");

       // Driver.closeDriver();

    }
}
