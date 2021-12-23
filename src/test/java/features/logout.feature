Feature: Log out
#  @test
  Scenario: As a registered user, I should be able to logout from the dashboard

    Given user is already logged in
    When user clicks on logout link
    Then user should be able to logout successfully