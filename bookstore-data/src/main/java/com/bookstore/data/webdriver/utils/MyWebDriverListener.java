/**

 * 创建时间：Apr 16, 2014 3:22:07 PM

 * 项目名称：TYTestLib

 * @author T.Y

 * @version 1.0

 * @since JDK 1.7

 * 文件名称：MyWebDriverListener.java

 * 类说明：

 */
package com.bookstore.data.webdriver.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.bookstore.data.tools.DateFormat;

public class MyWebDriverListener implements WebDriverEventListener {

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("beforeNavigateTo方法传入参数url : " + url);
		String currentUrl = driver.getCurrentUrl();
		System.out.println("跳转之前的页面url为：" + currentUrl);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		String currentUrl = driver.getCurrentUrl();
		System.out.println("跳转之后的页面url为：" + currentUrl);
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {

	}

	@Override
	public void afterNavigateBack(WebDriver driver) {

	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {

	}

	@Override
	public void afterNavigateForward(WebDriver driver) {

	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("listener   beforeFindBy  ");
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(" listener afterFindby");
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(" listener beforeClickOn");

	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(" listener afterClickOn");

	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		System.out.println(" listener beforeScript");

	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		System.out.println(" listener afterScript");

	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		String dateString = DateFormat.dateChange(new Date(),
				"yyyy-mm-dd hh-mm-ss");
		try {
			// 获取当前截图
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			// 创建图片文件
			File screenShot = new File("test-output/exception/" + dateString
					+ ".png");
			// 拷贝文件
			FileUtils.copyFile(scrFile, screenShot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("发生异常 : " + throwable.getMessage());
		System.out.println("截图已保存至：test-output/exception/" + dateString
				+ ".png");
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

}
