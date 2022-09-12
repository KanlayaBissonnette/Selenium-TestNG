package pageObj;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.Driver;

public class CheckOutPageObj extends CommonMethods {

	public CheckOutPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div/div[2]/div[2]/div[2]/a")
	public WebElement placeOrderBtn;

	@FindBy(xpath = "//*[@class='order_itemCon']")
	private WebElement verifyProductOnCart;

	@FindBy(xpath = "//*[text()='Cart']")
	private WebElement cartTxt;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/a")
	private WebElement verifyProduct;

	public void verifyOnCart() {
		wait(3);
		Assert.assertTrue(cartTxt.getText().equals("Cart"));
		
		
		
	
	}
}
