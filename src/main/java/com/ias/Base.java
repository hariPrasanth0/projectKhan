package com.ias;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base {

	public static WebDriver driver;
	    
	    public static WebDriver launchBrowser(String browser) {
	        if(browser.equals("chrome")) {
	        System.setProperty("webdriver.chrome.driver","D:\\Eclipse 2022\\WorkSpace\\IASOFFER\\src\\test\\resources\\Driver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        }
	        else if(browser.equals("ie")) {
	            System.setProperty("webdriver.ie.driver","C:\\Users\\50066\\Driver\\chromedriver.exe");
	            driver = new InternetExplorerDriver();
	        }
	        else if(browser.equals("firefox")) {
	            System.setProperty("webdriver.gecko.driver","C:\\Users\\50066\\Driver\\chromedriver.exe");
	            driver = new FirefoxDriver();
	        }
	            
	            
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	        return driver;
	    }
	    public static void getUrl(String url) {
	        driver.get(url);
	    }
	    public static void btnClick(WebElement w) {
	        w.click();
	    }
	    public static void type(WebElement w,String s) {
	        w.sendKeys(s);
	    }
	    public static void type(WebElement w,String s,String s2) {
	        w.sendKeys(s +Keys.ENTER+s2);
	    }
	    public static WebElement webElement(String xpath) {
	        WebElement element = driver.findElement(By.xpath(xpath));
	        return element;
	    }
	    
	    public static void quitBrowser() {
	        driver.quit();
	    } 
	    public static void mouseHover(WebElement w) {
	        Actions a = new Actions(driver);
	        a.moveToElement(w).perform();
	    }
	    public static void clear(WebElement w) {
	        w.clear();
	    }
	    public static void waitUntillPresent(WebElement w) {
	    	
	    }
	    public static void selectByValue(WebElement w, String s1) {
	       Select drpdwn = new Select(w);
	       drpdwn.selectByValue(s1);
	    }
	    public static void selectByText(WebElement w, String s1) {
		       Select drpdwn = new Select(w);
		       drpdwn.selectByVisibleText(s1);
		    }
	
}
