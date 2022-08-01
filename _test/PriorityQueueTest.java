package _test;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;
import linear.PriorityQueue;
import sonstiges.Autos;
import sonstiges.Celebrities;
import sonstiges.Celebrity;
import sonstiges.Person;
import sonstiges.Auto;

public class PriorityQueueTest {
	private List<Celebrity> cL;
	private PriorityQueue<Celebrity> pq;
	
	public PriorityQueueTest(){
		pq = new PriorityQueue<Celebrity>();
		cL = Celebrities.celebritiesList();
	}
	
	public boolean istLeer(){
		return pq.isEmpty();
	}
	
	public void nachEinkommenInPriorityQueueUebertragen(){
		for(cL.toFirst();cL.hasAccess(); cL.next()){
			Celebrity c = cL.getContent();
			pq.insert(c, c.getVermoegen());
		}
	}
	
	public Person front(){
		return pq.front();
	}
	
	public void dequeue(){
		pq.dequeue();
	}
	
	public void insert(String pVorname, int pEinkommen ){
		Celebrity c = new Celebrity("Test", pVorname, pEinkommen);
		pq.insert(c, c.getVermoegen());
	}
	
	
	public static void main(String[] args) {
		PriorityQueueTest lt = new PriorityQueueTest();
		new GUI(lt);
	}
}
