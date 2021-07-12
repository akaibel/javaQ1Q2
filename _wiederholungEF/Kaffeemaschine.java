package _wiederholungEF;

import gui.GUI;

public class Kaffeemaschine {
	private int kaffee;
	private int wasser;
	
	public Kaffeemaschine() {
		new GUI(this);		
	}
	
	public boolean wasserNachfuellen(int pMenge){
		if(wasser + pMenge > 2000){
			return false;
		}
		wasser += pMenge;
		return true;
	}

	public boolean kaffeeNachfuellen(int pMenge) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String kaffeeKochen(){
		//Abbruchbed.
		if(this.wasser < 150){
			return "zu wenig Wasser";
		}
		// Haupthandlung
		//TODO
		return "Kaffee";
	}

}
