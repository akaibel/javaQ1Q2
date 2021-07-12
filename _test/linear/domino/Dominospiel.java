package _test.linear.domino;

import gui.GUI;
import linear.Queue;
import linear.QueueWithViewer;

public class Dominospiel {
	private Queue<Spieler> spieler;
	private int anzahl;
	private Tisch tisch;

	public Dominospiel(int pAnzahl){
		System.out.println("Dominospiel("+pAnzahl+")");
		anzahl = pAnzahl;
		tisch = new Tisch();
		spieler = new QueueWithViewer<Spieler>();
		for(int i=1; i<=pAnzahl; i++){
			Spieler s = new Spieler("Spieler "+i);
			spieler.enqueue(s);
		}
	}

	/**
	 * an jeden Spieler werden vom Vorrat 5 Dominosteine verteilt
	 */
	public void austeilen(){
		System.out.println("Dominospiel.austeilen()");
		//TODO
	}

	public void spielen(){
		System.out.println("Dominospiel.spielen()");
		boolean gameover = false;
		while(! gameover){
			//TODO
		}
	}


	public static void main(String[] args) {
		new GUI(new Dominospiel(3));
	}

}
