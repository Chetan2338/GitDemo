#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#
@tag
Feature: purchase the order from E-commerce
  I want to use this template for my feature file


Background:
Given I landed on E-Commerce site.

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given I logged in username <name> and password <password>
    When add the product <Productname> to the code
    And checkout<Productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage.

    Examples: 
      | name  										| password | Productname |
     	| chetan.jayaraja@gmail.com | GGwtf_121 | ZARA_COAT_3|
     
