@ssePricing
Feature: pricing checks
  As a user I want to make sure that the pricing shown to me inside the pricing table

  Scenario: Pricing match for PO9 1QH postcode
    Given I navigate to sse website
    And I go to pricing and tariff Information
    When I enter the post code "PO9 1QH"
    Then I see the pricing details for "Fix 2020"
    And price value of should be "14.80"
