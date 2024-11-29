package org.example.sitehandlers.localWebsite;

import org.example.sitehandlers.ElementUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocalWebsiteElementHandler {

    public static void clickAlertButtons(WebDriver driver) {
        WebElement basicAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(2)"));
        WebElement confirmationAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(5)"));
        WebElement promptAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(8)"));

        basicAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert basicAlert = driver.switchTo().alert();
        basicAlert.accept();

        confirmationAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.dismiss();

        String name = "Cristi B";
        promptAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(name);
        promptAlert.accept();
        WebElement promptAlertMessage = driver.findElement(By.id("demo"));

        ElementUtils.assertTextEqualsExpected(promptAlertMessage, "Hello " + name + "! How are you today?");

    }

}
