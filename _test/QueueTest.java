package _test;


import gui.GUI;
import linear.Queue;
import linear.Queue;
import linear.QueueWithViewer;
import sonstiges.Auto;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;

public class QueueTest {
	private Queue<Celebrity> celebritiesQueue;
	
	//private Queue<Auto> autoQueue;
	
	public QueueTest(){
		celebritiesQueue = Celebrities.celebritiesQueue();
		
		//autoQueue = Autos.autoQueue();
	}
	
	public void ausgeben() {
		System.out.println("*** ausgeben ***");
		//TODO
	}

	public static void main(String[] args) {
		QueueTest qt = new QueueTest();
		new GUI(qt);
	}
}
