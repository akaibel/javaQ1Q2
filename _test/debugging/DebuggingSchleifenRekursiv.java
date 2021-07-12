package _test.debugging;

import gui.GUI;

/*
  Debugging
  Nutzen Sie den Debugger, um die Fehler in den folgenden Methoden zu finden.
  •	Setzen Sie einen Haltepunkt in die erste Zeile der Methode.
  •	„Steppen“ Sie Schritt für Schritt durch die Methode:
  o	Handelt das Programm erwartungsgemäß?
  o	Sind die Variablen erwartungsgemäß belegt?
 */
public class DebuggingSchleifenRekursiv {

	/**
	 * Fehler für a = 12 und b = 12
	 */
	private String gleichFehler(int a, int b){
		String ergebnis = "Keine Ahnung";
		if(a==b){
			ergebnis = "gleich!";
		}
		ergebnis = "NICHT gleich";
		return ergebnis;
	}

	/**
	 * n Fakultaet = 1*2*...*n
	 * Fehler fuer n = 4
	 */
	private int fakultaetFehler(int n){
		int ergebnis = 1;
		for(int i=0; i<=n; i++){
			ergebnis = ergebnis*i;
		}
		return ergebnis;
	}

	/**
	 * Fehler fuer n = 4 
	 */
	private int fakultaetRekursivFehler(int n){
		int ergebnis = 0;
		//Abbruchbedingung
		if(n>=0){
			ergebnis = 1;
		}
		else{
			ergebnis = n*fakultaetRekursivFehler(n-1);
		}
		return ergebnis;
	}


	/**
	 * Fehler fuer a = 2 und b = 4
	 */
	private int potenzFehler(int a, int b){
		int ergebnis = 1;
		for(int zaehler=1; zaehler<=b; zaehler++);
		{
			ergebnis = ergebnis * a;
		}
		return ergebnis;
	}
	
	private String[] namen = {"Maria", "Stefan", "Martin", "Rita"};

	//Fehler fuer "Maria"
	public boolean enthaeltFehler1(String pName){
		boolean ergebnis = false;
		for(int i=0; i<namen.length; i++){
			String derName = namen[i];
			if(derName == pName){
				ergebnis = true;
			}
			else{
				ergebnis = false;
			}
		}
		return ergebnis;
	}
	
	//Fehler fuer "Maria"
	public boolean enthaeltFehler2(String pName){
		boolean ergebnis = false;
		for(int i=0; i<namen.length; i++){
			String derName = namen[i];
			if(derName.equals(pName)){
				ergebnis = true;
			}
			else{
				ergebnis = false;
			}
		}
		return ergebnis;
	}
	
	
	//Fehler fuer "Maria"
	public boolean enthaeltFehler3(String pName){
		for(int i=0; i>namen.length; i++){
			String derName = namen[i];
			if(derName.equals(pName)){
				return true;
			}
		}
		return false;
	}
	
	//Fehler fuer "Xaver" (der ist gar nicht dabei
	public boolean enthaeltFehler4(String pName){
		for(int i=4; i<namen.length; i++){
			String derName = namen[i];
			if(derName.equals(pName));{
				return true;
			}
		}
		return false;
	}
	

		// Konstruktor (fehlerfrei...)
		public DebuggingSchleifenRekursiv() {
			new GUI(this);
		}
		
		// main-Methode (fehlerfrei...)
		public static void main(String[] args) {
			new DebuggingSchleifenRekursiv();
		}

	
}
