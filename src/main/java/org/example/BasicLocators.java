package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicLocators {

    public static void testBasicLocators(WebDriver driver) {

        long start;
        long end;

        //locators
        try {
            start = System.currentTimeMillis();
            driver.findElement(By.id("js-link-box-en"));
            end = System.currentTimeMillis();
            System.out.println("Time needed to get locator by ID: " + (end - start));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

        try {
            start = System.currentTimeMillis();
            driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/main/nav[1]/div[2]"));
            end = System.currentTimeMillis();
            System.out.println("Time needed to get locator by xPath: " + (end - start));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

        try {
            start = System.currentTimeMillis();
            driver.findElement(By.cssSelector("#js-link-box-fr"));
            end = System.currentTimeMillis();
            System.out.println("Time needed to get locator by cssSelector: " + (end - start));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

    }

    private static String findTextByLocator(WebDriver driver) {
        WebElement webPageTitle =
                driver.findElement(By.cssSelector("#www-wikipedia-org > main > div.central-textlogo > h1 > span"));
        return webPageTitle.getText();
    }

    public static void assertTextEqualsExpected(WebDriver driver) {
        String expectedText = "Wikipedia";
        if(findTextByLocator(driver).equals(expectedText)) {
            System.out.println("Title matches");
        } else
            System.out.println("Title does not match"); //can also throw an exception but won't do that here
    }

}
