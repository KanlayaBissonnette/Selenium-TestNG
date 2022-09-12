package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	int retry = 4;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retry) {
			counter++;
			return true;
		}
		CommonMethods.takeScreenshot("FAILED");
		return false;

	}
}
