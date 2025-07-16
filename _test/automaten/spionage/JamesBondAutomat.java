package _test.automaten.spionage;

import gui.GUI;

public class JamesBondAutomat {
	
	private char[] alphabet = {'0','1','2','3','4','5','6','7','8','9'};
	
	/**
	 * prueft, ob pZeichen im alphabet enthalten ist.
	 * @param pZeichen
	 * @return
	 */
	public boolean imAlphabet(char pZeichen){
		//TODO
		return false;
	}
	
	/**
	 * die Methode soll ueberpruefen, ob pEingabe die Zeichenkette "007" enthaelt.
	 * Dafuer soll ein det. endl. Automat, der das prueft, in einen Parser uebersetzt werden.
	 * 
	 * @param pEingabe
	 * @return
	 */
	public boolean enthaelt007(String pEingabe){
		int zustand = 0;
		//TODO
		return false;
	}
	
	public static void main(String[] args) {
		new GUI(new JamesBondAutomat());
	}
	
}
