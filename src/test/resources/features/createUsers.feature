Feature: create a new random user
  Scenario: client makes call to create a new random user
    Given client want to create a new random user
    When client makes a GET request to /api/users
    Then the response status code should be 201
    And in the database we should have a new user