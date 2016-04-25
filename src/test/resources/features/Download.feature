
Feature: Download section
  In order to use Selenium in my project, I want to download Selenium language bindings


Scenario: Java binding download link check
    Given I am on the Selenium homepage
    When I click "Download" tab
    Then I should see "Java" download link on Download page
    And I should see "C#" download link on Download page
    And I should see "Ruby" download link on Download page
    And I should see "Python" download link on Download page
    And I should see "Javascript (Node)" download link on Download page
    
@orig
Scenario: Simple second secenario
    Given I am a first step
    Then I am a second step