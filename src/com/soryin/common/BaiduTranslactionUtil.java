package com.soryin.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaiduTranslactionUtil {

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BaiduTranslactionUtil(String baiduKey) {
		this.baiduKey = baiduKey;
	}

	private String from = "zh";
	private String to = "en";
	private String baiduKey = "";

	/**
	 * 
	 * 百度翻译，默认CN->EN return EN
	 * @throws JSONException 
	 * 
	 * @throws MalformedURLException
	 */
	public String translation(String content) throws JSONException {
		HttpURLConnection connection = null;
		StringBuffer result = null;
		String urlStr = "http://openapi.baidu.com/public/2.0/bmt/translate?q="
				+ content + "&client_id=" + this.baiduKey + "&from="
				+ this.from + "&to=" + this.to;
		System.out.println(urlStr);
		URL url;
		try {
			url = new URL(urlStr);

			connection = (HttpURLConnection) url.openConnection();
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			// 对应的字符编码转换
			Reader reader = new InputStreamReader(inputStream,"UTF-8");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String str = null;
			result = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				result.append(str);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return analyzeJson(result.toString());
	}

	/**
	 * 解析百度翻译后的结果
	 * 
	 * @param jsonE
	 * @return
	 */
	protected String analyzeJson(String jsonStr) throws JSONException {
		String result = "";
		System.out.println(jsonStr);
		JSONObject jsonObject = new JSONObject(jsonStr);
		JSONArray childs = jsonObject.getJSONArray("trans_result");
		int length = childs.length();
		for (int i = 0; i < length; i++) {
			jsonObject = childs.getJSONObject(i);
			String childName = jsonObject.getString("dst");
			result = result + childName;
		}
		return result;
	}

//	public static void main(String[] args) {
//		BaiduTranslactionUtil bdt = new BaiduTranslactionUtil(
//				"MbtN6VL5LdmnUVytE9wDMK3a");
//		try {
//			String result = bdt.translation("魔兽世界");
//			System.out.println(result);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//	}

}
