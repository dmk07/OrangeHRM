@tag
Feature: Admin Login
  I want to use this template to check Admin Login Feature

  @tag1
  Scenario: Check Admin Login with valid data
    Given I open browser with url "http://orangehrm.qedgetech.com" 
    Then I should see login page
    When I enter username as "Admin"
    And I enter password as "Qedge123!@#"
    And i click login
    Then I should see admin module
    When i click logout
    Then I should see login page
    When I close browser
  
@tag2
  Scenario Outline: Check Admin Login with invalid data
   Given I open browser with url "http://orangehrm.qedgetech.com" 
   Then I should see login page
   When I enter username as "<uname>"
   And I enter password as "<pword>"
   And i click login
   Then I should see error message
   When I close browser

		Examples: 
      | uname | pword | 
      | Admin |  abc | 
      | abc |  Qedge123!@# |
      | abc | xyz |
  