Feature: User API

  Scenario: Get an existing user
    Given I have a user with ID 1
    When I send a GET request for the user
    Then the response status code should be 200
    And the user name should be "Leanne Graham"