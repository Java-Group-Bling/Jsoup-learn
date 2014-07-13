package com.bling.test;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupOne {

	/**
	 * 获取html文档内容
	 * @author bling
	 * @create Date:2014-07-13
	 */
	@Test
	public  void getHtml(){
		String html = "<html><head><title>First parse</title></head>"
				  + "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document doc = Jsoup.parse(html);
		System.out.println(doc);
	} 
	/**
	 * 获取htmlElement元素，使用遍历Elements的方式
	 * @author bling
	 * @throws IOException 
	 * @create Date:2014-07-13
	 */
	@Test
	public void getDataElement() throws IOException{
		File input = new File("tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		
		Element content = doc.getElementById("content");
		Elements links = content.getElementsByTag("a");
		for(Element link : links){
			String linkHref = link.attr("href");
			String linkText = link.text();
			System.out.println("linkHref:"+linkHref+"------"+"linkText:"+linkText);
		}
	}
	/**
	 * 获取htmlElement元素,使用选择器
	 * @author bling
	 * @throws IOException 
	 * @create Date:2014-07-13
	 */
	@Test
	public void getDataSelectorSsyntax() throws IOException{
		File input = new File("tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		
		Elements links = doc.select("a[href]");// a with href
		
		Elements pngs = doc.select("img[src$=.png]");// img with src ending .png
		
		Element masthead = doc.select("div.masthead").first();// div with class=masthead
		
		Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
		
		System.out.println("links:"+links);
		System.out.println("pngs:"+pngs);
		System.out.println("masthead:"+masthead);
		System.out.println("resultLinks:"+resultLinks);
	}	
	
	

}
