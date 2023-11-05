package _test;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;
import sonstiges.Person;
import sonstiges.Auto;

public class ListTest {
	private List<Celebrity> celebritiesList;
	//private List<Auto> autoList;
	private Celebrity arm = new Celebrity("Armer", "Schlucker", 2);
	private Celebrity mittel = new Celebrity("Max", "Mittel", 450);
	private Celebrity reich = new Celebrity("Reicher", "Schnoesel", 20000);
	
	
	
	public ListTest(){
		celebritiesList = Celebrities.celebritiesList();
		//autoList = Autos.autoList(); 
	}
	
	public void ausgeben() {
		System.out.println("*** ausgeben ***");
		celebritiesList.toFirst();
		while(celebritiesList.hasAccess()) {
			Celebrity c = celebritiesList.getContent();
			System.out.println(c.getVorname()+" "+c.getName()+": "+c.getVermoegen());
		}
	}

	
	
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		new GUI(lt);
	}
}
