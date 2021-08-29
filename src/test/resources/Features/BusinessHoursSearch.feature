Feature: BusinessHoursSearch
	
	Scenario Outline: Verify that a user can look up business hours for studios nearby
    Given user is on the workshop search page
    And user clicks on studio tab
    When enters <zipcode> in the search field
    And clicks on go arrow
    Then page should load results for that <zipcode>
    When user clicks on first search result
    Then user should be redirected to workshop details page
    When user clicks on business hours
    Then user should see all business hours for that studio

    Examples: 
      |zipcode|
      | 10011 | 

