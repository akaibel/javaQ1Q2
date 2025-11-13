package _test.vererbung;


import gui.GUI;
import linear.Queue;
import linear.Queue;
import linear.QueueWithViewer;
import sonstiges.Person;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class AnzahlQueueTest {
	private AnzahlQueue<Person> celebritiesQueue;
	
	public AnzahlQueueTest(){
		celebritiesQueue = new AnzahlQueue<>();
		Celebrity c1 = new Celebrity("Lopez", "Jennifer",400);
		Celebrity c2 = new Celebrity("Neuer", "Manuel",40); 
		Celebrity c3 = new Celebrity("Rowling", "JK",1000); 
		celebritiesQueue.enqueue(c1);
		celebritiesQueue.enqueue(c2);
		celebritiesQueue.enqueue(c3);
	}

	public void michHinzufuegen() {
		Celebrity ich = new Celebrity("ich", "selber",600);
		celebritiesQueue.enqueue(ich);
	}
	
	public void personHinzufuegen() {
		Person p = new Person("Musterfrau", "Erika");
		celebritiesQueue.enqueue(p);
	}
	
	public void schuelerHinzufuegen() {
		//TODO im package sonstiges die Klasse Schueler implementieren
		//TODO die folgenden Zeile einkommentieren
		//Schueler s = new Schueler("Busch", "Max", "5C");
		//celebritiesStack.enqueue(s);
	}

	public void denVorderstenWegNehmen() {
		celebritiesQueue.dequeue();
	}
	
	public int gibAnzahl() {
		return celebritiesQueue.getAnzahl();
	}

	public static void main(String[] args) {
		AnzahlQueueTest qt = new AnzahlQueueTest();
		new GUI(qt, "WARTEZEIT_LINEAR");
	}
}
