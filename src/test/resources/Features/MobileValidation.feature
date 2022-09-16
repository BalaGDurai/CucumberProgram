#Author: your.email@your.domain.com
Feature: MobileValidation

  #Scenario: 
    #Given user launch flipkart
    #And user login flipkart
    #When user search mobile and get text
    #And user click the mobile and windows handling
    #And user scrolldown to specification
    #Then user take screenshot
#
  #Scenario: 
    #Given user launch flipkart
    #And user login flipkart
    #When user search mobile and get text by using one dim list
      #| iPhone | realme | SAMSUNG |
    #And user click the mobile and windows handling
    #And user scrolldown to specification
    #Then user take screenshot

  Scenario Outline: 
    Given user launch flipkart
    And user login flipkart
    When user search mobile by using "<phones>"
    And user click the mobile and windows handling
    And user scrolldown to specification
    Then user take screenshot

    Examples: 
      | phones  |
      | iPhone  |
      | realme  |
      | SAMSUNG |
