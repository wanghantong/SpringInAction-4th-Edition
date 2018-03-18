package com.bookstore.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.data.domain.AmazonBook;
import com.bookstore.data.tools.CreateDriver;
import com.bookstore.data.webdriver.repository.AmazonBookRepository;
import com.bookstore.data.webdriver.utils.ElementUtil;

@Service
public class GetDataFromAmazon {
	static Logger log = Logger.getLogger(GetDataFromAmazon.class);
	// amazon 编程与开发栏目
	private static String url = "https://www.amazon.cn/s/ref=lp_658414051_nr_n_0/454-1251602-8298819?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051&bbn=658414051&ie=UTF8&qid=1481080063&rnid=658414051";
	// amazon 编程与开发栏目 第55页
	private static String url2 = "https://www.amazon.cn/s/ref=sr_pg_55?rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051&page=55&ie=UTF8&qid=1481248517";
	// 计算机与互联网/编程与开发/编程语言与工具/.net
	private static String net = "https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663835051&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none";
	// 计算机与互联网/编程与开发/编程语言与工具/ajax
	private static String ajax = "https://www.amazon.cn/s/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416131071&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none";
	// 计算机与互联网/编程与开发/编程语言与工具/asp
	private static String asp = "https://www.amazon.cn/s/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416132071&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none";
	// 计算机与互联网/编程与开发/编程语言与工具/css
	private static String css = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416133071&bbn=660974051&ie=UTF8&qid=1481263990&rnid=660974051";
	// 计算机与互联网/编程与开发/编程语言与工具/delphi
	private static String delphi = "https://www.amazon.cn/s/ref=sr_nr_n_5?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663836051&bbn=660974051&ie=UTF8&qid=1481264074&rnid=660974051";
	private static String html = "https://www.amazon.cn/s/ref=sr_nr_n_6?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416140071&bbn=660974051&ie=UTF8&qid=1481264153&rnid=660974051";
	private static String javascript = "https://www.amazon.cn/s/ref=sr_nr_n_8?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416138071&bbn=660974051&ie=UTF8&qid=1481264153&rnid=660974051";
	private static String jsp = "https://www.amazon.cn/s/ref=sr_nr_n_9?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416139071&bbn=660974051&ie=UTF8&qid=1481264153&rnid=660974051";
	private static String php = "https://www.amazon.cn/s/ref=sr_nr_n_11?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416136071&bbn=660974051&ie=UTF8&qid=1481264256&rnid=660974051";
	private static String python = "https://www.amazon.cn/s/ref=sr_nr_n_12?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663840051&bbn=660974051&ie=UTF8&qid=1481264256&rnid=660974051";
	private static String vb = "https://www.amazon.cn/s/ref=sr_nr_n_13?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663833051&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";
	private static String xml = "https://www.amazon.cn/s/ref=sr_nr_n_15?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416141071&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";
	private static String basic = "https://www.amazon.cn/s/ref=sr_nr_n_16?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663831051&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";

	@Autowired
	AmazonBookRepository AmazonBookRepositoryImpl;

	ChromeDriver driver;

	void urlmanager() {

	}

	public void run(String url, String category) {
		start(url);
		getBookCount();
		// getCurrentPageBookList("mainResults");
		getCurrentPageBookList("s-results-list-atf", category);
		try {
			while (true) {
				try {
					
					if (goToNextPageForAmazon()) {
						quit();
						return;
					} else {
						try {
							getCurrentPageBookList("s-results-list-atf", category);
						} catch (NoSuchElementException e) {
							ElementUtil.sleepSeconds(1);
							// 做个截图
//							ElementUtil.screenShort(driver, ".");
							getCurrentPageBookList("s-results-list-atf", category);
						}
					}
				} catch (org.openqa.selenium.TimeoutException e) {
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					System.out.println("找了两次都没找到s-results-list-atf  ,  ");
					e.printStackTrace();
					//尝试能否回到列表页
					goBack();
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			quit();
		}
	}

	public void start(String url) {
		driver = CreateDriver.initializeChromeDriver();
		driver.get(url);
	}

	/**
	 * 获取当前分类下书籍的总数
	 */
	public void getBookCount() {
		// 确认条数
		WebElement countTextElement = ElementUtil.getElement(driver, By.id("s-result-count"));
		String countText = countTextElement.getText();
		System.out.println("当前分类的名称和图书的总条数  " + countText);
	}

	/**
	 * 获取亚马逊当前页面下所有的书籍信息(15条/页)mainResults
	 */
	public void getCurrentPageBookList(String head, String category) {
		ElementUtil.sleepSeconds(1);
		WebElement mainResults = ElementUtil.getElement(driver, By.id(head));
		List<WebElement> list = ElementUtil.findElementListByTagName(driver, mainResults, "li");
		System.out.println("当前页面要循环  " + list.size() + "   次");
		for (int i = 0; i < list.size(); i++) {
			mainResults = ElementUtil.getElement(driver, By.id(head));
			list = ElementUtil.findElementListByTagName(driver, mainResults, "li");
			ElementUtil.sleepSeconds(1);
			String imageSrc;
			try {
				// __
				WebElement located = ElementUtil.presenceOfElementLocated(driver, 1, By.tagName("img"));
				Boolean invisibilityOfElementLocated = ElementUtil.invisibilityOfElementLocated(driver, 1,
						By.tagName("img"));
				//System.out.println("节点 " + i + " 是否暗藏 ： " + invisibilityOfElementLocated + " -- " + located);
				if (invisibilityOfElementLocated) {
					WebElement img = ElementUtil.getElement(driver, list.get(i), By.tagName("img"));
					imageSrc = img.getAttribute("src");
				} else {
					continue;
				}
			} catch (Exception e) {
//				System.out.println("当前页面是: " + driver.getCurrentUrl() + ",    当前分类是:  " + category);
				continue;
			}

			Map<String, String> map = new HashMap<String, String>();
			map.put("img", imageSrc);
			String href = ElementUtil.getElement(driver, list.get(i), By.tagName("a")).getAttribute("href");
			ElementUtil.sleepSeconds(1);
			// 跳转到详情页
			driver.navigate().to(href);
			// 等待详情页加载
			ElementUtil.sleepSeconds(1);
			List<WebElement> details;
			try {
				WebElement detailElement = ElementUtil.getElement(driver, By.id("detail_bullets_id"));
				details = ElementUtil.findElementListByTagName(driver, detailElement, "li");
			} catch (NoSuchElementException e) {
				System.err.println("在这个页面出错了... " + driver.getCurrentUrl());
				continue;
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			map.put("出版社", "");
			map.put("外文书名", "");
			map.put("平装", "");
			map.put("ISBN", "");
			map.put("条形码", "");
			map.put("amazonUrl", href);

			for (int k = 0; k < details.size(); k++) {
				String text = details.get(k).getText();
				map = cutPress(map, text);
			}

			Map<String, String> createMap = createMap(map);

			AmazonBook abook = new AmazonBook();
			// System.out.println(createMap);
			if (createMap.get("ISBN10") == "" || createMap.get("ISBN13") == "") {
				log.error(createMap);
				driver.navigate().back();
				continue;
			}
			abook.setIsbn10(createMap.get("ISBN10"));
			abook.setIsbn13(createMap.get("ISBN13"));
			abook.setImg(createMap.get("img"));
			abook.setCode(createMap.get("条形码"));
			abook.setOrigin_title(createMap.get("外文书名"));
			abook.setPress(createMap.get("出版社"));
			abook.setAmazonUrl(createMap.get("amazonUrl"));
			abook.setCategory(category);

			// 保存到数据库
			AmazonBookRepositoryImpl.save(abook);

			ElementUtil.sleepSeconds(1);

			driver.navigate().back();
		}

	}

	public void quit() {
		driver.quit();
	}

	/**
	 * 获取图书的基本信息
	 * 
	 * @param map
	 *            封装图书信息
	 * @param press
	 * @return
	 */
	public Map<String, String> cutPress(Map<String, String> map, String kv) {
		String[] split = kv.split(":");
		if (split.length > 1) {
			String key = split[0].trim();
			if (map.containsKey(key)) {
				map.replace(key, split[1].trim());
			}
			return map;
		}
		return map;
	}

	/**
	 * 封装成可以转换为bean的map
	 * 
	 * @param map
	 * @param result
	 * @return
	 */
	public Map<String, String> createMap(Map<String, String> map) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("出版社", map.get("出版社"));
		result.put("外文书名", map.get("外文书名"));
		result.put("条形码", map.get("条形码"));
		result.put("img", map.get("img"));
		result.put("amazonUrl", map.get("amazonUrl"));

		String isbn = map.get("ISBN");
		String[] split = isbn.split(",");
		if (split.length == 2) {
			if (split[0].length() == 10) {
				result.put("ISBN10", split[0].trim());
				result.put("ISBN13", split[1].trim());
			} else {
				result.put("ISBN10", split[1].trim());
				result.put("ISBN13", split[0].trim());
			}
		}
		if (split.length == 1) {
			if (split[0].length() == 10) {
				result.put("ISBN10", split[0].trim());
			}
			result.put("ISBN13", split[0].trim());
		}
		return result;
	}

	/**
	 * 
	 */
	public boolean goToNextPageForAmazon() {
		WebElement bottomBarElement = ElementUtil.getElement(driver, By.id("bottomBar"));
		// 取出当前是第几页
		WebElement currentPageElement = ElementUtil.getElement(driver, bottomBarElement, By.className("pagnCur"));
		String currentPage = currentPageElement.getText().trim();
		System.out.println("currentPage  " + currentPage);
		// // 找出最大页数(默认75页)
		// WebElement sumPagesElement = ElementUtil.getElement(driver,
		// bottomBarElement, By.className("pagnDisabled"));
		// System.err.println(sumPagesElement.getText());
		// span的父元素
		WebElement pagnElement = ElementUtil.getElement(driver, bottomBarElement, By.id("pagn"));
		// 找出所有的span
		List<WebElement> spans = ElementUtil.findElementListByTagName(driver, pagnElement, "span");
		// 求出总页数
		String totalPages = spans.get(spans.size() - 4).getText().trim();
		System.out.println("totalPages  : " + totalPages);
		if (Integer.parseInt(totalPages) == Integer.parseInt(currentPage)) {
			System.out.println("当前页面已经是该分类下的最后一页了");
			return true;
		}
		for (WebElement span : spans) {
			if (span.getText().trim().equals(Integer.parseInt(currentPage) + 1 + "")
			// && !currentPage.equals(sumPagesElement.getText().trim())
			) {
				String url = ElementUtil.getElement(driver, span, By.tagName("a")).getAttribute("href");
				driver.navigate().to(url);
				break;
			}
		}
		return false;
	}

	private void goBack() {
		System.err.println("尝试回到列表页......");
		driver.navigate().back();
	}
}
