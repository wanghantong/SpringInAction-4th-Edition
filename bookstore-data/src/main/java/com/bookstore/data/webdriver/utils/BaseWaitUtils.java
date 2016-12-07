/**

 * create time ：2014年5月4日 下午2:53:25

 * project name：exam

 * @author T.Y

 * @version 1.0

 * @since JDK 1.7

 * file name：BaseWaitUtils.java

 * class info：

 */
package com.bookstore.data.webdriver.utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWaitUtils {

	public static Logger logger = Logger.getLogger(BaseUtils.class);

	public static void defaultImplicitlyWait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try {
			WebElement dynamicElement = driver.findElement(By.id("second"));
			System.err.println(dynamicElement.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Title: textToBePresentInElement
	 * 
	 * <p>
	 * Description:wait some seconds to load the page, judge the given text is
	 * present in the specified element
	 * </p>
	 * 
	 * @param element
	 * @param driver
	 * @param text
	 * @param seconds
	 *            : wait time
	 * @return
	 * 
	 */
	public static Boolean textToBePresentInElement(WebDriver driver,
			int seconds, WebElement element, final String text) {
		// the default delay is 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions.textToBePresentInElement(
					element, text));
		} catch (TimeoutException e) {
			logger.error("textToBePresentInElement  : " + e);
		}

		return bool;

	}

	/**
	 * 
	 * Title: textToBePresentInElementLocated
	 * 
	 * <p>
	 * Description: wait for some seconds , then the given text is present in
	 * the element that matches the given locator.
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param locator
	 * @param text
	 * @return the result of find
	 * 
	 */
	public static Boolean textToBePresentInElementLocated(WebDriver driver,
			int seconds, final By locator, final String text) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions
					.textToBePresentInElementLocated(locator, text));
		} catch (TimeoutException e) {
			logger.error("textToBePresentInElementLocated  : " + e);
		}

		return bool;

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
	public static WebElement presenceOfElementLocated(WebDriver driver,
			int seconds, final By locator) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions
					.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			logger.error("presenceOfElementLocated  : " + e);
		}

		return element;

	}

	/**
	 * 
	 * Title: elementToBeClickableBy
	 * 
	 * <p>
	 * Description: wait for some seconds, checking an element is visible and
	 * enabled such that you can click it.
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param locator
	 * @return
	 * 
	 */
	public WebElement elementToBeClickableBy(WebDriver driver, int seconds,
			final By locator) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions
					.elementToBeClickable(locator));
		} catch (Exception e) {
			logger.error("elementToBeClickableBy  : " + e);
		}
		return element;

	}

	/**
	 * 
	 * Title: elementToBeClickableByElement
	 * 
	 * <p>
	 * Description: wait for some seconds, checking an element is visible and
	 * enabled such that you can click it.
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param element
	 * @return
	 * 
	 */
	public static WebElement elementToBeClickableByElement(WebDriver driver,
			int seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		try {
			element = wait.until(ExpectedConditions
					.elementToBeClickable(element));
		} catch (Exception e) {
			logger.error("elementToBeClickableByElement  : " + e);
		}

		return element;
	}

	/**
	 * 
	 * Title: elementToBeSelectedByElement
	 * 
	 * <p>
	 * Description: wait for some seconds, checking if the given element is
	 * selected
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param element
	 * @return
	 * 
	 */
	public static Boolean elementToBeSelectedByElement(WebDriver driver,
			int seconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (Exception e) {
			logger.error("elementToBeSelectedByElement  : " + e);
		}
		return bool;

	}

	/**
	 * 
	 * Title: elementToBeSelectedBy
	 * 
	 * <p>
	 * Description: checking if the given element is selected
	 * </p>
	 * 
	 * @param driver
	 * @param seconds
	 * @param locator
	 * @return
	 * 
	 */
	public static Boolean elementToBeSelectedBy(WebDriver driver, int seconds,
			final By locator) {

		WebDriverWait wait = new WebDriverWait(driver, seconds);

		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions.elementToBeSelected(locator));
		} catch (Exception e) {
			logger.error("elementToBeSelectedBy  : " + e);
		}

		return bool;

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
	public static Boolean invisibilityOfElementLocated(WebDriver driver,
			int seconds, final By locator) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions
					.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			logger.error("invisibilityOfElementLocated  : " + e);
		}
		return bool;
	}

	/**
	 * 
	 * Title: invisibilityOfElementWithText
	 * 
	 * <p>
	 * Description: An expectation for checking that an element with text is
	 * either invisible or not present on the DOM.
	 * </p>
	 * 
	 * @param locator
	 *            used to find the element
	 * @param text
	 *            of the element
	 * @param driver
	 * @param seconds
	 * @return
	 * 
	 */
	public static Boolean invisibilityOfElementWithText(WebDriver driver,
			int seconds, final By locator, final String text) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Boolean bool = false;
		try {
			bool = wait.until(ExpectedConditions.invisibilityOfElementWithText(
					locator, text));
		} catch (Exception e) {
			logger.error("invisibilityOfElementWithText  : " + e);
		}
		return bool;
	}

	/**
	 * Sets the amount of time to wait for a page load to complete before
	 * throwing an error. If the timeout is negative, page loads can be
	 * indefinite.
	 * 
	 * @param time
	 *            The timeout value.
	 * @param unit
	 *            The unit of time.
	 * @return A Timeouts interface.
	 */
	public static void pageLoadTimeout(long seconds, TimeUnit unit) {

	}

}
