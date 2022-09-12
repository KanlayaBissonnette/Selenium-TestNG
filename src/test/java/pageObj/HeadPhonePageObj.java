package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class HeadPhonePageObj extends CommonMethods {

	WebDriver driver = Driver.getDriver();

	public HeadPhonePageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@title='Description']")
	public WebElement descriptionTab;

	@FindBy(xpath = "//a[@title='Customers Reviews']")
	public WebElement reviewTab;

	@FindBy(xpath = "//div[@class='sizeDesc js-sizeDescription']/p")
	public WebElement spec;

	@FindBy(xpath = "//*[@id='anchorGoodsReviews']/div[1]/div[3]/a[2]")
	public WebElement writeReviewBtn;

	@FindBy(xpath = "//input[@class='compInputNumber_input']")
	public WebElement qtyBox;

	@FindBy(xpath = "/html/body/script[23]")
	public WebElement JSErrorMsg;

	@FindBy(xpath = "//div[@class='goodsIntro_btnWrap js-buyBtnWrap']/a[1]")
	public WebElement addToCartBtn;

	@FindBy(xpath = "//span[@class='headEntries_icon headEntries_iconCart']")
	public WebElement cartIcon;

	@FindBy(xpath = "//*[contains(text(),'Parameter error')]")
	public WebElement errTxt;

	public By byErrTxt = By.xpath("//*[contains(text(),'Parameter error')]");

	public void clickDescriptionTabAndVerify() {
		click(descriptionTab);
		verifyHeader(spec, ConfigReader.getProperties("specTxt"));
		wait(3);
		hp.clickArrowUpIcon();
		wait(3);
		hp.gearbestLogo.click();
		hover(hp.account);
		click(hp.logoutBtn);
	}

	public void clickReviewAndVerify() {
		scrollByPixel(1000);
		wait(2);
		click(reviewTab);
		wait(3);
		click(writeReviewBtn);
		verifyHeader(review.reviewTxt, ConfigReader.getProperties("review"));
		navBack();
	}

	public void addQtyAndVerifyErrorMsg() {
		scrollByPixel(1500);
		click(hp.headphone);
		qtyBox.sendKeys(ConfigReader.getProperties("errQty"));
		wait(3);
		addToCartBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byErrTxt));
		verifyHeader(errTxt, ConfigReader.getProperties("errTxt"));
		click(hp.gearbestLogo);
	}

	public void addToCartAndCheckout() {
		scrollByPixel(1700);
		hp.headphone.click();
		addToCartBtn.click();
		wait(3);
		cartIcon.click();
		scrollByPixel(500);
		cart.checkoutBtn.click();
		sr.checkoutSignin();
		checkout.placeOrderBtn.click();
		wait(5);
		System.out.println(payment.paymentTxt.getText());
		payment.verifyPaymentMtdTxt();
	}

}
