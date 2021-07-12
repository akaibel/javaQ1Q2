package _test.baeume.kettenbrief;

public class Teilnehmer {
	private String name;
	private double kontostand;

	public Teilnehmer(String pName, double pKontostand) {
		super();
		this.name = pName;
		this.kontostand = pKontostand;
	}

	public double gibKontostand() {
		return kontostand;
	}

	public void aendereKontostand(double pZahl) {
		this.kontostand += pZahl;
	}

	public String gibName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ": " + kontostand ;
	}
	
	
}
