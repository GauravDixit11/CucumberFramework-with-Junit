Feature: Launch Admin Interface

Background:
When Launch the browser 
Then Browser should be started

@RegressionTest
Scenario: Verify the Launch Admin Interface of the Application
Given User is on the landing page
Then Capture the text Administrator Login for verification 

@RegressionTest
Scenario: Verify Mandatory Elements availability in Admin interface home page
Given User is on the landing page
When Click on the link of online Catalog
Then Return the existence status of create an account,login, and Shopping Cart links

@RegressionTest
Scenario: Verify the Launch Admin Interface with valid credentials.
Given User is on the landing page
When Enter username "gcreddy" and password "Temp@2020" and click on login button
Then User lands on home page of Admin Interface
And Check the text on the home page
 

@SmokeTest
Scenario: Verify the Launch Admin Interface with blank credentials.
Given User is on the landing page
When Enter username "" and password "" and click on login button
Then Error message should be displayed on landing page


@SmokeTest
Scenario Outline: Verify the Launch Admin Interface with invalid credentials.
Given User is on the landing page
When Enter <username> and <password> invalid and click on login button
Then Error message should be displayed on landing page


Examples:
|username |password |
|abcdef   |Temp@0000|
|dfsfs    |asjdak   |

@RegressionTest
Scenario: Page Redirect Functionality (From Admin to User Interface) before Login
Given User is on the landing page
When Click on the link of online Catalog
Then Verify the user is on User Interface
 

@RegressionTest
Scenario Outline: Verify Admin Login Locking Functionality
Given User is on the landing page
When Enter <username> and <password> invalid and click on login button
Then Capture the Error message and compare with expected for fourth times


Examples:
|username |password |
|abcdefg  |Temp@2020|
|gcreddy  |Temp@0000|
|abcdxyz  |Temp@1111|
|gcreddy  |Temp@2020|

@Smoke
Scenario: Check the existance of G C Reddy link near Copyright text
Given User is on the landing page
When User clicks on the G C Reddy link
Then User should naviagte to next site 