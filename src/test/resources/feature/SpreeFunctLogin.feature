Feature: This describe the login functionality for Spree application
  Description: This explain how various login functionality will work
         #Business Need:
         #Valid user with valid password will be able to login
         #Invalid user with valid password will not be able to logim
         # Valid user with Invalid password will not be able to login

  Scenario: Valid user and valid password will be able to login

    Given not a validated user
    When user browse to the site "http://spree.shiftedtech.com"
    Then hompage should display
    When user click login page
    Then loginpage should display
    When user enter valid email address "shiftqa01@gmail.com"
    And user enter valid password address "shiftedtech"
    Then user click login button