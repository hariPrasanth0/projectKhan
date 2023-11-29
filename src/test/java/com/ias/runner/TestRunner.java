package com.ias.runner;

import com.ias.Base;

public class TestRunner extends Base{
	 public void beforeClass(String s1) {
	        launchBrowser("chrome");
	    }
	 public static void main(String[] args) {
		 launchBrowser("chrome");
		 getUrl("https://www.google.com/");
	}
	   
}
