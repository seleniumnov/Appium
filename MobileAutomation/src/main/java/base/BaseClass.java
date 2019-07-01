package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

//import com.CoA_SIT.qa.base.Webelement;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static Properties prop;
	
	public static AppiumDriver<MobileElement> driver;

	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/CoA_SIT" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void intialization() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Galaxy Tab S3");// setting > about
															// phone
		cap.setCapability("udid", "624258263526a1e8");
		// udid is the device name when you press - cmd adb devices
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "8.0.0");
		cap.setCapability("appPackage", "com.verizon.launcher.sdnasit");
		cap.setCapability("appActivity", "com.verizon.launcher.webview.WebActivity");
		// cap.setCapability(MobileCapabilityType.APP, "Apk file location
		// C:\\apkfiles\\AndroidUI.apk");
		cap.setCapability("noReset", "True");
		cap.setCapability("automationName", "uiautomator2");

		// any application will have app package and app activity
		// download apk info from playstore

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, cap);
		
		
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
}
