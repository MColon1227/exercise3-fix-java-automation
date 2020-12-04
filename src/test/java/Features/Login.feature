Feature: exercise 3 java automation
  This feature deals with the login functionality and research of products

  Scenario: Login Amazon page with the correct credentials
    Given I have to navigate to the Amazon Page
    And I enter username
      | username                   |
      | ADD EMAIL |
    And I click the continue button
    And I enter the password
      | password        |
      | ADD PASSWORD |
    Then I click the login button
    And I search for product: Samsung Galaxy S9 64GB
    And I Select first product and save the price And Click on the product
    And I Validate that the Shop car has 1 as a number
    And I Search for another product: Alienware Aw3418DW
    And I Select First product And Add to Cart
    Then I Verify that the cart number is now 2





