Scenario: Tries to add a project without name and fails
	Given the user is on the login page (/login)
		When the user enters "admin" in the "Username" field
		And enters "admin" in the "Password" field
		And clicks thre "Sign in" button
		And clicks the "New project" link
		And clicks the "Save" button
	Then "The project name is required" is show below the "Name" field