package _test;
import gui.GUI;
import sonstiges.Auto;
import sonstiges.Autos;
import linear.List;
import linear.ListWithViewer;
import baeume.BinarySearchTree;
import baeume.TreeViewer;


public class BinarySearchTreeTestAutos {
	//TODO BinarySearchTree parametrisieren!
	public BinarySearchTree autosBaum;
	
	
	public BinarySearchTreeTestAutos(){
		autosBaum = new BinarySearchTree<>();
		ListWithViewer<Auto> autosList = Autos.autoList();
		this.einfuegenListe(autosList);
		TreeViewer.showTree(autosBaum, 1000, 400);
	}
	
	/**
	 * fuegt die Celebrities aus der Liste in autosBaum ein
	 * @param pautosListe
	 */
	private void einfuegenListe(List<Auto> pList){
		System.out.println("einfuegenListe(pList)");
		//TODO programmieren!
	}
	
	public void einfuegen(String marke, String farbe, int ps, int preis, double tankGroesse){
		//TODO programmieren!
	}
	
	public Auto finde(int pPs){
		Auto ergebnis = null;
		//TODO programmieren
		return ergebnis;
	}
	
	public Auto finde (String pMarke){
		Auto ergebnis = null;
		//TODO programmieren
		return ergebnis;		
	}
	
	public void loeschen(int pPs) {
		//TODO
	}
	
	public void loeschen(String pMarke) {
		//TODO
	}
	

	/**
	 * gibt die Elemente von autosBaum sortiert zurueck
	 * @return
	 */
	public List<Auto> sortiert(){
		List<Auto> ergebnis = new ListWithViewer<Auto>();
		//TODO programmieren!
		//WICHTIG: das hier ist nur eine RAHMENMETHODE!
		return ergebnis;
	}
	
	public static void main(String[] args) {
		BinarySearchTreeTestAutos bstta = new BinarySearchTreeTestAutos();
		new GUI(bstta, "WARTEZEIT_BAEUME");
	}
}
