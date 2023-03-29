package Codesy.in.SwagLabs;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReExecute implements IRetryAnalyzer {
	
	int count = 0;
	int maxRetry = 1;
	
	public boolean retry(ITestResult result) {
		
		if(count < maxRetry) {
			count ++;
			return true; //Re-execute Failed test case
		}
		
		return false;  //Do not re-execute
	}

}
