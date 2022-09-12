package pageObj;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Constants;
import Utilities.Driver;

public class HomepageObj extends CommonMethods {

	public HomepageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/span[2]")
	public WebElement signinTab;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/div/div/div/a[2]")
	public WebElement registerBtn;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/div/div/div/a[1]")
	public WebElement signInBtn;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/a")
	private WebElement accTab;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/div/div/ul/li")
	private List<WebElement> accList;

	@FindBy(xpath = "//div[@class='guide-mark-cancel js-guide-mark-cancel']")
	private WebElement closeTutorail;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/div/div/ul/li[13]/a")
	public WebElement logoutBtn;

	@FindBy(xpath = "//*[@id='js-panelUserInfo']/a")
	public WebElement account;

	/// Footer //
	@FindBy(xpath = "//*[@id='js-siteFooter']/div[4]/dl[1]/dd/a")
	private List<WebElement> companyInformation;

	@FindBy(xpath = "//*[@id='js-siteFooter']/div[4]/dl[2]/dd/a")
	private List<WebElement> customerService;

	public void hoverSigninTab() {
		hover(signinTab);
	}

	public void hoverAccTab() {
		hover(accTab);
		for (int i = 0; i < accList.size(); i++) {
			hover(accList.get(i));
			System.out.println("Is Click able? : " + accList.get(i).isEnabled());
		}
	}

	public void selectMyPoint() {
		selectObj(accList, "Point");
		closeTutorail.click();

	}

	public void clickTestimonialTab() {
		selectObj(companyInformation, ConfigReader.getProperties("Testimonials"));
	}

	public void clickFAQTab() {
		selectObj(customerService, ConfigReader.getProperties("Support"));
	}

	public void clickContactUs() {
		selectObj(companyInformation, ConfigReader.getProperties("Contact"));
	}

	public void headerDisplay() {
		verifyHeader(accTab, Constants.accExp);
	}

	public void clicklogoutBtn() {
		logoutBtn.click();

	}

	@FindBy(xpath = "//i[@class='icon-top1']")
	public WebElement arrowUpIcon;

	@FindBy(xpath = "//i[@class='icon-fb']")
	public WebElement facebookIcon;

	@FindBy(xpath = "//li[@class='headNav_item '][1]")
	public WebElement superDealsTab;

	@FindBy(xpath = "//li[@class='headNav_item '][2]")
	public WebElement appOnlyTab;

	@FindBy(xpath = "//li[@class='headNav_item '][3]")
	public WebElement newArrivalsTab;

	@FindBy(xpath = "//*[contains(@class,'indexBanner_pageItem')]")
	public List<WebElement> sliders;

	@FindBy(xpath = "//div[@class='headEntries']/a")
	public WebElement gearbestLogo;

	@FindBy(xpath = "//img[@title='WT09 Active Noise Cancelling Headphones Bluetooth 5.1 Headphones with Wireless Stereo ANC Suitable for listening to music in any noisy environment']")
	public WebElement headphone;

	@FindBy(xpath = "/html/body/div[5]/div[2]/div[1]")
	public WebElement xTab;

	public void clickArrowUpIcon() {
		scrollByPixel(1500);
		click(arrowUpIcon);
	}

	public void clickFacebookIcon() {
		wait(2);
		click(facebookIcon);
	}

	public void clickSuperDealsTab() {
		click(superDealsTab);
	}

	public void clickAppOnlyTab() {
		click(appOnlyTab);
	}

	public void clicknewArrivalsTab() {
		click(newArrivalsTab);
	}

	public void verifyFiveSliders() {
		Assert.assertTrue(sliders.size() >= Integer.parseInt(ConfigReader.getProperties("minSliderSize")) && sliders.size() <= Integer.parseInt(ConfigReader.getProperties("maxSliderSize")) );
	}

	public void verifyNavBar() {
		clickSuperDealsTab();
		superD.verifySuperDealsPage();
		clickAppOnlyTab();
		app.verifyAppOnlyPage();
		clicknewArrivalsTab();
		newarr.verifyNewArrivalsPage();
	}

	public void clickHeadPhone() {
		sr.signin();
		if (Driver.getDriver().getCurrentUrl() == ConfigReader.getProperties("wrongUrl")) {
			click(xTab);
			click(gearbestLogo);
		}
		wait(4);
		scrollByPixel(1500);
		click(headphone);
	}

	@FindBy(xpath = "//*[@id='js-iptKeyword']")
	private WebElement supDSearchBox;

	@FindBy(xpath = "//*[@id='js-btnSubmitSearch']/i")
	private WebElement supDSearchBtn;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div[1]/div/header[2]/div[1]/div")
	private WebElement smartwatchText;

	@FindBy(xpath = "//*[@id='js-iptKeyword']")
	private WebElement enterKnite;

	@FindBy(xpath = "//*[@id='js-btnSubmitSearch']/i")
	private WebElement supDSubmitBtn;

	@FindBy(xpath = "//*[@id=\"siteWrap\"]/div[1]/div/div/div[1]/div")
	private WebElement sorryText;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div/div[1]/div/p/a[1]")
	private WebElement clickKnife;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div/div/div[1]/div/p/a[1]")
	private WebElement verifyWordKnife;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div[1]/div/header[2]/div[1]")
	private WebElement knifeText;

	@FindBy(xpath = "//*[@class='headLogo']")
	private WebElement backHomepage;

	public void supDSearchBox() {
		supDSearchBox.sendKeys("smartwatch");
		supDSearchBox.sendKeys(Keys.CLEAR);
		wait(2);
	}

	public void supDSearchBtn() {
		supDSearchBtn.click();
		wait(2);
	}

	public void verifySmartwatchText() {
		CommonMethods.verifyHeader(smartwatchText, "Smartwatch");
		System.out.println("Smartwatch");
	}

	public void enterKnite() {
		Driver.getDriver().findElement(By.xpath("//*[@id='js-iptKeyword']")).clear();
		enterKnite.sendKeys("knite");
		wait(2);
	}

	public void supDSubmitBtn() {
		supDSubmitBtn.click();
		wait(2);
	}

	public void verifySorryText() {
		verifyHeader(sorryText, "Sorry, your search for 'knite' did not match any products");
	}

	public void clickKnife() {

		clickKnife.click();
		wait(2);
	}

	public void verifyWordKnife() {
		verifyHeader(verifyWordKnife, "knife");
		System.out.println("Knife");
	}


	public void verifyKnifeText() {
		verifyHeader(knifeText, "Knife");
		System.out.println("Knife");
	}

	public void backHomepage() {
		backHomepage.click();
	}
	
	public void verifySignoutBtn() {
		verifyHeader(logoutBtn, "Sign Out");
		System.out.println("Sign Out");
		
	}
}
