package test.practice;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.DocuportUtils;
import test.utilities.Driver;

public class DocuportLogin extends TestBase {

    @Test
    public void testAdvisor() throws InterruptedException {
        DocuportUtils.login(Driver.getDriver(),"advisor");
        DocuportUtils.logOut(Driver.getDriver());
    }

    @Test
    public void testClient() throws InterruptedException {
        DocuportUtils.login(Driver.getDriver(),"client");
        DocuportUtils.logOut(Driver.getDriver());
    }

    @Test
    public void testSupervisor() throws InterruptedException {
        DocuportUtils.login(Driver.getDriver(),"supervisor");
        DocuportUtils.logOut(Driver.getDriver());
    }

    @Test
    public void testEmployee() throws InterruptedException {
        DocuportUtils.login(Driver.getDriver(),"employee");
        DocuportUtils.logOut(Driver.getDriver());
    }
}
