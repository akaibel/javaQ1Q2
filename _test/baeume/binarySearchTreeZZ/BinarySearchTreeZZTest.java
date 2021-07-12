package _test.baeume.binarySearchTreeZZ;

import baeume.TreeViewer;
import gui.GUI;
import linear.List;
import linear.ListWithViewer;


public class BinarySearchTreeZZTest {
	public BinarySearchTreeZZ<CelebrityZZ> celebrityBaum;
	private List<CelebrityZZ> celebritiesList; 
	
	public BinarySearchTreeZZTest(){
		celebrityBaum = new BinarySearchTreeZZ<CelebrityZZ>();
		celebritiesList = CelebritiesZZ.celebritiesList();
		this.einfuegen(celebritiesList);
		TreeViewerZZ.show(celebrityBaum);
	}
	
	private void einfuegen(List<CelebrityZZ> pCelebrityListe){
		System.out.println("einfuegen(...)");
		for(this.celebritiesList.toFirst(); this.celebritiesList.hasAccess(); this.celebritiesList.next()){
			CelebrityZZ c = this.celebritiesList.getContent();
			this.celebrityBaum.insert(c);
		}
	}
	
	public CelebrityZZ finde(String pName){
		System.out.println("finde("+pName+")");
		CelebrityZZ c = new CelebrityZZ(pName, null, -1);
		CelebrityZZ ergebnis = this.celebrityBaum.search(c);
		return ergebnis;
	}
	

	public ListWithViewer<CelebrityZZ> sortiert(){
		System.out.println("sortiert");
		ListWithViewer<CelebrityZZ> ergebnis = new ListWithViewer<CelebrityZZ>();
		//TODO
		//WICHTIG: das hier ist nur eine RAHMENMETHODE!
		return ergebnis;
	}
	
	public static void main(String[] args) {
		BinarySearchTreeZZTest bstt = new BinarySearchTreeZZTest();
		new GUI(bstt);
	}
}
