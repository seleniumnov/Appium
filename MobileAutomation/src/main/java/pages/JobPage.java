package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class JobPage extends BaseClass {
	
	public JobPage(AppiumDriver<MobileElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@AndroidFindBy(id = "sortWorkDispatch")
	WebElement WorkingDispatches;

	@AndroidFindBy(id = "sortByLi")
	WebElement SortByScheduled;

//Search
	@AndroidFindBy(id = "search-job")
	WebElement EnterSearch;

//Acknowledged Order
	@AndroidFindBy(id = "2045969784_1561574437029")
	WebElement AcknowledgedOrder;

	@AndroidFindBy(xpath = "//android.view.View[contains(text(),'ACK')]")
	WebElement ACK;

//COMMON
	@AndroidFindBy(id = "commonTabIdLink")
	WebElement CommonBtn;

//ALERT
	@AndroidFindBy(xpath = "//android.widget.Button[contains(text(),'−    Alert')]")
	WebElement Alert;

	@AndroidFindBy(id = "alertAccordion-content")
	WebElement AlertContent;

//QUICK SUMMARY
	@AndroidFindBy(xpath = "//android.widget.Button[contains(text(),'− Quick Summary')]")
	WebElement QuickSummary;

	@AndroidFindBy(id = "AddressButton")
	WebElement JobMapBtn;

	@AndroidFindBy(xpath = "//android.widget.Button[contains(text(),'  Nav')]")
	WebElement NavBtn;

//Customer & Contact Information
	@AndroidFindBy(xpath = "//android.widget.Button[contains(text(),'+ Customer & Contact Information')]")
	WebElement CustomerAndContactInformation;

//Comments
	@AndroidFindBy(xpath = "//android.widget.Button[contains(text(),'+ Comments')]")
	WebElement Comments;

//Service & time Stamp
	@AndroidFindBy(xpath = "//android.widget.Button[contains(text(),'+ Service & Time Stamp')]")
	WebElement ServiceTimeStamp;

	
//ALERT METHODS
	public void clickAlert() {
		Alert.click();
	}

	public void VerifyAlertContent() {
		// ??????????How to verify the second error message????????????
		String alertContent = AlertContent.getText();
		String alertMessage = "This is a Business Customer and their customer support is through the VBO and App";
		String alertMessage2 = "Router Firmware upgrade process will take up to 20 minutes. There will be NO LED lights or Router activity during the upgrade. Do NOT power off the Router";
		{
			if (alertContent.contains(alertMessage)) {
				System.out.println("Alert message is verified, Test case passed");
			} else {
				System.out.println("Alert message is not present, Test case Failed");
			}
		}
	}

//QUICK SUMMARRY METHODS
	public void clickOnQuickSummary() {
		QuickSummary.click();
	}

}
