package _test.netz.elternsprechtag;

public class Elternteil extends Gespraechsteilnehmer {
	private String benutzerkennung;
	private String passwortPruefwert;

	public Elternteil(String pName, String pBenutzerkennung,
			String pPasswort) {
		super(pName, ElternsprechtagServer.MAX_TERMINNUMMER);
		this.benutzerkennung = pBenutzerkennung;
		this.passwortPruefwert = pPasswort;
	}

	public String gibBenutzerkennung() {
		return benutzerkennung;
	}
	
	public boolean istPasswortGueltig(String pPasswort){
		return pPasswort.equals(passwortPruefwert);
	}
	
	public String toString(){
		return "E:: "+super.toString();
	}
	
}
