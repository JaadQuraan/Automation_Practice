package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

import java.io.File;
import java.time.Duration;

public class FileDownloader extends TestBase {
    @Test
    public void someFileTxt() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/download.html");
        WebElement someFile = Driver.getDriver().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        someFile.click();
        Thread.sleep(2000);
        boolean found = false;

       File f = new File("C:/Users/quraa/Downloads/some-file.txt");
       if(f.isFile()){
           String fileName = f.getName();
           System.out.println(fileName);
           if(fileName.matches("some-file.txt")){
               found = true;
       }
        }
        assertTrue(found, "Downloaded document not found");
    }
    @Test
    public void someFileTxt2() {
        Driver.getDriver().get("https://loopcamp.vercel.app/download.html");
        WebElement someFile = Driver.getDriver().findElement(By.xpath("//a[@href='download/some-file.txt']"));
        someFile.click();

        // Wait for the file to be downloaded
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Check if the file exists
        File downloadedFile = new File("C:/Users/quraa/Downloads/some-file.txt");
        assertTrue(downloadedFile.exists(), "Downloaded document not found");
    }
}
