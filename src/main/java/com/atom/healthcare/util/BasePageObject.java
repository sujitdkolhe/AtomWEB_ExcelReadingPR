package com.atom.healthcare.util;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.util.BrowserTypeUtil.BrowserType;

public class BasePageObject {
	protected static WebDriver driver;
	public WebDriverWait wait;
	public static JavascriptExecutor jse;
	protected WebElement submitFormElement;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
	}

	/**
	 * Desc:- This method use to launch the url
	 * 
	 * @param url and browser
	 */
	protected void get(String url, String browser) {
		try {
			BrowserUtil.certHndl(driver, url, browser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		maxWindow(browser);
	}

	/**
	 * Description : This method wait for page title
	 * 
	 * @param input String and long
	 */
	protected void waitForPageTitle(final String title, long sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().contains(title);
			}
		});
	}

	/**
	 * Description : This method use for maximize the window
	 * 
	 * @param input String
	 */
	protected void maxWindow(String browser) {
		if (!(TestConfig.getBrowserType(browser) == BrowserType.edge)) {
			String script = "if (window.screen){window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);};";
			jse.executeScript(script);
		}
	}

	/**
	 * Description : This method will click on Web element
	 * 
	 * @param input WebElement
	 */
	public void javascriptClick(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
	}

	/**
	 * Description : This method use for focus on element and select by visible text
	 * 
	 * @param input WebElement and string
	 */
	public void focusSelectAndSelectByValue(WebElement element, String value) {
		Actions build = new Actions(driver);
		build.moveToElement(element).build().perform();
		new Select(element).selectByVisibleText(value);
	}

	/**
	 * Submits form
	 */
	public void submitForm() {
		if (submitFormElement != null) {
			log("Submitting form");
			submitFormElement.click();
		} else {
			throw new UnsupportedOperationException(
					"Error when submitting form - submit form element has not been set up.");
		}
	}

	/**
	 * Description : This method use for highlight the element field in color
	 * 
	 * @param input WebElement
	 */
	public void highlightElement(WebElement element) {
		jse.executeScript("arguments[0].setAttribute('style','border: solid 6px red');", element);
	}

	/**
	 * Description : Wait will ignore instances of NotFoundException that are
	 * encountered (thrown) by default in the 'until' condition, and immediately
	 * propagate all others. You can add more to the ignore list by calling
	 * ignoring(exceptions to add).
	 * 
	 * @param driver
	 * @param n      :- how much time u want to wait
	 * @param ele    :- for which element u want to wait
	 */
	public static boolean waitForElement(WebDriver driver, WebElement ele) {
		// TestConfig.PrintMethodName();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		boolean found = false;
		try {
			found = wait.until(new WaitForWEIsDisplayedEnabled(ele));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return found;
	}

	/**
	 * Description : Wait will ignore instances of NotFoundException that are
	 * encountered (thrown) by default in the 'until' condition, and immediately
	 * propagate all others. You can add more to the ignore list by calling
	 * ignoring(exceptions to add).
	 * 
	 * @param driver
	 * @param n      :- how much time u want to wait
	 * @param ele    :- for which element u want to wait
	 */
	public static boolean waitForElementInDefaultFrame(WebDriver driver, int n, WebElement ele) {
		TestConfig.PrintMethodName();
		driver.switchTo().defaultContent();
		return waitForElement(driver, ele);
	}

	/**
	 * Description : This method will switch on window using title
	 * 
	 * @param inputString String
	 * @return boolean
	 */
	protected boolean switchToWindowUsingTitle(String title) throws InterruptedException {
		int retry = 0;
		String currentWindow = driver.getWindowHandle();
		while (retry < 3) {
			Set<String> availableWindows = driver.getWindowHandles();
			if (!availableWindows.isEmpty()) {
				for (String windowId : availableWindows) {
					driver.switchTo().window(windowId).getTitle();
					log("Current Window Title:  " + driver.getTitle(), Level.DEBUG);
					if (driver.getTitle().contains(title)) {
						log("Switch to " + driver.getTitle(), Level.INFO);
						return true;
					}
				}
			}
			retry++;
			Thread.sleep(5000);
		}
		log("Cannot find Window: " + title, Level.ERROR);
		driver.switchTo().window(currentWindow);
		return false;
	}

	/**
	 * Webdriver :-switchTo differnt window
	 * 
	 * @throws InterruptedException
	 */
	public void switchToPrintPopUp(int n) throws InterruptedException {
		Set<String> availableWindows = driver.getWindowHandles();
		Object[] ls = availableWindows.toArray();
		driver.switchTo().window((String) ls[n]);
		Thread.sleep(2000);
	}

	/**
	 * Description : This method use for select value from text using visible text
	 * 
	 * @param inputString String(xpath and contains text)
	 */
	protected void selectFromDropDown(String Xpath, String containsText) {
		Select select = new Select(driver.findElement(By.xpath(Xpath)));
		List<WebElement> allOptions = select.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().contains(containsText)) {
				select.selectByVisibleText(option.getText());
			}
		}
	}

	/**
	 * Description : This method use for select value from text using visible text
	 * 
	 * @param inputString WebElement and String(web element and contains text)
	 */
	protected void selectFromDropDown(WebElement webElement, String containsText) {
		Select select = new Select(webElement);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().contains(containsText)) {
				select.selectByVisibleText(option.getText());
			}
		}
	}

	/**
	 * Description : This method use for scroll and wait at given time
	 * 
	 * @param input int for x, y directions and time in millisecond
	 */
	protected void scrollAndWait(int x, int y, int ms) throws InterruptedException {
		jse.executeScript("scroll(" + x + ", " + y + ");");
		Thread.sleep(ms);
	}

	/**
	 * Desc:-Will clear text field by using id.
	 * 
	 * @param element :- value of the id
	 */
	protected void clearTextFieldById(String id) {
		jse.executeScript("document.getElementById('" + id + "').value='';");
	}

	protected void clearTextField(WebElement e) {
		if (e != null) {
			e.clear();
			// using javascript to clear
			String id = e.getAttribute("id");
			clearTextFieldById(id);
		}
	}

	/**
	 * Will return true if Element exist else false
	 * 
	 * @param element :- WebElement
	 * @return boolean
	 */
	public boolean isElementExists(WebElement element) {
		try {
			Point p = element.getLocation();
			log("Where on the page is the top left-hand corner of the rendered element" + p);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Desc:-Will first wait implicitly then will check if element exist or not .
	 * Will return true if Element exist else false
	 * 
	 * @param driver
	 * @param maxTimeInSecondsToWait
	 * @param element                Element that is checked
	 */
	public static boolean isElementExists(WebDriver driver, long maxTimeInSecondsToWait, WebElement element) {
		boolean bexists = false;
		try {
			driver.manage().timeouts().implicitlyWait(maxTimeInSecondsToWait, TimeUnit.SECONDS);
			Point p = element.getLocation();
			System.out.println("Where on the page is the top left-hand corner of the rendered element" + p);
			bexists = true;
		} catch (Exception e) {
			System.out.println("Element was not found.");
		}

		finally {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return bexists;
	}

	/**
	 * Desc:- Method will set the frame.Frist will set to default Content and then
	 * to str frame
	 */
	public static void setFrame(WebDriver driver, String frameName) {
		TestConfig.PrintMethodName();
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}

	/*
	 * Desc:- Some functionality is embedded in multiple iFrames. This method will
	 * take a list of frames and keep switching to them.
	 * 
	 * @param WebDriver and List of frames
	 * 
	 * @param frames list of frames (specified in order from parent first to deepest
	 * child)
	 */
	public static void setFrameChain(WebDriver driver, List<String> frames) {
		TestConfig.PrintMethodName();
		driver.switchTo().defaultContent();
		for (String frame : frames) {
			driver.switchTo().frame(frame);
		}
	}

	/**
	 * Desc:- Method will set to default Content
	 * 
	 * @param inpte WebDriver
	 */
	public static void setDefaultFrame(WebDriver driver) {
		TestConfig.PrintMethodName();
		driver.switchTo().defaultContent();
	}

	/**
	 * Description : This method will return web element form frame
	 * 
	 * @param inputString String
	 * @return List
	 */
	protected WebElement getFrameWebElement(String frameName) {
		driver.switchTo().defaultContent();
		List<WebElement> framesList = driver.findElements(By.xpath("//frame"));
		WebElement element = null;
		String fname = null;
		for (WebElement frame : framesList) {
			fname = frame.getAttribute("name");
			log("Found frame: " + fname, Level.DEBUG);
			if (fname.equals(frameName)) {
				element = frame;
				log("Found frame: " + fname, Level.INFO);
			}
		}

		if (element == null) {
			log("Cannot find frame: " + fname, Level.ERROR);
		}

		return element;
	}

	/**
	 * Description : This method converts the string to list provided the delimiter
	 * 
	 * @param inputString String
	 * @return List
	 * @throws Exception
	 */
	public List<String> convertStringToList(String inputString, String dlimiter) throws Exception {
		List<String> NewList = new ArrayList<String>();

		String[] pieces = inputString.split(dlimiter);
		// for (int i = pieces.length - 1; i >= 0; i--) {
		// pieces[i] = pieces[i].trim();
		// NewList.add(pieces[i]);
		// }
		for (int i = 0; i <= pieces.length - 1; i++) {
			pieces[i] = pieces[i].trim();
			NewList.add(pieces[i]);
		}
		return NewList;
	}

	/**
	 * Desc:- Method give u date in Format("yyyy")
	 */
	public static String getEstTiming() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("EST"));
		String expectedEST = dateFormatGmt.format(now);
		return expectedEST;
	}

	/**
	 * @Desc:- Will return u data in EST format
	 * @return :- String
	 */
	public static String getEstTimingWithTime() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat();
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("EST"));
		String expectedEST = dateFormatGmt.format(now);
		System.out.println("expectedEST==========================" + expectedEST);
		return expectedEST;
	}

	/**
	 * @Description : This Method will return the difference between two dates in
	 *              hours
	 * @param a [Date]
	 * @param b [Date]
	 * @return
	 */
	public static int calculate_Date_Difference_in_Hours(Date a, Date b) {
		int tempDifference = 0;
		int difference = 0;
		Calendar earlier = Calendar.getInstance();
		Calendar later = Calendar.getInstance();

		if (a.compareTo(b) < 0) {
			earlier.setTime(a);
			later.setTime(b);
		} else {
			earlier.setTime(b);
			later.setTime(a);
		}

		if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
			tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
			difference += tempDifference;

			earlier.add(Calendar.HOUR_OF_DAY, tempDifference);
		}

		if (earlier.get(Calendar.HOUR_OF_DAY) != later.get(Calendar.HOUR_OF_DAY)) {
			tempDifference = later.get(Calendar.HOUR_OF_DAY) - earlier.get(Calendar.HOUR_OF_DAY);
			difference += tempDifference;

			earlier.add(Calendar.HOUR_OF_DAY, tempDifference);
		}

		System.out.println("difference================" + difference);
		return difference;
	}

	/**
	 * Description : Method to get the Current Date in dd-MMM-yyyy format
	 *
	 * @throws Exception
	 */

	public String getDate(Calendar cal) {
		return "" + cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	}

	/**
	 * Description : Method to get the Current Date in yyyy-MMM-dd format
	 * 
	 * @throws Exception
	 */
	public static String getCurrentDate() throws Exception {
		DateFormat dfDate = new SimpleDateFormat("yyyy-MMMM-dd");
		Date today = Calendar.getInstance().getTime();
		String currentDate = dfDate.format(today);
		return currentDate;
	}

	/**
	 * Desc:- Method give u date in Format("MMMM d, yyyy")
	 */
	public static String getDate_MMM_d_yyyy() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("PST"));
		String expectedPST = dateFormatGmt.format(now);
		return expectedPST;
	}

	/**
	 * Desc:- Method give u date in Format("MMMM")
	 */
	public static String getDate_Month() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("MMMM", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("PST"));
		String expectedPST = dateFormatGmt.format(now);
		System.out.println("expectedPST" + expectedPST);
		return expectedPST;
	}
	
	/**
	 * Desc:- Method give u date in Format("MMMM")
	 */
	public static String getDate_MM() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("MMM", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("PST"));
		String expectedPST = dateFormatGmt.format(now);
		System.out.println("expectedPST" + expectedPST);
		return expectedPST;
	}

	/**
	 * Desc:- Method give u date in Format("d")
	 */
	public static String getDate_d() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("d", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("PST"));
		String expectedPST = dateFormatGmt.format(now);
		System.out.println("expectedPST" + expectedPST);
		return expectedPST;
	}

	/**
	 * Desc:- Method give u date in Format("yyyy")
	 */
	public static String getDate_yyyy() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("PST"));
		String expectedPST = dateFormatGmt.format(now);
		return expectedPST;
	}

	/**
	 * Description : Method to get the Current Date in required Format, user has to
	 * provide the date format i.e "MM/dd/yyyy", dd/MM/yyyy etc
	 * 
	 * @param typeOfDateFormat [String]
	 * @return
	 * @throws Exception
	 */
	public static String getFormattedCurrentDate(String typeOfDateFormat) throws Exception {
		Date today = Calendar.getInstance().getTime();
		DateFormat dfDate = new SimpleDateFormat(typeOfDateFormat);
		String formattedCurrentDateTime = dfDate.format(today);
		int Len = formattedCurrentDateTime.length();
		System.out.println("***Before Modification ***" + formattedCurrentDateTime);
		if (typeOfDateFormat.equals("dd")) {
			if (formattedCurrentDateTime.charAt(0) == '0') {
				formattedCurrentDateTime = formattedCurrentDateTime.substring(1);
			}
		}

		else if (typeOfDateFormat.equals("MMMMM dd, yyyy hh:mm")) {
			// This Modification is required for Event Logger as it displays time like
			// 9:51:23 instead 09:51:23, this
			// removes 0 in front of 9
			if (Len > 10 && formattedCurrentDateTime.charAt(Len - 5) == '0') {
				String str1 = formattedCurrentDateTime.substring(0, (Len - 5));
				String str2 = formattedCurrentDateTime.substring((Len - 4), Len);
				formattedCurrentDateTime = str1.concat(str2);
				System.out.println("***After Modification ***" + formattedCurrentDateTime);
			}
		}

		else if (typeOfDateFormat.equals("MM/dd/yyyy hh:mm")) {
			String eventDate = formattedCurrentDateTime.substring(0, (Len - 6));
			String eventTime = formattedCurrentDateTime.substring((Len - 5), Len);
			if (eventTime.charAt(0) == '0') {
				eventTime = eventTime.substring(1);
			}
			// String eventPeriod = formattedCurrentDateTime.substring(17);
			formattedCurrentDateTime = eventDate + " " + "@" + " " + eventTime;
			System.out.println("***After Modification ***" + formattedCurrentDateTime);
		}

		return formattedCurrentDateTime;
	}

	/**
	 * Description : Method to extract the Date from text
	 * 
	 * @param typeOfDateFormat [String]
	 * @return
	 * @throws Exception
	 */
	public static String extractDateFromText(String text) throws IllegalStateException {
		// tries to find and return date from last updated date text
		Pattern pattern = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d|\\d\\d/\\d\\d/\\d\\d\\d\\d");
		Matcher matcher = pattern.matcher(text);

		if (matcher.find())
			return matcher.group();
		else
			throw new IllegalStateException("Date not found");
	}

	/**
	 * Description : Method to add or subtract days from current date
	 * 
	 * @param dateFormat [String] date format i.e "MM/dd/yyyy", dd/MM/yyyy etc
	 * @param days       [int] number of days i.e. -7, 15
	 * @return
	 * @throws Exception
	 */
	public static String getRequiredDate(String dateFormat, int days) throws Exception {
		DateFormat dfDate = new SimpleDateFormat(dateFormat);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days); // Subtracting 1 day to current date
		String newdate = dfDate.format(cal.getTime());

		if (newdate.charAt(0) == '0') {
			newdate = newdate.substring(1);
		}
		return newdate;
	}

	/**
	 * Method to convert from one date format to another *
	 * 
	 * @throws Exception
	 */
	public static String convertDate(String srcDate, String srcDateFormat, String destDateformat) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat(srcDateFormat);
		Date dateStr = formatter.parse(srcDate);
		formatter = new SimpleDateFormat(destDateformat, Locale.ENGLISH);
		String FormattedDate = formatter.format(dateStr);
		System.out.println("FormattedDate" + FormattedDate);
		return FormattedDate;
	}

	/**
	 * Method to get the current date and time in yyyyMMMMddhhmmss format
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDateTime() throws Exception {
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("yyyyMMMMddhhmmss");
		Date now = Calendar.getInstance().getTime();
		String currentDateTime = sdfDateTime.format(now);
		return currentDateTime;
	}

	/**
	 * Description : This Method will return the difference between two dates in
	 * days
	 * 
	 * @param a [Date]
	 * @param b [Date]
	 * @return
	 */
	public static int calculate_Date_Difference(Date a, Date b) {
		int tempDifference = 0;
		int difference = 0;
		Calendar earlier = Calendar.getInstance();
		Calendar later = Calendar.getInstance();

		if (a.compareTo(b) < 0) {
			earlier.setTime(a);
			later.setTime(b);
		} else {
			earlier.setTime(b);
			later.setTime(a);
		}

		while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR)) {
			tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
			difference += tempDifference;

			earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
		}

		if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR)) {
			tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
			difference += tempDifference;

			earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
		}

		return difference;
	}

	/**
	 * Description: Finds the position of the string in the Array & returns it.
	 * 
	 * @param listToSearchFrom: List from which the item is to be searched.
	 * @param searchItem:       Item that has to be searched in the list.
	 * @return Index: Position of the String in the array. Null if the string is not
	 *         found in the array.
	 */
	public Integer findItemInList(String[] listToSearchFrom, String searchItem) {
		for (int n = 0; n < listToSearchFrom.length; n++) {
			if (listToSearchFrom[n].equals(searchItem))
				return n;
		}
		return null;
	}

	/**
	 * Description : executes a java script when ever is needed. some times we need
	 * to execute a Js to for example to execute the js
	 * "top.body.Ext.getCmp('dateRangeMenu').items.get('defaultDateRangeButton').disabled"
	 * 
	 * @param javascript
	 * @return
	 * @throws Exception
	 */
	public Object executeJavascript(String javascript) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return " + javascript + "");
	}

	/**
	 * Method to create random email address
	 * 
	 * @param inpue String and char
	 * @return String
	 * @throws Exception
	 */
	public static String createRandomEmailAddress(String email, char delimiter) {
		TestConfig.PrintMethodName();
		String[] tmp = email.split("@");
		String randomEmail = tmp[0] + delimiter + createRandomNumber() + "@" + tmp[1];
		System.out.println("dynamic Email address " + randomEmail);
		return randomEmail;
	}

	/**
	 * Method to create random email address
	 * 
	 * @param inpue String
	 * @return String
	 * @throws Exception
	 */
	public static String createRandomEmailAddress(String email) {
		return createRandomEmailAddress(email, '+');
	}

	/**
	 * Method to create random number
	 * 
	 * @return int
	 * @throws Exception
	 */
	public static String createRandomZip() {
		return RandomStringUtils.randomNumeric(10);
	}

	public static long generateMobileNumber() {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return number;
	}

	/**
	 * Method to create random number
	 * 
	 * @return int
	 * @throws Exception
	 */
	public static int createRandomNumber() {
		TestConfig.PrintMethodName();
		Random randomNumbers = new Random();
		int rnd = randomNumbers.nextInt(999999999);
		return rnd;
	}

	public static String generatRandomNum() {
		Random random = new Random();
		int randamNo = random.nextInt(100000);
		return String.valueOf(randamNo);
	}

	public static String createRandomNumericString(int length) {
		TestConfig.PrintMethodName();
		return RandomStringUtils.randomNumeric(length);
	}

	public static String createRandomNumericStringInRange(int min, int max) throws Exception {
		TestConfig.PrintMethodName();
		if (max < min) {
			throw new IllegalArgumentException();
		}
		Random rand = new Random();
		Integer randomNum = rand.nextInt(max - min) + min;
		return randomNum.toString();
	}

	public static String createRandomNumericString() {
		TestConfig.PrintMethodName();
		return createRandomNumericString(9);
	}

	/**
	 * @Description:Pick the Random String
	 * @param array
	 * @return
	 */
	public static String pickRandomString(String[] array) {
		TestConfig.PrintMethodName();
		Random r = new Random();
		return array[r.nextInt(array.length)];
	}

	public boolean assessPageElements(ArrayList<WebElement> allElements) {
		log("Checking page elements");

		for (WebElement element : allElements) {
			int attempt = 1;
			while (attempt < 3) {
				log("Searching for element: " + element.toString(), Level.DEBUG);
				try {
					wait.until(ExpectedConditions.visibilityOf(element));
					log(elementToString(element) + " : is displayed", Level.DEBUG);
					attempt = 3;
				} catch (StaleElementReferenceException ex) {
					log("StaleElementReferenceException was catched, attempt: " + attempt++, Level.DEBUG);
				} catch (TimeoutException ex) {
					log(ex.getMessage());
					log(elementToString(element) + " was not assessed successfuly due to TimeoutException",
							Level.ERROR);
					return false;
				} catch (Exception ex) {
					ex.printStackTrace();
					log(elementToString(element) + " was not assessed successfuly due to some Exception", Level.ERROR);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method is used to move on element
	 * 
	 * @param element
	 */
	public static void moveOnElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * Desc:- This method convert Webelement to string
	 * 
	 * @param WebElement
	 * @return
	 */
	public String elementToString(WebElement element) {
		return "Element (id: " + element.getAttribute("id") + ", tag: " + element.getTagName() + ")";
	}

	/**
	 * Method to create random email address
	 * 
	 * @param inpue String and char
	 * @return String
	 * @throws Exception
	 */
	public static String createRandomEmailAddress(String username, String domain) {
		TestConfig.PrintMethodName();
		String randomEmail = username + createRandomNumber() + "@" + domain;
		System.out.println("dynamic Email address " + randomEmail);
		return randomEmail;
	}

	/**
	 * Desc:- This method use to print the log
	 * 
	 * @param WebElement
	 */
	public static void log(String message) {
		Log4jUtil.log(message);
	}

	protected void log(String message, String level) {
		Log4jUtil.log(message, level);
	}

	protected void log(String message, Level level) {
		Log4jUtil.log(message, level);
	}

	public void waitUntilWebElementIsVisible(WebElement element, int n) {
		WebDriverWait wait = new WebDriverWait(driver, n);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static List<String> readJsonFile(String filePath, String listTitle) {
		Object obj = null;

		try {
			obj = new JSONParser().parse(new FileReader(System.getProperty("user.dir") + filePath));
		} catch (IOException | ParseException e) {
			log("Unable to read file" + e.getMessage());
			e.printStackTrace();
		}

		JSONObject jsonObj = (JSONObject) obj;
		JSONArray jsonArray = (JSONArray) jsonObj.get(listTitle);
		System.out.println(jsonArray.size());
		Iterator itr = jsonArray.iterator();
		List<String> expectedList = new ArrayList();

		String[] getList = new String[jsonArray.size()];
		for (int i = 0; i < jsonArray.size(); i++) {
			getList[i] = (String) jsonArray.get(i);
			expectedList.add(i, getList[i]);
		}
		return expectedList;
	}

	public static String createRandomCharacter(int length) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);

		}
		return sb.toString();

	}

	/**
	 * Description : This method use for scroll and wait at given time
	 * 
	 * @param input int for x, y directions and time in millisecond
	 */
	public static void scrollIntoElement(WebElement element, int ms) throws InterruptedException {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(ms);
	}

	/**
	 * Description : This method use for generating password
	 *
	 */

	public static char[] random_Password(int length) {
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
		log("Your new password is : " + password);
		return password;
	}

	/**
	 * Description : This method use to check active element
	 * 
	 * @param input WebElement
	 */

	public boolean isActiveElement(WebElement element) {
		TestConfig.PrintMethodName();
		boolean isActive = false;
		try {
			BasePageObject.waitForElement(driver, element);
			if (element.equals(driver.switchTo().activeElement())) {
				log("Element is active");
			}
			return isActive = true;
		} catch (Exception e) {
			log("Element is not active");
			return isActive;
		}
	}

	public static String getRandomNumber(int number) {
		Random random = new Random();
		int value = random.nextInt(number);
		return String.valueOf(value);
	}

	public static String getMinMaxRandomNumber(int max, int min) {
		int num = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return String.valueOf(num);
	}

	public String getSimpleDateFormat() {
		// displaying date
		SimpleDateFormat simpleformat = new SimpleDateFormat("MMM dd yyyy");
		String date = simpleformat.format(new Date());
		log("Current Date = " + date);
		return date;
	}

	public int getFutureOrPastDate(int addInt) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date d = new Date();
		int date = Integer.parseInt(formatter.format(d)) + addInt;
		log("Date: " + date);
		return date;
	}

	public long getTimeStamp(int add) {
		// Get epoch timestamp using System.currentTimeMillis()
		long currentTimestamp = System.currentTimeMillis();
		log("Current epoch timestamp in millis: " + currentTimestamp);
		String ss = Integer.toString(add) + "00000000";
		long ll = Integer.valueOf(ss);
		long s = currentTimestamp + ll;
		return currentTimestamp;
	}

	public static String getEpochConvertDate(long addDay) {
		long currentTimestamp = System.currentTimeMillis();
		log("Current epoch timestamp in millis: " + currentTimestamp);
		long addedTime = currentTimestamp + addDay;
		SimpleDateFormat simpleformat = new SimpleDateFormat("MMM d yyyy");
		String date = simpleformat.format(new Date());
		log("Current Date = " + date);
		simpleformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = simpleformat.format(addedTime);
		log("DATE:  " + formatted);
		return formatted;
	}

	public void waitUntilElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(5)).ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementsIsVisible(List<WebElement> element) {
		WebDriverWait wait = new WebDriverWait(driver, 50000);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static String getEpochTimeInDate(long addDay) {
		long currentTimestamp = System.currentTimeMillis();
		log("Current epoch timestamp in millis: " + currentTimestamp);
		long addedTime = currentTimestamp + addDay;
		SimpleDateFormat simpleformat = new SimpleDateFormat("MMM d yyyy");
		String date = simpleformat.format(new Date());
		log("Current Date = " + date);
		// simpleformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = simpleformat.format(addedTime);
		return formatted;
	}
	
	public static String getDateFormat(long addDay) {
		long currentTimestamp = System.currentTimeMillis();
		log("Current epoch timestamp in millis: " + currentTimestamp);
		long addedTime = currentTimestamp + addDay;

		SimpleDateFormat simpleformat = new SimpleDateFormat("d");
		String date = simpleformat.format(new Date());
		System.out.println("Current Date = " + date);
		// simpleformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = simpleformat.format(addedTime);
		return formatted;
	}
	
	public static String  getDate_MM_d_yyyy(long addDay) {
		long currentTimestamp = System.currentTimeMillis();
		log("Current epoch timestamp in millis: " + currentTimestamp);
		long addedTime = currentTimestamp + addDay;
		SimpleDateFormat simpleformat = new SimpleDateFormat("MM dd yyyy");
		String date = simpleformat.format(new Date());
		log("Current Date = " + date);
		// simpleformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = simpleformat.format(addedTime);
		return formatted;
	}
	
	public static String getDate_yyyy_mm_dd(long addDay) {
		long currentTimestamp = System.currentTimeMillis();
		log("Current epoch timestamp in millis: " + currentTimestamp);
		long addedTime = currentTimestamp + addDay;
		SimpleDateFormat simpleformat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleformat.format(new Date());
		log("Current Date = " + date);
		simpleformat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		String formatted = simpleformat.format(addedTime);
		log("DATE:  " + formatted);
		return formatted;
	}


			

	public static Object[][] readExcelFile(String className) throws IOException {
		Object[][] obj = null;
        FileInputStream fis = new FileInputStream(AtomHC.filePath);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet(className);
		int rows = sheet.getLastRowNum()+1;
		int cols = sheet.getRow(0).getLastCellNum();
		// DataFormatter formatter= new DataFormatter();
		obj = new Object[rows - 1][cols];
		for (int i = 1; i < rows; i++) {
			Row row = sheet.getRow(i);
			// int columns = row.getLastCellNum();
			for (int j = 0; j < cols; j++) {
				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				obj[i - 1][j] = formatter.formatCellValue(cell);
			}
		}
		return obj;
	}

	
}


