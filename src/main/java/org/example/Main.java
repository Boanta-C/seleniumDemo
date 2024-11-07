package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        long start;
        long end;

        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.wikipedia.org");

        //locators
        try {
            start = System.currentTimeMillis();
            driver.findElement(By.id("js-link-box-en"));
            end = System.currentTimeMillis();
            System.out.println("Time needed to get locator by ID: " +  (end - start));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

       try {
           start = System.currentTimeMillis();
           driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/main/nav[1]/div[2]"));
           end = System.currentTimeMillis();
           System.out.println("Time needed to get locator by xPath: " +  (end - start));
       } catch (NoSuchElementException e) {
           System.out.println("Element not found");
       }

        try {
            start = System.currentTimeMillis();
            driver.findElement(By.cssSelector("#js-link-box-fr"));
            end = System.currentTimeMillis();
            System.out.println("Time needed to get locator by cssSelector: " +  (end - start));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

        driver.close();
    }
}