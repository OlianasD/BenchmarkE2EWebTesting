Feature: Catalog management
Scenario: Adds a new tag
	Given the user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
		And clicks the "Login" button
		And hovers on "Catalog"
		And clicks on "Tags"
		And clicks the "Add new tag" button
		And enters "Hat" in the "Name" field
		And clicks on the "Save" button
	Then "Successful creation" is shown on a green box

	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link