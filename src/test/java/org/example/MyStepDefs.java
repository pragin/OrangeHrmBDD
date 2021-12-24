package org.example;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {

    HomePage homePage = new HomePage();
    DashBoard dashBoard = new DashBoard();
    PIM pim = new PIM();
    AddEmployee addEmployee = new AddEmployee();
    ViewPersonalDetails viewPersonalDetails = new ViewPersonalDetails();
    ViewEmployeeList viewEmployeeList = new ViewEmployeeList();


    @Given("user is on homepage")
    public void user_is_on_homepage() {
        homePage.verifyUserIsOnHomePage();
    }

    @Then("user enters username")
    public void user_enters_username() {
        homePage.enterAdminUserName();
    }

    @Then("user enters password")
    public void user_enters_password() {
        homePage.enterAdminPassword();
    }

    @Then("user clicks on Login button")
    public void user_clicks_on_login_button() {
        homePage.clickLoginButton();
    }

    @Given("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        dashBoard.verifyUserIsOnDashBoardPage();
    }

    @When("user clicks on logout link")
    public void user_clicks_on_logout_link() {
        dashBoard.clickOnTriangleAndLogout();
    }

    @Then("user should be able to logout successfully")
    public void user_should_be_able_to_logout_successfully() {
//        homePage.verifyUserIsOnHomePage();
    }

    @Given("user is already logged in")
    public void userIsAlreadyLoggedIn() {
        homePage.verifyUserIsOnHomePage();
        homePage.enterAdminUserName();
        homePage.enterAdminPassword();
        homePage.clickLoginButton();
        dashBoard.verifyUserIsOnDashBoardPage();
    }

    @When("user hover the mouse on PIM menu item")
    public void user_hover_the_mouse_on_pim_menu_item() {
        pim.hoverOnPimMenu();
    }

    @When("user clicks {string} sub item")
    public void user_clicks_sub_item(String menuItem) {
        Utils.clickOnMenuItem(menuItem);
    }

    @Then("user should see Add Employee form")
    public void user_should_see_add_employee_form() {
        addEmployee.verifyUserIsOnAddEmployeePage();
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        addEmployee.clickOnSaveBtn();
    }

    @Then("user should see the personal Details section")
    public void user_should_see_the_personal_details_section() {
        viewPersonalDetails.verifyEmployeeAddedSuccessfully();
    }

    @When("user fill Add employee form")
    public void userFillAddEmployeeForm() {
        addEmployee.FillAddEmployeeForm();
    }

    @Given("employee is added successfully")
    public void employeeIsAddedSuccessfully() {
    }

    @When("new employee enters username")
    public void newEmployeeEntersUsername() {
        homePage.enterEmployeeUserName();
    }

    @And("new employee enters password")
    public void newEmployeeEntersPassword() {
        homePage.enterEmployeePassword();
    }

    @Then("new employee should be logged in successfully")
    public void newEmployeeShouldBeLoggedInSuccessfully() {
        dashBoard.verifyNewEmployeeSuccessfullyLoggedIn();
    }

    @Then("user should be able to see Employee information form")
    public void userShouldBeAbleToSeeEmployeeInformationForm() {
        viewEmployeeList.verifyUserIsOnViewEmployeeList();
    }

    @When("user enters employee name")
    public void userEntersEmployeeName() {
        viewEmployeeList.enterEmployeeName();
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        viewEmployeeList.clickOnSearch();
    }

    @And("select the employee that needs to be deleted")
    public void selectTheEmployeeThatNeedsToBeDeleted() {
        viewEmployeeList.selectEmployee();
    }

    @And("clicks on delete button")
    public void clicksOnDeleteButton() {
        viewEmployeeList.clickOnDeleteBtn();
    }

    @And("clicks on ok button")
    public void clicksOnOkButton() {
        viewEmployeeList.confirmDelete();
    }

    @Then("employee should be deleted successfully")
    public void employeeShouldBeDeletedSuccessfully() {
        viewEmployeeList.verifyEmployeeHasBeenDeletedSuccessfully();
    }
}
