Feature: Landing Page Feature

Background:
Given user has already logged in to application
|username|password|
|gdgaurav66@gmail.com|Gaurav123|

@landing
Scenario: Landing page title
Given user is on Landing page
When user get the title of the page
Then page title should be this "My Account"

@landing
Scenario: My Account section count
Given user is on Landing page
Then user gets my account section
|My Account|
|Order History|
|Wish List|
|Newsletter|
And my account section count should be 4
