package com.atom.healthcare.util;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.atom.healthcare.util.BrowserTypeUtil.BrowserType;


public class BrowserUtil {
	private static WebDriver driver;
			public static  WebDriver getBrowser(String bname) {
				switch (bname) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
					capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--window-size=1920,1080");
					chromeOptions.addArguments("--no-sandbox");
					chromeOptions.addArguments("--disable-gpu");
					chromeOptions.merge(capabilities);
					//chromeOptions.addArguments("-disable-notification","start-maximized","--incognito");
					driver = new ChromeDriver(chromeOptions);
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					//firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
					firefoxOptions.addArguments("-disable-notification","start-maximized","--incognito");
					driver= new FirefoxDriver(firefoxOptions);
					break;
				case "iexplore":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
					ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					InternetExplorerOptions ieOptions = new InternetExplorerOptions();
					ieOptions.setCapability("INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS", true);
					driver= new InternetExplorerDriver(ieOptions);
					break;
				case "opera":
					WebDriverManager.operadriver().setup();
					driver = new OperaDriver();
					break;
				case "edge":
					//WebDriverManager.edgedriver().setup();
					System.setProperty("webdriver.edge.driver", "./src/test/resources/driver/edgedriver_win64/msedgedriver.exe");
					driver=new EdgeDriver();
					break;
				case "safari":
					driver= new SafariDriver();
					break;
				default:
					System.err.println("Invalid browser name : " + bname);
				}
				return driver;

			}

			public static void certHndl(WebDriver driver, String sURL,String browser) throws Exception {

				if (TestConfig.getBrowserType(browser) == BrowserType.edge) {
					driver.get(sURL);
					if (driver.getTitle().contains("Certificate Error")) {
						driver.navigate().to("javascript:document.getElementById('overridelink').click()");
					}
				} else if (TestConfig.getBrowserType(browser) == BrowserType.opera) {
					try {
						driver.get(sURL);
					} catch (Exception e) {
						driver.switchTo().activeElement().sendKeys(Keys.TAB);
						Thread.sleep(2000);
						driver.switchTo().activeElement().sendKeys(Keys.ENTER);
						Thread.sleep(10000);
					}
				} else {
					driver.get(sURL);
				}
			}

	public static void clearBrowserCache(WebDriver driver,String browser) throws Exception {
		if (TestConfig.getBrowserType(browser) == BrowserType.edge) {
			clearBrowsingDataIE();
		} else if (TestConfig.getBrowserType(browser) == BrowserType.firefox) {
			clearBrowsingDataFireFox();
		} else if (TestConfig.getBrowserType(browser) == BrowserType.safari) {
			clearBrowsingDataSafari();
		} else if (TestConfig.getBrowserType(browser) == BrowserType.chrome) {
			clearBrowsingDataChrome();
		} else if (TestConfig.getBrowserType(browser) == BrowserType.opera) {
			clearBrowsingDataOpera();
		}
		driver.manage().deleteAllCookies();
	}

	private static void clearBrowsingDataIE() throws Exception {
		Runtime rt = Runtime.getRuntime();

		// Clear temporary Internet files
		Process proc8 = rt.exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8");
		proc8.waitFor();
		// Clear Cookies
		Process proc2 = rt.exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
		proc2.waitFor();
		// Clear History
		Process proc1 = rt.exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 1");
		proc1.waitFor();
	}
	private static void clearBrowsingDataSafari() throws Exception {
		Map<String, String> map = System.getenv();
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.equals("windows") || osName.equals("windows 7")) {
			String tempFilePath1 = map.get("LOCALAPPDATA") + "\\Apple Computer\\Safari\\";
			String tempFilePath2 = map.get("HOMEPATH")
					+ "\\AppData\\LocalLow\\Apple Computer\\Safari\\";
			String tempFilePath3 = map.get("APPDATA")
					+ "\\AppData\\Roaming\\Apple Computer\\Safari\\";

			File tempFilesDir1 = new File(tempFilePath1);
			FileUtil.deleteDirectory(tempFilesDir1);

			File tempFilesDir2 = new File(tempFilePath2);
			FileUtil.deleteDirectory(tempFilesDir2);
			/*
			 * if( tempFilesDir2.exists() ) { File[] files2 =
			 * tempFilesDir2.listFiles(); for(int i=0; i<files2.length; i++) {
			 * if(files2[i].isDirectory()) { deleteDirectory(files2[i]); } else
			 * { files2[i].delete(); } } }
			 */
			File tempFilesDir3 = new File(tempFilePath3);
			FileUtil.deleteDirectory(tempFilesDir3);

		} else if (osName.equals("windows xp")) {
			String tempFilePath = map.get("HOMEPATH")
					+ "\\Local Settings\\Apple Computer\\Safari\\";
			File tempFilesDir = new File(tempFilePath);
			FileUtil.deleteDirectory(tempFilesDir);
		}
	}

	private static void clearBrowsingDataChrome() throws Exception {
		Map<String, String> map = System.getenv();
		String tempFilePath = "";
		String osName = System.getProperty("os.name").toLowerCase();

		if (osName.equals("windows") || osName.equals("windows 11")) { // Windows 7 set the path to the temp files for Win 7
																		 
			tempFilePath = map.get("LOCALAPPDATA") + "\\Chrome\\";  				 
		} else if (osName == "windows xp") {
			tempFilePath = map.get("HOMEPATH")
					+ "\\Local Settings\\Application Data\\Google\\Chrome\\"; // set the path to the temp files for WinXP		
		}
		
		File tempFilesDir = new File(tempFilePath);
		FileUtil.deleteDirectory(tempFilesDir);
		/*
		 * File[] files = tempFilesDir.listFiles(); for (File file : files) { if
		 * (!file.delete()) // Delete each file {
		 * System.out.println("Failed to delete "+file); // Failed to delete
		 * file } }
		 */
	}

	private static void clearBrowsingDataFireFox() throws Exception {
		String tempFilePath = "";
		Map<String, String> map = System.getenv();
		String osName = System.getProperty("os.name").toLowerCase();

		if (osName.equals("windows") || osName.equals("windows 7")) {
			tempFilePath = map.get("LOCALAPPDATA") + "\\Mozilla\\Firefox\\Profiles\\";
		} else if (osName.equals("windows xp")) {
			tempFilePath = map.get("HOMEPATH")
					+ "\\Local Settings\\Application Data\\Mozilla\\Firefox\\Profiles\\";
		}
		File tempFilesDir = new File(tempFilePath);
		FileUtil.deleteDirectory(tempFilesDir);
	}
	private static void clearBrowsingDataOpera() throws Exception {
		Map<String, String> map = System.getenv();
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.equals("windows") || osName.equals("windows 7")) {
			String tempFilePath1 = map.get("LOCALAPPDATA") + "\\Opera\\";
			String tempFilePath2 = map.get("HOMEPATH") + "\\AppData\\LocalLow\\Opera\\";
			String tempFilePath3 = map.get("APPDATA") + "\\Opera\\";

			File tempFilesDir1 = new File(tempFilePath1);
			FileUtil.deleteDirectory(tempFilesDir1);
			/*
			 * if( tempFilesDir1.exists() ) { File[] files1 =
			 * tempFilesDir1.listFiles(); for(int i=0; i<files1.length; i++) {
			 * if(files1[i].isDirectory()) { deleteDirectory(files1[i]); } else
			 * { files1[i].delete(); } } }
			 */
			File tempFilesDir2 = new File(tempFilePath2);
			FileUtil.deleteDirectory(tempFilesDir2);

			File tempFilesDir3 = new File(tempFilePath3);
			FileUtil.deleteDirectory(tempFilesDir3);

		} else if (osName.equals("windows xp")) {
			String tempFilePath = map.get("HOMEPATH") + "\\Local Settings\\Opera\\";
			File tempFilesDir = new File(tempFilePath);
			FileUtil.deleteDirectory(tempFilesDir);

		}
	}
	
	public static void getBrowserStackBrowser(String bname) {
		switch (bname) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
		case "safari":
			// driver= new SafariDriver();
			break;
		default:
			System.err.println("Invalid browser name : " + bname);
		}

	}

}
