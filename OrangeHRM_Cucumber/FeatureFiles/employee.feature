@tag
Feature: New Employee Registration
  I want to use this template to check new employee registration.

  @tag1
  Scenario: Check new employee registration with valid data
    Given I open browser with url "http://orangehrm.qedgetech.com" 
    Then I should see login page
    When I enter username as "Admin"
    And I enter password as "Qedge123!@#"
    And i click login
    Then I should see admin module
    When I click pim and add employee
    Then I should see new employee registration page
    When I enter firstname as "Leshant"
    And I enter lastname as "demo"
    And I click Save
    When I close browser    
   
	
