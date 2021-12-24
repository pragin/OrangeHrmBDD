package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BrowserManager{

//  Used to click on different menu items
    public static void clickOnMenuItem(String menuItem){
        clickOnElement(By.linkText(menuItem));
    }
//    Return text from an element
    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

//    Clicks on an element
    public static void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public static String getUrl(){
        return driver.getCurrentUrl();
    }

    public static WebElement getElement(By by){
        return driver.findElement(by);
    }

    public static String getCurrentTimeStamp(){
        Date date = new Date();
        SimpleDateFormat spf = new SimpleDateFormat("ddMMyyhhmmss");
        return spf.format(date);
    }

    public static void waitForVisible(By by, int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOf(getElement(by)));
    }

    public static void waitUntilPresent(int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForClickable(By by, int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
