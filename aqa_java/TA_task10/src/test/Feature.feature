Feature: Gmail tests

  Scenario: log in on the Gmail.com successful

    Given Gmail page is opened
    When user enters into email field with currect login and password
    Then user can see the main page
    Then user log out of email

  Scenario: messages withoud recipient should display error

    Given Gmail page is opened
    When user enters into email field with currect login and password
    Then user pick button Написать
    And user filling subject of the letter and send email
    And user should be see the message error
    Then user log out of email

