package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;

public class HomepageFunctionalityTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void HomePage_TC001_VerifySliderAndNavBar() {
		hp.verifyNavBar();
		hp.verifyFiveSliders();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void HomePage_TC002_HomePageFunctionality() {
		hp.clickArrowUpIcon();
		hp.clickFacebookIcon();
		fb.verifyFBPage();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void HomePage_TC003_ProductDetail() {
		hp.clickHeadPhone();
		hPhone.clickReviewAndVerify();
		hPhone.clickDescriptionTabAndVerify();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void HomePage_TC004_AddItemFunctionality() throws InterruptedException {
		click(hp.gearbestLogo);
		hPhone.addQtyAndVerifyErrorMsg();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void HomePage_TC005_CheckOutFunctionality() {
		hPhone.addToCartAndCheckout();
	}

	@AfterMethod
	public void destroy() {
		tearDown();
	}
}
