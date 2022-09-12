package pageObj;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class SuperDealsPageObj extends CommonMethods {

	public SuperDealsPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//span[@class='superDealsName']")
	public WebElement flashSaleTxt;

	public void verifySuperDealsPage() {
		verifyHeader(flashSaleTxt, ConfigReader.getProperties("superDealsTxt"));
		navBack();
	}

	@FindBy(xpath = "//*[@class='headNav_itemLink ']")
	private WebElement superDBtn;

	@FindBy(xpath = "//*[@id='siteWrap']/div/section/div[2]/ul[2]/li[1]")
	private WebElement superDFirstItem;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_titleWrap')]")
	private WebElement verifySupHeaderText;

	@FindBy(xpath = "//*[@id='js-panelIntroNormalPrice']/del")
	private WebElement originalPriceSupText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]")
	private WebElement discountPriceSupText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]/span[2]")
	private WebElement percentageDiscountSupText;

	@FindBy(xpath = "//*[@id='js-introAttrWrap']/li[2]")
	private WebElement shippingSupText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_btnWrap js-buyBtnWrap')]/a[1]")
	private WebElement superDAddToCartBtn;

	@FindBy(xpath = "//*[@id='js-labelHeadCart']")
	private WebElement superDViewCartItem;

	@FindBy(xpath = "//*[contains(@class,'paycart_cl-2')]/p[1]")
	private WebElement itemStillDiscountText;

	@FindBy(xpath = "//*[@id='siteWrap']/header/div/a")
	private WebElement superDHomepage;

	@FindBy(xpath = "//*[contains(@class,'category_item')]")
	private WebElement allFlashSaleBtn;

	@FindBy(xpath = "//*[contains(@class,'goodsItem_discount')]")
	private WebElement saleTagFlashText;

	@FindBy(xpath = "//*[contains(@class,'goodsItem_discount')]")
	private WebElement tagSaleFlashBtn;

	@FindBy(xpath = "//*[@id='goodsDetail']/div[2]/div[1]/div[2]/div[1]")
	private WebElement verifyFlashHeaderText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]/del/span")
	private WebElement originalPriceFlashText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]")
	private WebElement discountPriceFlashText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_discount js-panelIntroDiscount show')]")
	private WebElement percentageDiscountFlashText;

	@FindBy(xpath = "//*[@id='js-introAttrWrap']/li[2]")
	private WebElement shippingFlashText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_label')]")
	private WebElement flashShippingText;

	@FindBy(xpath = "//*[contains(@class,'btn big line2 uibtn-cart js-btnGoodsAddCart js-trackBtnAddCart')]")
	private WebElement flashSaleAdd;

	@FindBy(xpath = "//*[@id='js-labelHeadCart']")
	private WebElement flashViewCart;

	@FindBy(xpath = "//*[contains(@class,'cart_price')]")
	private WebElement flashPriceStillDiscount;

	@FindBy(xpath = "//*[@id='siteWrap']/div/section/div[1]/div/div/div[1]/div/div/div[3]")
	private WebElement comingSoonBtn;

	@FindBy(xpath = "//*[@id='goodsDetail']/div[2]/div[1]/div[2]/div[1]")
	private WebElement verifyComingHeaderText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]/del/span")
	private WebElement comingOriginalPriceText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]")
	private WebElement comingDiscountPriceText;

	@FindBy(xpath = "//*[contains(@class,'goodsIntro_priceWrap')]/span[2]")
	private WebElement comingPercentageDiscountText;

	@FindBy(xpath = "//*[@id='js-goodsPromoPrice']/div/div/span[1]")
	private WebElement comingPromoBeginText;

	@FindBy(xpath = "//*[@id='js-introAttrWrap']/li[2]")
	private WebElement comingShippingText;

	@FindBy(xpath = "//*[contains(@class,'btn big line2 uibtn-cart js-btnGoodsAddCart js-trackBtnAddCart')]")
	private WebElement comingSoonAddCardBtn;

	@FindBy(xpath = "//*[@class='headEntries_icon headEntries_iconCart']")
	private WebElement comingSoonViewCard;

	@FindBy(xpath = "//*[contains(@class,'paycart_cl-2')]/p[1]")
	private WebElement comingPriceStillDiscount;

	@FindBy(xpath = "//*[@id='siteWrap']/div/section/div[2]/ul[2]/li")
	private List<WebElement> supDProductList;

	@FindBy(xpath = "//*[@id='siteWrap']/div/section[2]/div/ul/li")
	private List<WebElement> allFlashProductList;

	@FindBy(xpath = "//*[@id='siteWrap']/div/section/div[2]/ul[3]/li[1]")
	private List<WebElement> comingSoonSaleProductList;

	public void superDBtu() {
		superDBtn.click();
	}

	public void clickFirstSupDProductAndVerify() {

		System.out.println(supDProductList.get(0).getText());
		String actual = supDProductList.get(0).getText();
		supDProductList.get(0).click();
		Assert.assertTrue(actual.contains(verifySupHeaderText.getText().substring(0, 17)));
		// for (int i = 0; i < superDProductList.size(); i++) {
		// System.out.println(superDProductList.get(i).getText());
		// superDProductList.get(i).click();
		// break;
		// }

	}

	public void verifyOriginalPriceSupText() {
		verifyHeader(originalPriceSupText, "RRP:");
		// System.out.println(getPriceAsInt(originalPriceSupText));

	}

	public void verifyDiscountPriceSupText() {
		verifyHeader(discountPriceSupText, "Price:");
	}

	public void verifyPercentageDiscountSupText() {
		verifyHeader(percentageDiscountSupText, "53% OFF");
	}

	public void verifyshippingSupText() {
		verifyHeader(shippingSupText, "Shipping:");
	}

	public void supperDAddToCartBtn() {
		superDAddToCartBtn.click();
		wait(2);
	}

	public void supperDViewCartItem() {
		superDViewCartItem.click();
		wait(2);
	}

	public void verifySupperDItemStillDiscount() {
		System.out.println(getPriceAsInt(itemStillDiscountText));

	}

	public void superDHomepage() {
		superDHomepage.click();
		wait(2);
	}

	public void flasSaleBtn() {
		allFlashSaleBtn.click();
		wait(2);
	}

	public void verifysaleTagFlashText() {
		verifyHeader(allFlashProductList.get(0), saleTagFlashText.getText());
	}

	public void clickFirstFlashProductAndVerify() {
		System.out.println(allFlashProductList.get(0).getText());
		String actual = allFlashProductList.get(0).getText();
		allFlashProductList.get(0).click();
		Assert.assertTrue(actual.contains(verifyFlashHeaderText.getText().substring(0, 7)));

	}

	public void verifyOriginalPriceFlashText() {
		verifyHeader(originalPriceFlashText, "RRP:");
	}

	public void verifyDiscountPriceFlashText() {
		verifyHeader(discountPriceFlashText, "Price:");
	}

	public void verifyPercentageDiscountFlashText() {
		verifyHeader(percentageDiscountSupText, "50% OFF");
	}

	public void verifyshippingFalshText() {
		verifyHeader(shippingFlashText, "Shipping:");
	}

	public void verifyFlashShippingText() {
		verifyHeader(flashShippingText, "Shipping:");
	}

	public void flashSaleAdd() {
		flashSaleAdd.click();
		wait(2);
	}

	public void flashViewCart() {
		flashViewCart.click();
		wait(2);
	}

	public void verifyFlashItemStillDiscount() {
		System.out.println(getPriceAsInt(flashPriceStillDiscount));
	}

	public void comingBtn() {
		comingSoonBtn.click();
		wait(2);
	}

	public void verifyComingSoonSaleProductList() {

		System.out.println(comingSoonSaleProductList.get(0).getText());
		String actual = comingSoonSaleProductList.get(0).getText();
		comingSoonSaleProductList.get(0).click();
		Assert.assertTrue(actual.contains(verifyComingHeaderText.getText().substring(0, 19)));

		// for (int i = 0; i < comingSoonSaleItemList.size(); i++) {
		// System.out.println(comingSoonSaleItemList.get(i).getText());
		// comingSoonSaleItemList.get(i).click();

		// break;
		// }

	}

	public void verifyComingOriginalPriceText() {
		verifyHeader(comingOriginalPriceText, "RRP:");
	}

	public void verifyComingDiscountPriceText() {
		CommonMethods.verifyHeader(comingDiscountPriceText, "Price:");
	}

	public void verifycomingPercentageDiscountText() {
		verifyHeader(comingPercentageDiscountText, "33% OFF");
	}

	public void verifycomingPromoBeginText() {
		System.out.println(comingPromoBeginText.getText());
	}

	public void verifycomingShippingText() {
		verifyHeader(comingShippingText, "Shipping:");
	}

	public void comingSoonAddCard() {
		comingSoonAddCardBtn.click();
		wait(2);
	}

	public void comingViewCardItem() {
		comingSoonViewCard.click();
		wait(2);
	}

	public void verifyComingPriceStillDiscount() {
		System.out.println(getPriceAsInt(comingPriceStillDiscount));
	}

}
