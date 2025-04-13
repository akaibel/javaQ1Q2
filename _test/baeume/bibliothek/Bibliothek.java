package _test.baeume.bibliothek;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import baeume.BinarySearchTree;
import baeume.BinaryTree;
import baeume.TreeViewer;

public class Bibliothek{
	
	/**
	 * die Liste der Buecher, die in den Baum sollen.
	 */
    private List<Buch> buecherListe;
    
    //TODO  BinarySearchTree statt BinaryTree 
    private BinaryTree<Buch> buecherBaum;

    public Bibliothek(){
    	buecherListe = new ListWithViewer<>();
    	buecherListe.concat(AlleBuecher.getListe());

    	//TODO buecherBaum als leeren Baum erzeugen

    	TreeViewer.showTree(buecherBaum);
     }  

    /**
     * in den buecherBaum sollen alle Buecher aus buecherListe
     * in alphabetischer Reihenfolge eingefuegt werden.
     */
    public void uebertrageListeInBaum(){
    	//TODO
    }
   
    /**
     * sucht ein Buch nach dem Titel und gibt es zurueck
     * @param pTitel
     * @return
     */
    public Buch suche(String pTitel){
    	Buch ergebnis = null;
        //TODO  ein Dummy-Buch mit dem richtigen Titel erzeugen!
        //TODO nach dem Dummy-Buch suchen
        return ergebnis;
    }
    
    /**
     * Sucht alle Buecher, die in einem Regal stehen 
     * und gibt sie als Liste zurueck.
     * @param pRegalNr
     * @return
     */
    public ListWithViewer<Buch> suche(int pRegalNr){
    	ListWithViewer<Buch> ergebnis = new ListWithViewer<Buch>();
    	//TODO eine REKURSIVE Methode aufrufen!
    	// d.h. die muss man dann noch programmieren.
    	return ergebnis;
    }
    
    public static void main(String[] args) {
		new GUI(new Bibliothek(), "WARTEZEIT_BAEUME");
	}
}