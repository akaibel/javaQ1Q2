package _test.vererbung;

public class Rechteck {
	private int breite;
	private int laenge;
	
	public Rechteck(int pBreite, int pLaenge) {
		this.breite = pBreite;
		this.laenge = pLaenge;
	}
	
	public void zeichne(){
		System.out.println();
		for(int i=0; i<breite; i++){
			for(int j=0; j<laenge; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void aendereLaenge(int pLaenge) {
		laenge = pLaenge;
	}
	
	public void aendereBreite(int pBreite) {
		breite = pBreite;
	}
	
	public int gibFlaeche() {
		return laenge*breite;
	}
	
}
