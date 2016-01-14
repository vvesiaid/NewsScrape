package scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lib.TextIO;

public class GetNews {

	public static void main(String[] args) throws IOException {
		System.out.print("Sisesta otsingusõna, mis peab sisalduma artikli pealkirjas: ");
		String input = TextIO.getlnString();
		int Leitud = 0;
		Document document1 = Jsoup.connect("http://www.delfi.ee").get();
		Elements pealkirjad1 = document1.select("a.article-title");
		for (Element element1 : pealkirjad1) {
			String htmlString1 = element1.html();
			if (htmlString1.contains(input)) {
				System.out.println("Delfi: " + htmlString1);
				Leitud = Leitud + 1;
			}

		}
		Document document = Jsoup.connect("http://www.aripaev.ee").get();
		Elements pealkirjad = document.select("h3.art-title");
		for (Element element : pealkirjad) {
			String htmlString = element.text();
			if (htmlString.contains(input)) {
				System.out.println("Äripäev: " + htmlString);
				Leitud = Leitud + 1;
			}
		}
		Document document2 = Jsoup.connect("http://www.postimees.ee").get();
		Elements pealkirjad2 = document2.select("h1.frontHeading");
		for (Element element2 : pealkirjad2) {
			String htmlString2 = element2.text();
			if (htmlString2.contains(input)) {
				System.out.println("Postimees: " + htmlString2);
				Leitud = Leitud + 1;
			}
		}
		System.out.println();
		System.out.println("Leitud " + Leitud + " sobivat artiklit.");
	}
}
