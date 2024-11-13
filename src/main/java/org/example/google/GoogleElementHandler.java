package org.example.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleElementHandler {

    public static void rejectGoogleCookies(WebDriver driver) {
        WebElement rejectCookiesButton = driver.findElement(By.xpath("//*[@id=\"W0wltc\"]/div"));
        rejectCookiesButton.click();
    }

    public static void rejectYoutubeCookies(WebDriver driver) {
        WebElement rejectCookiesButton = driver.findElement(By.xpath(
              "//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[3]/div[1]/form[1]/div/div/button")); //this might be a dynamic ID
        rejectCookiesButton.click();
    }

    public static void sentTextToSearchBox(WebDriver driver) {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchBox.sendKeys("youtube" + Keys.ENTER);
    }

    public static void clickChannelButton(WebDriver driver) {
        WebElement channelButton = driver.findElement(By.xpath(
                "//*[@id=\"rso\"]/div[1]/div/div/div/table/tbody/tr[2]/td/div/div/div/div/h3/a"));
        channelButton.click();
    }

}