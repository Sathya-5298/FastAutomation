package com.parctise.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UsingExistingChromeSessionWithWebDriver 
{

	public static void main(String[] args) 
	{
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "192.168.1.13:9222");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.youtube.com/");
		driver.get("https://www.gmail.com/");
		driver.get("https://www.google.com/");
		
		System.out.println("Completed===");
		
		driver.quit();
		
	}

}
