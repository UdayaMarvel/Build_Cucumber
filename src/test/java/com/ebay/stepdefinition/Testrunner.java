package com.ebay.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src\\test\\resources\\productpurchase.feature",
					glue = {"com.ebay.stepdefinition"},
					dryRun = false,
					monochrome = true,
					plugin = {"html:target","json:target/reports.json"})
public class Testrunner {

}
