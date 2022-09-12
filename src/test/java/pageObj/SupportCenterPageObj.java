package pageObj;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonMethods;
import Utilities.ConfigReader;
import Utilities.Driver;

public class SupportCenterPageObj extends CommonMethods {

	public SupportCenterPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='OK']")
	private WebElement languageBoxOK;

	@FindBy(xpath = "//*[@id='selectList1']/li")
	private List<WebElement> menuList;

	@FindBy(xpath = "//*[@id='selectList2']/li")
	private List<WebElement> subMenuList;

	@FindBy(xpath = "//*[@id='selectList3']/li")
	private List<WebElement> cancelMenu;

	@FindBy(xpath = "//*[@id='xtalk-edit']")
	private WebElement liveChatFieldBox;

	@FindBy(xpath = "//*[@id='xtalk-btn']")
	private WebElement liveChatBtn;

	@FindBy(xpath = "//*[@id='xtalk-panelMain']/div/div[1]/div[2]/div[2]")
	private WebElement chatBox;

	@FindBy(xpath = "//*[@id='header']/div[3]/a[1]/img")
	private WebElement gearBestLogo;

	public void AcceptOK() {
		languageBoxOK.click();
	}

	public void selectOrder() {
		wait(1);
		AcceptOK();
		selectObj(menuList, ConfigReader.getProperties("Order"));
		verifyIsDisplayed();
	}

	public void verifyIsDisplayed() {
		for (int i = 0; i < subMenuList.size(); i++) {
			System.out.println(subMenuList.get(i).getText());
			wait(1);
			Assert.assertTrue(subMenuList.get(i).isDisplayed());
		}
	}

	public void selectCancelOrder() {
		selectObj(subMenuList, ConfigReader.getProperties("Cancel"));
		verifyCancelMenu();
	}

	public void verifyCancelMenu() {
		for (int i = 0; i < cancelMenu.size(); i++) {
			System.out.println(cancelMenu.get(i).getText());
			wait(1);
			Assert.assertTrue(cancelMenu.get(i).isDisplayed());
		}
	}

	public void selectWorngOrder() {
		selectObj(cancelMenu, ConfigReader.getProperties("Wrong"));
	}

	public void selectLiveChat() {
		wait(2);
		liveChatBtn.click();

	}

	public void sendText() {
		liveChatFieldBox.sendKeys(ConfigReader.getProperties("sendTextChatBox"));
		liveChatFieldBox.sendKeys(Keys.ENTER);
		verifyHeader(chatBox, ConfigReader.getProperties("sendTextChatBox"));

	}

	public void clickLogo() {
		gearBestLogo.click();
	}

}
