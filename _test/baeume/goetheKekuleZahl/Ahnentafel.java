package _test.baeume.goetheKekuleZahl;

import gui.GUI;
import linear.Stack;
import baeume.BinaryTree;
import baeume.TreeViewer;

public class Ahnentafel {
	public BinaryTree<Individuum> ahnenBaum;

	public Ahnentafel(){
		init();
	}

	private void init(){
		ahnenBaum = new BinaryTree<Individuum>();

		Individuum gjw = new Individuum("Goethe", "Johann Wolfgang", 1749);
		ahnenBaum.setContent(gjw);

		Individuum gjc = new Individuum("Goethe", "Johann Caspar", 1710);
		BinaryTree<Individuum> gjcBaum = new BinaryTree<Individuum>(gjc);
		ahnenBaum.setLeftTree(gjcBaum);

		Individuum tce = new Individuum("Textor", "Catharina Elisabeth", 1731);
		BinaryTree<Individuum> tceBaum = new BinaryTree<Individuum>(tce);
		ahnenBaum.setRightTree(tceBaum);

		Individuum gfg = new Individuum("Göthe", "Friedrich Georg", 1657);
		BinaryTree<Individuum> gfgBaum = new BinaryTree<Individuum>(gfg);
		gjcBaum.setLeftTree(gfgBaum);

		Individuum wc = new Individuum("Walther", "Cornelia", 1668);
		BinaryTree<Individuum> wcBaum = new BinaryTree<Individuum>(wc);
		gjcBaum.setRightTree(wcBaum);

		Individuum tjw = new Individuum("Textor", "Johann Wolfgang", 1623);
		BinaryTree<Individuum> tjwBaum = new BinaryTree<Individuum>(tjw);
		tceBaum.setLeftTree(tjwBaum);

		Individuum lam = new Individuum("Lindheimer", "Anna Margaretha", 1711);
		BinaryTree<Individuum> lamBaum = new BinaryTree<Individuum>(lam);
		tceBaum.setRightTree(lamBaum);

		Individuum amc = new Individuum("Appel", "Maria Catharina", 1665);
		BinaryTree<Individuum> amcBaum = new BinaryTree<Individuum>(amc);
		tjwBaum.setRightTree(amcBaum);

		Individuum wg = new Individuum("Walter", "Georg", 1638);
		BinaryTree<Individuum> wgBaum = new BinaryTree<Individuum>(wg);
		wcBaum.setLeftTree(wgBaum);

		Individuum wam = new Individuum("Walther", "Anna Maria", 1633);
		BinaryTree<Individuum> wamBaum = new BinaryTree<Individuum>(wam);
		amcBaum.setRightTree(wamBaum);

		TreeViewer.showTree(ahnenBaum, 600,400);
	}

	private BinaryTree<Individuum> gibAhnenbaum() {
		return ahnenBaum;
	}

	public Individuum gibIndividuum(int pKekule) {
		if (pKekule > 0) {
			Stack<Boolean> pfadZumIndividuum = new Stack<Boolean>();
			int tempKekule = pKekule;
			while (tempKekule > 1) {
				pfadZumIndividuum.push(new Boolean(tempKekule % 2 == 0));
				tempKekule = tempKekule / 2;
			}
			BinaryTree<Individuum> aktTeilbaum = gibAhnenbaum();
			while (!pfadZumIndividuum.isEmpty() &&
					!aktTeilbaum.isEmpty()) {
				if (((Boolean) pfadZumIndividuum.top()).booleanValue()) {
					aktTeilbaum = aktTeilbaum.getLeftTree();
				} else {
					aktTeilbaum = aktTeilbaum.getRightTree();
				}
				pfadZumIndividuum.pop();
			}
			if (!aktTeilbaum.isEmpty()) {
				return (Individuum) aktTeilbaum.getContent();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}	
	
	public int gibAnzahlGenerationen(){
		int ergebnis = -1;
		//TODO
		System.out.println("gibAnzahlGenerationen() implementieren");
		return ergebnis;
	}


	public static void main(String[] args) {
		Ahnentafel at = new Ahnentafel();
		new GUI(at);
	}	


}
