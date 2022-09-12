package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class PaymentPageObj extends CommonMethods {

	public PaymentPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//h1[@class='h1']")
	public WebElement paymentTxt;

	public void verifyPaymentMtdTxt() {
		// System.out.println(paymentTxt.getText());
		verifyHeader(paymentTxt, ConfigReader.getProperties("paymentTxt"));
	}

}
