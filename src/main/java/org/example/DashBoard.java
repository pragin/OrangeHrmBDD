package org.example;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DashBoard extends Utils {
    LoadProp loadProp = new LoadProp();
    Actions builder = new Actions(driver);

    //    By _dashBoardHeadingText = By.linkText("Dashboard");
    By _welcomeText = By.id("welcome");
    By _logoutLink = By.xpath("//a[@href=\"/index.php/auth/logout\"]");

    public void verifyUserIsOnDashBoardPage() {
        Assert.assertTrue(getUrl().equalsIgnoreCase("Dashboard")
                || getTextFromElement(_welcomeText).contains("Welcome"));
    }

    public void clickOnTriangleAndLogut() {
        //Move the mouse to welcome and click
        builder.moveToElement(getElement(_welcomeText))
                .click()
                .build()
                .perform();

        waitForVisible(_logoutLink, 10);

        //Click on logout link
        builder.moveToElement(getElement(_logoutLink))
                .click()
                .build()
                .perform();

    }
}
