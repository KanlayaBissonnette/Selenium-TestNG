package pageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.CommonMethods;
import Utilities.Constants;
import Utilities.Driver;

public class TestimonialsPageObj extends CommonMethods {

	public TestimonialsPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(className = "article_centerWrap")
	private WebElement testimonialForm;

	@FindBy(xpath = "//*[@id='siteWrap']/div/div[2]/div/ul/li")
	private List<WebElement> customerRev;

	public void verifyTestimonial() {
		Assert.assertTrue(testimonialForm.isDisplayed());
		System.out.println("Customer Testimonials: " + customerRev.size());
		System.out.println(customerRev.get(0).getText());
		String text = customerRev.get(0).getText();
		Assert.assertTrue(text.contains(Constants.VERIFYTESTI));
	}

}
