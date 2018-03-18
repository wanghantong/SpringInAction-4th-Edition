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
public class TestGetHardware {

	private static String cpu = "https://www.amazon.cn/s/ref=sr_nr_n_0?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658815051%2Cn%3A661027051&bbn=658815051&sort=popularity-rank&ie=UTF8&qid=1481609594&rnid=658815051";
	private static String arm = "https://www.amazon.cn/s/ref=sr_nr_n_1?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658815051%2Cn%3A661030051&bbn=658815051&sort=popularity-rank&ie=UTF8&qid=1481609663&rnid=658815051";
	private static String dsp = "https://www.amazon.cn/s/ref=sr_nr_n_2?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658815051%2Cn%3A661028051&bbn=658815051&sort=popularity-rank&ie=UTF8&qid=1481609699&rnid=658815051";
	private static String plc = "https://www.amazon.cn/s/ref=sr_nr_n_3?fst=as%3Aoff&rh=n%3A658390051%2Cn%3A%21658391051%2Cn%3A658414051%2Cn%3A658815051%2Cn%3A661029051&bbn=658815051&sort=popularity-rank&ie=UTF8&qid=1481609712&rnid=658815051";
	private static String singlechip = "";
	private static String electro = "";
	private static String hardware = "";
	private static String flushbonading = "";
	private static String hwdl = "";
	@Autowired
	GetDataFromAmazon getDataFromAmazon;

	@Test
	public void testCPU() throws InterruptedException {
		getDataFromAmazon.run(cpu, "hardware");
	}

	@Test
	public void testArm() throws InterruptedException {
		getDataFromAmazon.run(arm, "hardware");
	}

	@Test
	public void testDsp() throws InterruptedException {
		getDataFromAmazon.run(dsp, "hardware");
	}

	@Test
	public void testPlc() throws InterruptedException {
		getDataFromAmazon.run(plc, "hardware");
	}

	@Test
	public void testCPU3() throws InterruptedException {
		getDataFromAmazon.run(singlechip, "hardware");
	}

	@Test
	public void testCPU4() throws InterruptedException {
		getDataFromAmazon.run(electro, "hardware");
	}

	@Test
	public void testCPU5() throws InterruptedException {
		getDataFromAmazon.run(hardware, "hardware");
	}

	@Test
	public void testCPU6() throws InterruptedException {
		getDataFromAmazon.run(flushbonading, "hardware");
	}

	@Test
	public void testCPU7() throws InterruptedException {
		getDataFromAmazon.run(hwdl, "hardware");
	}

}
