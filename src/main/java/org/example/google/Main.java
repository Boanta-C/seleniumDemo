package org.example.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        GoogleElementHandler.rejectGoogleCookies(driver);
        GoogleElementHandler.sentTextToSearchBox(driver);
        GoogleElementHandler.clickChannelButton(driver);
        GoogleElementHandler.rejectYoutubeCookies(driver);
        GoogleElementHandler.executeJavaScriptActions(driver);

        driver.quit();

    }
}