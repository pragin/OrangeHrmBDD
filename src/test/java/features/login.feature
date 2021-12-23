Feature: Login

#  @test
  Scenario: As an admin user, I should be able login with valid username and password

    Given user is on homepage
    Then user enters username
    And user enters password
    And user clicks on Login button
    Then user is successfully logged in