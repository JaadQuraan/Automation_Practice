package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import test.base.TestBase;

public class MultipleButtons extends TestBase {
    @Test
    public void button1 (){
        driver.get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button one!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 1 was not clicked");
    }
    @Test
    public void button2 (){
        driver.get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='button2()']"));
        button.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button two!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 2 was not clicked");
    }
    @Test
    public void button3 (){
        driver.get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button3()']"));
        button1.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button three!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 3 was not clicked");
    }
    @Test
    public void button4 (){
        driver.get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button4()']"));
        button1.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button four!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 4 was not clicked");
    }
    @Test
    public void button5 (){
        driver.get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button5()']"));
        button1.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "Clicked on button five!";
        String actual = result.getText();
        assertEquals(actual,expected,"Button 5 was not clicked");
    }
    @Test
    public void dont_click(){
        driver.get("https://loopcamp.vercel.app/multiple-buttons.html");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='button6()']"));
      //  System.out.println(button.getText());
        button.click();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "Now it's gone!";
        String actual = result.getText();
        assertEquals(actual,expected,"Don't click! was not clicked");

    }
}
