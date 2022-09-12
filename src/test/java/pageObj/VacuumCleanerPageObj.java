package pageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.CommonMethods;
import Utilities.Driver;

public class VacuumCleanerPageObj extends CommonMethods {

	public VacuumCleanerPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='goodsDetail']/div[2]/div[1]/div[2]/div[5]/a[1]")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//*[@id='js-labelHeadCart']")
	private WebElement clickCartIcon;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]//section[1]/div[3]/ul/li[1]/a")
	private WebElement vacuumCleannerBtn;

	@FindBy(xpath = "//a[@class='layui-layer-ico layui-layer-close layui-layer-close1']")
	private WebElement closeBtn;

	@FindBy(xpath = "//*[text()='Rating ']")
	private WebElement ratingBtn;

	@FindBy(xpath = "//*[@id='siteWrap']/div[1]/div[1]/div/div[2]/ul/li")
	private List<WebElement> vacuumCleaner;

	@FindBy(xpath = "//*[@class='goodsIntro_titleBox']")
	private WebElement productName;

	public void clickAddToCart() {
		wait(2);
		click(addToCartBtn);
		wait(2);
		click(clickCartIcon);
	}

	public void clickvVacuumCleannerBtn() {
		click(vacuumCleannerBtn);
	}

	public void closeBtn() {
		wait(2);
		click(closeBtn);
	}

	public void addingVacummToCart() {
		wait(2);
		click(ratingBtn);
		wait(1);
		vacuumCleaner.get(0).click();
		String product = productName.getText();
		String expected = product;
		System.out.println("Product name :" + product);
		System.out.println("Expected : " + expected);
		wait(2);
		click(addToCartBtn);
		wait(2);
		click(clickCartIcon);

	}

}
