package _test.linear.staumeldungen;

import gui.GUI;
import linear.List;
import linear.ListWithViewer;

public class Verwaltung {
	private List<Staumeldung> staumeldungen;
	
	public Verwaltung() {
		List<Staumeldung> sList= new List<>();
		for(int i=0; i<Staudaten.autobahnnummer.length; i++){
			Staumeldung s = 
					new Staumeldung(Staudaten.autobahnnummer[i],
									Staudaten.richtungVon[i],
									Staudaten.richtungNach[i],
									Staudaten.abschnittAnfang[i],
									Staudaten.abschnittEnde[i],
									Staudaten.laenge[i]);
			sList.append(s);
		}
		staumeldungen = new ListWithViewer<>();
		staumeldungen.concat(sList);
	}
	
	/**
	 * Warming up
	 * @return
	 */
	public Staumeldung laengsterStau(){
		//TODO
		return null;
	}
	
	/**
	 * Aufgabe b
	 * @param pMinStaulaenge
	 * @return
	 */
	public List<Staumeldung> erstelleVerleseListe(int pMinStaulaenge){
		List<Staumeldung> ergebnis = new ListWithViewer<>();
		//TODO
		return ergebnis;
	}
	
	/**
	 * Aufgabe c
	 * @param pParameter
	 * @return
	 */
	public int ermittleWas(int pParameter){
		int m = 0;
		int a = 0;
		do{
			m = m+1;
			a = 0;
			staumeldungen.toFirst();
			while(staumeldungen.hasAccess()){
				if(staumeldungen.getContent().gibLaenge() >= m){
					a = a+1;
				}
				staumeldungen.next();
			}
			// Hier werte fuer m, a und pParameter angeben
		} while(a>pParameter);
		return m;
	}

	public static void main(String[] args) {
		new GUI(new Verwaltung());
	}
}
