package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.Driver;

public class PointPageObj extends CommonMethods {

	public PointPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='ucenter_content']/div/div[3]/div")
	private WebElement pointBox;

	public void pointVerify() {
		System.out.println(pointBox.getText());
		Assert.assertTrue(pointBox.isDisplayed());
	}
}
