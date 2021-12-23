package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PIM extends Utils{

    By _PIMmenu = By.id("menu_pim_viewPimModule");
    By _addEmployeeLink = By.id("menu_pim_addEmployee");


    //Create an Actions class obj for mouse event
    Actions builder = new Actions(driver);

    public void hoverOnPimMenu(){
        //Create mouse over actions on PIM menu
        waitForVisible(_PIMmenu,20);
        builder.moveToElement(getElement(_PIMmenu)).perform();
    }

    public void clickOnAddEmployeeSubMenu(){
        //Click on Add employee link
        waitForClickable(_addEmployeeLink,20);
        builder.moveToElement(getElement(_addEmployeeLink))
                .click()
                .build()
                .perform();
    }
}
