package org.bookstore.data.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bookstore.data.service.GetDataFromAmazon;
import com.bookstore.data.webdriver.repository.RepositoryConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class TestOffice {

	private static String office = "https://www.amazon.cn/s/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A116087071%2Cn%3A%21116088071%2Cn%3A116169071%2Cn%3A143359071%2Cn%3A143362071&bbn=143359071&ie=UTF8&qid=1481677345&rnid=143359071";
	private static String visio = "https://www.amazon.cn/s/ref=sr_nr_n_6?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658806051%2Cn%3A660926051%2Cn%3A663803051%2Cn%3A664875051&bbn=663803051&ie=UTF8&qid=1481677524&rnid=663803051";
	private static String powerPoint = "https://www.amazon.cn/s/ref=sr_nr_n_4?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658806051%2Cn%3A660926051%2Cn%3A663803051%2Cn%3A664872051&bbn=663803051&ie=UTF8&qid=1481677584&rnid=663803051";
	private static String word = "https://www.amazon.cn/s/ref=sr_nr_n_5?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658806051%2Cn%3A660926051%2Cn%3A663803051%2Cn%3A664870051&bbn=663803051&ie=UTF8&qid=1481677584&rnid=663803051";
	private static String excelLow2High = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658414051%2Cn%3A658806051%2Cn%3A660926051%2Cn%3A663803051%2Cn%3A664871051&qid=1481677709&__mk_zh_CN=亚马逊网站&bbn=663803051&sort=price-asc-rank";
	private static String excelHigh2Low = "https://www.amazon.cn/s/ref=sr_st_price-desc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658414051%2Cn%3A658806051%2Cn%3A660926051%2Cn%3A663803051%2Cn%3A664871051&qid=1481677716&__mk_zh_CN=亚马逊网站&bbn=663803051&sort=price-desc-rank";
	private static String outlook = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658806051%2Cn%3A660926051%2Cn%3A663803051%2Cn%3A664873051&bbn=663803051&sort=price-desc-rank&ie=UTF8&qid=1481678113&rnid=663803051";

	@Autowired
	GetDataFromAmazon getDataFromAmazon;

	@Test
	public void testVisio() throws InterruptedException {
		getDataFromAmazon.run(visio, "office");
	}

	@Test
	public void testPowerPoint() throws InterruptedException {
		getDataFromAmazon.run(powerPoint, "office");
	}

	@Test
	public void testWord() throws InterruptedException {
		getDataFromAmazon.run(word, "office");
	}

	@Test
	public void testExcelLow2High() throws InterruptedException {
		getDataFromAmazon.run(excelLow2High, "office");
	}

	@Test
	public void testExcelHigh2Low() throws InterruptedException {
		getDataFromAmazon.run(excelHigh2Low, "office");
	}

	@Test
	public void testOutlook() throws InterruptedException {
		getDataFromAmazon.run(outlook, "office");
	}

}
