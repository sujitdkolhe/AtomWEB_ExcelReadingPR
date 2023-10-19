package com.atom.healthcare.NotificationConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;

public class NotificationConfiguration extends BasePageObject {
	private static NotificationConfiguration notifConfig = new NotificationConfiguration(driver);

	private NotificationConfiguration(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static NotificationConfiguration getNotificationConfiguration() {
		return notifConfig;
	}
}
