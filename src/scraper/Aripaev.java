package scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Aripaev {
	public static void main(String[] args) throws IOException {
		Document document = Jsoup.connect("http://www.aripaev.ee").get();
		Elements pealkirjad = document.select("h3.art-title");
		for (Element element : pealkirjad){
			System.out.println(element.text());
		}}

}
