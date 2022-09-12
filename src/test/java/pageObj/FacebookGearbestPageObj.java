package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class FacebookGearbestPageObj extends CommonMethods {

	public FacebookGearbestPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='bi6gxh9e aov4n071']/span/h1")
	public WebElement FBtxt;

	public void verifyFBPage() {
		verifyHeader(FBtxt, ConfigReader.getProperties("FBtxt"));
		Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperties("gearbestFB")));
		navBack();
	}

}
