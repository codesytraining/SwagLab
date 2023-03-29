package Codesy.in.SwagLabs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testCaseClasses.BaseTest;

public class SwagListeners extends BaseTest implements ITestListener{
	
	ExtentReportsObjectGenerator obj = new ExtentReportsObjectGenerator();
	ExtentReports extent = obj.getExtentReportsObj();
	ThreadLocal<ExtentTest> threadObj = new ThreadLocal<ExtentTest>();
	ExtentTest test;
	
	//It will get executed on start of every test case
	public void onTestStart(ITestResult result) {
	    test = extent.createTest(result.getMethod().getMethodName());
	    threadObj.set(test);
	    
	    //test case unique thread id 1-> test obj 1
	  //test case unique thread id 2-> test obj 2
	 }
	
	//It will get executed if any test case get Pass
	public void onTestSuccess(ITestResult result) {
		threadObj.get().log(Status.PASS, "Test Case is Passed!!");
	  }
	
	//It will be executed if any test case gets Fail
	public void onTestFailure(ITestResult result) {
		
		threadObj.get().fail(result.getThrowable());
		
		//Screenshot
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		//Call method to take screenshot
		String screenshotPath = null;
		try {
			screenshotPath = takeScreenshot(driver,result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadObj.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
		
		
	  }
	
	//It will get executed on end of execution
	public void onFinish(ITestContext context) {
		extent.flush();
	  }

}
