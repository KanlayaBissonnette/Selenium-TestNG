package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;

public class SuperDealFunctionalityTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void verifyItemDiscount() {
		superD.superDBtu();
		superD.clickFirstSupDProductAndVerify();
		superD.verifyOriginalPriceSupText();
		superD.verifyDiscountPriceSupText();
		superD.verifyPercentageDiscountSupText();
		superD.verifyshippingSupText();
		superD.supperDAddToCartBtn();
		superD.supperDViewCartItem();
		superD.verifySupperDItemStillDiscount();
		superD.superDHomepage();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void VerifyFlashSaleDiscount() {
		superD.superDBtu();
		superD.flasSaleBtn();
		superD.verifysaleTagFlashText();
		superD.clickFirstFlashProductAndVerify();
		superD.verifyOriginalPriceFlashText();
		superD.verifyDiscountPriceFlashText();
		superD.verifyPercentageDiscountFlashText();
		superD.verifyshippingFalshText();
		superD.flashSaleAdd();
		superD.flashViewCart();
		superD.verifyFlashItemStillDiscount();
		superD.superDHomepage();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void VerifyComingSoonSaleItemButton() {
		superD.superDBtu();
		superD.comingBtn();
		superD.verifyComingSoonSaleProductList();
		superD.verifyComingOriginalPriceText();
		superD.verifyComingDiscountPriceText();
		superD.verifycomingPercentageDiscountText();
		superD.verifycomingPromoBeginText();
		superD.verifycomingShippingText();
		superD.comingSoonAddCard();
		superD.comingViewCardItem();
		superD.verifyComingPriceStillDiscount();
		superD.superDHomepage();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
