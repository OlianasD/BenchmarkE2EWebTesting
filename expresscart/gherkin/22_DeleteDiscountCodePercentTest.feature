Scenario: Deletes a discount code (by percent)
	Given the user is on the administrative home page (/admin)
		When the user enters "owner@test.com" in the "email address" field
		And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
		And clicks the "Sign in" button
		And clicks the "Discount codes" link
		And clicks the "Delete" button in the row of "discperc000"
		And confirms the JavaScript alert
		And clicks the "Discount codes" link
	Then "discperc000" is not shown on the page

