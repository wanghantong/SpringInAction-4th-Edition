package org.bookstore.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookstore.data.service.DataTransfer;
import com.bookstore.data.service.GetDataFromAmazon;
import com.bookstore.data.service.GetDataFromDouban;
import com.bookstore.data.tools.CreateDriver;
import com.bookstore.data.webdriver.repository.RepositoryConfig;
import com.bookstore.data.webdriver.utils.ElementUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class TestService {
	@Autowired
	GetDataFromAmazon getDataFromAmazon;

	@Test
	public void testGetData() throws InterruptedException {
		new DataTransfer().getData();
	}

	@Test
	public void testRun() throws InterruptedException {
		getDataFromAmazon.run("", "");
	}

	@Test
	public void testCut() {

		String[] cases = new String[] { "出版社: 人民邮电出版社; 第2版 (2014年11月1日)", "外文书名: Beauty of Mathematics", "平装: 312页",
				"语种: 简体中文", "ISBN: 9787115373557, 7115373558", "条形码: 9787115373557", "条形码9787115373557" };
		GetDataFromAmazon amazon = new GetDataFromAmazon();
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		map.put("出版社", "");
		map.put("外文书名", "");
		map.put("平装", "");
		map.put("ISBN", "");
		map.put("条形码", "");

		for (int i = 0; i < cases.length; i++) {
			amazon.cutPress(map, cases[i]);
		}
		map2.put("出版社", map.get("出版社"));
		map2.put("外文书名", map.get("外文书名"));
		map2.put("条形码", map.get("条形码"));

		String isbn = map.get("ISBN");
		String[] split = isbn.split(",");
		if (split.length == 2) {
			if (split[0].length() == 10) {
				map2.put("ISBN10", split[0].trim());
				map2.put("ISBN13", split[1].trim());
			} else {
				map2.put("ISBN10", split[1].trim());
				map2.put("ISBN13", split[0].trim());
			}
		}
		if (split.length == 1) {
			if (split[0].length() == 10) {
				map2.put("ISBN10", split[0].trim());
			}
			map2.put("ISBN13", split[0].trim());
		}

	}

	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("出版社", "");
		map.put("外文书名", "");
		map.put("平装", "");
		map.put("ISBN", "");
		map.put("条形码", "");

		if (map.containsKey("出版社")) {
			map.replace("出版社", "not null");
		}
		System.out.println(map);
	}

	@Test
	public void testMap2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("出版社", "");
		map.put("外文书名", "");
		map.put("平装", "1111");
		map.put("ISBN", "");
		map.put("条形码", "");
		map.put("条形码", "xx");
		map.clear();
		map.put("条形码", "xxx");
		System.out.println(map);
	}

	@Test
	public void testString() {
		System.err.println(Integer.parseInt("3") + 1 + "");
	}

	@Test
	public void testTurnPage() {
		GetDataFromAmazon amazon = new GetDataFromAmazon();
		amazon.start("null");
		try {
			for (int i = 0; i < 75; i++) {
				amazon.goToNextPageForAmazon();
			}
		} catch (Exception e) {
			e.printStackTrace();
			amazon.quit();
		}

	}

	@Test
	public void testfindImg() {
		ChromeDriver driver = CreateDriver.initializeChromeDriver();
		driver.get(
				"https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663835051&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none");
		WebElement element = ElementUtil.getElement(driver, By.id("s-results-list-atf"));
		List<WebElement> list = ElementUtil.findElementListByTagName(driver, element, "li");
		System.out.println(list.size());
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			try {
				WebElement located = ElementUtil.presenceOfElementLocated(driver, 1, By.tagName("img"));
				Boolean invisibilityOfElementLocated = ElementUtil.invisibilityOfElementLocated(driver, 1,
						By.tagName("img"));
				System.out.println("节点 " + i + " 是否可见 ： " + invisibilityOfElementLocated + " -- " + located);
				if (invisibilityOfElementLocated) {
					WebElement img = ElementUtil.getElement(driver, list.get(i), By.tagName("img"));
					System.err.println(img.getAttribute("src"));
					sum ++;
				} else {
				}
			} catch (Exception e) {
				
			}
		}
		System.out.println("sum ==  "+sum );
		driver.quit();

	}
	
	@Test
	public void testHttpClient() throws Exception {
		GetDataFromDouban douban = new GetDataFromDouban();
		douban.fetchDataByDouban("9787111399179");
		
		//{"rating":{"max":10,"numRaters":0,"average":"0.0","min":0},"subtitle":"","author":["陈益才"],"pubdate":"2012-11","tags":[{"count":1,"name":"ewr","title":"ewr"}],"origin_title":"","image":"https://img3.doubanio.com\/mpic\/s24438185.jpg","binding":"","translator":[],"catalog":"","pages":"459","images":{"small":"https://img3.doubanio.com\/spic\/s24438185.jpg","large":"https://img3.doubanio.com\/lpic\/s24438185.jpg","medium":"https://img3.doubanio.com\/mpic\/s24438185.jpg"},"alt":"https:\/\/book.douban.com\/subject\/20283154\/","id":"20283154","publisher":"","isbn10":"711139917X","isbn13":"9787111399179","title":"Dreamweaver CS5+ASP动态网站建设从入门到精通","url":"https:\/\/api.douban.com\/v2\/book\/20283154","alt_title":"","author_intro":"","summary":"《Dreamweaver CS5+ASP动态网站建设从入门到精通(第2版)》是一本关于动态网站开发的技术图书，专门为初次接触动态网站开发的读者而写作，是读者迈向动态网站开发的第一步。《Dreamweaver CS5+ASP动态网站建设从入门到精通(第2版)》以Dreamweaver CS5+ASP为开发平台，从基本的动态网站入门知识到高端的动态网站建设进程，通过剖析大量商业应用实例，引导读者逐步掌握动态网站开发的方法。","price":"79.80元"}

	}
}
