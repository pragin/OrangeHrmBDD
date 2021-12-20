package org.example;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {

    HomePage homePage = new HomePage();
    DashBoard dashBoard = new DashBoard();

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        homePage.verifyUserIsOnHomePage();
    }

    @Then("user enters username")
    public void user_enters_username() {
        homePage.enterUserName();
    }

    @Then("user enters password")
    public void user_enters_password() {
        homePage.enterPassword();
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
        dashBoard.clickOnTriangleAndLogut();

    }
    @Then("user should be able to logout successfully")
    public void user_should_be_able_to_logout_successfully() {
//        homePage.verifyUserIsOnHomePage();
    }

    @Given("user is already logged in")
    public void userIsAlreadyLoggedIn() {
        homePage.verifyUserIsOnHomePage();
        homePage.enterUserName();
        homePage.enterPassword();
        homePage.clickLoginButton();
        dashBoard.verifyUserIsOnDashBoardPage();

    }
}
