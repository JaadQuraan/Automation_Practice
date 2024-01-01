package test.outsidepractice;

import org.testng.annotations.Test;
import test.utilities.Driver;

public class InterviewTask {
    @Test
    public void amazonTest(){
        Driver.getDriver().get("Amazon.com");

    }
}
