Feature: Purchase in Ebay

	Scenario: Shop By category
		Given locate the shop by category 
		When click the category 
		Then validate the category is clicked 
		And Click on Gps and security devices
		Then Search in search bar
		Then validate the parent page and current page title
		
#	Scenario: Shop By category
#		Given locate the shop by category "https://www.ebay.com"
#		When click the category 
#		Then validate the category is clicked 
#		And Click on Gps and security devices
#		Then Search in search bar
#		Then validate the parent page and current page title
#	
#	Scenario Outline: Shop By category
#		Given locate the shop by category "<Name>"
#		When click the category 
#		Then validate the category is clicked 
#		And Click on Gps and security devices
#		Then Search in search bar 
#		Then validate the parent page and current page title
#		
#		Examples:
#		|Name|value|
#		|https://www.facebook.com|nba|
#		|https://www.instagram.com|football|
#		|https://www.flipkart.com|cricket|
#		|https://www.amazon.com|baseball|