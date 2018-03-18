package com.bookstore.data.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bookstore.data.tools.CreateDriver;
import com.bookstore.data.webdriver.utils.ElementUtil;

public class DataTransfer {

	static Logger log = Logger.getLogger(DataTransfer.class);
	// amazon 编程与开发栏目
	private static String url = "https://www.amazon.cn/s/ref=lp_658414051_nr_n_0/454-1251602-8298819?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051&bbn=658414051&ie=UTF8&qid=1481080063&rnid=658414051";

	public void getData() throws InterruptedException {
		
		ChromeDriver driver = CreateDriver.initializeChromeDriver();
		driver.get(url);
		ElementUtil.setWindowMaxSize(driver);
		Thread.sleep(1000);
		// 确认条数
		WebElement countTextElement = ElementUtil.getElement(driver, By.id("s-result-count"));
		String countText = countTextElement.getText();
		System.out.println("当前分类的名称和图书的总条数  " + countText);
		WebElement mainResults = ElementUtil.getElement(driver, By.id("mainResults"));
		List<WebElement> list = ElementUtil.findElementListByTagName(driver, mainResults, "li");

		for (int i = 0; i < list.size(); i++) {
			mainResults = ElementUtil.getElement(driver, By.id("mainResults"));
			list = ElementUtil.findElementListByTagName(driver, mainResults, "li");

			String imageSrc = ElementUtil.getElement(driver, list.get(i), By.tagName("img")).getAttribute("src");
			System.out.println(imageSrc);

			String href = ElementUtil.getElement(driver, list.get(i), By.tagName("a")).getAttribute("href");
			Thread.sleep(3000);
			driver.navigate().to(href);
			ElementUtil.setWindowMaxSize(driver);
			Thread.sleep(3000);
			WebElement detailElement = ElementUtil.getElement(driver, By.id("detail_bullets_id"));
			List<WebElement> details = ElementUtil.findElementListByTagName(driver, detailElement, "li");
			for (int k = 0; k < details.size(); k++) {
				String text = details.get(k).getText();
				System.out.println(text);
			}

			driver.navigate().back();
		}

		driver.quit();
	}
}
