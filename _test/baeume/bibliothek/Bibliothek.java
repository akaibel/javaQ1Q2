package _test.baeume.bibliothek;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import baeume.BinarySearchTree;

public class Bibliothek{
	  
    //TODO Attribut buecherBaum

    public Bibliothek(){
    	//TODO buecherBaum als leeren Baum erzeugen
    	uebertrageListeInBaum(BuecherListe.getListe());
     }  

    public void uebertrageListeInBaum(List<Buch> buecherListe){
    	//TODO
    }
   
    public Buch suche(String pTitel){
    	Buch ergebnis = null;
        //TODO  ein Dummy-Buch mit dem richtigen Titel erzeugen!
        //TODO nach dem Dummy-Buch suchen
        return ergebnis;
    }
    
    public ListWithViewer<Buch> suche(int pRegalNr){
    	ListWithViewer<Buch> ergebnis = new ListWithViewer<Buch>();
    	//TODO eine REKURSIVE Methode aufrufen!
    	// d.h. die muss man dann noch programmieren.
    	return ergebnis;
    }
    
    public static void main(String[] args) {
		new GUI(new Bibliothek());
	}
}