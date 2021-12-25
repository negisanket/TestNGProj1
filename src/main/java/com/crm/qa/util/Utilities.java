package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	
	public static String takeScreenshot(WebDriver driver) 
	{
		
		String Scrpath = "C:\\Selenium\\screenshots\\"+getCurrentDateTime()+".png";
			try
			{
		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(Scrpath));
		
		System.out.println("\t\t*********Screenshot*****************");
			}
	
		catch(IOException e)
			{
		System.out.println("***********Screenshot capture Exception************"+e.getMessage());
			}
			return Scrpath;
	}
	
	
	
	
	static public String getCurrentDateTime() {
		
		//SimpleDateFormat myformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		//Date currentdate = new Date();
		//return myformat.format(currentdate);
		
		return new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());
	}
	
	
	
	
	
}
