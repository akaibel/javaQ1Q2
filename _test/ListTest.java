package _test;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import linear.List;
import linear.ListWithViewer;
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
		System.out.println("*** ausgeben() ***");
		celebritiesList.toFirst();
		while(celebritiesList.hasAccess()) {
			Celebrity c = celebritiesList.getContent();
			System.out.println(c.getVorname()+" "+c.getName()+": "+c.getVermoegen());
			celebritiesList.next();
		}
	}

	
	public int gesamtVermoegen() {
		System.out.println("*** gesamtVermoegen() ***");	
		//TODO
		return -1;
	}
	
	public boolean enthaelt(String pName) {
		System.out.println("*** enthaelt(\""+pName+") ***");
		//TODO
		// VORSICHT: Vergleich von Strings mit equals!!
		// z.B. if(pName.equals(...)){
		return false;
	}
	
	public Celebrity derReichste() {
		System.out.println("*** derReichste() ***");
		//TODO
		return null;
	}
	
	public void loeschen(String pName) {
		System.out.println("*** loeschen(\""+pName+"\") ***");		
		//TODO
	}
	
	public List<Celebrity> reicherAls(int pVermoegen){
		System.out.println("*** reicherAls(\""+pVermoegen+"\") ***");
		List<Celebrity> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}
		
	
	public void einfuegen(String pName, String pVorname, int pVermoegen) {
		System.out.println("*** einfuegen(\""+pName+"\", \""+pVorname+"\", "+pVermoegen+") ***");
		//TODO
	}
	
	/**
	 * um zu sortieren muss man die Methoden derReichste und loeschen geeignet aufrufen.
	 * @return
	 */
	public void sortierenNachVermoegen() {
		System.out.println("*** sortierenNachVermoegen() ***");
	}


	
	
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		new GUI(lt,"WARTEZEIT_LINEAR");
	}
}
