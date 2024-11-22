package org.example.tests;

import org.example.web.w3Schools.W3SchoolsElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class W3SchoolsTest {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_iframe.asp");

        W3SchoolsElementHandler.cookiesHandler(driver);
        W3SchoolsElementHandler.switchToFrame(driver);

        W3SchoolsElementHandler.
                selectURL(driver, "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        W3SchoolsElementHandler.pickElementFromSelect(driver);

        driver.quit();
    }
}
