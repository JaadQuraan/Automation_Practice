package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.Driver;
import test.utilities.WebDriverFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenImage extends TestBase {

    @Test
    public void brokenImgTest() throws MalformedURLException {
        Driver.getDriver().get("https://loopcamp.vercel.app/broken-images.html");
        WebElement nonBrokenImage = Driver.getDriver().findElement(By.xpath("//img[@src='img/avatar-blank.jpg']"));

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