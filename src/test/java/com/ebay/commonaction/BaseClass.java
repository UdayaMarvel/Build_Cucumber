package com.ebay.commonaction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver w;
	public static Alert alert;
	public static Actions a;
	public static JavascriptExecutor js;
	public static File target;
	public void browserLaunch() {
		ChromeOptions option = new ChromeOptions();
		 WebDriverManager.chromedriver().setup();
		 option.addArguments("--start-maximized");
		 option.addArguments("disable-pop-up");
		 option.addArguments("--headless");
		    w = new ChromeDriver(option);	
		    
	}
	public void browserClose() {
	w.quit();	
	}
	
	
	public void frame(WebElement ele) {
		w.switchTo().frame(ele);
	}
	
	public void pop_up() {
		alert = w.switchTo().alert();
	}
	public void popupText(String string) {
		alert.sendKeys(string);
	}
	
	public void switchWindow() {
		String parenturl = w.getWindowHandle();
		Set<String> child = w.getWindowHandles();
		for(String x : child) {
			if(!x.equals(parenturl)) {
				w.switchTo().window(x);
			}
		}
	}
	
	public void hold(ExpectedCondition<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(w, 20);
		wait.until(ele);
	}
	
	public void dropdown(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> options = s.getOptions();
	}
	
	public void mouseOver(WebElement ele) {
		a = new Actions(w);
		a.moveToElement(ele).build().perform();
	}
	public void mouseOver(WebElement ele, int x, int y) {
		a.moveToElement(ele,x,y).build().perform();
	}
	
	public void text(String value) {
		a.sendKeys(value).build().perform();
	}
	public void text(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	public void touch(WebElement ele) {
		ele.click();
	}
	public void keyboard1() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
	}
	
	public void scriptExe(WebElement ele) {
		js = (JavascriptExecutor) w;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}
	
	public void snap() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)w;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\target\\report.png");
		FileUtils.copyFile(source, target);
	}	
	
}
