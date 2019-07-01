package base;

import io.appium.java_client.MobileElement;

public class GenericMethods extends BaseClass {

	public static void input(MobileElement ele, String value, String fieldName) {

		try {
			if (ele.isDisplayed() && ele.isEnabled()) {

				ele.click();
				ele.clear();
				ele.sendKeys(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void click(MobileElement ele, String fieldName) {

		try {
			if (ele.isDisplayed() && ele.isEnabled()) {
				ele.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
