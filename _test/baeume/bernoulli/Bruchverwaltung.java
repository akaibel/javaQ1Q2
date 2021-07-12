package _test.baeume.bernoulli;

import linear.List;
import baeume.BinaryTree;
import baeume.TreeViewer;
import gui.GUI;

public class Bruchverwaltung {
	private BinaryTree<Bruch> baum;

	public Bruchverwaltung() {
		neuerBaum(4, 1, 6);
		new GUI(this);
	}

	public Bruch summe(){
		return null;
	}

	public Bruch finde(String pLinie){
		//TODO
		return null;
	}
	
	public List<Bruch> zweiErfolg(){
		//TODO
		return null;
	}
	
	private BinaryTree<Bruch> findeStartKnoten(int pEtage){
		//TODO
		return null;
	}

	private BinaryTree<Bruch> findeEndKnoten(int pEtage){
		//TODO
		return null;
	}

	public List<Bruch> etagenListe(int pEtage){
		//TODO
		return null;
	}
	
	
	
	public void neuerBaum(int pZahl, int pZ1, int pZ2){
		Bruch b1 = new Bruch(pZ1, pZ2);
		Bruch b2 = new Bruch(pZ2 - pZ1, pZ2);

		Bruch eins = new Bruch(1,1);
		// Hier wird auf das Attribut baum zugegriffen!
		baum = new BinaryTree<Bruch>(eins);

		List<BinaryTree<Bruch>> listeA = new List<BinaryTree<Bruch>>();
		listeA.append(baum);
		// *** x1 ***
		for(int i=0; i<pZahl; i++){
			List<BinaryTree<Bruch>> listeB = new List<BinaryTree<Bruch>>();
			for(listeA.toFirst(); listeA.hasAccess(); listeA.next()){
				BinaryTree<Bruch> derBaum = listeA.getContent();
				Bruch derBruch = derBaum.getContent();
				Bruch neuLinks = derBruch.multipliziereMit(b2);
				BinaryTree<Bruch> neuBaumLinks = new BinaryTree<Bruch>(neuLinks);
				derBaum.setLeftTree(neuBaumLinks);
				listeB.append(neuBaumLinks);
				Bruch neuRechts = derBruch.multipliziereMit(b1);
				BinaryTree<Bruch> neuBaumRechts = 
						new BinaryTree<Bruch>(neuRechts);
				derBaum.setRightTree(neuBaumRechts);
				listeB.append(neuBaumRechts);
			}
			// *** x2 ***
			listeA = listeB;
		}
		TreeViewer.showTree(baum, 1000,600);
	}



	public static void main(String[] args) {
		new Bruchverwaltung();
	}
}
