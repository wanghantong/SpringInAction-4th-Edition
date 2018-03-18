package com.dragon.enterprise.data.spider;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bookstore.data.tools.CreateDriver;
import com.bookstore.data.webdriver.utils.ElementUtil;

public class Direct {
public static void main(String[] args) {
	ChromeDriver driver = CreateDriver.initializeChromeDriver();
	driver.get("http://haibei.58.com/shangpucs/");
	ElementUtil.setWindowMaxSize(driver);
	WebElement parent = ElementUtil.getElement(driver, By.className("pars"));
	WebElement tr = ElementUtil.getElement(driver, parent, By.tagName("tr"));
	
	List<WebElement> list = ElementUtil.findElementListByTagName(driver, tr, "a");
	
	for (int i = 0;i<list.size();i++) {
		String href = list.get(i).getAttribute("href");
		System.err.println(href);
	}
	

}
}
