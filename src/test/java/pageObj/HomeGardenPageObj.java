package pageObj;

import org.openqa.selenium.support.PageFactory;
import Utilities.CommonMethods;
import Utilities.Driver;

public class HomeGardenPageObj extends CommonMethods {

	public HomeGardenPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
}
