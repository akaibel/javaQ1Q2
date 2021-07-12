package _wiederholungEF;

import gui.GUI;

public class FahrkartenDrucker {
	private int vorhandeneSeiten;
	
	public FahrkartenDrucker(){
		vorhandeneSeiten = 2;
		new GUI(this);
	}
	
	public void papierNachfuellen(int pSeiten){
		vorhandeneSeiten += pSeiten;
	}
	
	
	public boolean drucken(String pFahrkarte){
		if(vorhandeneSeiten < 1){
			System.err.println("Kein Papier mehr!");
			return false;
		}
		String ueberschrift = "*** Deine Fahrkarte ***";
		int sternchenZahl = (ueberschrift.length() - pFahrkarte.length() - 2)/2;
		System.out.println(ueberschrift);
		sternchenDrucken(sternchenZahl);
		System.out.print(" "+pFahrkarte+" ");
		sternchenDrucken(sternchenZahl);
		System.out.println();
		sternchenDrucken(ueberschrift.length());
		System.out.println();
		System.out.println();
		vorhandeneSeiten--;
		return true;
	}
	
	private void sternchenDrucken(int anzahl){
		if (anzahl > 0) {
			for (int i = 0; i < anzahl; i++) {
				System.out.print("*");
			} 
		}
	}
	
	public static void main(String[] args) {
		new FahrkartenDrucker();
	}
}
