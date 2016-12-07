/**

 * 创建时间：Mar 7, 2014 2:56:02 PM
 * 创建时间：Mar 7, 2014 2:56:02 PM

 * 项目名称：TYTestLib

 * @author T.Y

 * @version 1.0

 * @since JDK 1.7

 * 文件名称：BaseTemplate.java

 * 类说明：

 */
package com.bookstore.data.webdriver.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookstore.data.tools.SystemInfo;
import com.google.common.base.Strings;

/**
 * 
 * <p>
 * Title: BaseTemplate
 * </p>
 * 
 * <p>
 * Description: test template based on selenium2,it packaged some usual methods,
 * this class is abstract, when testing,this class should be extended
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author : T.Y
 * 
 * @date : Mar 7, 2014
 */
public class BaseUtils {

	public Logger logger = Logger.getLogger(BaseUtils.class); // this

	/**
	 * 
	 * @return system name
	 */
	public String getOSName() {
		return System.getProperty("os.name");
	}

	public FirefoxDriver initializeFirefoxDriver() {
		return new FirefoxDriver();
	}

	/**
	 * Mac OS
	 * 
	 * https://support.mozilla.org/zh-CN/kb/%E7%AE%A1%E7%90%86%E7%94%A8%E6%88%B7
	 * %E9%85%8D%E7%BD%AE%E6%96%87%E4%BB%B6
	 * 
	 * 1.完全退出Firefox
	 * 
	 * 2.导航到 /Applications/Utilities，打开终端应用程序。
	 * 
	 * 3.在终端应用程序中输入: /Applications/Firefox.app/Contents/MacOS/firefox-bin -p
	 * 
	 * Windows
	 * 
	 * 1.完全退出firefox
	 * 
	 * 2.https://support.mozilla.org/zh-CN/kb/%E5%A4%87%E4%BB%BD%E4%BD%A0%E7%9A%
	 * 84%E4%BF%A1%E6%81%AF
	 * 
	 * 3.cmd + R
	 * 
	 * 4.firefox.exe -p
	 * 
	 * @return
	 */
	public FirefoxDriver initializeFirefoxDriverWithFirefoxProfile() {

		String profilePath = verifyProfilePath();
		FirefoxProfile firefoxProfile = new FirefoxProfile(
				new File(profilePath));
		return new FirefoxDriver(firefoxProfile);
	}

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

	public EventFiringWebDriver initializeEventFiringWebDriver() {
		FirefoxDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		MyWebDriverListener myListener = new MyWebDriverListener();
		return eventDriver.register(myListener);
	}

	public EventFiringWebDriver initializeEventFiringWebDriverWithProfile() {

		String profilePath = verifyProfilePath();
		FirefoxProfile firefoxProfile = new FirefoxProfile(
				new File(profilePath));
		FirefoxDriver driver = new FirefoxDriver(firefoxProfile);
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		MyWebDriverListener myListener = new MyWebDriverListener();
		return eventDriver.register(myListener);
	}

	public InternetExplorerDriver initializeIEDriver() {
		InternetExplorerDriver IEDriver = new InternetExplorerDriver();
		return IEDriver;
	}

	public ChromeDriver initializeChromeDriver() {
		ChromeDriver chromeDriver = new ChromeDriver();
		return chromeDriver;
	}

	public SafariDriver initializeSafariDriver() {
		SafariDriver safariDriver = new SafariDriver();
		return safariDriver;
	}

	/**
	 * 
	 * Title: getWebElement
	 * 
	 * <p>
	 * Description: Returns the first WebElement using the given method
	 * </p>
	 * 
	 * @param by
	 *            the first WebElement
	 * @return the first WebElement
	 * 
	 */
	public  WebElement getElement(WebDriver driver, By by) {
		WebElement webElement = driver.findElement(by);
		highLight(driver, webElement);
		return webElement;
	}

	/** Is the Element in page or not. */
	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);// if it does not find the element throw
									// NoSuchElementException, thus returns
									// false.
			logger.info("the element is present");
			return true;
		} catch (NoSuchElementException e) {
			logger.info("the element is present");
			return false;
		}
	}

	/**
	 * 
	 * Title: isElementDisplay
	 * 
	 * <p>
	 * Description: Checks if the element is displayed, and it must be present
	 * </p>
	 * 
	 * @return true or false
	 * 
	 */
	public boolean isElementDisplay(WebElement e) {
		boolean isDisplay = false;
		try {
			isDisplay = e.isDisplayed();
			logger.info("Verify current element is displayed in the page :"
					+ isDisplay);
		} catch (NoSuchElementException error) {
			logger.info("Sorry,this element not displayed in the page,throw:"
					+ error.getMessage());
			error.printStackTrace();
		}
		return isDisplay;
	}

	/**
	 * 
	 * Title: highLight
	 * 
	 * <p>
	 * Description: highLight the element
	 * </p>
	 * 
	 * @param e
	 * 
	 */
	public void highLight(WebDriver driver, WebElement e) {
		if (driver instanceof JavascriptExecutor) {
			executeJS(driver, "arguments[0].style.border='3px solid blue'", e);
		}
	}

	/**
	 * 
	 * Title: highLight Element List
	 * 
	 * <p>
	 * Description: high Light the element list
	 * </p>
	 * 
	 * @param driver
	 * @param list
	 * 
	 */
	public void highLight(WebDriver driver, List<WebElement> list) {
		if (driver instanceof JavascriptExecutor) {
			for (WebElement e : list) {
				executeJS(driver, "arguments[0].style.border='1px solid red'",
						e);
			}
		}
	}

	public void highLightExt(WebDriver driver, WebElement e) {
		logger.info("Highlight the element ,the object is:" + e.getTagName()
				+ ",the text in this object is:" + e.getText());
		Actions action = new Actions(driver);
		highLight(driver, e);
		action.contextClick(e).perform();
		logger.info("Had right click the object ,then press the escape key");
		e.sendKeys(Keys.DOWN);
		e.sendKeys(Keys.ENTER);
	}

	public Object executeJS(WebDriver driver, String script) {
		logger.info("Run the javascript from page ,the java script is:"
				+ script);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		return je.executeScript(script);

	}

	public Object executeJSReturn(WebDriver driver, String script) {
		logger.info("Run the javascript from page ,the java script is:"
				+ script);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Object object = je.executeScript(script);
		return object;
	}

	/**
	 * what's this ?
	 * 
	 * @param driver
	 * @param script
	 * @param e
	 */
	public void executeJS(WebDriver driver, String script, WebElement e) {
		logger.info("Run the javascript from page ,the java script is:"
				+ script);
		// highLight(e);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript(script, e);

	}

	/**
	 * what's this ?
	 * 
	 * @param driver
	 * @param script
	 * @param e
	 * @return
	 */
	public Object executeJSReturn(WebDriver driver, String script, WebElement e) {
		logger.info("Run the javascript from page ,the java script is:"
				+ script);
		// highLight(e);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Object object = je.executeScript(script, e);
		return object;

	}

	/**
	 * 
	 * Title: clickElement
	 * 
	 * <p>
	 * Description: In chrome browser this function didn't work ,so give a
	 * solution to load the page correctly
	 * </p>
	 * ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+e.
	 * getLocation().y+")"); String code=getInnerHtmlCode(driver, e);
	 * logger.info("Clicked element html code is:"+code);
	 * 
	 * @param e
	 * 
	 */
	public void clickElement(WebDriver driver, WebElement e) {
		logger.info("Click elements in page-clicked this element:"
				+ e.getTagName() + ",the text is:" + e.getText());
		// In chrome browser this function didn't work ,so give a solution to
		// load the page correctly
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollTo(0,"+e.getLocation().y+")");
		// String code=getInnerHtmlCode(driver, e);
		// logger.info("Clicked element html code is:"+code);
		highLight(driver, e);
		e.click();
	}

	public void clickElementViaJs(WebDriver driver, WebElement e) {
		logger.info("Click elements in page-clicked this element:"
				+ e.getTagName() + ",the text is:" + e.getText());
		// In chrome browser this function didn't work ,so give a solution to
		// load the page correctly
		highLight(driver, e);
		executeJS(driver, "arguments[0].click();", e);

	}

	/**
	 * 
	 * Title: clickElementViaJsID
	 * 
	 * <p>
	 * Description:click an element in the page
	 * </p>
	 * 
	 * @param elementid
	 * 
	 */
	public void clickElementViaJsID(WebDriver driver, String elementid) {
		logger.info("Click elements in page-clicked this element html id is"
				+ elementid);
		// In chrome browser this function didn't work ,so give a solution to
		// load the page correctly
		// highLight(e);
		executeJS(driver, "document.getElementById('" + elementid
				+ "').click();");
		logger.info("Clicked element's html ID is:" + elementid);
	}

	/**
	 * 
	 * Title: clickElementViaMouse
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param e
	 * 
	 */
	public void clickElementViaMouse(WebDriver driver, WebElement e) {
		logger.info("Click elements in page-clicked this element:"
				+ e.getTagName() + ",the text is:" + e.getText());
		// In chrome browser this function didn't work ,so give a solution to
		// load the page correctly
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollTo(0,"+e.getLocation().y+")");
		highLight(driver, e);
		new Actions(driver).moveToElement(e).clickAndHold().release().build()
				.perform();
		// "return arguments[0].fireEvent('onclick');",
		// String code=getInnerHtmlCode(driver, e);
		// logger.info("Clicked element html code is:"+code);

	}

	/**
	 * 
	 * Title: rightClickElement
	 * 
	 * <p>
	 * Description: right click an element in the page
	 * </p>
	 * 
	 * @param e
	 * 
	 */
	public void clickElement_rightClick(WebDriver driver, WebElement e) {
		logger.info("Right Click elements in page-clicked this element:"
				+ e.getTagName() + ",the text is:" + e.getText());
		// In chrome browser this function didn't work ,so give a solution to
		// load the page correctly
		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollTo(0,"+e.getLocation().y+")");
		highLight(driver, e);
		new Actions(driver).contextClick(e).perform();
		// "return arguments[0].fireEvent('onclick');",
		// String code=getInnerHtmlCode(driver, e);
		// logger.info("Right Clicked element html code is:"+code);
	}

	/*
	 * select相关的全部操作----------------------------------------------start
	 */

	/**
	 * 
	 * Title: isSelected
	 * 
	 * <p>
	 * Description: verify the object is selected in the page
	 * </p>
	 * 
	 * @param e
	 * @return
	 * 
	 */
	public boolean isSelected(WebDriver driver, WebElement e) {
		logger.info("Verify webelement Selected in the page-the current webelement is:"
				+ e.getTagName()
				+ ",the text in the webelement is:"
				+ e.getText().trim());
		highLight(driver, e);
		return e.isSelected();
	}

	/**
	 * 
	 * Title: selectElementViaText
	 * 
	 * <p>
	 * Description: select an option from the drop list, depends on the visible
	 * text ----针对下拉选的操作：通过显示的文本，来checked下拉选
	 * </p>
	 * 
	 * @param e
	 * @param text
	 * 
	 */
	public void selectElementViaText(WebDriver driver, WebElement e, String text) {
		logger.info("Select option text from the list ,list element is:"
				+ e.getTagName() + ",the option text is:" + text);
		highLight(driver, e);
		Select select = new Select(e);
		select.selectByVisibleText(text);
	}

	/**
	 * 
	 * Title: SelectElementViaValue
	 * 
	 * <p>
	 * Description: select an option from the drop list, depends on the tag's
	 * attribute value
	 * </p>
	 * 
	 * @param e
	 * @param value
	 * 
	 */
	public void selectElementViaValue(WebDriver driver, WebElement e,
			String value) {
		logger.info("Select option value from the list ,list element is:"
				+ e.getTagName() + ",the option value is:" + value);
		highLight(driver, e);
		Select select = new Select(e);
		select.selectByValue(value);
	}

	/**
	 * 
	 * Title: SelectElementViaIndex
	 * 
	 * <p>
	 * Description: select an option from the drop list, depends on the index
	 * the index begin with 0
	 * </p>
	 * 
	 * @param e
	 * @param index
	 * 
	 */
	public void selectElementViaIndex(WebDriver driver, WebElement e, int index) {
		logger.info("Select option index from the list ,list element is:"
				+ e.getTagName() + ",the option index is:" + index);
		highLight(driver, e);
		Select select = new Select(e);
		select.selectByIndex(index);
	}

	/*
	 * select相关的全部操作----------------------------------------------end
	 */

	public List<WebElement> getElements(WebDriver driver, By by) {
		List<WebElement> elements = driver.findElements(by);
		highLight(driver, elements);
		return elements;
	}

	// /**
	// *
	// * Title: findElementListByTagName
	// *
	// * <p>
	// * Description: get all the web elements(subElements) behind the specified
	// * element
	// * </p>
	// *
	// * @param e
	// * -- the web element object
	// * @param tagname
	// * -- the web element's tag name
	// * @return
	// *
	// */
	public List<WebElement> findElementListByTagName(WebDriver driver,
			WebElement e, String tagname) {
		logger.info("Find all subelements by Tag Name:" + e.getTagName()
				+ ",the sub elment's tag name is:" + tagname);
		highLight(driver, e);
		List<WebElement> elements = e.findElements(By.tagName(tagname));
		return elements;
	}

	//
	public List<WebElement> findElementListByClassName(WebDriver driver,
			String selector) {
		logger.info("Find all subelements by class Name:" + selector);
		List<WebElement> elements = driver.findElements(By
				.cssSelector(selector));
		highLight(driver, elements);
		return elements;

	}

	//
	// /**
	// *
	// * Title: findElementByXpath
	// *
	// * <p>
	// * Description: find the element by xpath in the page
	// * </p>
	// *
	// * @param e
	// * --the web element object
	// * @param xpath
	// * -- the web element's xpath
	// * @return
	// *
	// */
	public WebElement findElementByXpath(WebDriver driver, WebElement e,
			String xpath) {
		logger.info("Find subelement by Xpath-we will find an sub element with the xpath:"
				+ xpath);
		highLight(driver, e);
		WebElement element = e.findElement(By.xpath(xpath));
		// highLight(driver, element);
		return element;
	}

	//
	// /**
	// *
	// * Title: findElementByCSS
	// *
	// * <p>
	// * Description: find the element(subElement of the parentElement) by CSS
	// in
	// * the page
	// * </p>
	// *
	// * @param e
	// * @param css
	// * @return
	// *
	// */
	public WebElement findElementByCSS(WebDriver driver, WebElement e,
			String css) {
		logger.info("Find subelement by css-we will find an sub element with the css selector:"
				+ css);
		highLight(driver, e);
		WebElement element = e.findElement(By.cssSelector(css));
		// highLight(driver, element);
		return element;
	}

	/**
	 * 
	 * Title: sendKeys
	 * 
	 * <p>
	 * Description: send key to an element
	 * </p>
	 * it could set value for <input type=text >
	 * 
	 * @param e
	 *            --the webElement you want to send the key
	 * @param enter
	 *            -- the key need to send
	 * 
	 */
	public void sendKeys(WebDriver driver, WebElement e, String enter) {
		logger.info("Send keys in this element:" + e.getTagName()
				+ ",the key we send is:" + enter);
		e.clear();
		highLight(driver, e);
		e.sendKeys(enter);
	}

	/**
	 * 
	 * Title: clearAndTypeString
	 * 
	 * <p>
	 * Description: clear the text in the elment and then type the new string in
	 * this element
	 * </p>
	 * 
	 * @param e
	 *            -- the webElment you need to type
	 * @param text
	 *            -- the text you want to input
	 * 
	 */
	public void clearAndTypeString(WebDriver driver, WebElement e, String text) {
		logger.info("Type a text into the element is:" + e.getTagName()
				+ ", the inputted text:" + text);
		// e.sendKeys(Keys.DELETE);
		// String code=getInnerHtmlCode(driver, e);
		// logger.info("Clicked element html code is:"+code);
		highLight(driver, e);
		e.clear();
		e.sendKeys(text);
		// e.sendKeys(Keys.TAB);

	}

	/**
	 * 
	 * Title: getCurrentPageURL
	 * 
	 * <p>
	 * Description: getCurrentURL:(get the current page URL address).
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public String getCurrentPageURL(WebDriver driver) {
		String pageurl = "";
		JavascriptExecutor je = (JavascriptExecutor) driver;
		final String docstate = (String) je
				.executeScript("return document.readyState");
		logger.info("Current loading page state is:" + docstate);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		ExpectedCondition<Boolean> ec = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return (docstate.equals("complete"));
			}
		};
		try {
			logger.info("We just wait for the current page load correctly now...");
			wait.until(ec);
			pageurl = driver.getCurrentUrl();
			logger.info("we found the current url is:" + pageurl);
		} catch (TimeoutException e) {
			pageurl = "time out:120 seconds";
			logger.error("Sorry the page cannot be loaded correctly:"
					+ e.getMessage() + driver.getCurrentUrl());
			throw new RuntimeException("the page is loading...");
		}
		return pageurl;
	}

	/**
	 * 
	 * Title: waitForBrowserFullSync
	 * 
	 * <p>
	 * Description: wait for the web page to full loading correctly ,it will
	 * wait for 3 minutes to load the page , if the page not loading in 3
	 * minutes ;it will throw error;
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public boolean waitForBrowserFullSync(WebDriver driver) {
		final String currentbrowserstate = (String) executeJS(driver,
				"return document.readyState;");
		logger.info("Current browser state is:" + currentbrowserstate);
		WebDriverWait wdw = new WebDriverWait(driver, 180);
		ExpectedCondition<Boolean> ec = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				String newpagestate = (String) executeJS(driver,
						"return document.readyState;");
				logger.debug("the new page state is:" + newpagestate);
				return (newpagestate.equals("complete"));
			}
		};

		boolean loaded = wdw.until(ec);
		logger.debug("finally the load is loading with completed status is:"
				+ loaded);
		return loaded;
	}

	public long getBrowserLoadTime(WebDriver driver) {
		long start = System.currentTimeMillis();
		long end = 0;
		JavascriptExecutor je = (JavascriptExecutor) driver;
		final String docstate = (String) je
				.executeScript("return document.readyState");
		logger.info("Current loading page state is:" + docstate);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		ExpectedCondition<Boolean> ec = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return (docstate.equals("complete"));
			}
		};
		try {
			logger.info("We just wait for the current page load correctly now...");
			wait.until(ec);
			end = System.currentTimeMillis();

		} catch (TimeoutException e) {
			logger.error("Sorry the page cannot be loaded correctly:"
					+ e.getMessage() + driver.getCurrentUrl());
			throw new RuntimeException(
					"the page is dead..I am already wait 300s.");
		}

		return (end - start) / 1000;
	}

	/**
	 * 
	 * Title: waitProcessBarNotAppear
	 * 
	 * <p>
	 * Description: wait for an object to be displayed in the page
	 * </p>
	 * 
	 * @param e
	 * @return true: the object displayed , false:the object not displayed in
	 *         the page ;
	 * 
	 */
	public boolean waitProcessBarNotAppear(WebDriver driver, WebElement e) {
		int waitcount = 0;
		boolean isDisplayed = false;
		while (e.isDisplayed()) {
			waitcount = waitcount + 1;
			isDisplayed = e.isDisplayed();
			logger.info("Waitting for the object displayed status-the load object displayed status is:"
					+ isDisplayed);
			sleepSeconds(3);
			if (waitcount == 5) {
				logger.error("Waitting for the object displayed status-the object cannot show in the page:"
						+ e.getTagName() + ",exit the identify the object ");
				break;
			}
		}
		return isDisplayed;

	}

	/**
	 * test failed Title: waitForGUIAppear
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param e
	 * @param timeout
	 * @return
	 * 
	 */
	public boolean waitForGUIAppear(WebDriver driver, WebElement e, long timeout) {
		boolean findelement = false;
		WebDriverWait wdw = new WebDriverWait(driver, timeout);
		logger.info("wait for the object displayed in the page:"
				+ getInnerHtmlCode(driver, e));
		ExpectedCondition<WebElement> visibilityOf = ExpectedConditions
				.visibilityOf(e);
		WebElement until = wdw.until(visibilityOf);
		findelement = until.isDisplayed();
		return findelement;
	}

	/**
	 * 
	 * Title: getInnerHtmlCode
	 * 
	 * <p>
	 * Description: get the webelement's html code
	 * </p>
	 * 
	 * @param e
	 * @return
	 * 
	 */
	public String getInnerHtmlCode(WebDriver driver, WebElement e) {
		String contents = (String) executeJSReturn(driver,
				"return arguments[0].innerHTML;", e);
		logger.info("Get the html code for this webelement:" + contents);
		highLight(driver, e);
		return contents;
	}

	/**
	 * 
	 * Title: waitForObjectDisplay
	 * 
	 * <p>
	 * Description: wait for the object displayed in the page ,the time out will
	 * be 120 seconds ,if it still not show ,it will failed
	 * </p>
	 * 
	 * @param xpathExpression
	 * @return
	 * 
	 */
	public boolean waitForObjectDisplay(WebDriver driver,
			final String xpathExpression) {
		boolean findobject = false;
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			wait.until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver driver) {
					logger.info("Enter the waitForObjectDisplay method to wait for the object displayed in the page ");
					return (driver.findElement(By.xpath(xpathExpression))
							.isDisplayed());
				}
			});
			findobject = true;
		} catch (TimeoutException te) {
			logger.info("throw expection ,cannot find the web element:"
					+ te.getMessage());
			logger.info("the time out is 120 ,we cannot find this webelment:"
					+ xpathExpression);
			Assert.fail("Cannot find this web element in the page:"
					+ xpathExpression);
		}

		return findobject;
	}

	/**
	 * 
	 * Title: getPageLoadTime
	 * 
	 * <p>
	 * Description: get the current page loading time ,it will return seconds
	 * 
	 * @see http 
	 *      ://www.softwareishard.com/blog/firebug/support-for-performance-timing
	 *      -in-firebug/
	 * @see http://selenium.polteq.com/en/implement-web-timings/
	 * @see http://www.html5rocks.com/en/tutorials/webperformance/basics/
	 * @see http
	 *      ://www.theautomatedtester.co.uk/blog/2010/selenium-webtimings-api
	 *      .html
	 *      </p>
	 * 
	 * @return
	 * 
	 */
	public long getPageLoadTime(WebDriver driver) {
		long pageloadtime = 0;
		long pagestarttime = 0;
		long pageendtime = 0;

		// try{
		// different with browser ,ie will return is double value but firefox
		// and chrome will return is long
		Object startobject = executeJSReturn(driver,
				"return window.performance.timing.navigationStart;");
		Object endobject = executeJSReturn(driver,
				"return window.performance.timing.loadEventEnd;");
		// @SuppressWarnings("unchecked")
		// pagetimer=executeJSReturn("var performance = window.performance || window.webkitPerformance || window.mozPerformance || window.msPerformance || {};"+
		// " var timings = performance.timing || {};"+
		// " return timings;");
		// long pageloadend=(pagetimer.get("loadEventEnd"))/1000;
		// long pageloadstart=(pagetimer.get("navigationStart"))/1000;
		// pageloadtime=(pageloadend-pageloadstart);
		// think it's the firefox or chrome browser
		if (startobject instanceof Long) {
			pagestarttime = (Long) startobject;
			logger.debug("the page navigate start time is:" + pagestarttime);
		}
		if (startobject instanceof Double) {
			Double tempvalue = (Double) startobject;
			pagestarttime = new Double(tempvalue).longValue();
			logger.debug("the page navigate start time is:" + pagestarttime);
		}
		if (endobject instanceof Long) {
			pageendtime = ((Long) endobject);
			logger.debug("the page end time is:" + pageendtime);
		}
		if (endobject instanceof Double) {
			double tempvalue = (Double) endobject;
			pageendtime = new Double(tempvalue).longValue();
			logger.debug("the page end time is:" + pageendtime);
		}

		pageloadtime = (pageendtime - pagestarttime) / 1000;
		logger.info("Get current page loading time is:" + pageloadtime);

		return pageloadtime;
	}

	/**
	 * 
	 * Title: scrollToView
	 * 
	 * <p>
	 * Description: scroll the view to we can see in the page
	 * </p>
	 * 
	 * @param e
	 * 
	 */
	public void scrollToView(WebDriver driver, WebElement e) {
		highLight(driver, e);
		executeJS(driver, "window.scrollTo(0," + e.getLocation().y + ")");
		executeJS(driver, "arguments[0].scrollIntoView(true);", e);
		logger.info("Now we scroll the view to the position we can see");
	}

	/**
	 * 
	 * Title: scrollToView
	 * 
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param driver
	 * @param by
	 * 
	 */
	public void scrollToView(WebDriver driver, By by) {
		System.err.println("还未测试  scrollToView(WebDriver driver, By by)  ");

		WebElement element = driver.findElement(by);

		highLight(driver, element);

		new Actions(driver).moveToElement(element);

		logger.info("Now we scroll the view to the position we can see");
	}

	/**
	 * 
	 * Title: refreshPage
	 * 
	 * <p>
	 * Description: refresh the current page
	 * </p>
	 * 
	 * 
	 */
	public void refreshPage(WebDriver driver) {
		// driver.navigate().refresh();
		logger.info("Now refresh the page to keep the session valid");
		// or blow
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.F5).perform();
	}

	/**
	 * 
	 * Title: getPageTitle
	 * 
	 * <p>
	 * Description: get this page title
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public String getPageTitle(WebDriver driver) {
		String title = driver.getTitle();
		logger.info("Get current page title is:" + title);
		return title;
	}

	/**
	 * 
	 * Title: sleepSeconds
	 * 
	 * <p>
	 * Description: sleep the current step for a few seconds
	 * </p>
	 * 
	 * @param seconds
	 *            -- the seconds we need to sleep
	 * 
	 */
	public void sleepSeconds(int seconds) {
		logger.info("Begin to sleep current step for " + seconds
				+ " seconds........");
		// You need to be in a synchronized block in order for Object.wait() to
		// work.

		// Also, I recommend looking at the concurrency packages instead of the
		// old school threading packages. They are safer and way easier to work
		// with.
		// synchronized (driver)
		// {
		// driver.wait(seconds * 1000);
		// }
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			logger.error("Sleep current step met an error:" + e.getMessage());
		}

	}

	/**
	 * 
	 * Title: screenShort
	 * 
	 * <p>
	 * Description: highLight the element or module then screenShort it
	 * </p>
	 * 
	 * @param filePath
	 *            -- the screenShort picture saved path
	 * @throws IOException
	 * 
	 */
	public void screenShort(WebDriver driver, String filePath)
			throws IOException {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filePath));
	}

	/**
	 * 
	 * Title: checkBoxed
	 * 
	 * <p>
	 * Description: select the checkBox ,if it selected ,we will not select it
	 * again
	 * </p>
	 * 
	 * @param e
	 * 
	 */
	public void checkBoxed(WebDriver driver, WebElement e) {
		highLight(driver, e);
		if (!(e.isSelected())) {
			logger.info("Check the checkbox,the webelment :" + e.getTagName()
					+ e.getText() + ",had been selected now");
			e.click();
		} else {
			logger.info("Check the checkbox,the webelment :" + e.getTagName()
					+ e.getText() + ",had been selected default");
		}
	}

	/**
	 * 
	 * Title: isEnabled
	 * 
	 * <p>
	 * Description: verify the object is enabled in the page
	 * </p>
	 * 
	 * @param e
	 * @return
	 * 
	 */
	public boolean isEnabled(WebDriver driver, WebElement e) {
		logger.info("Verify webelement Enabled in the page-the current webelement is:"
				+ e.getTagName()
				+ ",the text in the webelement is:"
				+ e.getText().trim());
		highLight(driver, e);
		return e.isEnabled();
	}

	/**
	 * 
	 * Title: getAttribute
	 * 
	 * <p>
	 * Description: get the webelement's attribute value
	 * </p>
	 * 
	 * @param e
	 *            --the web element object
	 * @param attributename
	 *            -- the web element's attribute
	 * @return
	 * 
	 */
	public String getAttribute(WebElement e, String attributename) {
		logger.info("Get the webelement Attribute-the webelement's attribute:"
				+ e.getTagName() + ",the text in the webelement is:"
				+ e.getText().trim());
		String attributevalue = e.getAttribute(attributename);
		logger.info("Get the webelement Attribute-the webelement's attribute:"
				+ attributename + " value is:" + attributevalue);
		return attributevalue;
	}

	/**
	 * 
	 * Title: getTagName
	 * 
	 * <p>
	 * Description: get the web element's tag name
	 * </p>
	 * 
	 * @param e
	 *            -- the web element object
	 * @return String --the web element's tag name
	 * 
	 */
	public String getTagName(WebDriver driver, WebElement e) {
		logger.info("Get the webelement TagName-the webelement's tag name is:"
				+ e.getTagName() + ",the text in the webelement is:"
				+ e.getText().trim());
		highLight(driver, e);
		String tagname = e.getTagName();
		logger.info("Get the webelement TagName-the webelement's tag name is:"
				+ e.getTagName());
		return tagname;
	}

	/**
	 * 
	 * Title: alertClickOK
	 * 
	 * <p>
	 * Description: click the ok button in the pop up dialog (alert dialog)
	 * </p>
	 * 
	 * @param seconds
	 *            -- the seconds we need to wait to click it
	 * @return
	 * 
	 */
	public boolean alertClickOK(WebDriver driver, int seconds) {
		boolean isclicked = false;
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			logger.info("Pop up Alert text is:" + alert.getText());
			alert.accept();
			isclicked = true;
		} catch (NoAlertPresentException e) {
			logger.info("the Alert didn't pop up currently:" + e.getMessage());
		} catch (TimeoutException e) {
			logger.error("Time out we cannot find this OK button:" + seconds);
		}

		return isclicked;
		// driver.w
	}

	/**
	 * 
	 * Title: alertClickCancel
	 * 
	 * <p>
	 * Description: this fuction is used for clicking the cancel button
	 * </p>
	 * 
	 * @param seconds
	 *            -- the second we need to wait to click the cancel button
	 * @return
	 * 
	 */
	public boolean alertClickCancel(WebDriver driver, int seconds) {
		boolean isclicked = false;
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			logger.info("Pop up Alert text is:" + alert.getText());
			alert.dismiss();
			isclicked = true;
		} catch (NoAlertPresentException e) {
			logger.info("the alert didn't pop up currently:" + e.getMessage());
		} catch (TimeoutException e) {
			logger.error("Time out we cannot find this Cancel button:"
					+ seconds);
		}

		return isclicked;
	}

	/**
	 * 
	 * Title: switchtoWindow
	 * 
	 * <p>
	 * Description: switchtoWindow:(Here describe the usage of this function).
	 * http
	 * ://santoshsarmajv.blogspot.com/2012/04/how-to-switch-control-to-pop-up
	 * -window.html
	 * http://stackoverflow.com/questions/11614188/switch-between-two
	 * -browser-windows-using-selenium-webDriver
	 * </p>
	 * 
	 * @param windowTitle
	 * @throws AWTException
	 * 
	 */
	public void switchtoWindow(WebDriver driver, String windowTitle)
			throws AWTException {
		Robot robot = new Robot();
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(windowTitle)) {
				robot.delay(5000);
				// robot.keyPress(keycode);
			}
		}
	}

	/**
	 * click the upload button to upload the file ,this is for the webFile
	 * element ,the input type is file
	 * 
	 * @param driver
	 * @param e
	 * @param filepath
	 *            http://sauceio.com/index.php/2012/03/selenium-tips-uploading-
	 *            files-in-remote-webdriver/ upload the local file from remote
	 *            webdriver
	 */
	public void uploadFile(WebDriver driver, WebElement e, String filepath) {
		String uploadcode = getInnerHtmlCode(driver, e);
		highLight(driver, e);
		logger.info("the upload webelement html code we get is:" + uploadcode);
		e.sendKeys(filepath);
	}

	/**
	 * ERROR--------------------- this is the first method we must use in every
	 * page ,so that we can get the page loading time
	 * 
	 * @param pagename
	 * @throws IOException
	 * @throws Exception
	 */
	public void verifyPageElements(WebDriver driver, String pagename)
			throws IOException {
		// this is a line seperator so that we can see the debug log clearly
		logger.info("\n" + Strings.repeat("*", 20) + pagename
				+ Strings.repeat("*", 20));
		// get the page loading time in every page if we use this method
		long pageloadingtime = getPageLoadTime(driver);
		System.err.println(pageloadingtime);
		// --------------------------------------
		// generatePageLoadTime(pagename, pageloadingtime);
	}

	public List<WebElement> getTableByTagName(WebElement e, By by) {
		List<WebElement> list = e.findElements(By.tagName("tr"));
		return list;
	}

	public List<WebElement> getTableTrByXpath(WebElement e, String xpath) {
		List<WebElement> trs = e.findElements(By.xpath(xpath));
		return trs;
	}

	public List<WebElement> getTableTrBy(WebElement table) {
		List<WebElement> trs = table.findElements(By.tagName("tr"));
		return trs;
	}

	public void setWindowMaxSize(WebDriver driver) {
		driver.manage().window().maximize();
	}

}
