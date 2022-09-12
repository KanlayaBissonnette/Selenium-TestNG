package pageObj;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.Driver;


public class AppliancesPageObj extends CommonMethods {

	public AppliancesPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "/html/body/div[1]/div/ul[2]/li[1]/ul/li[4]/a/span")
	private WebElement appliancesTab;

	@FindBy(xpath = "//*[@class='js-lazyload initial lazy-loaded']")
	private List<WebElement> threeSixtyTab;

	@FindBy(xpath = "//*[@class='cateMain_midText']")
	private WebElement noProducts;

	@FindBy(xpath = "//*[@class='cateMain_priceLink ']")
	private List<WebElement> priceOfFiveHundred;

	@FindBy(xpath = "//*[@class='gbGoodsItem js-gbGoodsItem  js-trackGoodsItem   gbGoodsItem-search  ']")
	private List<WebElement> mostExpensiveItem;

	@FindBy(xpath = "//*[@id='js-iptKeyword']")
	public WebElement searchField;

	@FindBy(xpath = "//*[@id='js-btnSubmitSearch']")
	private WebElement searchClick;

	@FindBy(xpath = "//*[@class='select_model headSearch-catelist']")
	private WebElement appDropDown;

	@FindBy(xpath = "//*[@class='select_option  ']")
	private List<WebElement> verifyListApp;

	@FindBy(xpath = "//*[@id='filter-price-from']")
	private WebElement minField;

	@FindBy(xpath = "//*[@id='filter-price-to']")
	private WebElement maxField;

	@FindBy(xpath = "//*[@class='cateMain_filterSubmit js-filterSubmit']")
	private WebElement okBtn;

	@FindBy(xpath = "//*[@class='js-orderItem  price_high-low  ']")
	private WebElement priceHighToLowBtn;

	@FindBy(xpath = "//*[@class='js-orderItem  price_low-high   on ']")
	private WebElement priceLowToHighBtn;

	@FindBy(xpath = "//*[@class='gbGoodsItem_price js-currency js-asyncPrice']")
	private List<WebElement> verifyHighPrices;

	@FindBy(xpath = "//*[@class='goodsIntro_title']")
	private WebElement productName;

	public void clickAppliances() {
		click(appliancesTab);
	}

	public void appArrivalOn360Section() {
		click(appliancesTab);
		wait(2);
		click(threeSixtyTab.get(1));
		wait(2);
		verifyHeader(noProducts, "There is no product under this category!");

	}

	public void clickMostExpensiveItem() {
		click(appliancesTab);
		wait(2);
		click(priceOfFiveHundred.get(7));
		wait(2);
		click(priceHighToLowBtn);
		wait(2);
		click(priceLowToHighBtn);
		wait(2);
		click(mostExpensiveItem.get(0));
		String product = productName.getText();
		String expected = product;
		System.out.println("Product name :" + product);
		System.out.println("Expected : " + expected);
		Assert.assertTrue(product.contains(expected));

	}

	public void inputVacuum() {
		wait(2);
		click(appliancesTab);
		searchField.sendKeys("Vacuum");
		click(searchClick);
	}

	public void checkDropDownBtnAreClickable() {
		click(appliancesTab);
		click(appDropDown);
		for (int i = 0; i < verifyListApp.size(); i++) {
			verifyListApp.get(i).click();
			System.out.println(verifyListApp.get(i).getText());
			click(appDropDown);
			waitForClickAbility(verifyListApp.get(i));
		}

	}

	public void appMinAndMaxPriceRangeItems() {
		click(appliancesTab);
		minField.sendKeys("50");
		wait(2);
		maxField.sendKeys("100");
		wait(2);
		click(okBtn);
		wait(2);
		click(priceHighToLowBtn);
		wait(2);
		click(priceLowToHighBtn);
		wait(2);
		for (int i = 0; i < verifyHighPrices.size(); i++) {
			System.out.println("Highest Price : " + verifyHighPrices.get(i).getText());
			break;

		}

	}

}
