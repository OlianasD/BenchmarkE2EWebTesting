Scenario: Add a new user
	Given the user is on the home of the site and logged as administrator
	When the user clicks the "Manage" link
		And clicks the "Manage users" link
		And clicks the "Create new account" button
		And enters "username001" in the "Username" field
		And enters "username001" in the "Real Name" field
		And enters "username@username.it" in the "E-mail" field
		And selects "updater" in the "Access Level" dropdown select
		And clicks the "Create user" button
		And clicks the "Manage Users" link
	Then "username001" is shown as username of the second user
	And "username001" is shown as real name of the second user
	And "username@username.it" is shown as e-mail of the second user
	And "updater" is shown as access level of the second user