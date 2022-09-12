package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;

public class RegisterTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC001registerValidEmailValidPassword() {
		hp.hoverSigninTab();
		sr.clickRegisterBtn();
		sr.registerValidEmailSendKey();
		sr.registerValidPasswordSendKey();
		sr.retypePasswordSendKey();
		sr.clickAgreeCheckbox();
		sr.clickUserRegisterBtn();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC002registerWithRegisteredEmail() {
		hp.hoverSigninTab();
		sr.clickRegisterBtn();
		sr.registerRegisteredEmailSendKey();
		sr.registerValidPasswordSendKey();
		sr.retypeInvalidPasswordSendKey();
		sr.clickAgreeCheckbox();
		sr.clickUserRegisterBtn();
		sr.verifyRegisterHeaderText();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
