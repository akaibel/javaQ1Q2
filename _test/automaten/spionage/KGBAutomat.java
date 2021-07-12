package _test.automaten.spionage;

import gui.GUI;

public class KGBAutomat {
	public int zustand;
	private char[] alphabet = {'0','1','2','3','4','5','6','7','8','9'};
	
	public boolean imAlphabet(char pZeichen){
		//TODO
		return false;
	}
	
	public boolean teste(String pEingabe){
		zustand = 0;
		//TODO
		return false;
	}
	
	public static void main(String[] args) {
		new GUI(new KGBAutomat());
	}
	
}
