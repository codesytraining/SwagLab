package Codesy.in.SwagLabs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsObjectGenerator {
	
	public ExtentReports getExtentReportsObj() {
		//1. ExtentSparkReporter -> Create HTML Document, Configure our report
		
		String reportPath = System.getProperty("user.dir") + "//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("20 March Results");
		reporter.config().setReportName("Automation Test Report");
		
		//2. ExtentReports -> This is main class. We have to link ExtentSparkReporter with ExtentReports object
		//It will help to generate reports
		ExtentReports extent = new ExtentReports();		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rohit Patil");
		
		return extent;
		
	}

}
