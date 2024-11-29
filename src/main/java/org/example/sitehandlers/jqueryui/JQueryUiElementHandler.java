package org.example.sitehandlers.jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JQueryUiElementHandler {

    public static void performDragAndDrop(WebDriver driver) {
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
    }

}
