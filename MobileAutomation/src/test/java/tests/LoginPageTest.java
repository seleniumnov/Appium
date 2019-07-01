package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import junit.framework.Assert;
import pages.DashBoardPage;
import pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	LoginPage loginPage = new LoginPage(driver);
	DashBoardPage dashBoardPage = new DashBoardPage(driver);

	/*
	 * // public AndroidDriver driver; public LoginPageTest() { super(); }
	 */

	@BeforeTest
	public void setup() throws MalformedURLException {
		intialization();
	
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
	
		Assert.assertEquals(getPageTitle(), "verizon");
	}

	/*
	 * @Test(priority = 2, description = "Logo is present Test") public boolean
	 * VerizonLogoTest() { //boolean logo = loginPage.VerizonLogo();
	 * //Assert.assertTrue(logo); //return logo; }
	 * 
	 * @Test(priority = 3, description = "LoginBtn is clickable and enabled") public
	 * boolean LoginBtnClickableTest() { //boolean clickable =
	 * loginPage.LoginBtnClickable(); //Assert.assertTrue(clickable); //return
	 * clickable; }
	 */

	@Test(priority = 4, description = "User is able to login succesfully with valid credentials")
	public void LoginTest() {
		//dashBoardPage = loginPage.Login(prop.getProperty("userID"), prop.getProperty("password"));
	}

	/*
	 * @Test(description = "FirstTimeUserLink is clickable and enabled") public
	 * boolean FirstTimeUserLinkClickableTest() { boolean clickable =
	 * loginPage.FirstTimeUserLinkClickable(); Assert.assertTrue(clickable); return
	 * clickable; }
	 */

	@AfterTest
	public void teardown() {
		if (driver != null) {

			driver.quit();
		}

	}
}
