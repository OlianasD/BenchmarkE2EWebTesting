Feature: Employee management
Scenario: Tries to add a new employee without email and fails
	Given the user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
		And clicks the "Login" button
		And hovers on "Administration"
		And clicks on "Employees"
		And clicks the "Add new employee" button
		And enters "John" into the "First Name" field
		And enters "Smith" into the "Last Name" field
		And enters "abcd!@#$23" into the "Password" field
		And selects "Salesman" from the "Permission profile" dropdown select
		And clicks on the "Save" button
	Then an error message is shown on a red box

	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link