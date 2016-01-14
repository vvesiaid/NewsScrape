package scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import lib.TextIO;

public class GetNews {

	public static void main(String[] args) throws IOException {
		System.out.println("Programm leiab kasutaja valikul Delfist, �rip�evast ning Postimehest pealkirjad,");
		System.out.println("milles sisaldub kasutaja poolt valitud otsingus�na v�i -v�ljend.");
		// Programm k�sib kasutajalt otsingus�na v�i -v�ljendit, mida
		// pealkirjadest otsida
		System.out.print("Sisesta otsingus�na v�i -v�ljend, mis peab sisalduma artikli pealkirjas: ");
		String input = TextIO.getlnString();
		// Programm k�sib kasutajalt, millistest allikatest otsingus�na v�i
		// -v�ljendit otsida
		System.out.println("Palun valige, millistest allikatest artikleid otsida:");
		System.out.print("Delfi (y/n):");
		char d = TextIO.getChar();
		System.out.print("�rip�ev (y/n):");
		char a = TextIO.getChar();
		System.out.print("Postimees (y/n):");
		char p = TextIO.getChar();
		//programm kutsub v�lja kasutaja valitud otsingud
		if (d == 'y') {
			System.out.println();
			delfi(input);
		}
		if (a == 'y') {
			System.out.println();
			aripaev(input);
		}
		if (p == 'y') {
			System.out.println();
			postimees(input);
		}

	}

	public static String delfi(String input) throws IOException {

		// Programm leiab k�ik pealkirjad Delfist ning filtreerib ning v�ljastab
		// otsinguga sobivad
		int leitud = 0;
		Document document1 = Jsoup.connect("http://www.delfi.ee").get();
		Elements pealkirjad1 = document1.select("a.article-title");
		for (Element element1 : pealkirjad1) {
			String htmlString1 = element1.html();
			if (htmlString1.contains(input)) {
				System.out.println("Delfi: " + htmlString1);
				leitud = leitud + 1;
			}
		}
		// Programm loeb kokku ning v�ljastab leitud sobivate artiklite arvu
		System.out.println();
		System.out.println("Delfist leitud " + leitud + " sobivat artiklit.");
		return null;

	}

	public static String aripaev(String input) throws IOException {
		// Programm leiab k�ik pealkirjad �rip�evast, filtreerib ning v�ljastab
		// otsingule sobivad
		int leitud = 0;
		Document document = Jsoup.connect("http://www.aripaev.ee").get();
		Elements pealkirjad = document.select("h3.art-title");
		for (Element element : pealkirjad) {
			String htmlString = element.text();
			if (htmlString.contains(input)) {
				System.out.println("�rip�ev: " + htmlString);
				leitud = leitud + 1;
			}
		}
		// Programm loeb kokku ning v�ljastab leitud sobivate artiklite arvu
		System.out.println();
		System.out.println("�rip�evast leitud " + leitud + " sobivat artiklit.");
		return null;

	}

	public static String postimees(String input) throws IOException {
		// Programm leiab Postimehest k�ik pealkirjad, filtreerib ning v�ljastab
		// otsingule sobivad
		int leitud = 0;
		Document document2 = Jsoup.connect("http://www.postimees.ee").get();
		Elements pealkirjad2 = document2.select("h1.frontHeading");
		for (Element element2 : pealkirjad2) {
			String htmlString2 = element2.text();
			if (htmlString2.contains(input)) {
				System.out.println("Postimees: " + htmlString2);
				leitud = leitud + 1;
			}
		}
		// Programm loeb kokku ning v�ljastab leitud sobivate artiklite arvu
		System.out.println();
		System.out.println("Postimehest leitud " + leitud + " sobivat artiklit.");
		return null;
	}

}
