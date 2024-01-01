package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

public class UploadFile {
    /**
     * Test goes to https://loopcamp.vercel.app/upload.html
     * Uploads note.txt
     * Checks the file was successfully uploaded
     */
    @Test
    public void testUpload(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vercel.upload"));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("C:\\Users\\quraa\\Desktop\\note.txt");
        WebElement uploadButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        uploadButton.click();

    }
}
