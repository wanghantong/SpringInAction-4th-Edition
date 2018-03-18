package com.bookstore.data.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;

public class GetDataFromDouban {
	// 每小时150次
	private final String openApi = "http://api.douban.com/v2/book/isbn/";

	public void fetchDataByISBN10(String isbn10) {

	}

	public void fetchDataByISBN13(String isbn13) {

	}

	public void fetchDataByISBN(String isbn10, String isbn13) {

	}

	public void fetchDataByDouban(String isbn) throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://api.douban.com/v2/book/isbn/" + isbn);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);

		try {
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			// System.out.println(EntityUtils.toString(entity1));
			JSONObject jsonObject = new JSONObject(EntityUtils.toString(entity1));
			JSONArray author_a = jsonObject.getJSONArray("author");
			String pubdate = (String) jsonObject.get("pubdate");
			String author = (String) author_a.get(0);
			System.out.println(author + "   -   " + pubdate);
			// String author = (String) jsonObject.get("author");
			// String pubdate = (String) jsonObject.get("pubdate");

			// {"rating":{"max":10,"numRaters":0,"average":"0.0","min":0},"subtitle":"","author":["陈益才"],"pubdate":"2012-11","tags":[{"count":1,"name":"ewr","title":"ewr"}],"origin_title":"","image":"https://img3.doubanio.com\/mpic\/s24438185.jpg","binding":"","translator":[],"catalog":"","pages":"459","images":{"small":"https://img3.doubanio.com\/spic\/s24438185.jpg","large":"https://img3.doubanio.com\/lpic\/s24438185.jpg","medium":"https://img3.doubanio.com\/mpic\/s24438185.jpg"},"alt":"https:\/\/book.douban.com\/subject\/20283154\/","id":"20283154","publisher":"","isbn10":"711139917X","isbn13":"9787111399179","title":"Dreamweaver
			// CS5+ASP动态网站建设从入门到精通","url":"https:\/\/api.douban.com\/v2\/book\/20283154","alt_title":"","author_intro":"","summary":"《Dreamweaver
			// CS5+ASP动态网站建设从入门到精通(第2版)》是一本关于动态网站开发的技术图书，专门为初次接触动态网站开发的读者而写作，是读者迈向动态网站开发的第一步。《Dreamweaver
			// CS5+ASP动态网站建设从入门到精通(第2版)》以Dreamweaver
			// CS5+ASP为开发平台，从基本的动态网站入门知识到高端的动态网站建设进程，通过剖析大量商业应用实例，引导读者逐步掌握动态网站开发的方法。","price":"79.80元"}

			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity1);
		} finally {
			response1.close();
		}
	}
}
