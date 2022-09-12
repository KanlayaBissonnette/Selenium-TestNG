package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class NewArrivalsPageObj extends CommonMethods {

	public NewArrivalsPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//p[@class='newArrivalTitle']/i")
	public WebElement newArrTxt;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div[2]/p[1]/a")
	public WebElement allNewArrTxt;

	public void verifyNewArrivalsPage() {
		verifyHeader(allNewArrTxt, ConfigReader.getProperties("newArrTxt"));
		navBack();
	}

}
