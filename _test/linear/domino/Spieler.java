package _test.linear.domino;

import gui.GUI;

import javax.swing.JOptionPane;

import linear.ListWithViewer;

public class Spieler {
	private ListWithViewer<Dominostein> steine;
	private String name; 
	// nur zu Testzwecken!
	private Dominostein d12 = new Dominostein(1,2); 
	private Dominostein d23 = new Dominostein(2,3); 
	private Dominostein d43 = new Dominostein(4,3); 
	private Dominostein d51 = new Dominostein(5,1); 
	
	public Spieler(String pName){
		System.out.println("Spieler("+pName+")");
		steine = new ListWithViewer<Dominostein>();
		this.name = pName;
	}
	
	public Dominostein steinAuswaehlen(){
		System.out.println("Spieler.steinAuswaehlen()");
		if(steine.isEmpty()){
			return null;
		}
		int zahl = -1;
		do{
			String zahlString = JOptionPane.showInputDialog(this.name, null);
			try {
				zahl = Integer.parseInt(zahlString);
			} catch (NumberFormatException e) {
				System.err.println("NumberFormatException in Spieler");
			}
		}while(zahl < 0);
		
		steine.toFirst();
		for(int i=1; i<zahl; i++){
			if(steine.hasAccess()){
				steine.next();
				if(!steine.hasAccess()){
					steine.toFirst();
				}
			}
		}
		return steine.getContent();
	}
	
	/**
	 * nimmt dem Spieler den Stein weg, den er vorher mit auswaehlen ausgewaehlt hat.
	 */
	public void wegnehmenAktuellenStein(){
		System.out.println("Spieler.wegnehmenAktuellenStein()");
		//TODO
	}
	
	/**
	 * Diese Methode fragt den Spieler, ob er vorne oder hinten anlegen will.
	 * Wenn der Spieler "vorne" waehlt, 
	 * dann gibt die Methode true zurueck,
	 * sonst false. 
	 * @return
	 */
	public boolean vorneHintenWaehlen(){
		System.out.println("Spieler.vorneHintenWaehlen()");
		int vorneZahl = JOptionPane.showOptionDialog(null, "vorne?", this.name, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		System.out.println(vorneZahl);
		if(vorneZahl == JOptionPane.OK_OPTION){
			return true;
		}
		return false;
	}

	public void steinHinzufuegen(Dominostein pStein) {
		System.out.println("Spieler.steinHinzufuegen("+pStein+")");
		//TODO
	}

	public String getName() {
		return name;
	}

	/**
	 * gibt zurueck, ob der Spieler alle seine Steine verbraucht 
	 * und also gewonnen hat.
	 * @return
	 */
	public boolean hatGewonnen() {
		System.out.println("Spieler.hatGewonnen()");
		if(this.steine.isEmpty()){
			JOptionPane.showMessageDialog(null,getName()+" hat gewonnen!");
			return true;
		}
		return false;
	}
	
	public String toString(){
		return name;
	}
	
	public static void main(String[] args) {
		Spieler s = new Spieler("test");
		new GUI(s);
	}
}
