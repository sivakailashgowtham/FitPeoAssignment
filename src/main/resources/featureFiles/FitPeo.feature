Feature: FitPeo Assignment

  Scenario: User navigate to fitPeo homePage and interact with revenue calculator and select cpt codes

    Given User navigate to fitPeo homePage
    When user click revenue calculator page
    And user select values in revenue calculator
    And user selecting cpt codes
    Then user verify the header with selected amount
