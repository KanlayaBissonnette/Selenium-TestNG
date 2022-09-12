package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods extends Pageinitialized {

	/*
	 * * Method that randomString
	 *
	 * @Param int
	 * 
	 * @return String by: Bee Date: 06/08/2022
	 */
	public static String randomsString(int size) {
		String generateString = RandomStringUtils.randomAlphabetic(size);
		return generateString;
	}

	/// ScreenShots ///
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy_MM_dd_HH:mm:ss");
		return sdf.format(date.getTime());
	}

	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOTS + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
		return picBytes;
	}

	public static byte[] takeScreenshot(String filename, WebElement element) {
		TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		byte[] picBytes = element.getScreenshotAs(OutputType.BYTES);

		File file = element.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOTS + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}
		return picBytes;
	}

	/*
	 * Method that navigate back
	 * 
	 */
	public static void navBack() {
		getDriver().navigate().back();
	}

	/*
	 * Method that select object/ product
	 * 
	 * @param List<WebElement>, String <nameForSelect>
	 * 
	 * by bee date: 06/12/2022
	 */
	public static void selectObj(List<WebElement> list, String key) {
		for (WebElement option : list) {
			if (option.getText().contains(key)) {
				option.click();
				break;
			}
		}
	}

	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 *
	 * @param list
	 * @return List<String>
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}

	/*
	 * Method that wait time without condition
	 * 
	 * @param int<second:Time> by bee date: 06/12/2022
	 */

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	/*
	 * Method that get JS alert messages
	 * 
	 * @param WebElement
	 */

	public static String getJsAlert(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", element);
		System.out.println("Alert: " + validationMessage);

		return validationMessage;
	}

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		return js;
	}

	/*
	 * Method that scroll up OR down to element (JS)
	 * 
	 * @param WebElement
	 */
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("argument[0].scrollIntoView(true)", element);
	}

	/*
	 * Method that scroll up OR down (JS)
	 * 
	 * @param int <pixel>
	 */
	public static void scrollByPixel(int pixel) {
		// scroll down => positiveNumber
		// scroll up => negativeNumber
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/*
	 * Method that dismiss Alert
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert alert = Driver.getDriver().switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method that get alert text and dismiss Alert
	 * 
	 */
	public static String getAlertText() {
		String alertText = null;
		try {

			Alert alert = Driver.getDriver().switchTo().alert();
			alertText = alert.getText();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	/*
	 * Method that assert Text
	 * 
	 * @param WebElement , String
	 * 
	 * by: bee Date: 06/15/2022
	 * 
	 */
	public static void verifyHeader(WebElement element, String expected) {
		System.out.println("Actual: " + element.getText());
		System.out.println("Expected: " + expected);
		Assert.assertTrue(element.getText().contains(expected));
		//System.out.println("Actual: " + element.getText());
		//System.out.println("Expected: " + expected);

	}

	/*
	 * Method that wait for element to be click
	 * 
	 * @param WebElement <element>
	 */
	public static WebElement waitForClickAbility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Constants.EXPLICIR_WAIT);
		return wait;
	}

	/*
	 * Method that CLICK
	 * 
	 * @param WebElement <element>
	 */
	public static void click(WebElement element) {
		waitForClickAbility(element).click();
	}

	/*
	 * Method Hover
	 * 
	 * @param WebElement <element>
	 * 
	 * By Kanlaya 06/17/2022
	 */

	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();

	}
	
	/*
	 * Method that take out symbol price
	 * 
	 * @PARAM WebElement element
	 * RETURN double
	 * 
	 * */
	public static double getPriceAsInt(WebElement element) {
        return Double.parseDouble(element.getText().substring(1));
    }

	/*
	 * Method that display text from list
	 * 
	 * @param List<WebElement>
	 * 
	 * by: bee date: 06/19/2022
	 * 
	 */
	public static void getTextFromList(List<WebElement> listEle) {
		for (int i = 0; i < listEle.size(); i++) {
			System.out.println(listEle.get(i).getText());

		}
	}

	/*
	 * Method Hover as List
	 * 
	 * @param List <WebElement> <element>
	 * 
	 * By Emmie 06/18/2022
	 */
	public static void hovers(List<WebElement> element) {

		for (WebElement el : element) {
			Actions act = new Actions(getDriver());
			act.moveToElement(el).build().perform();

		}
	}

}
