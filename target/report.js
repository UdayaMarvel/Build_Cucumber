$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\productpurchase.feature");
formatter.feature({
  "name": "Purchase in Ebay",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Shop By category",
  "description": "",
  "keyword": "Scenario"
});
formatter.embedding("image/png", "embedded0.png");
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "locate the shop by category",
  "keyword": "Given "
});
formatter.match({
  "location": "Category.locate_the_shop_by_category()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click the category",
  "keyword": "When "
});
formatter.match({
  "location": "Category.click_the_category()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"org.openqa.selenium.WebElement.click()\" because \"com.ebay.stepdefinition.Category.category\" is null\r\n\tat com.ebay.stepdefinition.Category.click_the_category(Category.java:141)\r\n\tat ✽.click the category(src\\test\\resources\\productpurchase.feature:5)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "validate the category is clicked",
  "keyword": "Then "
});
formatter.match({
  "location": "Category.validate_the_category_is_clicked()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click on Gps and security devices",
  "keyword": "And "
});
formatter.match({
  "location": "Category.click_on_Gps_and_security_devices()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Search in search bar",
  "keyword": "Then "
});
formatter.match({
  "location": "Category.search_in_search_bar()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "validate the parent page and current page title",
  "keyword": "Then "
});
formatter.match({
  "location": "Category.validate_the_parent_page_and_current_page_title()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded1.png");
formatter.after({
  "status": "passed"
});
});