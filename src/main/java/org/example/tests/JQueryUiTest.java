package org.example.tests;

import org.example.sitehandlers.jqueryui.JQueryUiElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class JQueryUiTest {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        JQueryUiElementHandler.performDragAndDrop(driver);
        JQueryUiElementHandler.performRightClick(driver);


        driver.quit();

    }

}
