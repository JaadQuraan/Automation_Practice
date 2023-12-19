package test.practice;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.DocuportUtils;

public class DocuportLogin extends TestBase {

    @Test
    public void testAdvisor() throws InterruptedException {
        DocuportUtils.login(driver,"advisor");
        DocuportUtils.logOut(driver);
    }

    @Test
    public void testClient() throws InterruptedException {
        DocuportUtils.login(driver,"client");
        DocuportUtils.logOut(driver);
    }

    @Test
    public void testSupervisor() throws InterruptedException {
        DocuportUtils.login(driver,"supervisor");
        DocuportUtils.logOut(driver);
    }

    @Test
    public void testEmployee() throws InterruptedException {
        DocuportUtils.login(driver,"employee");
        DocuportUtils.logOut(driver);
    }
}
