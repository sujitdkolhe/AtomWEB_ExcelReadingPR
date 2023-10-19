package com.atom.healthcare.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForWEIsDisplayedEnabled implements ExpectedCondition<Boolean> {

	private WebElement element;
	public WaitForWEIsDisplayedEnabled(WebElement element) {
		this.element = element;
	}

	public Boolean apply(WebDriver webDriver) {
		return element.isDisplayed() && element.isEnabled();

	}

}
