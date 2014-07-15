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
	 * ��ȡhtml�ĵ�����
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
	 * ��ȡhtmlElementԪ�أ�ʹ�ñ���Elements�ķ�ʽ
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
	 * ��ȡhtmlElementԪ��,ʹ��ѡ����
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
	@Test
	public void getBody(){
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		System.out.println(body);
	}
	@Test
	public void getConnect() throws IOException{
		Document doc = Jsoup.connect("http://example.com/").data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .timeout(3000)
				  .post();
		String title = doc.title();
		System.out.println(title);
	}
	@Test
	public void getDcument() throws IOException{
		File input = new File("tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		System.out.println(doc);
	}
	@Test
	public void getData() throws IOException{
		File input = new File("tmp/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		Element content = doc.getElementById("content");
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
			  String linkHref = link.attr("href");
			  System.out.print(linkHref);
			  String linkText = link.text();
			  System.out.println(linkText);
			}
		
	}
	@Test
	public void getDataShuX(){
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);//����HTML�ַ�������һ��Documentʵ��
		Element link = doc.select("a").first();//���ҵ�һ��aԪ��
		System.out.println(link);
		
		String text = doc.body().text(); // "An example link"//ȡ���ַ����е��ı�
		System.out.println(text);
		String linkHref = link.attr("href"); // "http://example.com/"//ȡ�����ӵ�ַ
		System.out.println(linkHref);
		String linkText = link.text(); // "example""//ȡ�����ӵ�ַ�е��ı�
		System.out.println(linkText);
		String linkOuterH = link.outerHtml(); // "<a href="http://example.com"><b>example</b></a>"
		System.out.println(linkOuterH);
		String linkInnerH = link.html(); // "<b>example</b>"//ȡ�������ڵ�html����
		System.out.println(linkInnerH);
	}
	@Test
	public void getURLs() throws IOException{
		Document doc = Jsoup.connect("http://www.open-open.com").get();
		Element link = doc.select("a").first();
		System.out.println(link);
		String relHref = link.attr("href"); // == "/"
		System.out.println(relHref);
		String absHref = link.attr("abs:href"); // "http://www.open-open.com/"
		System.out.println(absHref);
	}
	@Test
	public void setAttr(){
		String html = "<div class=comments><a>1</a><a>2</a></div>";
		Document doc =Jsoup.parse(html);
		doc.select("div.comments a").attr("rel", "nofollow");
		System.out.println(doc);
	}
	@Test
	public void setHtml(){
		String html = "<div class=comments><a>1</a><a>2</a></div>";
		Document doc =Jsoup.parse(html);
		doc.select("div.comments a").attr("rel", "nofollow");
		System.out.println(doc);
	}
}
