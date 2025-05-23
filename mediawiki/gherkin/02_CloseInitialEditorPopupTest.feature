Scenario: Closes the pop-up that is shown the first time the editor is opened. Required for a successful execution of other tests
	Given the user is on the home page
	When the user clicks the "Log in" link
        And enters "admin" in the "Username" field
        And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
        And clicks the "Log in" button
        And enters "Software testing" in the search bar
        And presses Enter
        And clicks the "Software testing" link
	Then a pop-up is shown inside the page

    Given the previous assertion passed
    Then the user clciks the "Start editing" button