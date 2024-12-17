package org.example.sitehandlers.jqueryui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JQueryUiElementHandler {

    public static void performDragAndDrop(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.cssSelector("#content > iframe")));

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions dragAndDrop = new Actions(driver);

        dragAndDrop.dragAndDrop(draggable, droppable).build().perform();
    }

    public static void performRightClick(WebDriver driver) {
        Actions rightClick = new Actions(driver);
        rightClick.contextClick().build().perform();
    }

}
