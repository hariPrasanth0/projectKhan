package com.ias.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

public class OutlookUtil extends ExecutionReport{

	public static void main(String[] args) {
			 try {
				 launchBrowser("chrome");
				 getUrl("https://outlook.office.com/mail/");
				 captureScreenShot(driver, Screenshotnames[array_increment++]="SS1");
				 type(webElement("//*[@id=\"i0116\"]"), "1000050171@hexaware.com");
				 captureScreenShot(driver, Screenshotnames[array_increment++]="SS2");
				 btnClick(webElement("//*[@id=\"idSIButton9\"]"));
				 waitUntillPresent(webElement("//*[@id=\"loginMessage\"]"));
				 type(webElement("//*[@id=\"passwordInput\"]"), "Likup&987");
				 captureScreenShot(driver, Screenshotnames[array_increment++]="SS3");
				 btnClick(webElement("//*[@id=\"submitButton\"]"));
				 waitUntillPresent(webElement("//*[text()=\"Stay signed in?\"]"));
				 captureScreenShot(driver, Screenshotnames[array_increment++]="SS4");
				 btnClick(webElement("//*[@id=\"idBtn_Back\"]"));
				 waitUntillPresent(webElement("//*[@id=\"O365_AppName\"]/span"));
				 Thread.sleep(5000);
				 driver.findElement(By.xpath("//*[text()=\"New mail\"]")).click();
				 waitUntillPresent(webElement("(//*[@role=\"textbox\"])[1]"));
				 type(webElement("(//*[@role=\"textbox\"])[1]"), "1000050171@hexaware.com");
				 type(webElement("//*[@placeholder=\"Add a subject\"]"), "Execution report");
				 btnClick(webElement("(//*[@role=\"textbox\"])[3]"));
				 type(webElement("(//*[@role=\"textbox\"])[3]"), "Testing: Please find attached document."," Thanks & Regards, Hari Prasanth.");
				 captureScreenShot(driver, Screenshotnames[array_increment++]="SS5");
				 btnClick(webElement("//*[@aria-label=\"Attach file\"]"));
				 btnClick(webElement("//*[text()=\"Browse this computer\"]"));
				 captureScreenShot(driver, Screenshotnames[array_increment++]="SS6");
				 Thread.sleep(5000);
				 saveScreenshotToWord("doc1",Screenshotnames);
				 StringSelection selection = new StringSelection(fileLocation);
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
				 Robot rob = new Robot();
				 rob.keyPress(KeyEvent.VK_CONTROL);
				 rob.keyPress(KeyEvent.VK_V);
				 rob.keyRelease(KeyEvent.VK_V);
				 rob.keyRelease(KeyEvent.VK_CONTROL);
				 Thread.sleep(5000);
				 rob.keyPress(KeyEvent.VK_ENTER);
				 rob.keyRelease(KeyEvent.VK_ENTER);
				 Thread.sleep(10000);
				 btnClick(webElement("//*[text()=\"Send\"]"));
			 }catch (Exception e) {
				 System.out.println("Failed.");
				 String message = e.getMessage();
				 System.out.println(message);
			}
		
	}

}
