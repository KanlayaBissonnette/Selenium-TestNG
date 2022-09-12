package pageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class FAQPageObj extends CommonMethods {

	public FAQPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/ul/li")
	private List<WebElement> menuOption;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/section[1]")
	private WebElement qaSec;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/section[2]")
	private WebElement paymentQA;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/section[1]/div")
	private List<WebElement> qa;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/section[2]/div")
	private List<WebElement> paymentqa;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]//section[2]/div[3]/h3")
	private WebElement payPalTab;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/section[2]/div[3]/div")
	private WebElement payPalDescBox;

	public void clickPayment() {
		selectObj(menuOption, ConfigReader.getProperties("payment"));
		veriPaymentSec();
	}

	public void verifyQASection() {
		getTextFromList(qa);
		Assert.assertTrue(qaSec.isDisplayed());
	}

	public void veriPaymentSec() {
		getTextFromList(paymentqa);
		Assert.assertTrue(paymentQA.isDisplayed());
	}

	public void clickWhatPayPal() {
		payPalTab.click();
		verifyPayPalBox();
	}

	public void verifyPayPalBox() {
		Assert.assertTrue(payPalDescBox.isDisplayed());
		System.out.println(payPalDescBox.getText());
	}

}
