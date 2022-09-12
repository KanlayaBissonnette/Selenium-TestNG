package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;


public class FooterHeaderTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC001_Footer_Navigate_To_Contact_Us() {
		sr.signin();
		hp.clickContactUs();
		contact.verifyIsDisplayed();
		tearDown();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC002_Footer_Live_Chat() {
		sr.signin();
		hp.headerDisplay();
		hp.clickContactUs();
		contact.verifyIsDisplayed();
		contact.clickObj();
		support.selectOrder();
		support.selectCancelOrder();
		support.selectWorngOrder();
		support.selectLiveChat();
		support.sendText();
		support.clickLogo();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC003_Footer_Check_My_Points() {
		sr.signin();
		hp.headerDisplay();
		hp.hoverAccTab();
		hp.selectMyPoint();
		point.pointVerify();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC004_Footer_Testimonials() {
		hp.clickTestimonialTab();
		test.verifyTestimonial();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC005_Footer_FAQ() {
		hp.clickFAQTab();
		faq.verifyQASection();
		faq.clickPayment();
		faq.clickWhatPayPal();
	}

	@AfterMethod
	public void destroy() {
		tearDown();
	}
}
