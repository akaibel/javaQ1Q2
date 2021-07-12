package _test.linear.domino;

import gui.GUI;

import java.util.Arrays;

import linear.List;
import linear.ListWithViewer;

public class Tisch {
	private static int groessteNummer = 6;
	private List<Dominostein> kette;
	private List<Dominostein> vorrat;
	// nur zu Testzwecken!
	private Dominostein d12 = new Dominostein(1,2); 
	private Dominostein d23 = new Dominostein(2,3); 
	private Dominostein d43 = new Dominostein(4,3); 
	private Dominostein d51 = new Dominostein(5,1); 
	
	public Tisch(){
		System.out.println("Tisch()");
		kette = new ListWithViewer<>();
		dominosteineErzeugen();
	}
	
	private void dominosteineErzeugen() {
		System.out.println("Tisch.dominosteineErzeugen()");
		Dominostein[] steineArray = new Dominostein[groessteNummer*groessteNummer];
		int index = 0;
		for(int i=1; i<=groessteNummer; i++){
			for(int j=1; j<=groessteNummer; j++){
				steineArray[index] = new Dominostein(i, j);
				index++;
			}
		}
		Arrays.sort(steineArray);
		vorrat = new ListWithViewer<>();
		for(Dominostein d: steineArray){
			vorrat.append(d);			
		}
	}


	public boolean anlegenVorne(Dominostein pStein){
		System.out.println("Tisch.anlegenVorne("+pStein+")");
		//TODO
		return false;
	}

	public boolean anlegenHinten(Dominostein pStein) {
		System.out.println("Tisch.anlegenHinten("+pStein+")");
		//TODO
		return false;
	}

	public boolean ketteIstGueltig() {
		System.out.println("Tisch.ketteIstGueltig()");
		//TODO
		return true;
	}

	/**
	 * nimmt den ersten Stein vom Vorrat und gibt ihn zurück
	 * wenn der Vorrat leer ist, dann wird null zurückgegeben.
	 * @return
	 */
	public Dominostein vomVorrat() {
		System.out.println("Tisch.vomVorrat()");
		//TODO
		return null;
	}
	
	public static void main(String[] args) {
		Tisch t = new Tisch();
		new GUI(t);
	}

}
