package pageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;



public class ApplianceFirstItemPageObj extends CommonMethods {
	
	public ApplianceFirstItemPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (xpath ="//*[@id='siteWrap']/div[1]/div[1]/div/div[2]/ul/li[1]/a/img")
	public WebElement firstApplianceItem;
	
	@FindBy (xpath = "//*[@id='siteWrap']/div[1]/div[1]/div/div[2]/ul/li[1]/div/p[1]/a")
	public WebElement NameOffirstApplianceItem;
	
	@FindBy (xpath = "//*[@id='goodsDetail']/div[2]/div[1]/div[2]/div[1]/div/h1")
	public WebElement titleOffirstApplianceItem;
	
	@FindBy (xpath= "//*[@id='goodsDetail']/div[2]/div[1]/div[2]/div[5]/a[1]")
	public WebElement addToCartButton;
	
	@FindBy (xpath= "//*[@id='js-labelHeadCart']/a")
	public WebElement cartButton;
	
	@FindBy (xpath= "//*[@id='js-goodsIntroQTY']/span[3]")
	public WebElement plusButton;
	
	@FindBy (xpath= "//*[@id='js-goodsIntroQTY']/span[2]/input")
	public WebElement Qty;
	
	public void selectAppliance() {
		String product = NameOffirstApplianceItem.getText();
		click(firstApplianceItem);
		Assert.assertTrue(product.equals(titleOffirstApplianceItem.getText()));
	}
	
	public void AddToCart() {
		click(firstApplianceItem);
		click(addToCartButton);
		click(cartButton);
		Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
		Assert.assertTrue(cart.cartText.getText().equals("Cart"));
		cart.clickCheckoutBtn();
	}
	
	public void checkoutFunction() {
		click(firstApplianceItem);
		click(addToCartButton);
		click(cartButton);
		click(cart.checkoutBtn);
		wait(3);
		sr.signinEmailField.sendKeys(ConfigReader.getProperties("signinEmail"));
		sr.signinPasswordField.sendKeys(ConfigReader.getProperties("signinPassword"));
		wait(3);
		sr.userSigninBtn.click();
	}
	
	public void addMoreItem() {
		click(firstApplianceItem);
		click(plusButton);
		String quantity = Qty.getText();
		click(addToCartButton);
		click(cartButton);
		Assert.assertTrue(quantity.equals(cart.CartQty.getText()));
	}

}
