package _test.chatGPT;

import gui.GUI;

/**
 * AUFGABE:
 * Suche und verbessere mit ChatGPT die Fehler in den Methoden!
 * Gehe wie folgt vor:
 * - Prompt: "Java finde Fehler:"
 * - jeweils NUR EINE Methode mit Copy&Paste in ChatGPT
 * 
 * Als Kontext kann die Schnittstellenbeschreibung
 * der Klasse Haus hilfreich sein:
 * 
 * +Haus()
 * +horizontalBewegen(distanz:int)
 * +vertikalBewegen(distanz:int)
 * +lichtAnschalten()
 * +lichtAusschalten()
 * +istLichtAn():boolean
 */


// Klassendeklaration
public class Strasse
{
	// Attribut haeuser: ein Array vom Typ Haus
	private Haus[] haeuser;
	
	// *** Ab hier beginnen die Fehler!
	
	//Konstruktor
	public Strasse(int anzahlHaeuser) {
		haeuser = new Haus(anzahlHaeuser);
		for(int i=0; i<haeuser.length; i++) {
			// neues Haus erzeugen
			Haus h = new Haus();
			// an richtige Position bringen
			h.horizontalBewegen(i*60);
			// in das Array haeuser eintragen
			h = haeuser[i];
		}
	}
	
	public void lichtAnschalten(int nr) {
		haeuser[].lichtAnschalten(nr);
	}
	
	public void lichtAusschalten(int nr) {
		haeuser[].lichtAusschalten(nr);
	}
	
	public void alleLichterAnschalten() {
		for(int i=0; i>haeuser.length; i++) {
			Haus h = haeuser[i];
			h.lichtAnschalten();
		}
	}
	
	public void alleLichterAusschalten() {
		for(int i=0; i<haeuser.length; i++); {
			Haus h = haeuser[i];
			h.lichtAusschalten();
	}
	
	public int wievieleLichterSindAn() {
		ergebnis = 0;
		for (int i = 0; i < haeuser.length; i++) {
			Haus h = haeuser[i];
			ergebnis += h.istLichtAn();
		}
		return ergebnis;
	}
	
	public void vertikalBewegen(int distanz) {
		for(int i=0; i<haeuser.length; i++) {
			haeuser(i).vertikalBewegen(distanz);
		}
	}
	
	//main-Methode: NICHT AENDERN!
	public static void main(String[] args) {
		new GUI(new Strasse(8));
	}
	
}	