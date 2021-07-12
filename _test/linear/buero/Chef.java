package _test.linear.buero;

/**
 * der Chef legt Auftraege auf den Stapel. 
 * @author akaibel
 */
public class Chef{

	private String name;
	private ChefGUI gui;
	private Buero meinBuero;

	/**
	 * erzeugt einen Chef
	 * @param name der Name des Chefs
	 * @param buero das Buero, zu dem der Chef gehoert.
	 */
	public Chef(String name, Buero buero){
		this.name = name;
		this.meinBuero = buero;
		// die Anzeige erzeugen
		gui = new ChefGUI(this);
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * wird aufgerufen, wenn in ChefGUI "Auftrag ablegen" gedrueckt wird.
	 * @param auftragText
	 */
	public void auftragAblegen(String auftragText, boolean dringend){
		System.out.println("Chef.auftragAblegen("+auftragText+","+dringend+")");
		// der Auftrag muss auf die Ablage gelegt werden.
		//TODO implement
	}
	

}
