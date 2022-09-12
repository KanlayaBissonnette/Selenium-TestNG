package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class SignInRegisterPageObj extends CommonMethods {

	public SignInRegisterPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='email']")
	public WebElement registerEmailField;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement createPasswordField;

	@FindBy(xpath = "//*[@id='password2']")
	public WebElement retypePasswordField;

	@FindBy(xpath = "//*[@id='js-captchaBox']")
	public WebElement registerCodeField;

	@FindBy(xpath = "//*[@id='js-verify']")
	public WebElement captcha;

	@FindBy(xpath = "//*[@id='js-regAgree']")
	public WebElement agreeCheckBox;

	@FindBy(xpath = "//*[@id='js-btnSubmit']")
	public WebElement userRegisterBtn;

	@FindBy(xpath = "//*[@id='email']")
	public WebElement signinEmailField;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement signinPasswordField;

	@FindBy(xpath = "//*[@id='js-btnSubmit']")
	public WebElement userSigninBtn;

	@FindBy(xpath = "//*[@id='siteWrap']/div[2]/div/ul/li[1]/a")
	public WebElement signinText;

	@FindBy(xpath = "//*[@id='siteWrap']/div[2]/div/ul/li[2]/a")
	public WebElement registerText;

	@FindBy(xpath = "//*[@id='siteWrap']/h2")
	public WebElement successfullRegisterText;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/span[1]")
	public WebElement userDisplayed;

	@FindBy(xpath = "//*[@class = 'headUser_entriesLink headUser_name js-labelUserName']")
	public WebElement userNameDisplayed;

	public void hoverSigninBtn() {
		hp.hoverSigninTab();
	}

	public void clickSigninBtn() {
		hp.signInBtn.click();
	}

	public void clickRegisterBtn() {
		hp.registerBtn.click();
	}

	// added it back by Nui
	// June 18, 2022
	public void signin() {
		hp.hoverSigninTab();
		hp.signInBtn.click();
		signinEmailField.click();
		signinEmailField.clear();
		signinEmailField.sendKeys(ConfigReader.getProperties("signinEmail"));
		CommonMethods.wait(2);
		signinPasswordField.click();
		signinPasswordField.clear();
		signinPasswordField.sendKeys(ConfigReader.getProperties("signinPassword"));
		CommonMethods.wait(2);
		userSigninBtn.click();

	}

	public void hoverUserAccountDisplayed() {
		hover(userDisplayed);
		System.out.println("User name: " + userNameDisplayed.getText());
	}

	// positive register
	public void registerValidEmailSendKey() {
		registerEmailField.click();
		registerEmailField.clear();
		registerEmailField.sendKeys(ConfigReader.getProperties("registerEmail"));
	}

	public void registerValidPasswordSendKey() {
		createPasswordField.click();
		createPasswordField.clear();
		createPasswordField.sendKeys(ConfigReader.getProperties("registerPassword"));
	}

	public void retypePasswordSendKey() {
		retypePasswordField.click();
		retypePasswordField.clear();
		retypePasswordField.sendKeys(ConfigReader.getProperties("registerPassword"));
	}

//	public void captchaSendKey() {
//		String captchaCode = captcha.getText();
//		registerCodeField.click();
//		registerCodeField.clear();
//		registerCodeField.sendKeys(captchaCode);
//	}
//		Usually, QA cannot test Captcha, QA will have to ask developer to disable captcha	
	public void clickAgreeCheckbox() {
		agreeCheckBox.click();
	}

	public void clickUserRegisterBtn() {
		userRegisterBtn.click();
	}

//		String registerSuccessTxt = successfullRegisterText.getText();
//		System.out.println(registerSuccessTxt);
//		CommonMethods.verifyHeader(successfullRegisterText, "registered successfully!");

	// negative register
	public void registerRegisteredEmailSendKey() {
		registerEmailField.click();
		registerEmailField.clear();
		registerEmailField.sendKeys(ConfigReader.getProperties("registerEmail"));
	}

	public void registerInvalidPasswordSendKey() {
		createPasswordField.click();
		createPasswordField.clear();
		createPasswordField.sendKeys(ConfigReader.getProperties("registerInvalidPassword"));
	}

	public void retypeInvalidPasswordSendKey() {
		retypePasswordField.click();
		retypePasswordField.clear();
		retypePasswordField.sendKeys(ConfigReader.getProperties("registerInvalidPassword"));
	}

//		String captchaCode = captcha.getText();
//		registerCodeField.click();
//		registerCodeField.clear();
//		registerCodeField.sendKeys(captchaCode);

	public void verifyRegisterHeaderText() {
		String registerTxt = registerText.getText();
		System.out.println(registerTxt);
		verifyHeader(registerText, "REGISTER");
	}

	// ------------------------Sign in-----------------------------------

	// positive sign in
	public void signinValidEmailSendKey() {
		signinEmailField.click();
		signinEmailField.clear();
		signinEmailField.sendKeys(ConfigReader.getProperties("signinEmail"));
	}

	public void signinValidPasswordSendKey() {
		signinPasswordField.click();
		signinPasswordField.clear();
		signinPasswordField.sendKeys(ConfigReader.getProperties("signinPassword"));
	}

	public void clickUserSigninBtn() {
		userSigninBtn.click();
		dismissAlert();
	}

	public void checkoutSignin() {
		signinEmailField.click();
		signinEmailField.clear();
		signinEmailField.sendKeys(ConfigReader.getProperties("signinEmail"));
		CommonMethods.wait(2);
		signinPasswordField.click();
		signinPasswordField.clear();
		signinPasswordField.sendKeys(ConfigReader.getProperties("signinPassword"));
		CommonMethods.wait(2);
		userSigninBtn.click();

	}

	// negative sign in
	public void signinInvalidEmailSendKey() {
		signinEmailField.click();
		signinEmailField.clear();
		signinEmailField.sendKeys(ConfigReader.getProperties("invalidSignInEmail"));
	}
	public void signInValidPasswordSendKey() {
		signinPasswordField.click();
		signinPasswordField.clear();
		signinPasswordField.sendKeys(ConfigReader.getProperties("signinPassword"));
	}
	
	public void clickSignInBtn() {
		userSigninBtn.click();
	}
	
	public void verifySigninHeaderText() {
		String signinTxt = signinText.getText();
		System.out.println(signinTxt);
		verifyHeader(signinText, "SIGN IN");

	}

	// negative sign in
	public void signinInvalidPasswordSendKey() {
		signinPasswordField.click();
		signinPasswordField.clear();
		signinPasswordField.sendKeys(ConfigReader.getProperties("invalidSignInPassword"));
	}
}

