package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {
    LoadProp loadProp = new LoadProp();

    By _usernameField = By.cssSelector("input#txtUsername");
    By _password = By.cssSelector("input#txtPassword");
    By _loginButton = By.cssSelector("input#btnLogin");
    By _loginPanel = By.xpath("//*[@id=\"logInPanelHeading\"]");

    public void enterUserName() {
        typeText(_usernameField, loadProp.getProperty("adminUsername"));
    }

    public void enterPassword(){
        typeText(_password, loadProp.getProperty("adminPassword"));
    }

    public void clickLoginButton(){
        clickOnElement(_loginButton);
    }

    public void verifyUserIsOnHomePage(){
        waitForVisible(_loginPanel,20);
        Assert.assertTrue(getTextFromElement(_loginPanel).equalsIgnoreCase("LOGIN Panel"), "Error: Login panel not found");
    }

}
