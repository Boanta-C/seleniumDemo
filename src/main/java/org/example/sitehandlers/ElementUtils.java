package org.example.sitehandlers;

import org.openqa.selenium.WebElement;

public class ElementUtils {

    public static void assertTextEqualsExpected(WebElement webElement, String expectedText) {
        if(webElement.getText().equals(expectedText)) {
            System.out.println(webElement.getText() + "\nmatches \n" + expectedText);
        } else
            System.out.println(webElement.getText() + " \ndoes not match \n" + expectedText); //can also throw an exception but won't do that here
    }



}
