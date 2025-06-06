Feature: Catalog management
Scenario: Checks that taxes are computed correctly when adding a new product using the italian reduced VAT rate (10%)
	Given the user is on the login page of the administration panel (/administrator)
	When the user enters "admin@prestashop.com" in the "Email address" field
		And enters "e2eW3Bt3s71nGB3nchM4rK" in the "Password" field
		And clicks the "Login" button
		And hovers on "Catalog"
		And clicks on "Products"
		And clicks the "Add new product" button
		And clicks the "Prices" link
		And enters "10" in the "Pre-tax retail price" field
		And selects "IT Reduced Rate (10%)" from the "Tax rule" dropdown select
	Then "11.00" is shown as value of the "Retail price with tax" field
	
	Given the previous assertion passed
	Then the user clicks on the user icon in the top right corner of the page
	And clicks the "Sign out" link