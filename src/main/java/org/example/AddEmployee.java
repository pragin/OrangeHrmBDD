package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class AddEmployee extends Utils{

    By _saveBtn = By.id("btnSave");
    By _headingAddEmployee = By.xpath("//div[@class=\"head\"]/h1");
    By _firstNameTxtField = By.id("firstName");
    By _lastNameTxtField = By.id("lastName");
    By _loginCheckBox = By.id("chkLogin");
    By _userNameTxtField = By.id("user_name");
    By _passwordTxtField = By.id("user_password");
    By _confirmPasswordTxtField = By.id("re_password");

    LoadProp loadProp = new LoadProp();

    String userName = loadProp.getProperty("employeeUserName") + getCurrentTimeStamp();

    public void verifyUserIsOnAddEmployeePage(){
          waitForVisible(_saveBtn, 20);
        Assert.assertTrue(getTextFromElement(_headingAddEmployee).equals("Add Employee"));
    }

    public void FillAddEmployeeForm(){
        //Enter first name
        typeText(_firstNameTxtField, loadProp.getProperty("employeeFirstName"));
        //Enter last name
        typeText(_lastNameTxtField,loadProp.getProperty("employeeLastName"));
        //click on login details checkbox
        clickOnElement(_loginCheckBox);
        //Enter username
        typeText(_userNameTxtField,userName);
        //Enter password
        typeText(_passwordTxtField,loadProp.getProperty("employeePassword"));
        //Enter confirm password
        typeText(_confirmPasswordTxtField,loadProp.getProperty("employeePassword"));
    }

    public void clickOnSaveBtn(){
        //Click on save button
        clickOnElement(_saveBtn);
    }
}
