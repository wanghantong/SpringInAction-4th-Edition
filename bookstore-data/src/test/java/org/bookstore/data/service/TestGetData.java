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
public class TestGetData {
	private static String net1 = "https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663835051&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none";
	private static String net2 = "https://www.amazon.cn/s/ref=sr_pg_43?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663835051&page=43&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481515800&lo=none,";
	private static String net = "https://www.amazon.cn/s/ref=sr_pg_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663835051&page=50&bbn=660974051&ie=UTF8&qid=1481521504";
	// 计算机与互联网/编程与开发/编程语言与工具/ajax
	private static String ajax = "https://www.amazon.cn/s/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416131071&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none";
	// 计算机与互联网/编程与开发/编程语言与工具/asp
	private static String asp = "https://www.amazon.cn/s/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416132071&bbn=660974051&sort=price-desc-rank&ie=UTF8&qid=1481261129&rnid=660974051&lo=none";
	// 计算机与互联网/编程与开发/编程语言与工具/css
	private static String css = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416133071&bbn=660974051&ie=UTF8&qid=1481263990&rnid=660974051";
	// 计算机与互联网/编程与开发/编程语言与工具/delphi
	private static String delphi1 = "https://www.amazon.cn/s/ref=sr_nr_n_5?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663836051&bbn=660974051&ie=UTF8&qid=1481264074&rnid=660974051";
	private static String delphi = "https://www.amazon.cn/s/ref=sr_pg_67?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663836051&page=67&bbn=660974051&ie=UTF8&qid=1481531043";

	private static String html = "https://www.amazon.cn/s/ref=sr_nr_n_6?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416140071&bbn=660974051&ie=UTF8&qid=1481264153&rnid=660974051";
	private static String javascript = "https://www.amazon.cn/s/ref=sr_nr_n_8?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416138071&bbn=660974051&ie=UTF8&qid=1481264153&rnid=660974051";
	private static String jsp = "https://www.amazon.cn/s/ref=sr_nr_n_9?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416139071&bbn=660974051&ie=UTF8&qid=1481264153&rnid=660974051";
	private static String php = "https://www.amazon.cn/s/ref=sr_nr_n_11?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416136071&bbn=660974051&ie=UTF8&qid=1481264256&rnid=660974051";
	private static String python = "https://www.amazon.cn/s/ref=sr_nr_n_12?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663840051&bbn=660974051&ie=UTF8&qid=1481264256&rnid=660974051";
	private static String vb = "https://www.amazon.cn/s/ref=sr_nr_n_13?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663833051&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";
	private static String vc = "https://www.amazon.cn/s/ref=sr_nr_n_14?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416134071&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";
	private static String xml = "https://www.amazon.cn/s/ref=sr_nr_n_15?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A1416141071&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";
	private static String basic = "https://www.amazon.cn/s/ref=sr_nr_n_16?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663831051&bbn=660974051&ie=UTF8&qid=1481264299&rnid=660974051";
	// Java价格从低开始--还需要降序执行一次
	private static String java2 = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663834051&qid=1481524876&__mk_zh_CN=亚马逊网站&bbn=660974051&sort=price-asc-rank";
	private static String java1 = "https://www.amazon.cn/s/ref=sr_pg_10?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663834051&page=10&bbn=660974051&sort=price-asc-rank&ie=UTF8&qid=1481530720";
	private static String java = "https://www.amazon.cn/s/ref=sr_st_price-desc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663834051&qid=1481585881&__mk_zh_CN=亚马逊网站&bbn=660974051&sort=price-desc-rank";
	// https://www.amazon.cn/s/ref=sr_pg_74?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663834051&page=74&bbn=660974051&sort=price-asc-rank&ie=UTF8&qid=1481547781

	// 五星及以上
	private static String c5_1 = "https://www.amazon.cn/s/ref=sr_nr_p_72_mrr_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039727051&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481525225&rnid=664973051";
	private static String c5 = "https://www.amazon.cn/s/ref=sr_pg_7?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039727051&page=7&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481530281";
	// 四星及以上
	private static String c4_2 = "https://www.amazon.cn/s/ref=sr_nr_p_72_mrr_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039714051&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481525279&rnid=664973051";
	private static String c4_1 = "https://www.amazon.cn/gp/search/ref=sr_nr_n_4?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cp_72%3A2039714051%2Cn%3A663832051&bbn=660974051&sort=price-asc-rank&ie=UTF8&qid=1481533213&rnid=660974051";
	private static String c4 = "https://www.amazon.cn/s/ref=sr_pg_41?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cp_72%3A2039714051%2Cn%3A663832051&page=41&bbn=660974051&sort=price-asc-rank&ie=UTF8&qid=1481543550";

	// 三星及以上
	private static String c3_1 = "https://www.amazon.cn/s/ref=sr_nr_p_72_mrr_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039715051&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481525290&rnid=664973051";
	private static String c3 = "https://www.amazon.cn/s/ref=sr_pg_58?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039715051&page=58&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481545868";
	// 二星及以上
	private static String c2 = "https://www.amazon.cn/s/ref=sr_nr_p_72_mrr_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039716051&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481525309&rnid=664973051";
	// 一星及以上
	private static String c1_1 = "https://www.amazon.cn/s/ref=sr_nr_p_72_mrr_4?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039717051&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481525318&rnid=664973051";
	private static String c1 = "https://www.amazon.cn/s/ref=sr_pg_44?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039717051&page=44&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481546064";
	// https://www.amazon.cn/s/ref=sr_pg_46?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658810051%2Cn%3A660974051%2Cn%3A663832051%2Cp_72%3A2039717051&page=46&bbn=663832051&sort=price-asc-rank&ie=UTF8&qid=1481547888

	private static String cloud = "https://www.amazon.cn/s/ref=sr_st_popularity-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658414051%2Cn%3A1416151071&qid=1481585981&__mk_zh_CN=亚马逊网站&bbn=658414051&sort=popularity-rank";

	private static String security_net = "https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658816051%2Cn%3A661035051&bbn=658816051&sort=popularity-rank&ie=UTF8&qid=1481586119&rnid=658816051";
	private static String security_data = "https://www.amazon.cn/s/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658816051%2Cn%3A661034051&bbn=658816051&sort=popularity-rank&ie=UTF8&qid=1481586350&rnid=658816051";
	private static String security_pass = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658816051%2Cn%3A661037051&bbn=658816051&sort=popularity-rank&ie=UTF8&qid=1481586350&rnid=658816051";
	private static String mysql = "https://www.amazon.cn/s/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660989051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481591097&rnid=658811051";
	private static String oracle = "https://www.amazon.cn/s/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660987051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481591245&rnid=658811051";
	private static String sqlserver = "https://www.amazon.cn/s/ref=sr_nr_n_5?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660990051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481598449&rnid=658811051";
	private static String dig = "https://www.amazon.cn/s/ref=sr_nr_n_10?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660983051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481598449&rnid=658811051";
	private static String theory = "https://www.amazon.cn/gp/search/ref=sr_nr_n_7?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660981051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481598449&rnid=658811051";
	private static String databaseDesign = "https://www.amazon.cn/s/ref=sr_nr_n_8?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660984051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481599234&rnid=658811051";
	private static String databaseType = "https://www.amazon.cn/s/ref=sr_nr_n_9?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658811051%2Cn%3A660982051&bbn=658811051&sort=popularity-rank&ie=UTF8&qid=1481599735&rnid=658811051";
	private static String ai = "https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658819051%2Cn%3A661050051&bbn=658819051&sort=popularity-rank&ie=UTF8&qid=1481601136&rnid=658819051";
	private static String aim = "https://www.amazon.cn/s/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658819051%2Cn%3A661051051&bbn=658819051&sort=popularity-rank&ie=UTF8&qid=1481601199&rnid=658819051";
	private static String ais = "https://www.amazon.cn/s/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658819051%2Cn%3A661052051&bbn=658819051&sort=popularity-rank&ie=UTF8&qid=1481603171&rnid=658819051";
	private static String vr = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658819051%2Cn%3A661053051&bbn=658819051&sort=popularity-rank&ie=UTF8&qid=1481607394&rnid=658819051";
	// private static String security = "";

	@Autowired
	GetDataFromAmazon getDataFromAmazon;

	@Test
	public void testNet() throws InterruptedException {
		getDataFromAmazon.run(net, ".net");
	}

	@Test
	public void testAjax() throws InterruptedException {
		getDataFromAmazon.run(ajax, "Ajax");
	}

	@Test
	public void testAsp() throws InterruptedException {
		getDataFromAmazon.run(asp, "ASP");
	}

	@Test
	public void testCss() throws InterruptedException {
		getDataFromAmazon.run(css, "Css");
	}

	@Test
	public void testDelphi() throws InterruptedException {
		getDataFromAmazon.run(delphi, "Delphi");
	}

	@Test
	public void testHtml() throws InterruptedException {
		getDataFromAmazon.run(html, "HTML");
	}

	@Test
	public void tesJavaScript() throws InterruptedException {
		getDataFromAmazon.run(javascript, "JavaScript");
	}

	@Test
	public void testJsp() throws InterruptedException {
		getDataFromAmazon.run(jsp, "JSP");
	}

	@Test
	public void testPhp() throws InterruptedException {
		getDataFromAmazon.run(php, "PHP");
	}

	@Test
	public void testPython() throws InterruptedException {
		getDataFromAmazon.run(python, "Python");
	}

	@Test
	public void testVb() throws InterruptedException {
		getDataFromAmazon.run(vb, "Visual Basic");
	}

	@Test
	public void testVc() throws InterruptedException {
		getDataFromAmazon.run(vc, "Visual C++");
	}

	@Test
	public void testXml() throws InterruptedException {
		getDataFromAmazon.run(xml, "XML");
	}

	@Test
	public void testBasic() throws InterruptedException {
		getDataFromAmazon.run(basic, "汇编语言");
	}

	@Test
	public void testC5() throws InterruptedException {
		getDataFromAmazon.run(c5, "C语言");
	}

	@Test
	public void testC4() throws InterruptedException {
		getDataFromAmazon.run(c4, "C语言");
	}

	@Test
	public void testC3() throws InterruptedException {
		getDataFromAmazon.run(c3, "C语言");
	}

	@Test
	public void testC2() throws InterruptedException {
		getDataFromAmazon.run(c2, "C语言");
	}

	@Test
	public void testC1() throws InterruptedException {
		getDataFromAmazon.run(c1, "C语言");
	}

	@Test
	public void testJava() throws InterruptedException {
		getDataFromAmazon.run(java, "Java");
	}

	@Test
	public void testCloud() throws InterruptedException {
		getDataFromAmazon.run(cloud, "cloud");
	}

	@Test
	public void testSecurity_pass() throws InterruptedException {
		getDataFromAmazon.run(security_pass, "Security");
	}

	@Test
	public void testSecurity_data() throws InterruptedException {
		getDataFromAmazon.run(security_data, "Security");
	}

	@Test
	public void testSecurity_net() throws InterruptedException {
		getDataFromAmazon.run(security_net, "Security");
	}

	@Test
	public void testMysql() throws InterruptedException {
		getDataFromAmazon.run(mysql, "mysql");
	}

	@Test
	public void testOracle() throws InterruptedException {
		getDataFromAmazon.run(oracle, "oracle");
	}

	@Test
	public void testDatabase() throws InterruptedException {
		getDataFromAmazon.run(sqlserver, "SQLServer");
	}

	@Test
	public void testDig() throws InterruptedException {
		getDataFromAmazon.run(dig, "database");
	}

	@Test
	public void testTheroy() throws InterruptedException {
		getDataFromAmazon.run(theory, "database");
	}

	@Test
	public void testDatabaseDesign() throws InterruptedException {
		getDataFromAmazon.run(databaseDesign, "database");
	}

	@Test
	public void testDatabaseType() throws InterruptedException {
		getDataFromAmazon.run(databaseType, "database");
	}

	@Test
	public void testAI() throws InterruptedException {
		getDataFromAmazon.run(ai, "AI");
	}

	@Test
	public void testAIM() throws InterruptedException {
		getDataFromAmazon.run(aim, "AI");
	}

	@Test
	public void testAIS() throws InterruptedException {
		getDataFromAmazon.run(ais, "AI");
	}

	@Test
	public void testVR() throws InterruptedException {
		getDataFromAmazon.run(vr, "VR");
	}

}
