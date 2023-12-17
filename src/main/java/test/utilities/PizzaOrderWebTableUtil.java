package test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaOrderWebTableUtil {
    /**
     * returns any field from table by given email
     *
     * @param driver
     * @param field
     * @return field's text
     * @author jaad
     */

    public static String returnAnyFieldValue(WebDriver driver, String name, String field) {
        String index = "";

        List<String> nameList = Arrays.asList("Alexandra Gray", "John Doe", "Stewart Dawidson", "Bart Fisher",
                "Ned Stark", "Bob Martin", "Samuel Jackson", "Robert Baratheon");

        String actualValue = "";

        for (int i = 0; i < nameList.size(); i++) {
            String currentName = nameList.get(i);

            if (currentName.equals(name)) {
                if (field.equalsIgnoreCase("Pizza Type")) {
                    index = "[1]";
                } else if (field.equalsIgnoreCase("Amount")) {
                    index = "[2]";
                } else if (field.equalsIgnoreCase("Date")) {
                    index = "[3]";
                } else if (field.equalsIgnoreCase("Street")) {
                    index = "[4]";
                } else if (field.equalsIgnoreCase("City")) {
                    index = "[5]";
                } else if (field.equalsIgnoreCase("State")) {
                    index = "[6]";
                } else if (field.equalsIgnoreCase("Zip")) {
                    index = "[7]";
                } else if (field.equalsIgnoreCase("Card")) {
                    index = "[8]";
                } else if (field.equalsIgnoreCase("Card Number")) {
                    index = "[9]";
                } else if (field.equalsIgnoreCase("Exp")) {
                    index = "[10]";
                } else {
                    System.out.println("There is not such a field: " + field);
                }

                WebElement element = driver.findElement(By.xpath("//td[.='" + currentName + "']//following-sibling::td" + index));
                actualValue = element.getText().trim();
               // System.out.println(actualValue);
            }
        }
        return actualValue;
    }
    public static List<String> pizzaNames (){
        return Arrays.asList("Alexandra Gray", "John Doe", "Stewart Dawidson", "Bart Fisher",
                "Ned Stark", "Bob Martin", "Samuel Jackson", "Robert Baratheon");
    }
}
