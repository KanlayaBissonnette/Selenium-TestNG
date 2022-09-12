package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;


public class SearchFunctionalityTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void searchWithKeyword() {
		hp.supDSearchBox();
		hp.supDSearchBtn();
		hp.verifySmartwatchText();
		hp.backHomepage();
	}

	@Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void searchByCategoriesWithMisspellingKeyword() {
		hp.enterKnite();
		hp.supDSubmitBtn();
		hp.verifySorryText();
		hp.clickKnife();
		hp.verifyKnifeText();
		hp.backHomepage();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
