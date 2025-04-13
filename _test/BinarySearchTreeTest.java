package _test;
import gui.GUI;
import sonstiges.Celebrities;
import sonstiges.Celebrity;
import linear.List;
import linear.ListWithViewer;
import baeume.BinarySearchTree;
import baeume.TreeViewer;


public class BinarySearchTreeTest {
	//TODO BinarySearchTree parametrisieren!
	public BinarySearchTree celebrityBaum;
	private ListWithViewer<Celebrity> celebritiesList;
	
	public BinarySearchTreeTest(){
		celebrityBaum = new BinarySearchTree<>();
		celebritiesList = Celebrities.celebritiesList();
		this.einfuegenListe(celebritiesList);
		TreeViewer.showTree(celebrityBaum);
	}
	
	/**
	 * fuegt die Celebrities aus der Liste in celebrityBaum ein
	 * @param pCelebrityListe
	 */
	private void einfuegenListe(List<Celebrity> pList){
		System.out.println("einfuegenListe(pList)");
	}
	
	public void einfuegen(String pName, String pVorname, int pGeld){
		//TODO programmieren!
	}
	
	public Celebrity finde(int pGeld){
		Celebrity ergebnis = null;
		//TODO programmieren
		return ergebnis;
	}
	
	public Celebrity finde (String pName){
		Celebrity ergebnis = null;
		//TODO programmieren
		return ergebnis;		
	}
	

	/**
	 * gibt die Elemente von celebrityBaum sortiert zurueck
	 * @return
	 */
	public List<Celebrity> sortiert(){
		List<Celebrity> ergebnis = new ListWithViewer<Celebrity>();
		//TODO programmieren!
		//WICHTIG: das hier ist nur eine RAHMENMETHODE!
		return ergebnis;
	}
	
	public static void main(String[] args) {
		BinarySearchTreeTest bstt = new BinarySearchTreeTest();
		new GUI(bstt, "WARTEZEIT_BAEUME");
	}
}
