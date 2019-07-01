package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseClass {

	public LoginPage(AppiumDriver<MobileElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@AndroidFindBy(id = "btnAgree")
	private WebElement agree;
	
	public WebElement getAgree() {
		
		return agree;
	}
	

	@AndroidFindBy(id = "iMSSO_Alert1_Continue_button")
	WebElement Continue;

	@AndroidFindBy(id = "iMSSO_Alert1_Cancel_button")
	WebElement Cancel;

	// VERIZON LOGO
	@AndroidFindBy(xpath = "//android.view.View[@index='0']")
	WebElement VerizonLogo;

	// LOGIN
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='USER' and index = '1']")
	WebElement UserID;

	@AndroidFindBy(id = "PASSWORD")
	WebElement Password;

	@AndroidFindBy(id = "btnLogin")
	WebElement LoginBtn;

	// LINK - for first time user
	@AndroidFindBy(xpath = "//android.view.View[@text='First time user, click here to activate.' and index='2']")
	WebElement FirstTimeUserLink;

	/*
	 * public boolean VerizonLogo(){ return VerizonLogo.isDisplayed(); }
	 * 
	 * public boolean LoginBtnClickable(){ return LoginBtn.isEnabled(); }
	 * 
	 * 
	 * public DashBoardPage Login(String un, String pass){ UserID.sendKeys(un);
	 * Password.sendKeys(pass); LoginBtn.click(); agree.click(); return new
	 * DashBoardPage() ; }
	 * 
	 * 
	 * 
	 * public boolean FirstTimeUserLinkClickable(){ return
	 * FirstTimeUserLink.isEnabled(); }
	 * 
	 * public void FirstTimeUserLinkGetText(){ String LinkText =
	 * FirstTimeUserLink.getText(); System.out.println(LinkText); }
	 */

}