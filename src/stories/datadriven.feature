@test
Feature: In order to test the pricing 
  as a user I want submit the contact form using valid fields

  Scenario: Sumbit form using valid data
    Given I navigate to zoo website
    When I navigate to contact form
    And I submit the form with valid data
      | name  | Address           | postcode | email         |
      | Harry | 41,Hensworth Road |   123456 | test@test.com |
    Then I check that the form has been submitted
