package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;


public class LoginTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC001_signinValidEmailValidPassword() {
		hp.hoverSigninTab();
		sr.clickSigninBtn();
		sr.signinValidEmailSendKey();
		sr.signinValidPasswordSendKey();
		sr.clickUserSigninBtn();
		sr.hoverUserAccountDisplayed();
		hp.verifySignoutBtn();
		hp.clicklogoutBtn();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC002_signinInvalidEmailValidPassword() {
		hp.hoverSigninTab();
		sr.clickSigninBtn();
		sr.signinInvalidEmailSendKey();
		sr.signinValidPasswordSendKey();
		sr.clickUserSigninBtn();
		sr.verifySigninHeaderText();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC003_signinInvalidEmailInvalidPassword() {
		hp.hoverSigninTab();
		sr.clickSigninBtn();
		sr.signinInvalidEmailSendKey();
		sr.signinInvalidPasswordSendKey();
		sr.clickUserSigninBtn();
		sr.verifySigninHeaderText();
		
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
