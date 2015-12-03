package scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Delfi {
	public static void main(String[] args) throws IOException {
		Document document1 = Jsoup.connect("http://www.delfi.ee").get();
		Elements pealkirjad1 = document1.select("a.article-title");
		for (Element element1 : pealkirjad1){
			System.out.println(element1.text());
		}}

}