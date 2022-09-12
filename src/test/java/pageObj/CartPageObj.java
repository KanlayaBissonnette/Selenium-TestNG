package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonMethods;

import Utilities.Driver;

public class CartPageObj extends CommonMethods {

	public CartPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='siteWrap']/div/nav/ul/li[1]/p")
	public WebElement cartText;

	@FindBy(xpath = "//*[@class='cart_stockNum']")
	public WebElement CartQty;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div[3]/div[3]/a[2]")
	public WebElement checkoutBtn;

	@FindBy(xpath = "//*[@id='siteWrap']/header/div/a/img")
	public WebElement gearBestBtnToHome;

	public void clickCheckoutBtn() {
		wait(2);
		click(checkoutBtn);
	}

	

}
