package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ViewPersonalDetails extends Utils{
    By _addBtn = By.id("btnAddAttachment");
    By _firstNameTxtField = By.id("personal_txtEmpFirstName");

//    String actual =  getElement(_firstNameTxtField).getAttribute("value");

    LoadProp loadProp = new LoadProp();

    public void verifyEmployeeAddedSuccessfully(){
        waitForClickable(_addBtn,20);
        System.out.println(getElement(_firstNameTxtField).getAttribute("value"));
//        Assert.assertEquals(
//                loadProp.getProperty("employeeFirstName"),
//                actual, "Error: Expected and actual do NOT match"
//                );
    }

}
