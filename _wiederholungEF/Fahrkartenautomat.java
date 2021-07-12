package _wiederholungEF;

import gui.GUI;

public class Fahrkartenautomat {
	private double eingeworfen;
	
	public Fahrkartenautomat(){
		eingeworfen = 0;
		new GUI(this);
		System.out.println("Fahrkartenautomat ist bereit");
	}
	
	public void geldEinwerfen(double pBetrag) {
		eingeworfen += pBetrag;	
	}

	public double geldRueckgabe() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String[] args) {
		new Fahrkartenautomat();
	}
}
