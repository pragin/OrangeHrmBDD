package org.example;

import org.openqa.selenium.By;

public class Utils extends BrowserManager{


//    Return text from an element
    public static String getText(By by){
        return driver.findElement(by).getText();
    }

//    Clicks on an element
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }


}
