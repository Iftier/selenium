Feature: Saucedemo login functionality

  Scenario: User should be able to login with valid credentials

    # Step are written using Gherkin comment  e.g Given and then

   Given I navigate to "http://saucedemo.com"
    When I enter valid username and password
    And I click on logon button
    Then I should be successfully logged in
    And I quit the browser