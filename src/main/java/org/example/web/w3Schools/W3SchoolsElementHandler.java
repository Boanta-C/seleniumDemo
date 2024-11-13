package org.example.web.w3Schools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3SchoolsElementHandler {

    public static void cookiesHandler(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sn-b-custom")));
        driver.findElement(By.cssSelector("#sn-b-custom")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sn-b-save")));
        driver.findElement(By.cssSelector("#sn-b-save")).click();

    }

    public static void switchToFrame(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //we need to wait until the YouTube playlist loads because it automatically scrolls to it
        WebElement playlist = driver.findElement(By.cssSelector("#yt-playlist-container"));
        wait.until(ExpectedConditions.visibilityOf(playlist));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");

        WebElement iFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#main > div:nth-child(7) > iframe")));
        driver.switchTo().frame(iFrame);
        cookiesHandler(driver);
        WebElement javaScriptButton = driver.findElement(By.cssSelector("#subtopnav > a:nth-child(5)"));


        //had to change the order of next two lines to become more reliable
        WebElement title = driver.findElement(By.cssSelector("#main > h1"));
        javaScriptButton.click();
        wait.until(ExpectedConditions.stalenessOf(title));
        WebElement newTitle = driver.findElement(By.cssSelector("#main > h1"));
        System.out.println(newTitle.getText());

        //by index
        //System.out.println(driver.switchTo().frame(0).findElement(By.cssSelector("#main > h1")).getText());

    }

}
