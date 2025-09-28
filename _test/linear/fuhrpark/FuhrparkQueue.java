package _test.linear.fuhrpark;

import gui.GUI;
import linear.Queue;
import linear.QueueWithViewer;

public class FuhrparkQueue {
	private Queue<Lastwagen> lastwagenQueue;
	private Queue<Fahrt> fahrtenQueue;
	private Lastwagen A, B, C, D, E;
	
	public FuhrparkQueue() {
		lastwagenQueue = new QueueWithViewer<>();
		A = new Lastwagen("A",40);
		A.zuladen(20);
		B = new Lastwagen("B",50);
		B.zuladen(20);
		C = new Lastwagen("C",40);
		C.zuladen(10);
		D = new Lastwagen("D",30);
		D.zuladen(30);
		E = new Lastwagen("E",40);
		E.zuladen(30);
		lastwagenQueue.enqueue(E);
		lastwagenQueue.enqueue(D);
		lastwagenQueue.enqueue(C);
		lastwagenQueue.enqueue(B);
		lastwagenQueue.enqueue(A);
		fahrtenQueue = new QueueWithViewer<>();
		Fahrt A1 = new Fahrt("Max", A, 20);
		Fahrt B1 = new Fahrt("Tom", B, 30);
		Fahrt C1 = new Fahrt("Otto", C, 40);
		Fahrt A2 = new Fahrt("Otto", A, 25);
		Fahrt B2 = new Fahrt("Tom", B, 15);
		Fahrt D1 = new Fahrt("Lea", D, 41);
		Fahrt E1 = new Fahrt("Martina", E, 43);
		fahrtenQueue.enqueue(A1);
		fahrtenQueue.enqueue(B1);
		fahrtenQueue.enqueue(C1);
		fahrtenQueue.enqueue(A2);
		fahrtenQueue.enqueue(B2);
		fahrtenQueue.enqueue(E1);
		fahrtenQueue.enqueue(D1);
	}

	/**
	 * fuegt einen Lastwagen zum lastwagenList hinzu.
	 * Seine Beladung soll 0 sein.
	 * @param pKennzeichen
	 * @param pMaxBeladung
	 */
	public void lastwagenHinzufuegen(String pKennzeichen, double pMaxBeladung){
		//TODO
	}
	
	public void fahrtHinzufuegen(String pFahrer, Lastwagen pLastwagen, int pKm){
		Fahrt f = new Fahrt(pFahrer, pLastwagen, pKm);
		fahrtenQueue.enqueue(f);
	}
	
	/**
	 * gibt zurueck, wie viele Lastwagen weniger oder gleich pGewicht geladen haben.
	 * Fuer pGewicht == 20 sind das z.B. 3.
	 * @param pGewicht
	 * @return
	 */
	public int anzahlMitBeladungWenigerOderGleich(double pGewicht){
		//TODO
		return -1;
	}
	
	
	/**
	 * sucht einen Lastwagen, der noch pGewicht zusaetzlich laden kann und gibt ihn zurueck.
	 * Dafuer muss man das MaximalGewicht und die Beladung beruecksichtigen.
	 * Lastwagen B kann z.B. 20t zuladen
	 * Der Lastwagen wird aus lastwagenList entfernt.
	 * @param pGewicht
	 * @return
	 */
	public Lastwagen lastwagenFuerGewichtSuchen(double pGewicht){
		//TODO
		return null;
	}
	
	/**
	 * gibt den Lastwagen zurueck, der am wenigsten gefahren ist.
	 * Dafuer braucht man eine geeignete Hilfsmethode!
	 * 
	 * Am wenigsten gefahren ist Lastwagen C.
	 * @return
	 */
	public Lastwagen istAmWenigstenGefahren(){
		//TODO
		return null;
	}
	
	/**
	 * misst, wie viel die Lastwagen insgesamt geladen haben 
	 * und packt dann die ersten Lastwagen ganz voll.
	 * Die voll beladenen Lastwagen werden als Queue zurueckgegeben,
	 * die anderen Lastwagen bleiben in lastwagenQueue.
	 * 
	 * Am Ende wird zurueckgegeben: (A,40/40), (B,50/50), (C,20/40)
	 * Im lastwagenQueue bleiben: (D,0/30), (E,0/30)
	 */
	public Queue<Lastwagen> aufMoeglichstWenigeLastwagenUmladen(){
		Queue<Lastwagen> ergebnis = new QueueWithViewer<>();
		//TODO
		return ergebnis;
	}
	
	public static void main(String[] args) {
		new GUI(new FuhrparkQueue(), "WARTEZEIT_LINEAR");
	}
}
