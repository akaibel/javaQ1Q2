package _test.backtracking;


public class BacktrackingRucksackproblem {
	public int[] gewichte = {28, 57, 33, 18, 99, 42, 17, 52};
	public int maxGewicht = 200;
	
	public boolean[] dabei = new boolean[gewichte.length];
	public int erreichtesGewicht = 0;
	
	public boolean[] besteLoesung = new boolean[gewichte.length];
	public int bestesGewicht = 0;
	
	public void sucheBesteLoesung(){
		//Vorbereitung
		for(int i=0; i<dabei.length; i++){
			dabei[i] = false;
		}
		kopiereInBesteLoesung();
		// los gehts!
		sucheBesteLoesung(0);
		System.out.println("*** Beste Loesung: ***");
		ausgeben(besteLoesung);
	}

	public void sucheBesteLoesung(int pStufe) {
		dabeiArrayAusgeben();
		//TODO
	}
	
	public void ausgeben(boolean[] b){
		System.out.print(berechneGewicht(b)+": ");
		for(int i=0; i<dabei.length; i++){
			if(b[i]){
				System.out.print(gewichte[i]+",");
			}
		}
		System.out.println();
	}
	
	public void dabeiArrayAusgeben(){
		for(int i=0; i<dabei.length; i++){
			if(dabei[i]){
				System.out.print("+");
			}
			else{
				System.out.print("-");
			}
		}
		System.out.println();
	}
	
	
	
	
	public void kopiereInBesteLoesung(){
		for(int i=0; i<dabei.length; i++){
			besteLoesung[i] = dabei[i];
		}
	}
	
	public int berechneGewicht(boolean[] p){
		int ergebnis = 0;
		for(int i=0; i<p.length; i++){
			if(p[i]){
				ergebnis += gewichte[i];
			}
		}
		return ergebnis;
	}
	
	public static void main(String[] args) {
		BacktrackingRucksackproblem rp = new BacktrackingRucksackproblem();
		rp.sucheBesteLoesung();
	}
}
