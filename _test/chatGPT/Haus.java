package _test.chatGPT;

import formenBlueJ.*;
import gui.GUI;

/**
 * Ein Haus besteht aus einem Dach (Dreieck), einer Wand (Quadrat) und einem Fenster (Quadrat)
 * Man kann das Haus horizontal und vertikal bewegen.
 * Man kann das Licht anschalten (Fenster wird gelb) und ausschalten (Fenster wird schwarz).
 * 
 * Very advanced: 
 * Man kann das Haus vergroessern und verkleinern (um einen Faktor). 
 */
public class Haus
{
	//main-Methode: NICHT AENDERN!
	public static void main(String[] args) {
		new GUI(new Haus());
	}
	
	private Quadrat wand;
	private Quadrat fenster;
	private Dreieck dach;
	private boolean istLichtAn;
	
	public Haus() {
		wand = new Quadrat();
		wand.farbeAendern("blau");
		wand.groesseAendern(50);
		wand.bewegeZuPosition(50, 50);
		
		fenster = new Quadrat();
		fenster.farbeAendern("schwarz");
		fenster.groesseAendern(20);
		fenster.bewegeZuPosition(40, 40);
		istLichtAn = false;
		
		dach = new Dreieck();
		dach.farbeAendern("rot");
		dach.groesseAendern(25, 50);
		dach.bewegeZuPosition(50, 0);
		
		sichtbarMachen();
	}

	public void sichtbarMachen() {
		wand.sichtbarMachen();
		fenster.sichtbarMachen();
		dach.sichtbarMachen();
	}
	
	public void unsichtbarMachen() {
		wand.unsichtbarMachen();
		fenster.unsichtbarMachen();
		dach.unsichtbarMachen();
	}
	
	public void lichtAnschalten() {
		fenster.farbeAendern("gelb");
		istLichtAn = true;
	}
	
	public void lichtAusschalten() {
		fenster.farbeAendern("schwarz");
		istLichtAn = false;
	}
	
	public boolean istLichtAn() {
		return istLichtAn;
	}
	
	public void horizontalBewegen(int distanz) {
		wand.horizontalBewegen(distanz);
		fenster.horizontalBewegen(distanz);
		dach.horizontalBewegen(distanz);
	}

	public void vertikalBewegen(int distanz) {
		wand.vertikalBewegen(distanz);
		fenster.vertikalBewegen(distanz);
		dach.vertikalBewegen(distanz);
	}
}	// Ende der Klasse. HIER NICHTS MEHR DRUNTER SCHREIBEN