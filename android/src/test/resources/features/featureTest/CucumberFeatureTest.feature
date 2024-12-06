Feature: Cucumber Features Testing

  @p1 @test
  Scenario: This is a passing scenario
    Given I run a sample step
    And This Step passes

#  @p2
#  Scenario Outline: This is a parameterised test
#    Given I run a sample step
#    Then I enter params here '<username>' and password '<password>'
#
#    Examples:
#      | username | password |
#      | user1    | pass1 |
#      | user2    | pass2 |
#
#  Scenario: This is a failing scenario
#    Given I run a sample step
#    When This Step fails
#
#  Scenario: This is a failing scenario with exception
#    Given I run a sample step
#    Then I run a step that will fail with Exception
#
#  @ignoredScenario
#  Scenario: This is Scenario will skip
#    Given I run a sample step
#    Then I run a step that will have a PendingException
