package com.dragon.enterprise.data.spider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bookstore.data.tools.CreateDriver;
import com.bookstore.data.webdriver.utils.ElementUtil;

public class City {

	public static Logger logger = Logger.getLogger(City.class);

	public static void main(String[] args) {
		ChromeDriver driver = CreateDriver.initializeChromeDriver();

		driver.get("http://www.58.com/shangpucs/changecity/");
//		ElementUtil.setWindowMaxSize(driver);
		WebElement parent = ElementUtil.getElement(driver, By.id("clist"));

		List<WebElement> list = ElementUtil.findElementListByTagName(driver, parent, "a");

		System.err.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			String href = list.get(i).getAttribute("href");
			System.out.println(href);
			logger.error(href);
			fileWrite("parent.txt",href);

			// _____
			driver.navigate().to(href);
			WebElement son = ElementUtil.getElement(driver, By.className("pars"));
			WebElement tr = ElementUtil.getElement(driver, son, By.tagName("tr"));
			List<WebElement> sons = ElementUtil.findElementListByTagName(driver, tr, "a");
			for (int j = 0; j < sons.size(); j++) {
				String son_href = sons.get(j).getAttribute("href");
				System.err.println(son_href);
				logger.error(son_href);
				fileWrite("son.txt",son_href);
			}

			driver.navigate().back();
			// -----

			parent = ElementUtil.getElement(driver, By.id("clist"));

			list = ElementUtil.findElementListByTagName(driver, parent, "a");

		}
		driver.close();
	}
	public static void fileWrite(String fileDest,String value) {

		FileWriter fileWriter = null;
		BufferedWriter writer = null;
		try {
			fileWriter = new FileWriter(new File(fileDest), true);
			writer = new BufferedWriter(fileWriter);
			writer.write(value);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e1) {
			}
		}
	}
}
