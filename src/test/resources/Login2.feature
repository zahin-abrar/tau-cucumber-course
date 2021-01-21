Feature: Login Functionality
  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully


#Scenario: Login Successful
  #Given I am in the login page of the Para Bank Application
  #When I enter valid credential
  #Then I should be taken to the Overview page

#Scenario Outline: Login successful
 # Given I am in the login page of the Para Bank Application
  #When I enter valid <username> and <password>
  #Then I should be taken to the Overview page

#Examples:
 # |username|password|
  #|"autotester"|"passowrd"|
  #|"tautester"|"password" |

#data table example
#Scenario: Login Successful
  #Given I am in the login page of the Para Bank Application
  #When I enter valid credentials
  #|autotester|password|
  #Then I should be taken to the Overview page

  Scenario Outline: Login successful
    Given I am in the login page of the Para Bank Application
    When I enter valid <username> and <password> with <userFullName>
    Then I should be taken to the Overview page

    Examples:
      |username|password|userFullName|
      |"autotester"|"passowrd"|"Auto Tester"|
      |"tautester"|"password" |"TAU Tester"   |



