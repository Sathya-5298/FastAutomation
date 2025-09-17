package com.assign.fastautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

	public static void main(String[] args) 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://fast.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		By speedValueLocator = By.id("speed-value");
		By speedUnitLocator = By.id("speed-units");
		
		String classAttributeName;

		while(true)
		{

			WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
			WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));

			System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());
			
			classAttributeName = speedValueElement.getAttribute("class");
			
			if(classAttributeName != null && classAttributeName.contains("succeeded"))
			{
				break;
			}
		}
		
		WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
		WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));
		

		System.out.println("Your Final Internet Speed is - " + speedValueElement.getText() + " " + speedUnitElement.getText());
		
		if(speedUnitElement.isDisplayed())
		{
			driver.quit();
		}
		
	}
}
