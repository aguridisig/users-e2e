Feature: Search in Google

  Scenario: Search Cucumber Selenium JavaPointers Tutorial
    When I go to "https://google.com"
    And I type "cucumber selenium java pointers tutorial"
    And I hit Enter
    Then I should be shown the results from my query