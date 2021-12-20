package org.example;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepDefs {

    HomePage homePage = new HomePage();

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

    @Then("user should see the the dashboard with name")
    public void user_should_see_the_the_dashboard_with_name() {

    }


}
