Feature: Verify Syntax Writing for cucumber files

  Background: Make sure user is on Login page

    #Used for testing concrete scenario's
  Scenario: Verify if user is able to login successfully
    Given User enters username
    When User enters password
    Then User is able to login

    #Used for testing parametrized scenario's
    Scenario Outline: Verify if user is able to login with multiple creds
      Given User enters this "<username>"
      When User enters that "<password>"
      Then User is able to login

      Examples:
      |username|password|
      |abc@gmail.com|   qwer1234|
      |xyz@gmail.com|   qwer1234|

      #Following is strictly applicable for .net/c#. Not recommended for java
      @source:LoginData.csv
      Scenario Template:
        Given do something please "<abc>"
        When do something more
        Then Do something even more "<xyz>"
        Examples:
          |  abc|xyz|
          |  def | ghi   |
