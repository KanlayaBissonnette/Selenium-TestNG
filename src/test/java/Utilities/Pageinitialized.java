package Utilities;

import pageObj.AppOnlyPageObj;
import pageObj.ApplianceFirstItemPageObj;
import pageObj.AppliancesPageObj;
import pageObj.CartPageObj;
import pageObj.CheckOutPageObj;
import pageObj.ContactUsPageObj;
import pageObj.FAQPageObj;
import pageObj.FacebookGearbestPageObj;
import pageObj.HeadPhonePageObj;
import pageObj.HomepageObj;
import pageObj.NewArrivalsPageObj;
import pageObj.PaymentPageObj;
import pageObj.PointPageObj;
import pageObj.ReviewPageObj;
import pageObj.SignInRegisterPageObj;
import pageObj.SuperDealsPageObj;
import pageObj.SupportCenterPageObj;
import pageObj.TestimonialsPageObj;
import pageObj.VacuumCleanerPageObj;

public class Pageinitialized extends Driver {

	protected static HomepageObj hp;
	protected static AppliancesPageObj appliances;
	protected static SignInRegisterPageObj sr;
	protected static CartPageObj cart;
	protected static CheckOutPageObj checkout;
	protected static PaymentPageObj payment;
	protected static SuperDealsPageObj superD;
	protected static AppOnlyPageObj app;
	protected static ContactUsPageObj contact;
	protected static SupportCenterPageObj support;
	protected static PointPageObj point;
	protected static TestimonialsPageObj test;
	protected static FAQPageObj faq;
	protected static VacuumCleanerPageObj vc;
	protected static ApplianceFirstItemPageObj appFI;
	protected static FacebookGearbestPageObj fb;
	protected static NewArrivalsPageObj newarr;
	protected static HeadPhonePageObj hPhone;
	protected static ReviewPageObj review;
	
	public static void init() {
		hp = new HomepageObj();
		appliances = new AppliancesPageObj();
		sr = new SignInRegisterPageObj();
		cart =new CartPageObj();
		checkout= new CheckOutPageObj();
		payment=new PaymentPageObj();
		superD = new SuperDealsPageObj();
		app = new AppOnlyPageObj();
		contact = new ContactUsPageObj();
		support = new SupportCenterPageObj();
		point = new PointPageObj();
		test = new TestimonialsPageObj();
		faq = new FAQPageObj();
		vc = new VacuumCleanerPageObj();
		appFI = new ApplianceFirstItemPageObj();
		fb = new FacebookGearbestPageObj();
		newarr = new NewArrivalsPageObj();
		hPhone = new HeadPhonePageObj();
		review = new ReviewPageObj();
	}
}
