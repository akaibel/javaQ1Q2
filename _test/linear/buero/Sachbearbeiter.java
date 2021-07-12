package _test.linear.buero;

/**
 * der Sachbearbeiter holt sich Auftraege vom Stapel 
 * dann zeigt er an, dass er sie bearbeitet.
 * @author akaibel
 */
public class Sachbearbeiter{
	private String name;
	private SachbearbeiterGUI gui;
	private Buero meinBuero;
	
	/**
	 * erzeugt einen Sachbearbeiter.
	 * @param name der Name des Sachbearbeiters.
	 * @param buero das Buero, zu dem der Sachbearbeiter gehoert.
	 */
	public Sachbearbeiter(String name, Buero buero){
		this.name = name;
		this.meinBuero = buero;
		// die Anzeige erzeugen
		gui = new SachbearbeiterGUI(this);
	}

	public String getName() {
		return name;
	}

	/**
	 * wird aufgerufen, wenn in SachbearbeiterGUI "hole Auftrag" gedrueckt wird.
	 */
	public void holeUndBearbeiteAuftrag() {
		System.out.println("Sachbearbeiter.holeUndBearbeiteAuftrag()");
		String auftragText = null;
		// TODO der Sachbearbeiter muss sich den naechsten Auftrag vom Stapel holen.
		
		// Wenn kein Auftrag vorhanden ist, dann kann der Sachbearbeiter Kaffee trinken...
		if(auftragText == null){
			auftragText = "*** Kaffee trinken... ***";
		}
		
		// den aktuellen Auftrag anzeigen 
		gui.append(auftragText);
	}

}
