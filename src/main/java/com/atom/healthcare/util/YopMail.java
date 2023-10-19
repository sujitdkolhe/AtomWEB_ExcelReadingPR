package com.atom.healthcare.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YopMail {
	private static final int TIME_TO_WAIT_MS = 10000;
	protected WebDriver driver;
	protected JavascriptExecutor jse;

	public YopMail(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public String getLinkFromEmail(String username, String emailSubject, int retries) throws InterruptedException {
		for (int j = 1; j <= retries; j++) {
			WebElement links = getEmailElements(username, emailSubject);
			if (links != null) {
				String p = links.getText();
				if (p.contains("https://alphamdhealth.page.link")) {
					Log4jUtil.log("URL found: " + p);
					return p;
				}
			}
			logAttemptAndSleep(j, retries);
		}
		return null;
	}

	private WebElement getEmailElements(String username, String emailSubject) throws InterruptedException {
		driver.get("https://yopmail.com/en/");
		String email;

		WebElement homeButton = driver.findElement(By.xpath("//input[@id='login']"));
		BasePageObject.waitForElement(driver, homeButton);
		homeButton.clear();
		homeButton.sendKeys(username);
		WebElement goInboxButton = driver.findElement(By.xpath("//button[@title='Check Inbox @yopmail.com']"));
		goInboxButton.click();
		driver.switchTo().frame("ifinbox");
		List<WebElement> mailList = driver.findElements(By.xpath("//div[@class='m']/button/div[2]"));
		int l = mailList.size();
		if (l > 0) {
			Thread.sleep(2000);
			for (int i = 0; i < l; i++) {
				jse.executeScript("arguments[0].scrollIntoView(true);", mailList.get(i));
				email = mailList.get(i).getText();
				if (email.contains(emailSubject)) {
					mailList.get(i).click();
					driver.switchTo().defaultContent();
					driver.switchTo().frame("ifmail");
					WebElement mailLink = driver.findElement(By.xpath("//*[@id='mail']/div/div/div[2]/p[2]/strong"));
					System.out.println("Mail : " + mailLink.getText());
					return mailLink;
				}
			}
		}

		return null;
	}

	private void logAttemptAndSleep(int currentAttempt, int maxAttempts) throws InterruptedException {
		logAttemptAndSleep(currentAttempt, maxAttempts, false);
	}

	private void logAttemptAndSleep(int currentAttempt, int maxAttempts, boolean plural) throws InterruptedException {
		Log4jUtil.log((plural ? "Emails were" : "Email was") + " not retrieved. Trial number " + currentAttempt + "/"
				+ maxAttempts + "."
				+ (currentAttempt != maxAttempts
						? " Waiting for e-mail" + (plural ? "s" : "") + " to arrive for " + TIME_TO_WAIT_MS / 1000
								+ " s."
						: ""));
// we don't need to sleep after the last retry
		if (currentAttempt != maxAttempts) {
			Thread.sleep(TIME_TO_WAIT_MS);
		}
	}

	private WebElement getVerificationCodeFromMail(String username, String emailSubject) {
		driver.get("https://yopmail.com/en/");
		String email;
		try {
			WebElement homeButton = driver.findElement(By.xpath("//input[@id='login']"));
			BasePageObject.waitForElement(driver, homeButton);
			homeButton.clear();
			homeButton.sendKeys(username);
			Thread.sleep(1000);

			WebElement goInboxButton = driver.findElement(By.xpath("//button[@title='Check Inbox @yopmail.com']"));
			goInboxButton.click();
			Thread.sleep(1000);
			driver.switchTo().frame("ifinbox");
			List<WebElement> mailList = driver.findElements(By.xpath("//div[@class='m']/button/div[2]"));
			int l = mailList.size();
			if (l > 0) {
				Thread.sleep(2000);
				for (int i = 0; i < l; i++) {
					jse.executeScript("arguments[0].scrollIntoView(true);", mailList.get(i));
					email = mailList.get(i).getText();

					if (email.contains(emailSubject)) {
						mailList.get(i).click();
						driver.switchTo().defaultContent();
						driver.switchTo().frame("ifmail");
						WebElement verificationCode = driver
								.findElement(By.xpath("//*[@id='mail']/div/div/div[2]/p[2]/strong"));
						System.out.println("verification Code : " + verificationCode.getText());
						return verificationCode;

					}
				}

			}

		} catch (Exception e) {
			Log4jUtil.log("unable to find links in yopmail" + e);
		}

		return null;
	}

	public String getVerificationCode(String username, String emailSubject, int retries)
			throws InterruptedException {
		for (int j = 1; j <= retries; j++) {
			WebElement otp = getVerificationCodeFromMail(username, emailSubject);
			if (otp != null) {
				String vCode = otp.getText();
					Log4jUtil.log("Verification code found: " + vCode);
					return vCode;
			}
			logAttemptAndSleep(j, retries);
		}
		return null;
	}

	private WebElement getResetVerificationCodeFromMail(String username, String emailSubject) {
		driver.get("https://yopmail.com/en/");
		String email;
		try {
			WebElement d = driver.findElement(By.xpath("//input[@id='login']"));
			Thread.sleep(1000);
			d.clear();
			Thread.sleep(1000);
			d.sendKeys(username);
			Thread.sleep(1000);

			WebElement goInboxButton = driver.findElement(By.xpath("//button[@title='Check Inbox @yopmail.com']"));
			goInboxButton.click();
			Thread.sleep(1000);
			driver.switchTo().frame("ifinbox");
			List<WebElement> mailList = driver.findElements(By.xpath("//div[@class='m']/button/div[2]"));
			int l = mailList.size();
			if (l > 0) {
				Thread.sleep(2000);
				for (int i = 0; i < l; i++) {
					jse.executeScript("arguments[0].scrollIntoView(true);", mailList.get(i));
					email = mailList.get(i).getText();

					if (email.replaceAll(" ", "").contains(emailSubject.replaceAll(" ", ""))) {
						mailList.get(i).click();
						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						Thread.sleep(2000);
						driver.switchTo().frame("ifmail");
						WebElement verificationCode = driver
								.findElement(By.xpath("//*[@id='mail']/div/div/div/ul/li/strong"));
						return verificationCode;
					}
				}
			}

		} catch (Exception e) {
			Log4jUtil.log("unable to find links in yopmail" + e);
		}

		return null;
	}

	public String getResetVerificationCode(String username, String emailSubject, String message, int retries)
			throws InterruptedException {
		for (int j = 1; j <= retries; j++) {
			WebElement otp = getResetVerificationCodeFromMail(username, emailSubject);
			if (otp != null) {
				String p = otp.getText();
				if (p.contains(message)) {
					WebElement code = driver.findElement(By.xpath("//*[@id='mail']/div/div/div[2]/ul/li"));
					String vCode = code.getText();
					Log4jUtil.log("Verification code found: " + vCode);
					return vCode;
				}
			}
			logAttemptAndSleep(j, retries);
		}
		return null;
	}

}
