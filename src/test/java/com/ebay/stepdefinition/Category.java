package com.ebay.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ebay.commonaction.BaseClass;
import com.ebay.pom.ObjectRepository;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Category extends BaseClass{
	ObjectRepository or = new ObjectRepository();
	BaseClass b = new BaseClass();
public static WebElement  category;
public static WebElement  gps;
public static  String text;
public static HttpURLConnection http;
//	public void launch_the_browser() {
//	    WebDriverManager.edgedriver().setup();
//	    w = new EdgeDriver();
//	}
//
//	@When("pass the url")
//	public void pass_the_url() {
//	    w.get("https://www.ebay.com/");]
//	}

@Then("Search in search bar")
public void search_in_search_bar() throws InterruptedException {
	 b.text(or.getSearch(), "puma");
	 b.hold(ExpectedConditions.elementToBeClickable(or.getSearch()));
//	 try {
//		 b.scriptExe(or.getScroll());	 
//		 b.touch(or.getScroll());
//	 }catch(Exception e ) {
//		 b.scriptExe(or.getCruze());
//		 b.touch(or.getCruze());
//	 }
//	 
//	
//	 b.switchWindow();
//
//	 b.touch(or.getBuynow());
}

@Then("Search in search bar {string}")
public void search_in_search_bar(String string) throws InterruptedException {
	WebElement search = w.findElement(By.xpath("//input[@type='text']"));
	 search.sendKeys(string);	
	 Thread.sleep(2000);
  
}
@Then("Search in search bar with onedim map")
public void search_in_search_bar_with_onedim_map(DataTable dataTable) {
   Map<Integer, String> asmap = dataTable.asMap(Integer.class, String.class);
   Set<Entry<Integer,String>> entrySet = asmap.entrySet();
   for(Entry<Integer,String> a :entrySet) {
   String string = asmap.get(1);
   System.out.println(a.getValue());
   WebElement search = w.findElement(By.xpath("//input[@type='text']"));
   }
}

@Then("Search in search bar with onedim list")
public void search_in_search_bar_with_onedim_list(DataTable dataTable) throws InterruptedException {
	List<String> aslist = dataTable.asList();
	WebElement search = w.findElement(By.xpath("//input[@type='text']"));
	
	for (int i = 0; i < aslist.size(); i++) {
		Thread.sleep(2000);
		String stri = aslist.get(i);
		System.out.println(stri);
		search.sendKeys(stri);
		Thread.sleep(1000);
		search.clear();
	}

	
}


@Given("locate the shop by category")
public void locate_the_shop_by_category() throws IOException {
  

	File f1 = new File(".\\src\\test\\resources\\credentials.property");
	FileInputStream f = new FileInputStream(f1);
	Properties p = new Properties();
	p.load(f);
	System.out.println(p.getProperty("mobile"));
	
	String setProperty = (String) p.setProperty("username", "newname");
	FileOutputStream f2 = new FileOutputStream(f1);
	
	p.store(f2, setProperty);
		   
		text = w.getTitle();
//	   category = w.findElement(By.xpath("//button[text()='Shop by category']"));
	   
	}

	private Writer FileWriter(File f1) {
	// TODO Auto-generated method stub
	return null;
}

	@When("click the category")
	public void click_the_category() {
	    category.click();
	}

	@Then("validate the category is clicked")
	public void validate_the_category_is_clicked() throws InterruptedException {
		
	   gps = w.findElement(By.xpath("//a[text()='GPS & Security Devices']"));
	 String text = gps.getText();  
	 Assert.assertEquals(text, "GPS & Security Devices");
	}
	@Then("Click on Gps and security devices")
	public void click_on_Gps_and_security_devices() throws InterruptedException {
		Thread.sleep(6000);
	    gps.click();
	}

	@Then("validate the parent page and current page title")
	public void validate_the_parent_page_and_current_page_title() throws ClassNotFoundException, SQLException {
	  String title = w.getTitle();
//	  Assert.assertEquals(title, text);
	  Class.forName("database");
	  Connection connection = DriverManager.getConnection("database//localhost:9090","username","password");
	  Statement createStatement = connection.createStatement();
	  ResultSet executeQuery = createStatement.executeQuery("select * from table");
	  while (executeQuery.next()) {
		  System.out.println(executeQuery.getInt(0));
	}
	  }
	
}
