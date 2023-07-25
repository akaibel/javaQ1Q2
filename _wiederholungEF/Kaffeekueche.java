package _wiederholungEF;

import gui.GUI;

public class Kaffeekueche {

	private Kaffeetrinker[] kaffeetrinker;
	private Kaffeemaschine kaffeemaschine;
	
	public Kaffeekueche() {
		this.kaffeemaschine = new Kaffeemaschine();
		new GUI(this);
	}
	
	public Kaffeemaschine gibKaffeemaschine(){
		return this.kaffeemaschine;
	}
	
	public String toString(){
		return "dieKueche";
	}

	public void setzeKaffeetrinker(Kaffeetrinker[] pKaffeetrinker) {
		this.kaffeetrinker = pKaffeetrinker;
		
	}
	
	
	
}
