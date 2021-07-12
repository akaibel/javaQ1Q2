package projektkurs;

import gui.GUI;

import java.util.Random;

import linear.Queue;
import linear.Queue;

public class SelectionSortTest {
	private int anzahlVergleiche;
	
	public SelectionSortTest(){
		anzahlVergleiche = 0;
	}
	
	public void anzahlVergleicheAufNullSetzen(){
		anzahlVergleiche = 0;
	}
	
	public String kleinstenFinden(Queue<String> pQueue){
		if(pQueue.isEmpty()){
			return null;
		}
		String erster = pQueue.front();
		String ergebnis = pQueue.front();
		pQueue.dequeue();
		pQueue.enqueue(erster);
		while(pQueue.front() != erster){
			String s = pQueue.front();
			if(s.compareTo(ergebnis) <0 ){
				ergebnis = s;
			}
			pQueue.dequeue();
			pQueue.enqueue(s);
		}
		return ergebnis;
	}
	
	public void loeschen(String pString, Queue<String> pQueue){
		if(pQueue.isEmpty()){
			return;
		}
		if(pQueue.front() == pString){
			pQueue.dequeue();
			return;
		}
		String erster = pQueue.front();
		pQueue.dequeue();
		pQueue.enqueue(erster);
		while(pQueue.front() != erster){
			String s = pQueue.front();
			pQueue.dequeue();
			if(s == pString ){
				return;
			}
			pQueue.enqueue(s);
		}
	}
	
	public Queue<String> selectionsort(Queue<String> pQueue){
		System.out.println("*** Selectionsort ***");
		Queue<String> ergebnis = new Queue<String>();
		while( ! pQueue.isEmpty()){
			String s = kleinstenFinden(pQueue);
			loeschen(s, pQueue);
			ergebnis.enqueue(s);
		}
		return ergebnis;		
	}
	
	public void selectionsortTestGross(int pAnzahl){
		Queue<String>strings = erzeugen(pAnzahl);
		long startzeit = System.currentTimeMillis();
		Queue<String> ergebnis = selectionsort(strings);
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
		new GUI(new SelectionSortTest());
	}
}
