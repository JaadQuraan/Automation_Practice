package test.vercel;

import org.testng.annotations.Test;
import test.base.TestBase;
import test.utilities.PizzaOrderWebTableUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
/*
1. go to https://loopcamp.vercel.app/web-tables.html
2. create a method to test given field for a given name
3. test type
4. test amount
5. test date
6. test street
7. test city
8. test state
9. test zip
10. test card
11. test card number
12. test exp
 */
public class PizzaOrders extends TestBase {

    @Test
    public void test_pizza_type() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");

        List<String> nameList = Arrays.asList("Alexandra Gray", "John Doe", "Stewart Dawidson", "Bart Fisher",
                "Ned Stark", "Bob Martin", "Samuel Jackson", "Robert Baratheon");

        List<String> expectedPizzaType = Arrays.asList("Thin Crust", "Pepperoni", "Sausage", "Cheese", "Italian", "Cheese",
                "Italian", "Hawaiian");

        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualPizzaType = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Pizza Type");
            // System.out.println(i + " " + actualPizzaType);
            assertEquals(actualPizzaType, expectedPizzaType.get(i), "Actual does not match expected");
        }
    }

    @Test
    public void test_amount() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedAmounts = new ArrayList<>(Arrays.asList("2", "3", "4", "3", "5", "2", "3", "4"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualAmount = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Amount");
            System.out.println(actualAmount);
            assertEquals(actualAmount, expectedAmounts.get(i), "Actual does not match expected");
        }
    }
    @Test
    public void test_dates() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedDates = new ArrayList<>(Arrays.asList("04/15/2021","01/08/2021","03/29/2021","01/16/2021","05/12/2021","12/31/2021","12/21/2021","12/04/2021"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualDate = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Date");
           // System.out.println(actualDate);
            assertEquals(actualDate, expectedDates.get(i), "Actual does not match expected");
        }
    }
    @Test
    public void test_street() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedStreets = new ArrayList<>(Arrays.asList("7, Miller Street", "12, Cherry Ave", "19, Victor Ave", "35, Rock st.", "17, Rose Street", "22, West Ave", "13, Owl st.", "29, Sanderson Ave"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualStreet = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Street");
            // System.out.println(actualDate);
            assertEquals(actualStreet, expectedStreets.get(i), "Actual does not match expected");
        }
    }

    @Test
    public void test_city() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedCities = new ArrayList<>(Arrays.asList("Chicago, IL", "Arlington, VA", "Cate Island", "McLean, VA", "Newcastle", "New York, NY", "Starberry, UT", "Bluecity, CA"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualCity = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "City");
            // System.out.println(actualDate);
            assertEquals(actualCity, expectedCities.get(i), "Actual does not match expected");
        }
    }
    @Test
    public void test_state() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedStates = new ArrayList<>(Arrays.asList("US", "Canada", "Canada", "US", "Italy", "US", "US", "US"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualState = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "State");
            // System.out.println(actualDate);
            assertEquals(actualState, expectedStates.get(i), "Actual does not match expected");
        }
    }
    @Test
    public void test_zipcode() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedZips = new ArrayList<>(Arrays.asList("748", "76743", "24232", "22043", "21444", "11368", "53665", "63325"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualZip = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Zip");
            // System.out.println(actualDate);
            assertEquals(actualZip, expectedZips.get(i), "Actual does not match expected");
        }
    }

    @Test
    public void test_cards() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedCards = new ArrayList<>(Arrays.asList("VISA", "MasterCard", "VISA", "American Express", "MasterCard", "VISA", "MasterCard", "MasterCard"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualCard = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Card");
            // System.out.println(actualDate);
            assertEquals(actualCard, expectedCards.get(i), "Actual does not match expected");
        }
    }
    @Test
    public void test_cardNumbers() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedCardNumbers = new ArrayList<>(Arrays.asList("321456789012", "980077987700", "774555444555", "444222333666", "777888777888", "333222111222", "555743242342", "776565770000"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualCardNumber = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Card Number");
            // System.out.println(actualDate);
            assertEquals(actualCardNumber, expectedCardNumbers.get(i), "Actual does not match expected");
        }
    }
    @Test
    public void test_exp() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        List<String> nameList = PizzaOrderWebTableUtil.pizzaNames();
        List<String> expectedExps = new ArrayList<>(Arrays.asList("02/24", "01/23", "03/23", "07/26", "04/25", "06/24", "03/25", "03/26"));
        for (int i = 0; i < nameList.size(); i++) {
            String name = nameList.get(i);
            String actualExp = PizzaOrderWebTableUtil.returnAnyFieldValue(driver, name, "Exp");
            // System.out.println(actualDate);
            assertEquals(actualExp, expectedExps.get(i), "Actual does not match expected");
        }
    }


}
