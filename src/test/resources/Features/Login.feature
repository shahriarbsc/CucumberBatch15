Feature: Login Functionalities

  @smoke

  Scenario: Valid Admin login
   #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser


  @smoke2
  Scenario: Valid Admin login
   #Given open the browser and launch HRMS application
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

  @scenarioOutline

    #Parametrization / Data Driven

  Scenario Outline: Login with multiple credentials using Scenario outline

    #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser
    Examples:

      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |


  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |



    #HOOKS: For defining pre and post steps in any framework

  #      :This is always created inside the StepDefinitions folder
  #      :This class cannot be inherited
  #      : Hooks will take care of pre and post conditions irrespective of what goes in between the test steps
  #      : of what goes in between the test steps.

  #BACKGROUND: Its the clubbing of common steps in different scenarios of a feature file
  # till flow is not broken.

  #1. Hard Code
  #2. Config file

  #--------------------Cucumber itself provides multiple option through
  # which we can feed data from feature file into step definition
  #3. Regular Expression
  # put the data in double quotes [""]

  #4. Scenario Outline

  # provides you an alternative to Data driven testing
  # it also supports parametrization



  #================PARAMETERIZATION======================

  ## Executing the same test case with multiple data


  # if you want to use parametrization
  # if you wish to implement data driven

  # Scenario outline is always used along with the keyword 'Examples'

  #hard Code

  #config file

 # =================

  #Cumcumber Expression [limited set of test data]
  #Scenario Outline [Parametrization ], [Data driven Testing] [Browser will open and close number of times]
  #data table

  # Page Object Model: An object repository [It stores or holds all the webElements specific to