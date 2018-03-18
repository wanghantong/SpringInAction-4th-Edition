package com.bookstore.data.webdriver.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	public static Logger logger = Logger.getLogger(ElementUtil.class); // this

	public static void setWindowMaxSize(WebDriver driver) {
		driver.manage().window().maximize();
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
	public static WebElement getElement(WebDriver driver, By by) {
		WebElement webElement = driver.findElement(by);
		highLight(driver, webElement);
		return webElement;
	}

	public static WebElement getElement(WebDriver driver, WebElement webElement, By by) {
		WebElement element = webElement.findElement(by);
		highLight(driver, element);
		return element;
	}

	/** Is the Element in page or not. */
	public static boolean isElementPresent(WebDriver driver, By by) {
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
	public static boolean isElementDisplay(WebElement e) {
		boolean isDisplay = false;
		try {
			isDisplay = e.isDisplayed();
			logger.info("Verify current element is displayed in the page :" + isDisplay);
		} catch (NoSuchElementException error) {
			logger.info("Sorry,this element not displayed in the page,throw:" + error.getMessage());
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
	public static void highLight(WebDriver driver, WebElement e) {
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
	public static void highLight(WebDriver driver, List<WebElement> list) {
		if (driver instanceof JavascriptExecutor) {
			for (WebElement e : list) {
				executeJS(driver, "arguments[0].style.border='1px solid red'", e);
			}
		}
	}

	public static void highLightExt(WebDriver driver, WebElement e) {
		logger.info("Highlight the element ,the object is:" + e.getTagName() + ",the text in this object is:"
				+ e.getText());
		Actions action = new Actions(driver);
		highLight(driver, e);
		action.contextClick(e).perform();
		logger.info("Had right click the object ,then press the escape key");
		e.sendKeys(Keys.DOWN);
		e.sendKeys(Keys.ENTER);
	}

	public static Object executeJS(WebDriver driver, String script) {
		logger.info("Run the javascript from page ,the java script is:" + script);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		return je.executeScript(script);

	}

	public static Object executeJSReturn(WebDriver driver, String script) {
		logger.info("Run the javascript from page ,the java script is:" + script);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Object object = je.executeScript(script);
		return object;
	}

	public static void executeJS(WebDriver driver, String script, WebElement e) {
		logger.info("Run the javascript from page ,the java script is:" + script);
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
	public static Object executeJSReturn(WebDriver driver, String script, WebElement e) {
		logger.info("Run the javascript from page ,the java script is:" + script);
		// highLight(e);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Object object = je.executeScript(script, e);
		return object;

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
	public static List<WebElement> findElementListByTagName(WebDriver driver, WebElement e, String tagname) {
		logger.info("Find all subelements by Tag Name:" + e.getTagName() + ",the sub elment's tag name is:" + tagname);
		highLight(driver, e);
		List<WebElement> elements = e.findElements(By.tagName(tagname));
		return elements;
	}

	//
	public static List<WebElement> findElementListByClassName(WebDriver driver, String selector) {
		logger.info("Find all subelements by class Name:" + selector);
		List<WebElement> elements = driver.findElements(By.cssSelector(selector));
		highLight(driver, elements);
		return elements;

	}

	public static List<WebElement> findElementListByClassName(WebDriver driver, WebElement element, String className) {
		logger.info("Find centure element's all subelements by class Name:" + className);
		List<WebElement> elements = element.findElements(By.className(className));
		highLight(driver, elements);
		return elements;

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
	public static void sleepSeconds(double seconds) {
		logger.info("Begin to sleep current step for " + seconds + " seconds........");
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
			Thread.sleep((long) (seconds * 1000));
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
	public static void screenShort(WebDriver driver, String filePath) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filePath));
	}

	/**
	 * 
	 * Title: presenceOfElementLocated
	 * 
	 * <p>
	 * Description: checking an element is present on the DOM of a page.whatever
	 * the element visible or invisible is ok.
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param locator
	 * @return : element
	 * 
	 */
	public static WebElement presenceOfElementLocated(WebDriver driver, int seconds, final By locator) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			logger.error("presenceOfElementLocated  : " + e);
		}

		return element;

	}

	/**
	 * Title: invisibilityOfElementLocated
	 * <p>
	 * Description: wait for some seconds, checking that an element is either
	 * invisible or not present on the DOM.
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param locator
	 * @return
	 * 
	 */
	public static Boolean invisibilityOfElementLocated(WebDriver driver, int seconds, final By locator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			logger.error("invisibilityOfElementLocated  : " + e);
		}
		return bool;
	}
}
