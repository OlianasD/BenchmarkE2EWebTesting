Scenario: Searches a student in the system
	Given the user is on the home page (/claroline11110/index.php)
		When the user enters "admin" in the "Username" field
		And enters "n0tl34k3dy3t" in the "Password" field
		And clicks the "Enter" button
		And clicks the "Platform administration" link
		And clicks the "Advanced" link in the "Users" section
		And enters "testuser1" into the "Name" field
		And selects "Student" in the "Action" dropdown select
		And clicks the "Search user" button
	Then "testuser1" is shown in the "Name" column of the first row of the table

	Given the previous assertion passed
	Then the user clicks the "Logout" link