Feature: 91 Wheels

  Scenario: Navigate to Upcoming Bikes and Display Honda Bikes
    Given Hover on Bikes DropDown
    When Click on Upcoming Bikes
    And Select Honda Bikes from select brand DropDown and click LoadMore
    Then Print the Honda Bikes price under fourLakhs
    
  Scenario: Used Cars in CHENNAI
  	Given Hover on usedCars DropDown
  	When Click usedCars in CHENNAI
  	And Click Read More button
  	Then Print the information of Popular used cars
  	
	Scenario: Invalid LoginPage
		Given Click the userLogin button
		When Click the signIn button
		And Enter the email credentials
		Then Print the error message
    
    
