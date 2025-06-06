Feature: Catalog management
Scenario: Tries to add a manufacturer without name and fails
	Given the user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
		And clicks the "Login" button
		And hovers on "Catalog"
		And clicks on "Manufacturers"
		And clicks the "Add new manufacturer" button
		And clicks the "Save" button
	Then an error message is shown on a red box

	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link