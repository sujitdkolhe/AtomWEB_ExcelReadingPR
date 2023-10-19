package com.atom.healthcare.util;

public class BrowserTypeUtil {
	public enum BrowserType {
		firefox, safari, chrome, opera, htmlunit, edge
	}

	public static BrowserType getBrowserType(String browser) {
		if (browser == null)
			return BrowserType.htmlunit;
		else if (browser.equalsIgnoreCase("*firefox") || browser.equalsIgnoreCase("firefox"))
			return BrowserType.firefox;
		else if (browser.equalsIgnoreCase("*safari") || browser.equalsIgnoreCase("safari"))
			return BrowserType.safari;
		else if (browser.equalsIgnoreCase("*chrome") || browser.equalsIgnoreCase("chrome"))
			return BrowserType.chrome;
		else if (browser.equalsIgnoreCase("*opera") || browser.equalsIgnoreCase("opera"))
			return BrowserType.opera;
		else if (browser.equalsIgnoreCase("*edge") || browser.equalsIgnoreCase("edge"))
			return BrowserType.edge;
		else
			return BrowserType.htmlunit;
	}

}