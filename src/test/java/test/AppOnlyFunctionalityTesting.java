package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;
import Utilities.ConfigReader;


public class AppOnlyFunctionalityTesting extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void AppOnlyFunctionality_001_AppOnlyButtonClickable() {
		// hp.appOnlyTab.click();
		click(hp.appOnlyTab);
		Assert.assertTrue(getDriver().getCurrentUrl().equals(ConfigReader.getProperties("appOnlyUrl")));
		app.verifyAppOnlyLists();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void AppOnlyFunctionality_003_CellphonesAndAccessories() {
		click(hp.appOnlyTab);
		click(app.cellPhonesAndAccessories);
		app.verifyPhoneClickable();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void AppOnlyFunctionality_002_Discount() {
		click(hp.appOnlyTab);
		click(app.homeAndGarden);
		click(app.homeGardenFirstItem);
		app.verifyPrice();
	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void AppOnlyFunctionality_004_VerifyIconDisplay() {
		click(hp.appOnlyTab);
		click(app.cellPhonesAndAccessories);
		click(app.clickFirstItemCellPhoneAndAccessories);
		app.verifyPhoneIconisDisplayed();

	}

	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void AppOnlyFunctionality_005_SortBy_Botton_On_WatchandJewelry() {
		click(hp.appOnlyTab);
		app.verifyHottest();
		app.verifyNewest();
		app.verifyDiscount();

	}

	@AfterMethod
	public void TearDown() {
		tearDown();
	}
}
