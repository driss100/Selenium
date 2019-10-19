package com.eyes.applitools.VisualAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;



public class AppTest {
	WebDriver driver;
	Eyes eyes;
	
	@Test
	
	public void LogginValidCredentials() {

	       // Open a Chrome browser.
		   System.setProperty("webdriver.chrome.driver","C:/Users/Driss/Desktop/SeleniumJavaFramework1-master/SeleniumJavaFramework/drivers/chromedriver/chromedriver.exe");
	       WebDriver browser = new ChromeDriver();

	       // Initialize the eyes SDK and set your private API key.
	       eyes = new Eyes();
	       
	       eyes.setApiKey("IqE1003onf0aePwBPEg85wrQIJA5R4ZMWiWEtaNYBP6v4110");

	       //try{

	           // Start the test and set the browser's viewport size to 800x600.
	           driver=eyes.open(browser, "the-internet", "Visual Automated test",
	                   new RectangleSize(800, 600));

	           // Navigate the browser to the "hello world!" web-site.
	           driver.navigate().to("http://the-internet.herokuapp.com/login");

	           // Visual checkpoint #1.
	           eyes.checkWindow("Login form");

	           // Click the "Click me!" button.
	           driver.findElement(By.name("username")).sendKeys("tomsmith");
	           driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	           // Visual checkpoint #2.
	           driver.findElement(By.cssSelector("button")).click();
	          JavascriptExecutor js = (JavascriptExecutor)driver;
	           js.executeScript("$('#flash').removeClass('success').addClass('error');");
	           eyes.checkWindow("Logged in");

	           // End the test.
	           eyes.close();
	           
	      // } finally {
	    	   
	           // Close the browser.
	           browser.quit();

	           // If the test was aborted before eyes.close was called, ends the test as aborted.
	         //  eyes.abortIfNotClosed();
	       }

	   }

//}

   