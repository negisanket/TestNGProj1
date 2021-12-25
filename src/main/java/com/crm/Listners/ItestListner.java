package com.crm.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ItestListner implements ITestListener{


	
	public void onTestStart(ITestResult result) {
		System.out.println("MYTest case started"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("MYTest case Success"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("MYTest case FAILLEEEDD==========================="+result.getName());
	
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Suite started"+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
