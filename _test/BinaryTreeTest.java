package _test;
import linear.List;
import linear.ListWithViewer;
import gui.GUI;
import baeume.BinaryTree;
import baeume.TreeViewer;


public class BinaryTreeTest {
	public BinaryTree<Integer> suchbaum;
	
	public BinaryTreeTest(){
        suchbaum = new BinaryTree<Integer>(59);
        BinaryTree<Integer> b4= new BinaryTree<Integer>(4);
        BinaryTree<Integer> b34 = new BinaryTree<Integer>(34);
        BinaryTree<Integer> b16 = new BinaryTree<Integer>(16);
        BinaryTree<Integer> b7= new BinaryTree<Integer>(7);
        BinaryTree<Integer> b6 = new BinaryTree<Integer>(6);
        BinaryTree<Integer> b12 = new BinaryTree<Integer>(12);
        BinaryTree<Integer> b18= new BinaryTree<Integer>(18);
        BinaryTree<Integer> b17= new BinaryTree<Integer>(17);
        BinaryTree<Integer> b53 = new BinaryTree<Integer>(53);
        BinaryTree<Integer> b45 = new BinaryTree<Integer>(45);
        BinaryTree<Integer> b78 = new BinaryTree<Integer>(78);
        BinaryTree<Integer> b62 = new BinaryTree<Integer>(62);
        BinaryTree<Integer> b61= new BinaryTree<Integer>(61);
        BinaryTree<Integer> b71 = new BinaryTree<Integer>(71);
        BinaryTree<Integer> b73 = new BinaryTree<Integer>(73);
        
        suchbaum.setLeftTree(b4);
        b4.setRightTree(b34);
        b7.setLeftTree(b6);
        b7.setRightTree(b12);
        b16.setRightTree(b18);
        b18.setLeftTree(b17);
        b16.setLeftTree(b7);
        b34.setLeftTree(b16);
        b34.setRightTree(b53);
        b53.setLeftTree(b45);
        suchbaum.setRightTree(b78);
        b78.setLeftTree(b62);
        b62.setLeftTree(b61);
        b62.setRightTree(b71);
        b71.setRightTree(b73);
        TreeViewer.showTree(suchbaum, 600, 400);
	}
	
	// Rahmenmethode
	public int summe(){
		//Aufruf der rekursiven Methode
		return summe(suchbaum);
	}
	

	private int summe(BinaryTree<Integer> pTree) {
		int ergebnis = 0;
		// TODO programmieren:
		// Abbruchbedingung, Wurzelbehandlung, 2 rekursive Aufrufe, Sachlogik
		return ergebnis;
	}
	
	public int anzahlKnoten() {
		int ergebnis = 0;
		//TODO: Rekursive Methode programmieren und hier aufrufen!
		return ergebnis;
	}
	
	public int tiefe() {
		int ergebnis = 0;
		//TODO: Rekursive Methode programmieren und hier aufrufen!
		return ergebnis;
	}
	
	public boolean enthaelt(int pZahl) {
		//Aufruf der rekursiven Methode
		return enthaelt(suchbaum, pZahl);
	}
	
	private boolean enthaelt(BinaryTree<Integer> pTree, int pZahl) {
		// TODO programmieren
		return false;
	}
	
	public void anRichtigeStelleEinfuegen(int pZahl) {
		//Aufruf der rekursiven Methode
		anRichtigeStelleEinfuegen(suchbaum, pZahl);
	}

	private void anRichtigeStelleEinfuegen(BinaryTree<Integer> pTree, int pZahl) {
		// TODO Auto-generated method stub
		
	}

	public List<Integer> alleKnotenInListe(){
		List<Integer> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}
	
	public List<Integer> alleBlaetter(){
		List<Integer> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}
	
	/**
	 * fuegt die Knoten in Preorder-Reihenfolge der Liste ergebnis hinzu.
	 * @return
	 */
	public List<Integer> preorder(){
		List<Integer> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}
	
	/**
	 * fuegt die Knoten in Inorder-Reihenfolge der Liste ergebnis hinzu.
	 * @return
	 */
	public List<Integer> inorder(){
		List<Integer> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}
	

	public static void main(String[] args) {
		new GUI(new BinaryTreeTest(), "WARTEZEIT_BAEUME");
	}
}
