Scenario: Tries to add a swimlane without name and fails
	Given the user is on the login page (/login)
		When the user enters "admin" in the "Username" field
		And enters "admin" in the "Password" field
		And clicks thre "Sign in" button
		And clicks the "#1" icon to the left of "Test 2"
		And clicks the "Configure this project" link
		And clicks the "Swimlanes" link
		And clicks the "Add a new swimlane" link
		And clicks the "Save" button
	Then "The name is required" is shown below the "Name" field
