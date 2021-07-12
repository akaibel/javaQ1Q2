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
		boolean ergebnis =  kueche.gibKaffeemaschine().wasserNachfuellen(pMenge);
		return ergebnis;
	}
	
	public boolean kaffeeNachfuellen(){
		boolean hatgeklappt = false;
		Kaffeemaschine km = this.kueche.gibKaffeemaschine();
		hatgeklappt = km.kaffeeNachfuellen(500);
		return hatgeklappt;
	}
	
	public String kaffeeHolen(){
		Kaffeemaschine km = this.kueche.gibKaffeemaschine();
		return km.kaffeeKochen();
	}
	
	public String toString(){
		return name;
	}
	
	
	
}
