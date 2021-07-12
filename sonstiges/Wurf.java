package sonstiges;

import java.util.Random;

/**
 * simuliert das Werfen von zwei Wuerfeln
 * @author akaibel
 *
 */
public class Wurf {
	private int zahl1;
	private int zahl2;
	private static Random r = new Random();


	public Wurf() {
		zahl1 = r.nextInt(6)+1;
		zahl2 = r.nextInt(6)+1;
	}

	public int getZahl1() {
		return zahl1;
	}

	public int getZahl2() {
		return zahl2;
	}

	public String toString() {
		return "Wurf ("+zahl1+"," + zahl2 + ")";
	}
	
	public boolean istPasch(){
		return zahl1 == zahl2;
	}
	
}
