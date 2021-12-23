Feature: Delete existing user

  I should be able to delete an existing employee/user
  Scenario: As an admin user, I should be able delete an existing employee/user
    Given user is already logged in
    When user hover the mouse on PIM menu item
    And user clicks "Employee list" sub item
    Then user should be able to see Employee information form
    When user enters employee name
    And clicks on search button
    And select the employee that needs to be deleted
    And clicks on delete button
    And clicks on ok button
    Then employee should be deleted successflly


