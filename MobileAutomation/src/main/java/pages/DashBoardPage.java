package pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashBoardPage extends BaseClass{
	
	

	public DashBoardPage(AppiumDriver<MobileElement> driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	private int today;
	
	//ActionsBar
	
	//Title
	@AndroidFindBy(id="jobPageTitle")
	WebElement dashBoard;
	
	
	//Search
	@AndroidFindBy(xpath="//android.widget.Image[text()[contains(.,'searchiconnew')]]") 
	WebElement searchIcon;
	
	@AndroidFindBy(xpath="//android.widget.Image[text()[contains(.,'search_cancel')]]") 
	WebElement searchIconCancelBtn;
	
	@AndroidFindBy(id="txtSearchBtn")
	WebElement dropDown;
	
	@AndroidFindBy(id="txtSearch")
	WebElement searchBar;
	
	
	//Help Logo
	@AndroidFindBy(id="helpLogo")
	WebElement helpLogo;
	
	@AndroidFindBy(xpath="//android.widget.Button[text()[contains(.,'OK')]]")  
	WebElement helpLogoOKBtn;
	
	
	//DropIcon
	@AndroidFindBy(xpath="//android.widget.Image[text()[contains(.,'dropingIcon')]]")
	WebElement dropIcon;
	
	@AndroidFindBy(xpath="//android.view.View[text()[contains(.,'Send Log')]]")
	WebElement dropiconSendLog;
	
	@AndroidFindBy(xpath="//android.view.View[text()[contains(.,'Logout')]]")
	WebElement dropiconLogOut;
	
	
	//Previous and Next
	@AndroidFindBy(xpath="//android.view.View[text()[contains(.,' Previous')]]")
	WebElement previousBtn;
	
	@AndroidFindBy(xpath="//android.view.View[text()[contains(.,' Next')]]")
	WebElement nextBtn;
	
	
	//Month
	@AndroidFindBy(id="calMonth")
	WebElement monthName;
	
	@AndroidFindBy(id="next")
	WebElement monthNextBtn;
	
	
	//Refresh Calender
	@AndroidFindBy(id="RefreshCalBtn")
	WebElement refreshCalenderBtn;
	
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void clicksearch(String search){
		searchIcon.sendKeys(search);
	}
	
	public void cancelSeacrhBar(){
		searchIconCancelBtn.click();
	}
	
	/*
	 * public void optionsSearchDropdown(){ driver.
	 * findElementByAndroidUIAutomator("new UiScrollable(newUiSelector()).scrollIntoView(new UiSelector().text(\"E Glossary\"));"
	 * ).click(); }
	 */
	public void getTextDropDown(){
		Select dropdown = new Select(driver.findElement(By.id("txtSearchBtn")));
		List <WebElement> dd = dropdown.getOptions();
		System.out.println(dd.size());
		for(int i = 0; i<= dd.size();i++){
			System.out.println(dd.get(i).getText());
		}
	}
	
	public void VerifyOptionInDropDown() {
		Select dropdown1 = new Select(driver.findElement(By.id("txtSearchBtn")));
		
		String[] exp = { "Document", "E Glossary" };
		List<WebElement> dd1 = dropdown1.getOptions();
		int i = 0;
		for (WebElement we : dd1) {

			if (we.getText().equals(exp[i])) {

				System.out.println("Matched :: " + we.getText());

			} else {
				System.out.println("Not Matched  :: " + we.getText());
			}
			i++;
		}

	}
	
	public void clickHelpIcon(){
		helpLogo.click();
	Alert alert =	driver.switchTo().alert();
	alert.accept();
	
		
	}
	
	//If Alert is present
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}   // isAlertPresent()
		
		
	public boolean DropIconOptionsSendLogEnabled(){
		dropIcon.click();
		return dropiconSendLog.isEnabled();
	}
		
	public boolean DropIconOptionsLogOutEnabled(){
		dropIcon.click();
		return dropiconLogOut.isEnabled();
	}
	
	
	public void PreviousBtnEnabled(){
		previousBtn.isEnabled();
	}
	
	public void NextBtnEnabled(){
		nextBtn.isEnabled();
	}
	
	public void monthChangesOnNextBtn(){
		Calendar now = Calendar.getInstance();
  //Trying to check if clicking next button actually changes the month
		monthNextBtn.click();
	String monthname= monthName.getText();// clicking on monthname and getting text of it
	{
		if(monthname.equals(now.get(Calendar.MONTH)+2)){//month start from 0 to 11
			System.out.println("Date have changed upon clicking the next button");
		}else{
			System.out.println("Date have not changed upon clicking next button, please check Button");
		}
	}
	}

	
	//to check calender picker has todays date as default
	public void defaultDate(){
		Calendar now = Calendar.getInstance();
	}
	
	//check the refresh Calender return to current month and current date
	public void refreshCalenderFunctionality(){
		Calendar now = Calendar.getInstance();
		monthNextBtn.click();
		refreshCalenderBtn.click();
		String month = monthName.getText();
		{
			if (month.equals(now.get(Calendar.MONTH)+1)){
				System.out.println("Refresh Calender button fucntionality is working");
			}else{
				System.out.println("Check Refresh Calender");
			}
		}
	}
	
	
}
