package com.atom.healthcare.Content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.atom.healthcare.util.BasePageObject;

public class Content extends BasePageObject {
	private static Content content = new Content(driver);

	private Content(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static Content getContent() {
		return content;
	}
}