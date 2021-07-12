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
	
	public static void main(String[] args) {
		Kaffeekueche kueche = new Kaffeekueche();

		kueche.kaffeetrinker = new Kaffeetrinker[2];
		kueche.kaffeetrinker[0] = new Kaffeetrinker("Lisa", kueche);
		kueche.kaffeetrinker[1] = new Kaffeetrinker("Anton", kueche);

	}
	
	
}
