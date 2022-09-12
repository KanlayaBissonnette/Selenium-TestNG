package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.Driver;

public class ContactUsPageObj extends CommonMethods {

	public ContactUsPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/a/img")
	private WebElement imgMenu;

	public void verifyIsDisplayed() {
		Assert.assertTrue(imgMenu.isDisplayed());
	}

	public void clickObj() {
		imgMenu.click();
	}

}
