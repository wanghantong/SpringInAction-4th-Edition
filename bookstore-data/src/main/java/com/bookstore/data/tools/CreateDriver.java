package com.bookstore.data.tools;

import java.io.InputStream;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.springframework.context.annotation.ImportResource;
@ImportResource("classpath:automationDriver/chromedriverl")
public class CreateDriver {

	public static String getOSName() {
		return System.getProperty("os.name");
	}

	public static FirefoxDriver initFirefoxDriver() {
		return new FirefoxDriver();
	}

	public static EventFiringWebDriver initFirefoxDriverWithEvent() {
		FirefoxDriver driver = initFirefoxDriver();
		WebDriverEventListener driverListener = new StoreWebDriverListener();
		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver).register(driverListener);
		return eventFiringWebDriver;
	}
	/**
	 * 注意driver的存储路径
	 * @return
	 */
	public static ChromeDriver initializeChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/Dragon/developCode/eclipse-workspace-javaee/bookstore-parent/bookstore-data/chromedriver");
		return new ChromeDriver();
	}
	/**
	 * 目前只有Mac管用
	 * @return
	 */
	private String verifyProfilePath() {
		SystemInfo systemInfo = new SystemInfo();
		String osName = systemInfo.getOSName();
		String profilePath = "";
		if (osName.equals("Windows 7")) {
			profilePath = "C:/Users/hantong/AppData/Roaming/Mozilla/Firefox/Profiles/b2t404bv.default";
		} else if (osName.equals("Windows 8")) {
			profilePath = "";
		} else if (osName.equals("Mac OS X")) {
			profilePath = "/Users/Dragon/Library/Application Support/Firefox/Profiles/yf1eq66a.default";
		}
		return profilePath;
	}
}
