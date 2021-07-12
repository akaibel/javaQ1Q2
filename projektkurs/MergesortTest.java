package projektkurs;

import gui.GUI;

import java.util.Random;

import linear.Queue;
import linear.QueueWithViewer;

public class MergesortTest {
	private Queue<String> avengers;
	private Queue<String> justiceLeague;
	private int anzahlVergleiche;
	
	public MergesortTest(){
		anzahlVergleiche = 0;
	}
	
	public void anzahlVergleicheAufNullSetzen(){
		anzahlVergleiche = 0;
	}
	
	public Queue<String> verschmelze(Queue<String> q1, Queue<String> q2){
		Queue<String> ergebnis = new QueueWithViewer<String>();
		//TODO
		return ergebnis;
	}
	
	public Queue<String> mergesort(Queue<String> pStrings){
		Queue<String> ergebnis = new QueueWithViewer<String>();
		//TODO
		return ergebnis;		
	}
	
	public void verschmelzeTest(){
		avengers = new QueueWithViewer<String>();
		avengers.enqueue("Black Widow");
		avengers.enqueue("Captain America");
		avengers.enqueue("Iron Man");
		avengers.enqueue("Spider Man");
		avengers.enqueue("Thor");
		justiceLeague = new QueueWithViewer<String>();
		justiceLeague.enqueue("Aquaman");
		justiceLeague.enqueue("Batman");
		justiceLeague.enqueue("Cyborg");
		justiceLeague.enqueue("Flash");
		justiceLeague.enqueue("Wonderwoman");
		Queue<String> ergebnis = verschmelze(avengers, justiceLeague);
	}
	
	public void mergesortTestKlein(){
		avengers = new QueueWithViewer<String>();
		avengers.enqueue("Thor");
		avengers.enqueue("Iron Man");
		avengers.enqueue("Captain America");
		avengers.enqueue("Spider Man");
		avengers.enqueue("Black Widow");
		Queue<String> ergebnis = mergesort(avengers);
	}
	
	public void mergesortTestGross(int pAnzahl){
		Queue<String>strings = erzeugen(pAnzahl);
		long startzeit = System.currentTimeMillis();
		Queue<String> ergebnis = mergesort(strings);
		long endzeit = System.currentTimeMillis();
		ausgeben(ergebnis);
		long verbrauchteZeit = endzeit - startzeit; 
		System.out.println("+++ Zeitverbrauch: "+verbrauchteZeit+"ms +++");
		System.out.println("+++ Anzahl Vergleiche: "+anzahlVergleiche);
	}
	
	/**
	 * erzeugt eine Queue mit zufaelligen Strings der Laenge 10.
	 * @param pAnzahl
	 */
	public Queue<String> erzeugen(int pAnzahl){
		Queue<String> ergebnis = new Queue<String>();
		Random r = new Random();
		System.out.println("*** erzeugen("+pAnzahl+") ***");
		for(int n=0; n<pAnzahl; n++){
			String s = "";
			for (int i=0; i<10;i++)
			{
				s += (char)(r.nextInt(26) + 65);
			}
			ergebnis.enqueue(s);
			System.out.println(s);
		}
		return ergebnis;
	}
	
	public void ausgeben(Queue<String> pStrings){
		int anzahl = 0;
		System.out.println();
		System.out.println("*** ausgeben() ***");
		String erster = pStrings.front();
		System.out.println(erster);
		anzahl++;
		pStrings.dequeue();
		pStrings.enqueue(erster);
		while(pStrings.front() != erster){
			System.out.println(pStrings.front());
			anzahl++;
			pStrings.enqueue(pStrings.front());
			pStrings.dequeue();
		}
		System.out.println("+++ "+anzahl+" Strings ausgegeben +++");
	}

	public static void main(String[] args) {
		new GUI(new MergesortTest());
	}
}
