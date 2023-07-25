package _wiederholungEF;

import gui.GUI;

public class Kaffeetrinker {
	private String name;
	private Kaffeekueche kueche;
	
	public Kaffeetrinker(String pName, Kaffeekueche pKueche) {
		this.name = pName;
		this.kueche = pKueche;
		new GUI(this);
	}

	public boolean wasserNachfuellen(int pMenge){
		boolean ergebnis = false;
		//TODO
		// in der kueche die Kaffeemaschine suchen und Wasser nachfuellen.
		// Wichtig: sich zurueckgeben lassen, ob das erfolgreich ist!!
		return ergebnis;
	}
	
	/**
	 * es wird immer ein ganzes Pack von 500 g nachgefuellt.
	 * @return
	 */
	public boolean kaffeeNachfuellen(){
		boolean ergebnis = false;
		//TODO
		// in der kueche die Kaffeemaschine suchen und Kaffee nachfuellen.
		// Wichtig: sich zurueckgeben lassen, ob das erfolgreich ist!!
		return ergebnis;
	}
	
	public String kaffeeHolen(){
		Kaffeemaschine km = this.kueche.gibKaffeemaschine();
		return km.kaffeeKochen();
	}
	
	public String toString(){
		return name;
	}
	
	
	
}
