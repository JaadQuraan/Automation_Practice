package test.day8_tasks;

import test.utilities.DocuportConstants;
import test.utilities.DocuportUtils;
import test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
1. login as an advisor
2. go to users
3. validate that full name for alex.de.souza@gmail.com is Alex De Souza +
4. validate that user name for alex.de.souza@gmail.com is alexdesouze +
5. validate that phone number for alex.de.souza@gmail.com is +994512060042
6. validate that role for alex.de.souza@gmail.com is client
7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
 */
public class T1_WebTables extends TestBase {

    @Test
    public void test_webTables() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement users = driver.findElement(By.xpath("//a[@href='/users']"));
        users.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com","Full name");
        System.out.println("actualFullName = " + actualFullName);
        assertEquals(actualFullName, expectedFullName, "TEST #001 FAILED !" + actualFullName + " NOT MATCHING WITH " + expectedFullName);

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
        assertEquals(actualUserName,expectedUserName,"Actual does not match expected");

        String expectedPhoneNumber = "+994512060042";
        String actualPhoneNumber = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "phone number");
        assertEquals(actualPhoneNumber,expectedPhoneNumber,actualPhoneNumber + " does not match " + expectedPhoneNumber);

        String expectedRole = "Client";
        String actualRole = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "role");
        assertEquals(expectedRole,actualRole,actualRole + " does not match " + expectedRole);

        String expectedAdvisor = "Batch1 Group1";
        String actualAdvisor = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "advisor");
        assertEquals(actualAdvisor,expectedAdvisor, actualAdvisor + " does not match " + expectedAdvisor);
    }

}


//(//td[2][text()='admin123@gmail.com'])
//Second td in that row
//Not good to locate element if it returns two even if you need the first