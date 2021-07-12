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
	
	
	public BinarySearchTreeTest(){
		celebrityBaum = new BinarySearchTree<>();
		ListWithViewer<Celebrity> celebritiesList = Celebrities.celebritiesList();
		this.einfuegenListe(celebritiesList);
		TreeViewer.showTree(celebrityBaum, 1000, 400);
	}
	
	/**
	 * fuegt die Celebrities aus der Liste in celebrityBaum ein
	 * @param pCelebrityListe
	 */
	private void einfuegenListe(List<Celebrity> pList){
		System.out.println("einfuegenListe(pList)");
		//TODO programmieren!
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
		new GUI(bstt);
	}
}
