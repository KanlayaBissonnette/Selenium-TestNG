package pageObj;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class AppOnlyPageObj extends CommonMethods {

	public AppOnlyPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//i[@class= 'icon-iphone']")
	public WebElement phoneIcon;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/a")
	public WebElement viewMoreTab;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[2]/a")
	public WebElement consumerElectronicsTab;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[3]/a")
	public WebElement cellPhonesAndElectronics;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[5]/a")
	public WebElement computerTabletsAndOffice;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[6]/a")
	public WebElement dronesToysAndHobbies;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[7]/a")
	public WebElement homeImprovementandTools;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[8]/a")
	public WebElement homeAndGarden;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[9]/a")
	public WebElement motorAndCarElectronics;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li")
	public List<WebElement> categoriesItems;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[4]/a")
	public WebElement womenFashion;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[10]/a")
	public WebElement menFashion;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[12]/a")
	public WebElement industrialAndScientific;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[11]/a")
	public WebElement healthAndPersonalCare;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[13]/a")
	public WebElement outdoorFitnessAndSport;
	
	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[15]/a")
	public WebElement watchAndJewelry;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[14]/a")
	public WebElement appliances;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[1]/div/ul/li[3]/a")
	public WebElement cellPhonesAndAccessories;

	@FindBy(xpath = "//div[@class='cateMain_listModel']/ul/li")
	public List<WebElement> items;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[2]/div/ul/li[1]/a/img")
	public WebElement anyItem;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[2]/div/ul/li[1]/a")
	public WebElement homeGardenFirstItem;

	@FindBy(xpath = "//*[@id='js-panelIntroNormalPrice']/del/del")
	public WebElement originalPrice;

	@FindBy(xpath = "//*[@id='js-panelIntroNormalPrice']/span[1]")
	public WebElement discountedPrice;

	@FindBy(xpath = "//*[@id='js-panelIntroNormalPrice']/span[2]")
	public WebElement DiscountPercentage;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div[2]/div/ul/li[1]/a/img")
	public WebElement clickFirstItemCellPhoneAndAccessories;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/nav/a[1]/span")
	public WebElement hottestButton;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/nav/a[2]/span")
	public WebElement newestButton;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/nav/a[3]/span")
	public WebElement discountButton;

	public void verifyAppOnlyPage() {
		Assert.assertTrue(phoneIcon.isDisplayed());
		Assert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperties("appOnlyUrl"));
		navBack();

	}

	public void verifyAppOnlyLists() {

		click(viewMoreTab);
		verifyHeader(consumerElectronicsTab, ConfigReader.getProperties("consumerElectronicsTab"));
		verifyHeader(cellPhonesAndElectronics, ConfigReader.getProperties("cellphonesandAccessories"));
		verifyHeader(computerTabletsAndOffice, ConfigReader.getProperties("computersTabletsandOffice"));
		verifyHeader(dronesToysAndHobbies, ConfigReader.getProperties("dronesToysandHobbies"));
		verifyHeader(homeImprovementandTools, ConfigReader.getProperties("homeImprovementandTools"));
		verifyHeader(homeAndGarden, ConfigReader.getProperties("homeandGarden"));
		verifyHeader(motorAndCarElectronics, ConfigReader.getProperties("motorandCarElectronics"));
		verifyHeader(womenFashion, ConfigReader.getProperties("womensFashion"));
		verifyHeader(menFashion, ConfigReader.getProperties("mensFashion"));
		verifyHeader(industrialAndScientific, ConfigReader.getProperties("industrialandScientific"));
		verifyHeader(healthAndPersonalCare, ConfigReader.getProperties("healthandPersonalCare"));
		verifyHeader(outdoorFitnessAndSport, ConfigReader.getProperties("outdoorsFitnessandSports"));
		verifyHeader(watchAndJewelry, ConfigReader.getProperties("watchesandJewelry"));
		verifyHeader(appliances, ConfigReader.getProperties("applianceS"));
	}

	public void verifyPhoneClickable() {
		String appOnlyUrl = Driver.getDriver().getCurrentUrl();
		for (int i = 0; i < Integer.valueOf(ConfigReader.getProperties("numberOfCellPhones")); i++) {
			CommonMethods.click(app.items.get(i));
			Assert.assertNotEquals(Driver.getDriver().getCurrentUrl(), appOnlyUrl);
			Driver.getDriver().navigate().back();
		}
	}

	public void verifyPhoneIconisDisplayed() {
		assertTrue(phoneIcon.isDisplayed());
	}

	public void verifyHottest() {
		assertTrue(hottestButton.isDisplayed());
		System.out.println("Hottest Button is Displayed");
	}

	public void verifyNewest() {
		assertTrue(newestButton.isDisplayed());
		System.out.println("Newest Button is Displayed");
	}

	public void verifyDiscount() {
		assertTrue(discountButton.isDisplayed());
		System.out.println("Discount Button is Displayed");
	}

	public void verifyPrice() {
		System.out.print("Original Price ");
		System.out.println(app.originalPrice.getText());
		System.out.print("Discounted Price ");
		System.out.println(app.discountedPrice.getText());
		System.out.print("Discount Percentage ");
		System.out.println(app.DiscountPercentage.getText());

		String originalPrice = app.originalPrice.getText();
		String newOriginalPrice = originalPrice.substring(1, originalPrice.length());
		double doubleOriginalPrice = Double.valueOf(newOriginalPrice);
		System.out.println(doubleOriginalPrice);

		String discountedPrice = app.discountedPrice.getText();
		String newDiscountedPrice = discountedPrice.substring(1, discountedPrice.length());
		double doubleDiscountedPrice = Double.valueOf(newDiscountedPrice);
		System.out.println(doubleDiscountedPrice);

		String discountPercentage = app.DiscountPercentage.getText();
		String newDiscountPercentage = discountPercentage.substring(0, 2);
		double doubleDiscountPercentage = Double.valueOf(newDiscountPercentage);
		System.out.println(doubleDiscountPercentage);

		double verifySale = (100 - doubleDiscountPercentage) / 100 * doubleOriginalPrice;
		System.out.println(verifySale);

		String s = String.valueOf(verifySale);
		System.out.println(s);

		int decimalIndex = s.indexOf('.');

		// Append after decimal to end price 99c
		String updatedNumber = s.substring(0, decimalIndex + 1) + "99";

		System.out.println(updatedNumber);

		Assert.assertEquals(updatedNumber, newDiscountedPrice);

	}

}
