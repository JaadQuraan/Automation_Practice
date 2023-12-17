package test.vercel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import test.base.TestBase;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import java.util.List;

public class ChallengingDOM extends TestBase {
    @Test
    public void testDOM() {

        driver.get("https://loopcamp.vercel.app/challenging-dom.html");
        WebElement button1 = driver.findElement(By.xpath("//a[@class='button']"));
        // button1.click();
        WebElement button2 = driver.findElement(By.xpath("//a[@class='button']/following-sibling::a"));
        // button2.click();
        WebElement button3 = driver.findElement(By.xpath("//a[@class='button']/following-sibling::a/following-sibling::a"));
        // button3.click();

        String[] expectedHeader = {"Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action"};
        String[][] expectedData = {
                {"Iuvaret0", "Apeirian0", "Adipisci0", "Definiebas0", "Consequuntur0", "Phaedrum0"},
                {"Iuvaret1", "Apeirian1", "Adipisci1", "Definiebas1", "Consequuntur1", "Phaedrum1"},
                {"Iuvaret2", "Apeirian2", "Adipisci2", "Definiebas2", "Consequuntur2", "Phaedrum2"},
                {"Iuvaret3", "Apeirian3", "Adipisci3", "Definiebas3", "Consequuntur3", "Phaedrum3"},
                {"Iuvaret4", "Apeirian4", "Adipisci4", "Definiebas4", "Consequuntur4", "Phaedrum4"},
                {"Iuvaret5", "Apeirian5", "Adipisci5", "Definiebas5", "Consequuntur5", "Phaedrum5"},
                {"Iuvaret6", "Apeirian6", "Adipisci6", "Definiebas6", "Consequuntur6", "Phaedrum6"},
                {"Iuvaret7", "Apeirian7", "Adipisci7", "Definiebas7", "Consequuntur7", "Phaedrum7"},
                {"Iuvaret8", "Apeirian8", "Adipisci8", "Definiebas8", "Consequuntur8", "Phaedrum8"},
                {"Iuvaret9", "Apeirian9", "Adipisci9", "Definiebas9", "Consequuntur9", "Phaedrum9"}
        };

        List<WebElement> tableHeaders = driver.findElements(By.tagName("th"));

        List<String> tableHeaderText = new ArrayList<>();

        for (WebElement element : tableHeaders) {
            tableHeaderText.add(element.getText());
        }
//        System.out.println("Expected Headers: " + Arrays.toString(expectedHeader));
//        System.out.println("Actual Headers  : " + tableHeaderText);
//        for (int i = 0; i < expectedHeader.length; i++) {
//            System.out.println("Comparison for index " + i + ": " +
//                    "Expected: " + expectedHeader[i] +
//                    ", Actual: " + tableHeaderText.get(i) +
//                    ", Match: " + expectedHeader[i].equals(tableHeaderText.get(i)));
//        }

        assertEquals(expectedHeader, tableHeaderText.toArray(new String[0]), "Headers not obtained");


        List<WebElement> allRows = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/table/tbody/tr"));
        for (int i = 0; i < expectedData.length; i++) {
            List<WebElement> cellsInRow = allRows.get(i).findElements(By.tagName("td"));

            for (int j = 0; j < expectedData[i].length; j++) {
                String expectedValue = expectedData[i][j];
                String actualValue = cellsInRow.get(j).getText();
                assertEquals(expectedValue, actualValue, "Mismatch in row " + i + ", cell " + j);

            }


//        List <WebElement> row1 = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td"));
//        for (WebElement each: row1){
//            System.out.println(each.getText());
//        }

        }
    }
}

