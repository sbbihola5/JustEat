Feature: Use the JustEat website to find restaurants
Scenario: Search for restaurants in an area
	Given I want food in "AR51 1AA"
When I search for restaurants
Then I should see some restaurants in "AR51 1AA"
