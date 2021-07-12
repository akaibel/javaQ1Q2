package _test.baeume.kettenbrief;

import baeume.BinaryTree;
import baeume.TreeViewer;
import gui.GUI;

public class KettenbriefVerwaltung {
	private BinaryTree<Teilnehmer> teilnehmerBaum;
	
	public KettenbriefVerwaltung(){
		teilnehmerBaum = new BinaryTree<>();
		teilnehmerBaum.setContent(new Teilnehmer("August",0));
		tueWas("Karl","l");
		tueWas("Ina","r");
		tueWas("Lisa","ll");
		TreeViewer.showTree(teilnehmerBaum,600,400);
	}
	
	/**
	 * siehe Aufgabe 2)
	 */
	public double kontoStand(String pName){
		//TODO
		return -1;
	}
	
	/**
	 * siehe Aufgabe 2)
	 */
	public int verdientAn(String pName){
		//TODO
		return -1;
	}
	
	
	/**
	 * siehe Aufgabe 4)
	 * @param pName
	 * @param pString
	 */
	public void tueWas(String pName, String pString){
		BinaryTree<Teilnehmer> b = teilnehmerBaum;
		int n = pString.length();
		double z = 1;
		for(int i=0; i<n; i++){
			z = z*2;
		}
		// ****
		b.getContent().aendereKontostand( 10.0 / z );
		for(int i=0; i<n; i++){
			Teilnehmer t = b.getContent();
			t.aendereKontostand( 10 / z);
			z = z / 2;
			char c = pString.charAt(i);
			if( c == 'r'){
				b = b.getRightTree();
			}
			else{
				b = b.getLeftTree();
			}
		}
		b.setContent( new Teilnehmer(pName, -10));
	}
	
	
	
	/**
	 * das muss insgesamt immer 0 ergeben.
	 * @return
	 */
	public double summe(){
		return -1;
	}
	
	public static void main(String[] args) {
		new GUI(new KettenbriefVerwaltung());
	}
	
}
