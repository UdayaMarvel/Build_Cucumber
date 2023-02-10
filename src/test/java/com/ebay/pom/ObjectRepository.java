package com.ebay.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ebay.commonaction.BaseClass;

public class ObjectRepository extends BaseClass {

	BaseClass b = new BaseClass();
	
	public ObjectRepository() {
		PageFactory.initElements(b.w, this);
	}	
	@FindBy(xpath="//input[@type='text']")
	private WebElement search;
	
	public WebElement getSearch() {
		return search;
	}
	@FindBy(xpath="//h3[contains(text(),'FASTWAVE SAFETY SYSTEM')]")
	private WebElement scroll;
	
	@FindBy(xpath="//span[text()='Buy It Now']")
	private WebElement buynow;
	
	public WebElement getScroll() {
		return scroll;
	}

	public WebElement getBuynow() {
		return buynow;
	}
	@FindBy(xpath="(//h3[contains(text(),'Chevrolet Cruze')])[1]")
	private WebElement cruze;
	
	public WebElement getCruze() {
		return cruze;
	}
	
	@FindBys({@FindBy(id=""),
			  @FindBy(className = "")})
	private WebElement e;
	
	@FindAll({@FindBy(xpath=""),@FindBy(className = "")})
	private WebElement x;
}
	