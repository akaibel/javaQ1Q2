package _test.linear.staumeldungen;

public class Staumeldung {
	private int autobahnnummer;
	private int laenge;
	
	private String richtungVon;
	private String richtungNach;
	private String abschnittAnfang;
	private String abschnittEnde;

	public Staumeldung(int pAutobahnnummer, String pRichtungVon, String pRichtungNach, String pAbschnittAnfang,
			String pAbschnittEnde, int pLaenge) {
		this.autobahnnummer = pAutobahnnummer;
		this.richtungVon = pRichtungVon;
		this.richtungNach = pRichtungNach;
		this.abschnittAnfang = pAbschnittAnfang;
		this.abschnittEnde = pAbschnittEnde;
		this.laenge = pLaenge;
	}

	public int gibAutobahnnummer() {
		return autobahnnummer;
	}

	public int gibLaenge() {
		return laenge;
	}

	public String gibRichtungNach() {
		return richtungNach;
	}

	public String gibAbschnittAnfang() {
		return abschnittAnfang;
	}

	public String gibAbschnittEnde() {
		return abschnittEnde;
	}
	
	public String toString(){
		return 	"A"+autobahnnummer+": "+laenge+"km "+
				richtungVon+"/"+richtungNach+" "+
				abschnittAnfang+"/"+abschnittEnde;
	}
	
	
	

}
