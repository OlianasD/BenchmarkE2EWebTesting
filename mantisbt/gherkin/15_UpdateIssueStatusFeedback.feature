Scenario: Changes the status of an issue to "feedback"
	Given the user is on the home of the site and logged as administrator
	When the user clicks the "View Issues" link
		And clicks the pencil icon in the row of the first issue
		And selects "feedback" in the "Status" dropdown select
		And clicks the "Update Information" button
	Then "feedback" is shown to the right of "Status"