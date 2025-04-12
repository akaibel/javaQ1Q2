package _test;


import gui.GUI;
import linear.Queue;
import linear.QueueWithViewer;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class QueueTest {
	private Queue<Celebrity> celebritiesQueue;
	
	//private Queue<Auto> autoQueue;
	
	public QueueTest(){
		celebritiesQueue = Celebrities.celebritiesQueue();
		
		//autoQueue = Autos.autoQueue();
	}
	
	/**
	 * die Namen von allen in celebritiesQueue 
	 * mit System.out.println(...) an die Konsole ausgeben
	 * Damit der celebritiesQueue nicht zerstoert wird, 
	 * muss man jede Celebrity auf den HilfsQueue umschichten 
	 * und am Ende wieder zurueck.
	 * Zum Test mehrfach aufrufen!!
	 */
	public void ausgeben() {
		System.out.println("*** ausgeben() ***");
		
		//TODO
	}
	
	public int gesamtVermoegen() {
		System.out.println("*** gesamtVermoegen() ***");
		Queue<Celebrity> hilfsQueue = new QueueWithViewer<>();
		//TODO
		return -1;
	}
	
	public boolean enthaelt(String pName) {
		System.out.println("*** enthaelt(\""+pName+") ***");
		Queue<Celebrity> hilfsQueue = new QueueWithViewer<>();
		//TODO
		// VORSICHT: Vergleich von Strings mit equals!!
		// z.B. if(pName.equals(...)){
		return false;
	}
	
	public Celebrity derReichste() {
		System.out.println("*** derReichste() ***");
		Queue<Celebrity> hilfsQueue = new QueueWithViewer<>();
		//TODO
		return null;
	}
	
	public void loeschen(String pName) {
		System.out.println("*** loeschen(\""+pName+"\") ***");		
		Queue<Celebrity> hilfsQueue = new QueueWithViewer<>();
		//TODO
	}

	public Queue<Celebrity> reicherAls(int pVermoegen){
		System.out.println("*** reicherAls(\""+pVermoegen+"\") ***");
		Queue<Celebrity> ergebnis = new QueueWithViewer<>();
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
	public Queue<Celebrity> sortierenNachVermoegen() {
		System.out.println("*** sortierenNachVermoegen() ***");
		Queue<Celebrity> ergebnis = new QueueWithViewer<>();
		//TODO
		return ergebnis;
	}


	public static void main(String[] args) {
		QueueTest qt = new QueueTest();
		new GUI(qt, "WARTEZEIT_LINEAR");
	}
}
