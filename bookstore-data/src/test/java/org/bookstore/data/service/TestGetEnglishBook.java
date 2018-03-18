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
public class TestGetEnglishBook {
	private static String lifeEnglish = "https://www.amazon.cn/s/ref=lp_658748051_nr_p_n_binding_browse-b_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658748051%2Cp_n_binding_browse-bin%3A2038564051&bbn=658748051&ie=UTF8&qid=1482111226&rnid=2038547051";
	private static String babyEnglish = "https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658757051%2Cn%3A660669051&bbn=658757051&ie=UTF8&qid=1482111400&rnid=658757051";
	private static String childEnglish = "https://www.amazon.cn/gp/search/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658757051%2Cn%3A660670051&bbn=658757051&ie=UTF8&qid=1482111400&rnid=658757051";
	private static String EnglishReading = "https://www.amazon.cn/gp/search/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658757051%2Cn%3A660671051&bbn=658757051&ie=UTF8&qid=1482111400&rnid=658757051";
	private static String cambEnglish = "https://www.amazon.cn/s/ref=sr_nr_n_4?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658757051%2Cn%3A660673051&bbn=658757051&ie=UTF8&qid=1482111400&rnid=658757051";
	private static String happyStudy = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658757051%2Cn%3A660672051&bbn=658757051&ie=UTF8&qid=1482111649&rnid=658757051";

	private static String businessEnglishLow2High = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658747051%2Cn%3A660587051&qid=1482288191&__mk_zh_CN=亚马逊网站&bbn=660587051&sort=price-asc-rank";
	private static String businessEnglishHigh2Low = "https://www.amazon.cn/s/ref=sr_st_price-desc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658747051%2Cn%3A660587051&qid=1482288197&__mk_zh_CN=亚马逊网站&bbn=660587051&sort=price-desc-rank";
	private static String grade1 = "https://www.amazon.cn/s/ref=lp_658758051_nr_p_n_feature_seven_br_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_feature_seven_browse-bin%3A2152463051&bbn=658758051&ie=UTF8&qid=1482293695&rnid=2152462051";
	private static String grade2 = "https://www.amazon.cn/s/ref=lp_658758051_nr_p_n_feature_seven_br_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_feature_seven_browse-bin%3A2152464051&bbn=658758051&ie=UTF8&qid=1482293863&rnid=2152462051";
	private static String grade3l2h = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_feature_seven_browse-bin%3A2152465051&qid=1482293887&__mk_zh_CN=亚马逊网站&bbn=658758051&sort=price-asc-rank";
	private static String grade3h2l = "https://www.amazon.cn/s/ref=sr_st_price-desc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_feature_seven_browse-bin%3A2152465051&qid=1482293893&__mk_zh_CN=亚马逊网站&bbn=658758051&sort=price-desc-rank";
	private static String grade4 = "https://www.amazon.cn/s/ref=sr_nr_p_n_binding_browse-b_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_feature_seven_browse-bin%3A2152466051%2Cp_n_binding_browse-bin%3A2038564051&bbn=658758051&ie=UTF8&qid=1483409809&rnid=2038547051";
	private static String grade5 = "https://www.amazon.cn/s/ref=sr_nr_p_n_feature_seven_br_4?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_seven_browse-bin%3A2152467051&bbn=658758051&ie=UTF8&qid=1483409887&rnid=2152462051";
	private static String grade6 = "https://www.amazon.cn/s/ref=sr_nr_p_n_feature_seven_br_5?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658758051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_seven_browse-bin%3A2152468051&bbn=658758051&ie=UTF8&qid=1483409907&rnid=2152462051";
	private static String middle1l2h = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152545051&qid=1483411790&__mk_zh_CN=亚马逊网站&bbn=658759051&sort=price-asc-rank";
	private static String middle1h2l = "https://www.amazon.cn/s/ref=sr_st_price-desc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152545051&qid=1483411818&__mk_zh_CN=亚马逊网站&bbn=658759051&sort=price-desc-rank";
	private static String middle2l2h = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152546051&qid=1483411980&__mk_zh_CN=亚马逊网站&bbn=658759051&sort=price-asc-rank";
	private static String middle2h2l = "https://www.amazon.cn/s/ref=sr_st_price-desc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152546051&qid=1483411985&__mk_zh_CN=亚马逊网站&bbn=658759051&sort=price-desc-rank";
	private static String middle3h2l = "https://www.amazon.cn/s/ref=sr_nr_p_n_feature_nine_bro_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152547051&bbn=658759051&sort=price-desc-rank&ie=UTF8&qid=1483423238&rnid=2152544051";
	private static String middle3l2h = "https://www.amazon.cn/s/ref=sr_st_price-asc-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152547051&qid=1483424360&__mk_zh_CN=亚马逊网站&bbn=658759051&sort=price-asc-rank";
	private static String high1 = "https://www.amazon.cn/s/ref=sr_nr_p_n_feature_nine_bro_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152548051&bbn=658759051&sort=price-asc-rank&ie=UTF8&qid=1483424493&rnid=2152544051";
	private static String high2 = "https://www.amazon.cn/s/ref=sr_nr_p_n_feature_nine_bro_4?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152549051&bbn=658759051&sort=price-asc-rank&ie=UTF8&qid=1483436589&rnid=2152544051";
	private static String high3 = "https://www.amazon.cn/s/ref=sr_st_popularity-rank?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A!658391051%2Cn%3A658410051%2Cn%3A658759051%2Cp_n_binding_browse-bin%3A2038564051%2Cp_n_feature_nine_browse-bin%3A2152550051&qid=1483437495&__mk_zh_CN=亚马逊网站&bbn=658759051&sort=popularity-rank";

	// 大学英语
	// 1066
	private static String colleage0_16 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A1600-1900&sort=popularity-rank&qid=1483440458&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=&high-price=16&x=0&y=0";
	// 1096
	private static String colleage16_19 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2100-2300&sort=popularity-rank&qid=1483440429&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=16&high-price=19&x=0&y=0";
	// 933
	private static String colleage19_21 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A1900-2200&sort=popularity-rank&qid=1483440010&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=19&high-price=21&x=0&y=0";
	// 987
	private static String colleage21_23 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2100-2400&sort=popularity-rank&qid=1483440035&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=21&high-price=23&x=0&y=0";
	// 1074
	private static String colleage23_25 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2100-2300&sort=popularity-rank&qid=1483440042&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=23&high-price=25&x=0&y=0";
	// 1055
	private static String colleage25_27 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2500-2800&sort=popularity-rank&qid=1483440108&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=25&high-price=27&x=0&y=0";
	// 943
	private static String colleage27_29 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2700-3000&sort=popularity-rank&qid=1483440136&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=27&high-price=29&x=0&y=0";
	// 1203
	private static String colleage29_32 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2900-3300&sort=popularity-rank&qid=1483440179&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=29&high-price=32&x=0&y=0";
	// 1197
	private static String colleage32_36 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A2900-3200&sort=popularity-rank&qid=1483440183&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=32&high-price=36&x=0&y=0";
	// 1137
	private static String colleage36_45 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A3600-4100&sort=popularity-rank&qid=1483440286&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=36&high-price=45&x=0&y=0";
	// 796
	private static String colleage45 = "https://www.amazon.cn/s/ref=sr_nr_p_36_0?rnid=664971051&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658410051%2Cp_n_binding_browse-bin%3A2038564051%2Cn%3A658751051%2Cp_36%3A4500-10000&sort=popularity-rank&qid=1483440326&__mk_zh_CN=亚马逊网站&bbn=658751051&low-price=45&high-price=&x=0&y=0";
	@Autowired
	GetDataFromAmazon getDataFromAmazon;

	@Test
	public void testLifeEnglish() throws InterruptedException {
		getDataFromAmazon.run(lifeEnglish, "生活实用英语");
	}

	@Test
	public void testBabyEnglish() throws InterruptedException {
		getDataFromAmazon.run(babyEnglish, "幼儿英语");
	}

	// 儿童英语

	@Test
	public void testChildEnglish() throws InterruptedException {
		getDataFromAmazon.run(childEnglish, "少儿英语");
	}

	@Test
	public void testEnglishReading() throws InterruptedException {
		getDataFromAmazon.run(EnglishReading, "英语读物");
	}

	@Test
	public void testCambEnglish() throws InterruptedException {
		getDataFromAmazon.run(cambEnglish, "剑桥少儿英语");
	}

	@Test
	public void testHappyStudy() throws InterruptedException {
		getDataFromAmazon.run(happyStudy, "趣味学习英语");
	}

	// 商务英语
	@Test
	public void testBusinessLow2High() throws InterruptedException {
		getDataFromAmazon.run(businessEnglishLow2High, "商务英语");
	}

	@Test
	public void testBusinessHigh2Low() throws InterruptedException {
		getDataFromAmazon.run(businessEnglishHigh2Low, "商务英语");
	}

	// 小学英语
	@Test
	public void testGrade1() throws InterruptedException {
		getDataFromAmazon.run(grade1, "小学英语-一年级");
	}

	@Test
	public void testGrade2() throws InterruptedException {
		getDataFromAmazon.run(grade2, "小学英语-二年级");
	}

	@Test
	public void testGrade3h2l() throws InterruptedException {
		getDataFromAmazon.run(grade3h2l, "小学英语-三年级");
	}

	@Test
	public void testGrade3l2h() throws InterruptedException {
		getDataFromAmazon.run(grade3l2h, "小学英语-三年级");
	}

	@Test
	public void testGrade4() throws InterruptedException {
		getDataFromAmazon.run(grade4, "小学英语-四年级");
	}

	@Test
	public void testGrade5() throws InterruptedException {
		getDataFromAmazon.run(grade5, "小学英语-五年级");
	}

	@Test
	public void testGrade6() throws InterruptedException {
		getDataFromAmazon.run(grade6, "小学英语-六年级");
	}

	@Test
	public void testMiddle1h2l() throws InterruptedException {
		getDataFromAmazon.run(middle1h2l, "中学英语-初一年级");
	}

	@Test
	public void testMiddle1l2h() throws InterruptedException {
		getDataFromAmazon.run(middle1l2h, "中学英语-初一年级");
	}

	@Test
	public void testMiddle2l2h() throws InterruptedException {
		getDataFromAmazon.run(middle2l2h, "中学英语-初二年级");
	}

	@Test
	public void testMiddle2h2l() throws InterruptedException {
		getDataFromAmazon.run(middle2h2l, "中学英语-初二年级");
	}

	@Test
	public void testMiddle3h2l() throws InterruptedException {
		getDataFromAmazon.run(middle3h2l, "中学英语-初三年级");
	}

	@Test
	public void testMiddle3l2h() throws InterruptedException {
		getDataFromAmazon.run(middle3l2h, "中学英语-初二年级");
	}

	@Test
	public void testHight1() throws InterruptedException {
		getDataFromAmazon.run(high1, "中学英语-高一年级");
	}

	@Test
	public void testHight2() throws InterruptedException {
		getDataFromAmazon.run(high2, "中学英语-高二年级");
	}

	@Test
	public void testHigh3() throws InterruptedException {
		getDataFromAmazon.run(high3, "中学英语-高三年级");
	}

	@Test
	public void testColleage0_16() throws InterruptedException {
		getDataFromAmazon.run(colleage0_16, "大学英语");
	}

	// running
	@Test
	public void testColleage16_19() throws InterruptedException {
		getDataFromAmazon.run(colleage16_19, "大学英语");
	}

	// running
	@Test
	public void testColleage19_21() throws InterruptedException {
		getDataFromAmazon.run(colleage19_21, "大学英语");
	}
	// running
	@Test
	public void testColleage21_23() throws InterruptedException {
		getDataFromAmazon.run(colleage21_23, "大学英语");
	}
	//-------循环调用本页面，调用当前+下一个方法
	@Test
	public void testColleage23_25() throws InterruptedException {
		getDataFromAmazon.run(colleage23_25, "大学英语");
		testColleage25_27();
	}

	@Test
	public void testColleage25_27() throws InterruptedException {
		getDataFromAmazon.run(colleage25_27, "大学英语");
	}
	//----循环调用本页面，调用当前+下一个方法
	@Test
	public void testColleage27_29() throws InterruptedException {
		getDataFromAmazon.run(colleage27_29, "大学英语");
		testColleage29_32();
	}

	@Test
	public void testColleage29_32() throws InterruptedException {
		getDataFromAmazon.run(colleage29_32, "大学英语");
	}
	//----循环调用本页面，调用当前+下一个方法
	@Test
	public void testColleage32_36() throws InterruptedException {
		getDataFromAmazon.run(colleage32_36, "大学英语");
		testColleage36_45();
	}

	@Test
	public void testColleage36_45() throws InterruptedException {
		getDataFromAmazon.run(colleage36_45, "大学英语");
	}
	

	@Test
	public void testColleage45() throws InterruptedException {
		getDataFromAmazon.run(colleage45, "大学英语");
	}
}
