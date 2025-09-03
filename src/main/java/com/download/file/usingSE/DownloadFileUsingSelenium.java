package com.download.file.usingSE;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileUsingSelenium {

	public static void main(String[] args) throws InterruptedException 
	{
		String downloadPath = System.getProperty("user.dir") + File.separator + "DownlaodTest";
		
		File downloadFile = new File(downloadPath);
		
		if(!downloadFile.exists())
		{
			System.out.println("Folder is not Present!!");
			if(downloadFile.mkdir())
			{
				System.out.println("Folder is created!!");
			}
		}
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_downlaod", false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://get.jenkins.io/war-stable/2.516.2/jenkins.war");
		
		// Check the file is downloaded Successfully or not
		
		File warFile = new File(downloadFile,"jenkins.war");
		
		int timeOutSeconds = 52;
		int elapsedTime = 0;
		
		while(elapsedTime < timeOutSeconds && !warFile.exists())
		{
			Thread.sleep(2500);
			elapsedTime++;
			System.out.println("Waiting for file to Download!!");
		}
		
		if(warFile.exists())
		{
			System.out.println("File downloaded Successfully!!");
		}
		else
		{
			System.err.println("File is not downloaded!! Timeout Error!!");
		}
	}
}
