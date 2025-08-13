package _test.chatGPT;

import gui.GUI;

/**
 * AUFGABE:
 * lasse ChatGPT die Klasse Stadt implementieren.
 * 
 * VORAUSSETZUNGEN:
 * 1) Die Klasse Strasse muss korrigiert sein und funktionieren!
 * 2) ChatGPT muss die Methoden der Klasse Strasse kennen, d.h.:
 * 
 * +Strasse(anzahlHaeuser:int)
 * +lichtAnschalten(nr:int)
 * +lichtAusschalten(nr:int)
 * +alleLichterAnschalten()
 * +alleLichterAusschalten()
 * +wievieleLichterSindAn():int
 * +vertikalBewegen(distanz:int)
 * 
 */


public class Stadt
{
	// Array von Strassen:
	// die Strassen sind jeweils im Abstand von 100px untereinander platziert.
	public Strasse[] strassen;
	
	public Stadt(int anzahlStrassen, int anzahlHaeuser) {
		//TODO
	}
	
	public void lichtAnschalten(int strasseNr, int hausNr) {
		//TODO
	}
	
	public void lichtAusschalten(int strasseNr, int hausNr) {
		//TODO
	}
	
	public void alleLichterAnschalten() {
		//TODO
	}
	
	public void alleLichterAusschalten() {
		//TODO
	}
	
	public int wievieleLichterSindAn() {
		//TODO
		return -1;
	}
	
	
	//main-Methode: NICHT AENDERN!
	public static void main(String[] args) {
		// Es wird eine Stadt mit vier Strassen und jeweils 6 Haeusern erzeugt.
		new GUI(new Stadt(4, 6));
	}

	
}	// Ende der Klasse. HIER NICHTS MEHR DRUNTER SCHREIBEN