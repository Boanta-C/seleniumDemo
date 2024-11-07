package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicLocators {

    //will remain static for now
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

    //will remain static for now
    public static void clickElement(WebDriver driver) {
        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));
        englishButton.click();
        WebElement wikipediaWelcome = driver.findElement(By.id("Welcome_to_Wikipedia"));
        assertTextEqualsExpected(wikipediaWelcome, "Welcome to Wikipedia");
    }

    //will remain static for now
    public static void sentTextToWebPage(WebDriver driver, String textToSend) {
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys(textToSend);

        WebElement searchButton = driver.findElement(By.cssSelector("#searchform > div > button"));
        searchButton.click();
    }

    public static void assertTextEqualsExpected(WebElement webElement, String expectedText) {
        if(webElement.getText().equals(expectedText)) {
            System.out.println("Title " + webElement.getText() + " matches " + expectedText);
        } else
            System.out.println("Title " + webElement.getText() + " does not match " + expectedText); //can also throw an exception but won't do that here
    }

}
