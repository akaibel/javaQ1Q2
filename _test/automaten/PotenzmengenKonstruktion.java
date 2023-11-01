package _test.automaten;

import linear.List;
import linear.ListWithViewer;

public class PotenzmengenKonstruktion {
	private Automat NEA;
	private Automat ergebnisAutomat;
	
	public PotenzmengenKonstruktion() {
		init();		
		potenzmengenKonstruktion();
		System.out.println();
		
		System.out.println("*** Deterministischer endlicher Automat (DEA) ***");
		ergebnisAutomat.print();
	}
	
	public void init() {
		NEA = new Automat();
		NEA.startzustandSetzen("q0");
		
		NEA = new Automat();
		NEA.uebergangHinzufuegen("q0", "a", "q0,q1");
		NEA.uebergangHinzufuegen("q0", "b", "q0");
		NEA.uebergangHinzufuegen("q0", "x", "q0");
		
		NEA.uebergangHinzufuegen("q1", "a", "q2");
		NEA.uebergangHinzufuegen("q1", "b", "q2");

		NEA.uebergangHinzufuegen("q2", "a", "q3");
		
		NEA.uebergangHinzufuegen("q3", "a", "q3");
		NEA.uebergangHinzufuegen("q3", "b", "q3");
		NEA.uebergangHinzufuegen("q3", "x", "q3");
		
		NEA.startzustandSetzen("q0");
		String[] endzustaende = {"q3"};
		NEA.endzustaendeSetzen(endzustaende);		
		System.out.println();
		System.out.println("*** Nicht Deterministischer Endlicher Automat (NEA): ***");
		System.out.println();
		NEA.print();
		
	}
	
	public void potenzmengenKonstruktion() {
		System.out.println("Potenzmengenkonstruktion wird durchgefuehrt");
		ergebnisAutomat = new Automat();
		String startzustand = NEA.startzustand();
		ergebnisAutomat.startzustandSetzen(startzustand);
		List<String> zustandsListeErgebnis= new ListWithViewer<>();
		String[] alphabet = NEA.alphabet();
		zustandsListeErgebnis.append(NEA.startzustand());
		//TODO
	}
	
	public static void main(String[] args) {
		new PotenzmengenKonstruktion();
	}
	
}
