package _test.baeume.ahnenverwaltung;

public class Ahne {
	private String zGender;
	private String zGebDatum;
	private String zName;
	private String zVorname;
	
	public Ahne(String pName, String pVorname, String pGender, String pGebDatum){
		zName = pName;
		zVorname = pVorname;
		zGender = pGender;
		zGebDatum = pGebDatum;
	}

	public String gibName() {
		return zName;
	}

	public void setzeName(String name) {
		zName = name;
	}

	public String gibGender() {
		return zGender;
	}

	public String gibGebDatum() {
		return zGebDatum;
	}

	public String gibVorname() {
		return zVorname;
	}
	
	public String toString(){
		return zVorname;
	}
}
