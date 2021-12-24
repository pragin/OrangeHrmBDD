package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ViewEmployeeList extends Utils{
    By _empInfoH1 = By.xpath("//h1[contains(text(),\"Employee Information\")]");
    By _employeeName = By.id("empsearch_employee_name_empName");
    By _searchBtn = By.id("searchBtn");
    By _checkBox = By.xpath("//td/input[@type=\"checkbox\"]");
    By _deleteBtn = By.id("btnDelete");
    By _modalHeaderText = By.xpath("//div[@class=\"modal-header\"]/h3[contains(text(),\"Confirmation\")]");
    By _modalOkBtn = By.id("dialogDeleteBtn");
    By _noRecordsFound = By.xpath("//td[contains(text(),\"No Records Found\")]");

    LoadProp loadProp = new LoadProp();

    public void verifyUserIsOnViewEmployeeList(){
        Assert.assertEquals(getTextFromElement(_empInfoH1), "Employee Information", "Error: Admin cannot see employee list");
    }

    public void enterEmployeeName(){
        String empName = loadProp.getProperty("employeeFirstName")+" " +loadProp.getProperty("employeeLastName");
        typeText(_employeeName, empName);
    }

    public void clickOnSearch(){
        clickOnElement(_searchBtn);
    }

    public void selectEmployee(){
        List<WebElement> checkBoxList = driver.findElements(_checkBox);
        System.out.println(checkBoxList.size());
        for (WebElement checkbox:checkBoxList) {
            checkbox.click();
        }
//        clickOnElement(_checkBox);
    }

    public void clickOnDeleteBtn(){
        clickOnElement(_deleteBtn);
    }

    public void confirmDelete(){
        waitForClickable(_modalOkBtn, 10);
        System.out.println(getTextFromElement(_modalHeaderText));
        clickOnElement(_modalOkBtn);
    }

    public void verifyEmployeeHasBeenDeletedSuccessfully() {
        Assert.assertEquals(
                getTextFromElement(_noRecordsFound),
                "No Records Found",
                "Error: Employee has not been deleted!!!");
    }
}
