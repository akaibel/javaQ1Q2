package _test;


import gui.GUI;
import linear.Stack;
import linear.Stack;
import linear.StackWithViewer;
import sonstiges.Auto;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class StackTest {
	private Stack<Celebrity> celebritiesStack;
	
	//private Stack<Auto> autoStack;
	
	public StackTest(){
		celebritiesStack = Celebrities.celebritiesStack();
		
		//autoStack = Autos.autoStack();
	}
	
	/**
	 * die Namen von allen in celebritiesStack 
	 * mit System.out.println(...) an die Konsole ausgeben
	 * Damit der celebritiesStack nicht zerstoert wird, 
	 * muss man jede Celebrity auf den Hilfsstack umschichten 
	 * und am Ende wieder zurueck.
	 * Zum Test mehrfach aufrufen!!
	 */
	public void ausgeben() {
		Stack<Celebrity> hilfsStack = new StackWithViewer<>();
		System.out.println("*** ausgeben ***");
		
		//TODO
	}
	
	public int gesamtVermoegen() {
		Stack<Celebrity> hilfsStack = new StackWithViewer<>();
		//TODO
		return -1;
	}
	
	public boolean enthaelt(String pName) {
		Stack<Celebrity> hilfsStack = new StackWithViewer<>();
		//TODO
		// VORSICHT: Vergleich von Strings mit equals!!
		// z.B. if(pName.equals(...)){
		return false;
	}
	
	public Celebrity derReichste() {
		Stack<Celebrity> hilfsStack = new StackWithViewer<>();
		//TODO
		return null;
	}
	
	public void loeschen(String pName) {
		Stack<Celebrity> hilfsStack = new StackWithViewer<>();
		//TODO
	}
	
	public Stack<Celebrity> reicherAls(int pVermoegen){
		Stack<Celebrity> ergebnis = new StackWithViewer<>();
		//TODO
		return ergebnis;
	}
	
	public void einfuegen(String pName, String pVorname, int pVermoegen) {
		//TODO
	}
	
	/**
	 * um zu sortieren muss man die Methoden derReichste und loeschen geeignet aufrufen.
	 * @return
	 */
	public Stack<Celebrity> sortierenNachVermoegen() {
		Stack<Celebrity> ergebnis = new StackWithViewer<>();
		//TODO
		return ergebnis;
	}

	public static void main(String[] args) {
		StackTest st = new StackTest();
		new GUI(st);
	}
}
