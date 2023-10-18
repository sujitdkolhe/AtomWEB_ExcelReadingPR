package com.atom.healthcare.Utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestResult;

import com.atom.healthcare.Pojo.AtomHC;
import com.atom.healthcare.page.Pojo.AHC;
import com.atom.healthcare.util.BasePageTestNG;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	protected static ExtentReports reports;
	protected static ExtentTest test;
	private static String resultpath = getResultPath();
	static String ReportLocation = "test-output/Report/" + resultpath + "/";
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					Log4jUtil.log(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {
		resultpath = "test";
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	public static void startTest(String className) {
		reports = new ExtentReports(
				ReportLocation + "ExtentReportResults for "+className+"_" + AHC.deviceName + " " + timeStamp + ".html");
		//test = reports.startTest("Atom Healthcare Mobile");
		//reports.addSystemInfo("Environment", TestConfig.getTestEnv());
		reports.addSystemInfo("OS", AHC.deviceName);
		reports.loadConfig(new File(System.getProperty("user.dir")+"/"+"extent-config.xml"));
	}

	public static void extentReports(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test = reports.startTest(result.getMethod().getMethodName());
			test.log(LogStatus.PASS, result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test = reports.startTest(result.getMethod().getMethodName());
			test.log(LogStatus.FAIL, result.getMethod().getMethodName());
			test.log(LogStatus.FAIL, result.getThrowable());
			String screenshotPath = BaseTest.getScreenshot(result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		}else if (result.getStatus() == ITestResult.SKIP) {
			test = reports.startTest(result.getMethod().getMethodName());
			test.log(LogStatus.SKIP, result.getMethod().getMethodName());
			test.log(LogStatus.SKIP, result.getThrowable());
			String screenshotPath = BasePageTestNG.getScreenshot(result.getName());
			test.log(LogStatus.SKIP, test.addScreenCapture(screenshotPath));
		}
	}

	public static void endTest() {
		reports.endTest(test);
		reports.flush();
	}

}
