package _wiederholungEF;

import gui.GUI;

public class Kaffeemaschine {
	// maximal 1000g
	private int kaffee;
	
	// maximal 2000ml
	private int wasser;
	
	public Kaffeemaschine() {
		new GUI(this);		
	}
	
	public boolean wasserNachfuellen(int pMenge){
		//TODO
		return false;
	}

	public boolean kaffeeNachfuellen(int pMenge) {
		// TODO 
		return false;
	}
	
	public String kaffeeKochen(){
		//TODO
		//Abbruchbedingung fuer zu wenig Wasser
		
		// Abbruchbedingung fuer zu wenig Kaffee
		
		// Haupthandlung: kaffee und wasser reduzieren
		
		return "Kaffee";
	}
	
	public String toString() {
		return "De'longhi ECAM";
	}

}
