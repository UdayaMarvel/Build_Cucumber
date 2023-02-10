package com.ebay.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ebay.commonaction.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks  {

	BaseClass b = new BaseClass();
	@Before
	public void launch(Scenario scenario) throws IOException {
		 b.browserLaunch();
//			File f1 = ;
			FileInputStream f = new FileInputStream(new File(".\\src\\test\\resources\\credentials.property"));
			Properties p = new Properties();
			p.load(f);
			String url = p.getProperty("url");
			String usenam = p.getProperty("username");
			System.out.println(usenam);
			String password = p.getProperty("password");
			System.out.println(password);
			 b.w.get(url);
			final byte[] ss=((TakesScreenshot)b.w).getScreenshotAs(OutputType.BYTES);
			scenario.embed(ss, "image/png");
	}

	@After
	public void exit(Scenario scenario) {
		final byte[] ss=((TakesScreenshot)b.w).getScreenshotAs(OutputType.BYTES);
		scenario.embed(ss, "image/png");
//		b.browserClose();
	}
	
}
