package _test.baeume.goetheKekuleZahl;

public class Individuum {
	private String name;
	private String vorname;
	private int geburtsjahr;

	public Individuum(String pName, String pVorname, int pGeburtsjahr) {
		super();
		this.name = pName;
		this.vorname = pVorname;
		this.geburtsjahr = pGeburtsjahr;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	
	public String toString() {
		String ergebnis = "";
		String[] vornameSplits = vorname.split(" ");
		for (int i = 0; i < vornameSplits.length; i++) {
			ergebnis+=vornameSplits[i].charAt(0);
			ergebnis+=".";
		}
		ergebnis+=" ";
		ergebnis+=name;
		return ergebnis;
	}
	
	
	
	
}
