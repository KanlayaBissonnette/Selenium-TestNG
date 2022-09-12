package test.CatagoryFunctionality;

import org.testng.annotations.BeforeMethod;
import Utilities.CommonMethods;
import Utilities.Driver;

public class HomeGardenTesting extends CommonMethods{
	
	@BeforeMethod
	public void setUp() {
		init();
		Driver.getDriver();
	}

}
