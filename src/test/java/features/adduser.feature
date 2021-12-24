Feature: Add user

  @test
  Scenario: As an admin user, I should be able to add new users

    Given user is already logged in
    When user hover the mouse on PIM menu item
    And user clicks "Add Employee" sub item
    Then user should see Add Employee form
    When user fill Add employee form
    And user clicks on save button
    Then user should see the personal Details section
    When user clicks on logout link
    Then user should be able to logout successfully
    Given employee is added successfully
    When new employee enters username
    And new employee enters password
    And user clicks on Login button
    Then new employee should be logged in successfully




