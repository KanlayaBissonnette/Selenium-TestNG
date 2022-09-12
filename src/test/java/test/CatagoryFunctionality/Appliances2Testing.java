package test.CatagoryFunctionality;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.CommonMethods;

public class Appliances2Testing extends CommonMethods {

	@BeforeMethod
	public void setUp() {
		getDriver();

	}

	@Test(priority = 1, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Appliance_TC001_verifyAppliances() {
		appliances.clickAppliances();
		Assert.assertTrue(getDriver().getCurrentUrl().contains("appliances"));
	}

	@Test(priority = 2, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Appliance_TC002_selectAppliance() {
		appliances.clickAppliances();
		appFI.selectAppliance();

	}

	@Test(priority = 3, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Appliance_TC003_AddToCart() {
		appliances.clickAppliances();
		appFI.AddToCart();
	}

	@Test(priority = 4, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Appliance_TC004_addMoreItem() {
		appliances.clickAppliances();
		appFI.addMoreItem();

	}

	@Test(priority = 5, retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Appliance_TC005_checkoutFunction() {
		appliances.clickAppliances();
		appFI.checkoutFunction();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
