package _test.vererbung;

public class Quadrat extends Rechteck{

	public Quadrat(int pSeite) {
		super(pSeite,pSeite);
	}
	
	public void aendereSeite(int pSeite) {
		super.aendereBreite(pSeite);
		super.aendereLaenge(pSeite);
	}

	
}
