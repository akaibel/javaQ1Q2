package _test.linear.buero;



public class Buero {

	private Chef[] dieChefs;
	private Sachbearbeiter[] dieSachbearbeiter;

	//TODO ein Attribut fuer die Ablage.
	
	public Buero() {
		//TODO die Ablage erzeugen
		// am besten als ...WithViewer-Objekt erzeugen!
		// dann ist die Ablage sichtbar!
	}
	
	public void setzeChefs(Chef[] pChefs) {
		dieChefs = pChefs;
	}
	
	public void setzeSachbearbeiter(Sachbearbeiter[] pSachbearbeiter) {
		dieSachbearbeiter = pSachbearbeiter;		
	}
	
	//TODO eine gib-Methode fuer die Ablage
}
