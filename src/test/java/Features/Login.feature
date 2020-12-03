Feature: exercise 3 java automation
  This feature deals with the login functionality and research of products

  Scenario: Login Amazon page with the correct credentials
    Given I have to navigate to the Amazon Page
    And I enter username
      | username                   |
      | marisolcolon1227@gmail.com |
    And I click the continue button
    And I enter the password
      | password        |
      | amazonTesting!! |
    Then I click the login button



