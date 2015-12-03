package scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Postimees {
	public static void main(String[] args) throws IOException {
		Document document2 = Jsoup.connect("http://www.postimees.ee").get();
		Elements pealkirjad2 = document2.select("h1.frontHeading");
		for (Element element2 : pealkirjad2){
			System.out.println(element2.text());
		}}

}
