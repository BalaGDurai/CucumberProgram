#Author: your.email@your.domain.com
Feature: Tv Validation

  Scenario Outline: 
    Given user launches the flipkart
    Given user enter to login page
    When user search Tv by using "<product>"
    And user click Tv and move to next page and windows handling
    And user moves to specification using scrolldown
    Then user get the screenshot

    Examples: 
      | product |
      | SAMSUNG |
      | SONY    |
      | OnePlus |
