package _test.vererbung;


import gui.GUI;
import linear.Queue;
import linear.Queue;
import linear.QueueWithViewer;
import sonstiges.Auto;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class AnzahlQueueTest {
	private AnzahlQueue<Celebrity> celebritiesQueue;
	
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
	
	public void denVorderstenWegNehmen() {
		celebritiesQueue.dequeue();
	}
	
	public int gibAnzahl() {
		//TODO
		return celebritiesQueue.getAnzahl();
	}

	public static void main(String[] args) {
		AnzahlQueueTest qt = new AnzahlQueueTest();
		new GUI(qt);
	}
}
