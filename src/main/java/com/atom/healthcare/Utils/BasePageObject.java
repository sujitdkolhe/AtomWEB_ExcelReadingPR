package com.atom.healthcare.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.Calendar;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.offset.ElementOption.element;
import org.apache.log4j.Level;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.util.TestConfig;
import com.atom.healthcare.util.WaitForWEIsDisplayedEnabled;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;


import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import org.openqa.selenium.*;

public class BasePageObject {

	protected static AppiumDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor jse;
	protected WebElement submitFormElement;
	 public final int timeOut = 40;

	public BasePageObject(AppiumDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
	}

	/**
	 * Checks to see if an element exists or not and returns the element or null.
	 * 
	 * @param parentElement The parent element to search off of or null to search
	 *                      off of the driver.
	 * @param by            How the element should be searched for.
	 * @param l             How long to wait IN SECONDS before we assume that it's
	 *                      not there.
	 * @return The element or null if it doesn't exist.
	 */
	protected WebElement getElement(final WebElement parentElement, final By by, long l) {
		return getElement(parentElement, by, (long) (1000 * l));
	}

	public void javascriptClick(WebElement element) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", element);
	}

	public void focusSelectAndSelectByValue(WebElement element, String value) {
		Actions build = new Actions(driver);
		build.moveToElement(element).build().perform();
		new Select(element).selectByVisibleText(value);
	}

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
	 * Wait will ignore instances of NotFoundException that are encountered (thrown)
	 * by default in the 'until' condition, and immediately propagate all others.
	 * You can add more to the ignore list by calling ignoring(exceptions to add).
	 * 
	 * @param driver
	 * @param n      :- how much time u want to wait
	 * @param ele    :- for which element u want to wait
	 */

	

	

	public String getDate(Calendar cal) {
		return "" + cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	}

	/**
	 * Description : Method to get the Current Date in yyyy-MMM-dd format
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getCurrentDate() throws Exception {
		DateFormat dfDate = new SimpleDateFormat("yyyy-MMMM-dd");
		Date today = Calendar.getInstance().getTime();
		String currentDate = dfDate.format(today);
		return currentDate;
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
	public static String getDate_y() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("PST"));
		String expectedPST = dateFormatGmt.format(now);
		return expectedPST;
	}

	/**
	 * Desc:- Method give u date in Format("yyyy")
	 */
	public static String getEstTiming() {
		Date now = new Date();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("EST"));
		String expectedPST = dateFormatGmt.format(now);
		return expectedPST;
	}

	public static int createRandomNumber() {
		TestConfig.PrintMethodName();
		Random randomNumbers = new Random();
		int rnd = randomNumbers.nextInt(999999999);
		return rnd;
	}

	public String createRandomNumber(int numberLimit) {
		TestConfig.PrintMethodName();
		Random random = new Random();
		int randamNo = random.nextInt(numberLimit);
		return String.valueOf(randamNo);
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
	 * @Description:Pick the Random String
	 * @param array
	 * @return
	 */
	public static String pickRandomString(String[] array) {
		TestConfig.PrintMethodName();
		Random r = new Random();
		return array[r.nextInt(array.length)];
	}

	/**
	 * 
	 * Logs generate in console
	 */
	public static void log(String message) {
		Log4jUtil.log(message);
	}

	public void log(String message, String level) {
		Log4jUtil.log(message, level);
	}

	protected void log(String message, Level level) {
		Log4jUtil.log(message, level);
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
	public static boolean waitForElement(AppiumDriver driver, int n, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, n);
		boolean found = false;
		try {
			found = wait.until(new WaitForWEIsDisplayedEnabled(ele));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return found;
	}

	public static String getMinMaxRandomNumber(int max, int min) {
		int num = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return String.valueOf(num);
	}

	public static void openWebBrowser(String url) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		if (AHC.platformName.equals("Android")) {
		AHC.webDriver = new ChromeDriver();
		} else {
			AHC.webDriver = new SafariDriver();
		}
		AHC.webDriver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		AHC.webDriver.manage().window().maximize();
		AHC.webDriver.get(url);
		AHC.webDriver.navigate().refresh();
		Thread.sleep(3000);
	}
	
	public static void closeWebBrowser() throws InterruptedException {
		try {
			AHC.webDriver.quit();
		} catch (Exception e) {
			//AHC.webDriver.quit();
			log("ERROR: Unable to close browser(s), no browser is currently open.");
		}
	}

	public static long generateMobileNumber() {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return number;
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
	 * Description : This method use for scroll and wait at given time
	 * 
	 * @param input int for x, y directions and time in millisecond
	 */
	public static void scrollAndWait(int x, int y, int ms) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)AHC.webDriver;
		jse.executeScript("scroll(" + x + ", " + y + ");");
		Thread.sleep(ms);
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
				obj[i-1][j] = formatter.formatCellValue(cell);
			}
		}
		return obj;
	}
	
	 /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     * @throws InterruptedException Thrown when a thread is waiting, sleeping,
     *                              or otherwise occupied, and the thread is interrupted, either before
     *                              or during the activity.
     */
    public Boolean isElementPresent(By targetElement) throws InterruptedException {
        Boolean isPresent = driver.findElements(targetElement).size() > 0;
        return isPresent;
    }

    /**
     * method to hide keyboard
     */
    public void hideKeyboard() {
        ((AppiumDriver) driver).hideKeyboard();
    }

    /**
     * method to go back by Android Native back click
     */
    public void back() {
       // ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    	//driver.pressKeyCode(AndroidKeyCode.BACK);// create android object
    	
    }

    /**
     * method to wait for an element to be visible
     *
     * @param targetElement element to be visible
     * @return true if element is visible else throws TimeoutException
     */
    public boolean waitForVisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + targetElement);
            throw e;

        }
    }

    /**
     * method to wait for an element until it is invisible
     *
     * @param targetElement element to be invisible
     * @return true if element gets invisible else throws TimeoutException
     */
    public boolean waitForInvisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            log("Element is still visible: " + targetElement);
            log(e.getMessage());
            throw e;

        }
    }

    /**
     * method to tap on the screen on provided coordinates
     *
     * @param xPosition x coordinate to be tapped
     * @param yPosition y coordinate to be tapped
     */
    public void tap(double xPosition, double yPosition) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("startX", xPosition);
        tapObject.put("startY", yPosition);
        js.executeScript("mobile: tap", tapObject);
    }


    /**
     * method to find an element
     *
     * @param locator element to be found
     * @return WebElement if found else throws NoSuchElementException
     */
    public WebElement findElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element;
        } catch (NoSuchElementException e) {
        	log(this.getClass().getName(), "Element not found" + locator);
            throw e;
        }
    }

    /**
     * method to find all the elements of specific locator
     *
     * @param locator element to be found
     * @return return the list of elements if found else throws NoSuchElementException
     */
    public List<WebElement> findElements(By locator) {
        try {
            List<WebElement> element = driver.findElements(locator);
            return element;
        } catch (NoSuchElementException e) {
        	log(this.getClass().getName(),  "element not found" + locator);
            throw e;
        }
    }

    /**
     * method to get message test of alert
     *
     * @return message text which is displayed
     */
    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            return alertText;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }

    /**
     * method to verify if alert is present
     *
     * @return returns true if alert is present else false
     */
    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            throw e;
        }
    }

    /**
     * method to Accept Alert if alert is present
     */

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    /**
     * method to Dismiss Alert if alert is present
     */

    public void dismissAlert() {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    /**
     * method to get network settings
     */
    public void getNetworkConnection() {
        System.out.println(((AndroidDriver) driver).getConnection());
    }

    /**
     * method to set network settings
     *
     * @param airplaneMode pass true to activate airplane mode else false
     * @param wifi         pass true to activate wifi mode else false
     * @param data         pass true to activate data mode else false
     */
    public void setNetworkConnection(boolean airplaneMode, boolean wifi, boolean data) {
        long mode = 1L;
        if (wifi) {
            mode = 2L;
        } else if (data) {
            mode = 4L;
        }
        ConnectionState connectionState = new ConnectionState(mode);
        ((AndroidDriver) driver).setConnection(connectionState);
        System.out.println("Your current connection settings are :" + ((AndroidDriver) driver).getConnection());
    }


    /**
     * method to get all the context handles at particular screen
     */
    public void getContext() {
        ((AppiumDriver) driver).getContextHandles();
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
        if (contextNames.contains(context)) {
            ((AppiumDriver) driver).context(context);
            log("Context changed successfully");
        } else {
        	log(context + "not found on this page");
        }

       log("Current context" + ((AppiumDriver) driver).getContext());
    }

    /**
     * method to long press on specific element by passing locator
     *
     * @param locator element to be long pressed
     */
    public void longPress(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touch = new TouchAction((MobileDriver) driver);
            LongPressOptions longPressOptions = new LongPressOptions();
            longPressOptions.withElement(ElementOption.element(element));
            touch.longPress(longPressOptions).release().perform();
            log("Long press successful on element: " + element);
        } catch (NoSuchElementException e) {
            log(this.getClass().getName(),  "Element not found" + locator);
            throw e;
        }
    }
    
    /**
     * Java script method to long press on specific element by passing locator
     *
     * @param locator element to be long pressed
     */
    public void longPresssByUsingJS(WebElement ele) {
        try {
        	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
            log("Long press successful on element: " + ele);
        } catch (NoSuchElementException e) {
            log(this.getClass().getName(),  "Element not found" + ele);
            throw e;
        }
    }
    
    /**
     * method to long press on specific element by passing locator
     *
     * @param locator element to be long pressed
     */
    
    public void longPresss(WebElement ele) {
        try {
            TouchAction t= new TouchAction(driver);
            t.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release().perform();
            log("Long press successful on element: " + ele);
        } catch (NoSuchElementException e) {
            log(this.getClass().getName(),  "Element not found" + ele);
            throw e;
        }
    }

    /**
     * method to long press on specific x,y coordinates
     *
     * @param x x offset
     * @param y y offset
     */
    public void longPress(int x, int y) {
        TouchAction touch = new TouchAction((MobileDriver) driver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(x, y);
        touch.longPress(pointOption).release().perform();
       log("Long press successful on coordinates: " + "( " + x + "," + y + " )");

    }

    /**
     * method to long press on element with absolute coordinates.
     *
     * @param locator element to be long pressed
     * @param x       x offset
     * @param y       y offset
     */
    public void longPress(By locator, int x, int y) {
        try {
            WebElement element = driver.findElement(locator);
            TouchAction touch = new TouchAction((MobileDriver) driver);
            LongPressOptions longPressOptions = new LongPressOptions();
            longPressOptions.withPosition(new PointOption().withCoordinates(x, y)).withElement(ElementOption.element(element));
            touch.longPress(longPressOptions).release().perform();
           log("Long press successful on element: " + element + "on coordinates" + "( " + x + "," + y + " )");
        } catch (NoSuchElementException e) {
            log(this.getClass().getName(), "Element not found" + locator);
            throw e;
        }
    }

    /**
     * method to swipe on the screen on provided coordinates
     *
     * @param startX   - start X coordinate to be tapped
     * @param endX     - end X coordinate to be tapped
     * @param startY   - start y coordinate to be tapped
     * @param endY     - end Y coordinate to be tapped
     * @param duration duration to be tapped
     */

    public void swipe(double startX, double startY, double endX, double endY, double duration) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        // swipeObject.put("touchCount", 1.0);
        swipeObject.put("startX", startX);
        swipeObject.put("startY", startY);
        swipeObject.put("endX", endX);
        swipeObject.put("endY", endY);
        swipeObject.put("duration", duration);
        js.executeScript("mobile: swipe", swipeObject);
    }

    static String UiScrollable(String uiSelector) {
        return "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ".instance(0));";
    	//return "new UiScrollable(new UiSelector()).scrollIntoView(" + uiSelector + ");";
    }

    /**
     * method to open notifications on Android
     */

    public void openNotifications() {
        ((AndroidDriver) driver).openNotifications();
    }

    /**
     * method to launchApp
     */

    public void launchApp() {
        ((AppiumDriver) driver).launchApp();
    }

    /**
     * method to click on Element By Name
     *
     * @param elementByName - String element name to be clicked
     */

    public void click(String elementByName) {
        ((AppiumDriver) driver).findElementByName(elementByName).click();
    }

    /**
     * method to scroll down on screen
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollDown(int swipeTimes, int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();
        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.5);
            int end = (int) (dimension.getHeight() * 0.3);
            int x = (int) (dimension.getWidth() * .5);
            new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

    /**
     * method to scroll up on screen
     *
     * @param swipeTimes       number of times swipe operation should work
     * @param durationForSwipe time duration of a swipe operation
     */
    public void scrollUp(int swipeTimes, int durationForSwipe) {
        Dimension dimension = driver.manage().window().getSize();
        for (int i = 0; i <= swipeTimes; i++) {
            int start = (int) (dimension.getHeight() * 0.3);
            int end = (int) (dimension.getHeight() * 0.5);
            int x = (int) (dimension.getWidth() * .5);
            new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe)))
                    .release().perform();
        }
    }

}
