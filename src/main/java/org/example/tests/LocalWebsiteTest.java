package org.example.tests;

import org.example.web.localWebsite.LocalWebsiteElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class LocalWebsiteTest {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String projectPath = System.getProperty("user.dir"); //getting the project path
        driver.get("file:///" + projectPath + "/alerts.html");

        LocalWebsiteElementHandler.clickAlertButtons(driver);

        driver.quit();
    }

}
