package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.wikipedia.org");

        BasicLocators.testBasicLocators(driver);

        WebElement wikipediaLogo = driver.
                findElement(By.cssSelector("#www-wikipedia-org > main > div.central-textlogo > h1 > span"));
        BasicLocators.assertTextEqualsExpected(wikipediaLogo, "Wikipedia");

        BasicLocators.clickElement(driver);

        driver.quit();

    }
}