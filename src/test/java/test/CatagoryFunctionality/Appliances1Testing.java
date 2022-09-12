package test.CatagoryFunctionality;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;
import Utilities.Driver;

public class Appliances1Testing extends CommonMethods {

	/*
	 * Brush vacuum 360
	 */

	@BeforeMethod
	public void setUp() {
		getDriver();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC001CatAppliancesArrivalNoticeIn360Product() {
		appliances.appArrivalOn360Section();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC002CatAppliancesMostExpensiveProductInCart() {
		appliances.clickMostExpensiveItem();
		vc.clickAddToCart();
		cart.clickCheckoutBtn();
		sr.checkoutSignin();
		checkout.verifyOnCart();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC003CatAppliancesAddBestRatingVacuum() {
		sr.signin();
		appliances.inputVacuum();
		vc.addingVacummToCart();
		checkout.verifyOnCart();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC004CatAppliancesDropDownButtonsAreClickable() {
		appliances.checkDropDownBtnAreClickable();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void TC005CatAppliancesMinAndMaxPriceRange() {
		appliances.appMinAndMaxPriceRangeItems();

	}

	@AfterMethod
	public void tear() {
		tearDown();
	}

}
