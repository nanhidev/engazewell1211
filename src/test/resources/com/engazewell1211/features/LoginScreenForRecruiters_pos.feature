
Feature: LoginScreenForRecruiters_pos @feature_user_login

  Background: 
    Given the user is on the Login Screen

  @valid-login
  Scenario Outline: Login Screen for Recruiters
    When I enter a valid email ID <email> in the Email ID field
    And I enter a valid password <password> in the Password field
    And I click on the 'Show Password' option to verify the password visibility
    And I click the Login button
    Then the user should be redirected to the dashboard
    And the dashboard loads successfully without errors

    Examples:
      | email                   | password            |
      | recruiter@example.com   | SecurePassword123    |

  @feature_user_login
  @disabled_login_button
  Scenario Outline: Login button state verification with empty password
    When I enter a valid email ID in the Email ID field
    And I leave the Password field empty
    Then the Login button should be disabled

    Examples:
      | email              | password |
      | <email>           | <password> |
  
  @enabled_login_button
  Scenario Outline: Login button state verification with filled password
    When I enter a valid email ID in the Email ID field
    And I enter a valid password in the Password field
    Then the Login button should be enabled

    Examples:
      | email              | password    |
      | krishna@gmail.com  | password123  |

  @toggle_password_visibility
  Scenario Outline: Verify 'Show/Hide Password' Functionality
    Given the user has entered a valid password in the Password field
    When the user clicks on the 'Show Password' option
    Then the password should be visible
    When the user clicks on the 'Hide Password' option
    Then the password should be hidden
    And the user can still log in successfully after toggling

  Examples:
    | password              |
    | ValidPassword123!     |

  @valid-login-with-subdomain
  Scenario Outline: Login Screen for Recruiters
    When I enter "<email_with_subdomain>"
    And I enter "<password>"
    And I click the Login button
    Then the user should be redirected to the dashboard successfully

    Examples:
      | email_with_subdomain       | password        |
      | user@mail.example.com      | correct_password |

  @valid-login-without-subdomain
  Scenario Outline: Login Screen for Recruiters
    When I log out and return to the Login Screen
    And I enter "<email_without_subdomain>"
    And I enter "<password>"
    And I click the Login button
    Then the user should be redirected to the dashboard successfully

    Examples:
      | email_without_subdomain     | password        |
      | user@example.com            | correct_password |

  @valid-login
  Scenario Outline: Login process is case-sensitive for passwords
    When I enter "<email>"
    And I enter "<password>"
    And I click the Login button
    Then the user should be redirected to the dashboard successfully

    When I log out and return to the Login Screen
    And I enter "<email>"
    And I enter "<incorrect_password>"
    And I click the Login button
    Then an error message "Incorrect email ID or password." should be displayed

  Examples:
    | email              | password      | incorrect_password |
    | krishna@gmail.com  | Password123   | password123        |

  @valid-login-gmail
  Scenario Outline: Login Screen for Recruiters
    When I enter "<email>"
    And I enter "<password>"
    And I click the Login button
    Then the user should be redirected to the dashboard successfully

    Examples:
      | email               | password            |
      | user@gmail.com     | correctPassword123  |
      | user@yahoo.com     | correctPassword123  |

  @logout
  Scenario Outline: Logout from Dashboard
    Given the user is on the dashboard
    When I log out
    Then the user should return to the Login Screen

    Examples:
      | email               | password            |
      | user@gmail.com     | correctPassword123  |
      | user@yahoo.com     | correctPassword123  |

  @valid-login-alphanumeric
  Scenario Outline: Login Screen for Recruiters
    When the user enters "<email>"
    And the user enters "<password>"
    And the user clicks the Login button
    Then the user should be redirected to the dashboard successfully

    When the user logs out and returns to the Login Screen
    And the user enters "<email>"
    And the user enters "<special_password>"
    And the user clicks the Login button
    Then the user should be redirected to the dashboard successfully

  Examples:
    | email              | password      | special_password |
    | krishna@gmail.com  | Password123   | !@#Password      |

@valid-login
Scenario Outline: Login Screen for Recruiters
  When I enter a valid email ID containing numbers "<email>"
  And I enter the correct password "<password>"
  And I click the Login button
  Then the user should be redirected to the dashboard successfully

  Examples:
    | email                     | password         |
    | user123@example.com      | correct_password |
    | user456@example.com      | correct_password |

@logout
Scenario Outline: Logout and Return to Login Screen
  When I log out
  Then the user should return to the Login Screen
  When I enter a valid email ID containing numbers "<email>"
  And I enter the correct password "<password>"
  And I click the Login button
  Then the user should be redirected to the dashboard successfully

  Examples:
    | email                     | password         |
    | user123@example.com      | correct_password |
    | user456@example.com      | correct_password |

  @valid-login-hyphen-emails
  Scenario Outline: Login process with valid email IDs containing hyphens
    When the user enters "<email>"
    And the user enters "<password>"
    And the user clicks the Login button
    Then the user should be redirected to the dashboard successfully

    Given the user logs out and returns to the Login Screen
    When the user enters "<email2>"
    And the user enters "<password2>"
    And the user clicks the Login button
    Then the user should be redirected to the dashboard successfully

    Examples:
      | email                  | password              | email2                     | password2              |
      | user-name@example.com  | correctPassword123    | user-name123@example.com   | correctPassword123     |
