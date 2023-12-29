package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;

public class MultipleButtons {
    @Test
    public void button1 (){
        Driver.getDriver().get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@onclick='button1()']"));
        button.click();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button one!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 1 was not clicked");
    }
    @Test
    public void button2 (){
        Driver.getDriver().get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@onclick='button2()']"));
        button.click();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button two!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 2 was not clicked");
    }
    @Test
    public void button3 (){
        Driver.getDriver().get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button1 = Driver.getDriver().findElement(By.xpath("//button[@onclick='button3()']"));
        button1.click();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button three!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 3 was not clicked");
    }
    @Test
    public void button4 (){
        Driver.getDriver().get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button1 = Driver.getDriver().findElement(By.xpath("//button[@onclick='button4()']"));
        button1.click();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button four!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 4 was not clicked");
    }
    @Test
    public void button5 (){
        Driver.getDriver().get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button1 = Driver.getDriver().findElement(By.xpath("//button[@onclick='button5()']"));
        button1.click();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button five!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 5 was not clicked");
    }
    @Test
    public void dont_click(){
        Driver.getDriver().get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@onclick='button6()']"));
      //  System.out.println(button.getText());
        button.click();
        WebElement result = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expected = "Now it's gone!";
        String actual = result.getText();
        assertEquals(actual,expected,"Don't click! was not clicked");

    }
}
