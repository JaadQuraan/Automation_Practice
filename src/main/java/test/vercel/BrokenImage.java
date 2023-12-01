package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.utilities.WebDriverFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenImage {
    public static void main(String[] args) throws MalformedURLException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //     //img[@src='img/avatar-blank.jpg']
        driver.get("https://loopcamp.vercel.app/broken-images.html");
        WebElement nonBrokenImage = driver.findElement(By.xpath("//img[@src='img/avatar-blank.jpg']"));

        String urlImage = nonBrokenImage.getAttribute("src");
        System.out.println(urlImage);

        URL url = new URL(urlImage);
        BufferedImage img = null;
        try {
            img = ImageIO.read(url);

        } catch (IOException e) {
        }

        var frame = new JFrame();
        var icon = new ImageIcon(img);
        var label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}