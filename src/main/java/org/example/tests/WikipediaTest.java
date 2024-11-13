package org.example.tests;

import org.example.web.ElementUtils;
import org.example.web.wikipedia.WikipediaElementHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class WikipediaTest {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.wikipedia.org");

        WikipediaElementHandler.testBasicLocators(driver);

        WebElement wikipediaLogo = driver.
                findElement(By.cssSelector("#www-wikipedia-org > main > div.central-textlogo > h1 > span"));
        ElementUtils.assertTextEqualsExpected(wikipediaLogo, "Wikipedia");

        WikipediaElementHandler.clickElement(driver);
        WikipediaElementHandler.sentTextToWebPage(driver, "Selenium Webdriver");

        driver.quit();

    }
}