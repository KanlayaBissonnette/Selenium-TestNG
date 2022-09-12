package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonMethods;
import Utilities.Driver;

public class ReviewPageObj extends CommonMethods {

	public ReviewPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//th[@class='td3']")
	public WebElement reviewTxt;

}
